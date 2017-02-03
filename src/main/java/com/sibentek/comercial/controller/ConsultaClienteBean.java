/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.controller;

import com.sibentek.comercial.binder.ClienteBinder;
import com.sibentek.comercial.model.Cliente;
import com.sibentek.comercial.model.vo.ClienteVO;
import com.sibentek.comercial.service.ClienteService;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author william
 */
@Named
@RequestScoped
public class ConsultaClienteBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ClienteService clienteService;
    private Collection<Cliente> clientesModel;
    private Collection<ClienteVO> clientes;
    
    @PostConstruct
    public void init(){
        clientesModel = clienteService.listar();
        clientes = ClienteBinder.bindFromModel(clientesModel);
    }

    public Collection<ClienteVO> getClientes() {
        return clientes;
    }
}

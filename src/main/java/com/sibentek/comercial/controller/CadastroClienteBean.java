/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.controller;

import com.sibentek.comercial.model.Cliente;
import com.sibentek.comercial.model.Endereco;
import com.sibentek.comercial.service.ClienteService;
import com.sibentek.comercial.util.jsf.FacesUtil;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author william
 */
@Named
@RequestScoped
public class CadastroClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private ClienteService clienteService;
    private Cliente cliente = new Cliente();
    private Endereco endereco = new Endereco();

    
    public void salvar(){
        cliente.setEndereco(endereco);
        clienteService.salvar(cliente);
        cliente = new Cliente();
        endereco = new Endereco();
        FacesUtil.addInfoMessage("Cliente salvo com sucesso!");
    }
    public Cliente getCliente() {
        return cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.service;

import com.sibentek.comercial.model.Cliente;
import com.sibentek.comercial.repository.ClienteRepository;
import com.sibentek.comercial.util.jpa.Transacional;
import java.io.Serializable;
import java.util.Collection;
import javax.inject.Inject;

/**
 *
 * @author william
 */
public class ClienteService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ClienteRepository clienteRepository;

    @Transacional
    public void salvar(Cliente cliente) {
        clienteRepository.salvar(cliente);
    }

    public Collection<Cliente> listar() {
        return clienteRepository.listar();
    }

}

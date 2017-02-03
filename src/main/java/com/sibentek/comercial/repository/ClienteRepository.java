/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.repository;

import com.sibentek.comercial.model.Cliente;
import java.io.Serializable;
import java.util.Collection;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author william
 */
public class ClienteRepository implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private EntityManager entityManager;
    
    public Cliente salvar(Cliente cliente){
        return entityManager.merge(cliente);
    }
    
    public Collection<Cliente> listar(){
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
    }
}

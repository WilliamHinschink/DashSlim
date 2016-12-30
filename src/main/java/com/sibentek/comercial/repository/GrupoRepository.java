/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.repository;

import com.sibentek.comercial.model.Grupo;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author william
 */
public class GrupoRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;
    
    public Grupo porId(Long id){
        return manager.find(Grupo.class, id);
    }
    
    public List<Grupo> listar(){
        return manager.createQuery("SELECT g FROM Grupo g", Grupo.class).getResultList();
    }
    
    public Grupo salvar(Grupo grupo){
        return manager.merge(grupo);
    }
}

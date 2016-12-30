/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.service;

import com.sibentek.comercial.model.Grupo;
import com.sibentek.comercial.repository.GrupoRepository;
import com.sibentek.comercial.util.jpa.Transacional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author william
 */
public class GrupoService implements Serializable{
    private static final long serialVersionUID = 1L;
    @Inject
    private GrupoRepository grupos;
    
    @Transacional
    public void salvar(Grupo grupo){
        grupos.salvar(grupo);
    }
    
    public List<Grupo> listar(){
        return grupos.listar();
    }
}

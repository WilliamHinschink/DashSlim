/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.controller;

import com.sibentek.comercial.model.Grupo;
import com.sibentek.comercial.service.GrupoService;
import java.io.Serializable;
import java.util.List;
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
public class CadastroGrupoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private GrupoService grupoService;
    private Grupo grupo = new Grupo();
    private List<Grupo> grupos;
    
    @PostConstruct
    public void init() {
        grupos = grupoService.listar();
    }
    
    public void salvar(){
        grupoService.salvar(grupo);
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }
}

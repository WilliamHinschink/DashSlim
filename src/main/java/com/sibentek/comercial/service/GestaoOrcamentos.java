package com.sibentek.comercial.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sibentek.comercial.model.Orcamento;
import com.sibentek.comercial.repository.OrcamentosRepository;
import com.sibentek.comercial.util.jpa.Transacional;
import java.util.List;

public class GestaoOrcamentos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OrcamentosRepository orcamentos;
	
	@Transacional
	public void salvar(Orcamento orcamento) {
		orcamentos.guardar(orcamento);
	}
        
        public List<Orcamento> listar(){
            return orcamentos.listar();
        }
	
}
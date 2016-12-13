package com.sibentek.comercial.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sibentek.comercial.model.Orcamento;
import java.util.List;

public class OrcamentosRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public Orcamento guardar(Orcamento orcamento) {
		return manager.merge(orcamento);
	}
        
        public List<Orcamento> listar(){
            return manager.createQuery("SELECT c FROM Orcamento c", Orcamento.class)
                    .getResultList();
        }

}
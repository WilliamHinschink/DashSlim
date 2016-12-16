/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.repository;

import com.sibentek.comercial.model.Orcamento;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author WILLIAM
 */
public class ComprasRepository implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;
    
    @SuppressWarnings({ "unchecked" })
    public List<Orcamento> listaDeComprasPorCliente(Long orc_id) {
        Session session = manager.unwrap(Session.class);
        Query query = session.createQuery("SELECT orc.cliente, orc.condicaoPagamento, orc.dataValidade, orc.diasEntrega, orc.telefone FROM Orcamento orc INNER JOIN ORC.itens AS i WHERE ORC.id = :orc_id", Orcamento.class);
        query.setParameter("orc_id", orc_id);
        List<Orcamento> orcamentos = query.getResultList();
        return orcamentos.stream()
                .collect(Collectors.toList());
    }

}

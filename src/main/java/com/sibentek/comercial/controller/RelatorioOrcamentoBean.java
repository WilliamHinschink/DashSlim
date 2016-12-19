/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.controller;

import com.sibentek.comercial.util.jsf.FacesUtil;
import com.sibentek.comercial.util.report.ExecutorRelatorio;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;

/**
 *
 * @author william
 */
@Named
@RequestScoped
public class RelatorioOrcamentoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long orc_id;

    @Inject
    private FacesContext facesContext;

    @Inject
    private HttpServletResponse httpServletResponse;

    @Inject
    private EntityManager entityManager;

    public void emitir() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("orc_id", this.orc_id);

        ExecutorRelatorio executor = new ExecutorRelatorio("/reports/Cherry.jrxml",
                this.httpServletResponse, parametros, "Pedidos.pdf");
        
        
        SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
        sessionFactory.openSession().doWork(executor);
//        Session session = entityManager.unwrap(Session.class);
//        session.doWork(executor);

        if (executor.isRelatorioGerado()) {
            facesContext.responseComplete();
        } else {
            FacesUtil.addErrorMessage("A execução do relatório não retornou dados.");
        }
    }

    @NotNull
    public Long getOrc_id() {
        return orc_id;
    }

    public void setOrc_id(Long orc_id) {
        this.orc_id = orc_id;
    }
    
}

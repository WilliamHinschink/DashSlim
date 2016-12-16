/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.util.jsf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WILLIAM
 */
public class FacesProducer {

    @Produces @RequestScoped
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    @Produces @RequestScoped
    public ExternalContext getExternalContext() {
        return getFacesContext().getExternalContext();
    }

    @Produces @RequestScoped
    public HttpServletResponse getHttpServletResponse() {
        return ((HttpServletResponse) getExternalContext().getResponse());
    }
}

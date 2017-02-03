/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.controller;

import com.sibentek.comercial.model.Orcamento;
import javax.inject.Inject;
import org.junit.Test;

/**
 *
 * @author william
 */
public class EnvioEmailBeanTest {

    private static final String EMAIL_TO = "wii.will93@gmail.com";
    private static final String URL_PDF = "localhost:7070/PDF/Full Stack JavaScript Development With MEAN.pdf";
    private final String url = "<a href=\"http://$url\" target=\"_blank\">Clique aqui!</a>";

    @Test
    public void expectedHtmlBody() {
        Orcamento orcamento = new Orcamento();
        orcamento.setCliente("WILLIAM HINSCHINK");
        orcamento.setId(2L);
        EnvioEmailBean emailBean = new EnvioEmailBean();
        System.out.println(emailBean.builtHtml(orcamento));
    }
    
    @Test
    public void expectedLink(){
        System.out.println(url.replace(url.substring(16,20), URL_PDF));
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.controller;

import com.sibentek.comercial.model.Orcamento;
import com.sibentek.comercial.util.jsf.FacesUtil;
import com.sibentek.comercial.util.mail.MailerMail;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author william
 */
@Named
@RequestScoped
public class EnvioEmailBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String EMAIL_TO = "wii.will93@gmail.com";
    private static final String URL_PDF = "localhost:7070/PDF/Full Stack JavaScript Development With MEAN.pdf";
    private final String url = "<a href=\"http://$url\" target=\"_blank\">Clique aqui!</a>";

    @Inject
    private MailerMail mail;

    public void enviarEmailAlt(Orcamento orcamento) throws AddressException, MessagingException, IOException {
        Message message = mail.novaMensagem();
        message.setFrom(new InternetAddress("william@wins.com", "William Amaral", "UTF-8"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(EMAIL_TO));
        message.setSubject("Orçamento " + orcamento.getCliente());
        message.setContent(builtHtml(orcamento), "text/html; charset=utf-8");
        Transport.send(message);
        
        FacesUtil.addInfoMessage("Orcamento enviado por e-mail com sucesso!");
    }

    public String builtHtml(Orcamento orcamento) {
        StringBuilder sb = new StringBuilder();
        return sb.append("<!DOCTYPE html>\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n    <body>\n        <table>\n            <tr>\n                <td style=\"width: 100px\">N\u00famero:</td>\n                <td>").append(orcamento.getId()).append("</td>\n            </tr>\n            <tr>\n                <td>Cliente:</td>\n                <td>").append(orcamento.getCliente()).append("</td>\n            </tr>\n            <tr>\n                <td>Link do Relat\u00f3rio:</td>\n                <td>").append(url.replace(url.substring(16, 20), URL_PDF)).append("</td>\n            </tr>\n        </table>\n        \n        <br/>\n    </body>\n</html>").toString();
    }
}

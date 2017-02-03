/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.util.mail;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author william
 */
@RequestScoped
public class MailerMail implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private Session session;
    
    public Message novaMensagem(){
        return new MimeMessage(this.session);
    }   
}

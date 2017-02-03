/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.util.mail;

import java.io.IOException;
import java.util.Properties;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 *
 * @author william
 */

@ApplicationScoped
public class EmailConfigProducer {

    private static final String USERNAME = "williamhinschink@gmail.com";
    private static final String PASS = "01010111";
    
    @Produces
    public Session getMailConfig() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("/mail.properties"));

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASS);
            }
        });
        return session;
    }
}

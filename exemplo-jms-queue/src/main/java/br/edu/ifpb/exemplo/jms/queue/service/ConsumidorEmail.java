/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.exemplo.jms.queue.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.TextMessage;

/**
 *
 * @author romulo
 */
@Stateless
public class ConsumidorEmail {

    @Resource(lookup = "java:global/jms/Fila")
    private Queue fila;

    @Inject
    private JMSContext context;

    public String lerEmail() {
        JMSConsumer createConsumer = context.createConsumer(fila);
        TextMessage receive = (TextMessage) createConsumer.receive();
        try {
            return fila.getQueueName() + " - " + receive.getText();
        } catch (JMSException ex) {
            Logger.getLogger(ConsumidorEmail.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "sem email";
    }

}

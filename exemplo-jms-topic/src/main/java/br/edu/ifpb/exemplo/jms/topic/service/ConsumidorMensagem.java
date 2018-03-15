/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.exemplo.jms.topic.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author romulo
 */
@MessageDriven(
        mappedName = "java:global/jms/Topic",
        activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
            @ActivationConfigProperty(propertyName = "destinationName", propertyValue = "topico"),
            @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "setor='consumidor'"),
        }
)
public class ConsumidorMensagem implements MessageListener {

    @Override
    public void onMessage(Message message) {

        try {
            String body = message.getBody(String.class);
            System.out.println("Mensagem recebida do setor de consumidor: " + body);
        } catch (JMSException ex) {
            Logger.getLogger(ConsumidorMensagem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

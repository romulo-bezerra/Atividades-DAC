/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.exemplo.jms.queue.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSProducer;
import javax.jms.Queue;

/**
 *
 * @author romulo
 */
@JMSDestinationDefinition(
        name = "java:global/jms/Fila",
        interfaceName = "javax.jms.Queue",
        resourceAdapter = "jmsra",
        destinationName = "fila")
@Stateless
public class ProdutorEmail {

    @Resource(lookup = "java:global/jms/Fila")
    private Queue fila;

    @Inject
    private JMSContext context;

    public void enviarEmail(String email) {
        JMSProducer createProducer = context.createProducer();
        createProducer.send(fila, email);
        System.out.println("Email enviado: " + email);
    }
}
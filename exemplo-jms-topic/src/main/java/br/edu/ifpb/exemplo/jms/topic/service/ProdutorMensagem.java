/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.exemplo.jms.topic.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSProducer;
import javax.jms.Topic;

/**
 *
 * @author romulo
 */
@JMSDestinationDefinition(
        name = "java:global/jms/Topic",
        interfaceName = "javax.jms.Topic",
        resourceAdapter = "jmsra",
        destinationName = "topico"
)
@Stateless
public class ProdutorMensagem {

    @Resource(lookup = "java:global/jms/Topic")
    private Topic topic;

    @Inject
    private JMSContext context;

    public void enviar(String setor, String mensagem) {
        JMSProducer createProducer = context.createProducer();
        createProducer.setProperty("setor", setor);
        createProducer.send(topic, mensagem);
        System.out.println("Mensagem enviada: " + mensagem);
    }
}

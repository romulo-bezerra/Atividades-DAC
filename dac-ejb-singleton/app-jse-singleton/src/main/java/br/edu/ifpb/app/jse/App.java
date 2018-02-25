/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.jse;

import br.edu.ifpb.service.shared.SalaDeBatepapo;
import br.edu.ifpb.service.shared.ServiceLookup;

/**
 *
 * @author romulo
 */
public class App {
    
    public static void main(String[] args) {
        
        SalaDeBatepapo sdb = new ServiceLookup()
                .lookup("localhost", "3700",
                        "java:global/service-core-singleton/SalaDeBatepapoOnline");

        sdb.addMensagem("Olá, mundo.");
        sdb.addMensagem("Seja bem vindo.");
        
        System.out.println(sdb.listarMensagens());
        
    }
    
}

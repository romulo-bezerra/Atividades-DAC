package br.edu.ifpb.service.shared;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLookup {

//    public Carrinho lookup(String name) {
//        try {
//            Properties properties = new Properties();
//            properties.put(InitialContext.INITIAL_CONTEXT_FACTORY,
//                    "com.sun.enterprise.naming.SerialInitContextFactory");
//
//            Context context = new InitialContext(properties);
//            return (Carrinho) context.lookup(name);
//
//        } catch (NamingException ex) {
//            Logger.getLogger(ServiceLookup.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    public Calculadora lookup(String host, String porta, String nome) {
        try {
            Properties properties = new Properties();
            properties.put(InitialContext.INITIAL_CONTEXT_FACTORY,
                    "com.sun.enterprise.naming.SerialInitContextFactory");
            properties.setProperty("org.omg.CORBA.ORBInitialHost", host);
            properties.setProperty("org.omg.CORBA.ORBInitialPort", porta);

            Context context = new InitialContext(properties);
            return (Calculadora) context.lookup(nome);
        } catch (NamingException ex) {
            Logger.getLogger(ServiceLookup.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

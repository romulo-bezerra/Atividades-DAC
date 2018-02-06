/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.persistencia.jpa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author romulo
 */
public class App {
    
    public static void main(String[] args) throws IOException {
        
        EntityManager em = Persistence
                .createEntityManagerFactory("UnidadePersistencia")
                .createEntityManager();
        
        Path path = Paths.get("/home/romulo/Área de Trabalho/todd-desantis-37264.jpg");
        byte[] bs = Files.readAllBytes(path);
        
        Telefone telefone = new Telefone("345678", "dfghjkl");
        Telefone telefone1 = new Telefone("3435678", "d333fghjkl");
        
        Contato contato = new Contato();
        contato.addEmail("bromulosoares@gmail.com");
        contato.addEmail("bromulosoares1@gmail.com");
        contato.addTelefone(telefone);
        contato.addTelefone(telefone1);
        contato.setApelido("ghjklç");
        contato.setDataDaCriacao(Date.valueOf(LocalDate.now()));
        contato.setDescricao("sdfghjklkjhgfd");
        contato.setFoto(bs);
        contato.setNome("fghjklççlkjh");
        contato.setSobreNome("ghjklkjhg");
        
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(contato);
        transaction.commit();
        
        System.out.println(em.find(Contato.class, 51).getApelido());
        
    }
    
}

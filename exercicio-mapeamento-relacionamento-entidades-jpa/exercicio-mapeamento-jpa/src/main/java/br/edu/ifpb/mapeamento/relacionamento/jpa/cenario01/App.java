/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.relacionamento.jpa.cenario01;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author romulo
 */
public class App {
    
    public static void main(String[] args) {
        
        EntityManager em = Persistence
                .createEntityManagerFactory("exercicio-mapeamento-jpa")
                .createEntityManager();
        
        Funcionario func1 = new Funcionario("Rômulo", "113.409.864-26", "3956096", 8000);
        Funcionario func2 = new Funcionario("Maria", "112.403.864-25", "3946097", 8000);
        
        Projeto appMixFruits = new Projeto("App Salada de Fruta", "Gourmet", 
                LocalDate.now(), LocalDate.now());
        appMixFruits.adicionarFuncionario(func1);
        appMixFruits.adicionarFuncionario(func2);
        
        TrabalhaProjeto trabalhaAppMixFruits = new TrabalhaProjeto(160, LocalDate.now(), appMixFruits, func1);
        TrabalhaProjeto trabalhaAppMixFruits1 = new TrabalhaProjeto(160, LocalDate.now(), appMixFruits, func2);
        
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(appMixFruits);
        em.persist(trabalhaAppMixFruits);
        em.persist(trabalhaAppMixFruits1);
        transaction.commit();
        
    }
    
}

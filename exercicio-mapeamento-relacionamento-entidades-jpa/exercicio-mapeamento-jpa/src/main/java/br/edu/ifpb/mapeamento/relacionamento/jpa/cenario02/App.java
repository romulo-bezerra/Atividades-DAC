/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.relacionamento.jpa.cenario02;

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
        
//        FuncionarioOficina joao = new FuncionarioOficina("Joao", "113.409.864.27",
//                "3956094", 1500, Funcao.EMPREGADO);
//        FuncionarioOficina jose = new FuncionarioOficina("José", "113.509.864.27",
//                "3955094", 2500, Funcao.GERENTE);
//        
//        Conserto moto = new Conserto(35, LocalDate.now(), joao);
//        Conserto carro = new Conserto(75, LocalDate.now(), joao);
//        
//        Localizacao localizacao = new Localizacao("São Sebastião", "Rabo da Gata", "Cajazeiras");
//        
//        Oficina oficina = new Oficina(7500, localizacao);
//        oficina.adicionarConserto(carro);
//        oficina.adicionarConserto(moto);
//        oficina.adicionarFuncionario(joao);
//        oficina.adicionarFuncionario(jose);
        
        ConsertoDao consertoDao = new ConsertoDaoImpl();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
//        em.persist(oficina);

        //Deletando tupla conserto do banco
        Conserto c = consertoDao.consultarPorId(2, em);
        consertoDao.deletar(c, 1, em);
        transaction.commit();
        
    }
    
}

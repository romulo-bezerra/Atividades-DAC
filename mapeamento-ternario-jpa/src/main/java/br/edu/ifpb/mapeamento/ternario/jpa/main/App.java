/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.ternario.jpa.main;

import br.edu.ifpb.mapeamento.ternario.jpa.domain.Departamento;
import br.edu.ifpb.mapeamento.ternario.jpa.domain.Empregado;
import br.edu.ifpb.mapeamento.ternario.jpa.domain.Endereco;
import br.edu.ifpb.mapeamento.ternario.jpa.domain.Projeto;
import br.edu.ifpb.mapeamento.ternario.jpa.domain.TrabalhaEmProjeto;
import br.edu.ifpb.mapeamento.ternario.jpa.enums.Sexo;
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

    public static void main(String[] args) {

        EntityManager em = Persistence
                .createEntityManagerFactory("persistencia_local")
                .createEntityManager();

        Endereco enderecoGerente = new Endereco("Jose", "186", "Belo", "CZ");

        Empregado gerente = new Empregado("Romulo Soares", "123", enderecoGerente,
                8000, Sexo.MASCULINO, Date.valueOf(LocalDate.now()));

        Departamento departamento = new Departamento("11", "Financeiro");

        gerente.setDepartamento(departamento);
        departamento.setGerente(gerente);

        Endereco ee1 = new Endereco("Joao", "12", "Feio", "CZ");
        Endereco ee2 = new Endereco("MAria", "13", "Feio", "CZ");

        Empregado e1 = new Empregado("Renan", "345", ee1, 2000, Sexo.MASCULINO,
                Date.valueOf(LocalDate.now()));
        Empregado e2 = new Empregado("Raissa", "567", ee2, 2000, Sexo.FEMININO,
                Date.valueOf(LocalDate.now()));

        departamento.addEmpregado(e1);
        departamento.addEmpregado(e2);

        Projeto p1 = new Projeto("BestPlaces", "1", "PB");
        Projeto p2 = new Projeto("Casa", "2", "AC");

        departamento.addProjeto(p1);
        departamento.addProjeto(p2);

        TrabalhaEmProjeto tep1 = new TrabalhaEmProjeto(e1, departamento, p2, 3);
        TrabalhaEmProjeto tep2 = new TrabalhaEmProjeto(e2, departamento, p2, 3);

        e1.addTrabalhaEmProjeto(tep1);
        e2.addTrabalhaEmProjeto(tep2);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(gerente);
        em.persist(departamento);
        em.persist(e1);
        em.persist(e2);
        em.persist(p1);
        em.persist(p2);
        em.persist(tep1);
        em.persist(tep2);
        transaction.commit();

    }

}

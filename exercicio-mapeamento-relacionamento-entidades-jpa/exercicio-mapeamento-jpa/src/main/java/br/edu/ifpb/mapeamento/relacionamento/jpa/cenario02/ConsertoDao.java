/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.relacionamento.jpa.cenario02;

import javax.persistence.EntityManager;

/**
 *
 * @author romulo
 */
public interface ConsertoDao {

    public void cadastrar(Conserto conserto, EntityManager em);

    public Conserto consultarPorId(int idConserto, EntityManager em);

    public void deletar(Conserto conserto, int idOficina, EntityManager em);

}

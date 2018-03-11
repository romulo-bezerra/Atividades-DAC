/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.relacionamento.jpa.cenario02;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author romulo
 */
public class ConsertoDaoImpl implements ConsertoDao {

    @Override
    public void cadastrar(Conserto conserto, EntityManager em) {
        em.persist(conserto);
    }

    @Override
    public Conserto consultarPorId(int idConserto, EntityManager em) {
        String querySql = "SELECT c FROM Conserto c WHERE c.id= :id";
        TypedQuery<Conserto> createQuery = em
                .createQuery(querySql, Conserto.class);
        createQuery.setParameter("id", idConserto);

        return createQuery.getSingleResult();
    }

    //metodo modo gambiarra 
    @Override
    public void deletar(Conserto conserto, int idOficina, EntityManager em) {
        conserto.setFuncionario(null);
        em.merge(conserto);
        em.remove(conserto);
        Oficina oficina = em.find(Oficina.class, idOficina);
        oficina.removerConserto(conserto);
        em.merge(oficina);
    }
    
}

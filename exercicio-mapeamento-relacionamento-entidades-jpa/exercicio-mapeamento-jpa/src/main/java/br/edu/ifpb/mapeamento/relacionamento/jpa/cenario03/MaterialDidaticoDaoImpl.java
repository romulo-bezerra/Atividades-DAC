/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.relacionamento.jpa.cenario03;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author romulo
 */
public class MaterialDidaticoDaoImpl implements MaterialDidaticoDao {

    private final EntityManager em;
    private final EntityTransaction transaction;

    public MaterialDidaticoDaoImpl() {
        this.em = Persistence
                .createEntityManagerFactory("exercicio-mapeamento-jpa")
                .createEntityManager();
        this.transaction = em.getTransaction();
    }

    @Override
    public void salvar(MaterialDidatico materialDidatico) {
        transaction.begin();
        em.persist(materialDidatico);
        transaction.commit();
    }

    @Override
    public void atualizar(long codMaterialParaAtualizar, MaterialDidatico novoEstado) {
        transaction.begin();
        MaterialDidatico md = em.find(MaterialDidatico.class, codMaterialParaAtualizar);
        md.setAutor(novoEstado.getAutor());
        md.setCodigo(novoEstado.getCodigo());
        md.setDataCadastro(novoEstado.getDataCadastro());
        md.setDescricao(novoEstado.getDescricao());
        md.setOrigem(novoEstado.getOrigem());
        md.setPublico(novoEstado.isPublico());
        md.setTamanho(novoEstado.getTamanho());
        md.setTipo(novoEstado.getTipo());
        md.setTitulo(novoEstado.getTitulo());
        em.merge(md);
        transaction.commit();
    }

    @Override
    public void remover(long codMaterial) {
        transaction.begin();
        MaterialDidatico md = em.find(MaterialDidatico.class, codMaterial);
        em.remove(md);
        transaction.commit();
    }

}

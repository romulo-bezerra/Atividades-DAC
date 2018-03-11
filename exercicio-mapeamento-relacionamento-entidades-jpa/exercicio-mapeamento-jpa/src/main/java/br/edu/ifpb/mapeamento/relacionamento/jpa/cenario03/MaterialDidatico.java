/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.relacionamento.jpa.cenario03;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author romulo
 */
@Entity
public class MaterialDidatico implements Serializable {

    @Id
    @Column(length = 45)
    private String origem;

    @Id
    private long codigo;
    
    @Column(nullable = false, length = 155)
    private String titulo;

    @Column(nullable = false)
    private Date dataCadastro;

    @Lob
    private String descricao;

    @Column(length = 55)
    private String autor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private TipoMaterialDidatico tipo;

    private boolean publico;

    @Column(precision = 6, scale = 2)
    private double tamanho;

    public MaterialDidatico() {

    }

    public MaterialDidatico(String origem, long codigo, String titulo,
            Date dataCadastro, String descricao, String autor,
            TipoMaterialDidatico tipo, boolean publico, double tamanho) {
        this.origem = origem;
        this.codigo = codigo;
        this.titulo = titulo;
        this.dataCadastro = dataCadastro;
        this.descricao = descricao;
        this.autor = autor;
        this.tipo = tipo;
        this.publico = publico;
        this.tamanho = tamanho;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public TipoMaterialDidatico getTipo() {
        return tipo;
    }

    public void setTipo(TipoMaterialDidatico tipo) {
        this.tipo = tipo;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

}

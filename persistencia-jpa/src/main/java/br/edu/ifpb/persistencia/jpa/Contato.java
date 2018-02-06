package br.edu.ifpb.persistencia.jpa;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author romulo
 */
@Entity
public class Contato implements Serializable {

    @Id
    @GeneratedValue
    private int codigo;

    private String nome;
    private String sobreNome;
    private String apelido;

    @Lob
    private String descricao;

    @ElementCollection
    @CollectionTable(name = "Emails")
    private List<String> emails;

    @Lob
    private byte[] foto;

    @Temporal(TemporalType.DATE)
    private Date dataDaCriacao;

    @ElementCollection
    @CollectionTable(name = "Telefones")
    private List<Telefone> telefones;

    public Contato() {
        this.emails = new ArrayList<>();
        this.telefones = new ArrayList<>();
    }

    public Contato(int codido, String nome, String sobreNome,
            String apelido, String descricao, List<String> emails,
            byte[] foto, Date dataDaCriacao, List<Telefone> telefones) {
        this.codigo = codido;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.apelido = apelido;
        this.descricao = descricao;
        this.emails = emails;
        this.foto = foto;
        this.dataDaCriacao = dataDaCriacao;
        this.telefones = telefones;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getCodido() {
        return codigo;
    }

    public void setCodido(int codido) {
        this.codigo = codido;
    }

    public Date getDataDaCriacao() {
        return dataDaCriacao;
    }

    public void setDataDaCriacao(Date dataDaCriacao) {
        this.dataDaCriacao = dataDaCriacao;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    public boolean addTelefone(Telefone telefone){
        return this.telefones.add(telefone);
    }

    public boolean addEmail(String email){
        return this.emails.add(email);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.sobreNome);
        hash = 17 * hash + Objects.hashCode(this.apelido);
        hash = 17 * hash + Objects.hashCode(this.descricao);
        hash = 17 * hash + Objects.hashCode(this.emails);
        hash = 17 * hash + Arrays.hashCode(this.foto);
        hash = 17 * hash + Objects.hashCode(this.dataDaCriacao);
        hash = 17 * hash + Objects.hashCode(this.telefones);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contato other = (Contato) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sobreNome, other.sobreNome)) {
            return false;
        }
        if (!Objects.equals(this.apelido, other.apelido)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.emails, other.emails)) {
            return false;
        }
        if (!Arrays.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.dataDaCriacao, other.dataDaCriacao)) {
            return false;
        }
        if (!Objects.equals(this.telefones, other.telefones)) {
            return false;
        }
        return true;
    }

}

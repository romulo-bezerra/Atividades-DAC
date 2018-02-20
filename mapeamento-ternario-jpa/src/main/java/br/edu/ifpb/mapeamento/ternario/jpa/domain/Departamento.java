package br.edu.ifpb.mapeamento.ternario.jpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Departamento implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String numero;
    @Column(unique = true)
    private String nome;
    @OneToOne
    private Empregado gerente;
    @OneToMany
    private List<Projeto> projetos;
    @OneToMany(mappedBy = "departamento")
    private List<Empregado> empregados;

    public Departamento() {
    }

    public Departamento(String numero, String nome) {
        empregados = new ArrayList<>();
        projetos = new ArrayList<>();
        this.numero = numero;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Empregado getGerente() {
        return gerente;
    }

    public void setGerente(Empregado gerente) {
        this.gerente = gerente;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public List<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(List<Empregado> empregados) {
        this.empregados = empregados;
    }
    
    public boolean addProjeto(Projeto projeto){
        return projetos.add(projeto);
    }
    
    public boolean addEmpregado(Empregado empregado){
        return empregados.add(empregado);
    }


}

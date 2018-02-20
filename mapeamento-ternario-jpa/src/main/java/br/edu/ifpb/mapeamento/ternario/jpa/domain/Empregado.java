package br.edu.ifpb.mapeamento.ternario.jpa.domain;

import br.edu.ifpb.mapeamento.ternario.jpa.enums.Sexo;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Empregado implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 14)
    private String numeroSeguroSocial;
    @Embedded
    private Endereco endereco;
    @Column(nullable = false)
    private double salario;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @ManyToOne
    @JoinColumn(name = "departamento_gerenciado")
    private Departamento departamento;
    @OneToMany(mappedBy = "empregado")
    private List<TrabalhaEmProjeto> trabalhaEmProjetos;

    public Empregado() {

    }

    public Empregado(String nome, String numeroSeguroSocial, Endereco endereco,
            double salario, Sexo sexo, Date nascimento) {
        trabalhaEmProjetos = new ArrayList<>();
        this.nome = nome;
        this.numeroSeguroSocial = numeroSeguroSocial;
        this.endereco = endereco;
        this.salario = salario;
        this.sexo = sexo;
        this.nascimento = nascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    public void setNumeroSeguroSocial(String numeroSeguroSocial) {
        this.numeroSeguroSocial = numeroSeguroSocial;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<TrabalhaEmProjeto> getTrabalhaEmProjetos() {
        return trabalhaEmProjetos;
    }

    public void setTrabalhaEmProjetos(List<TrabalhaEmProjeto> trabalhaEmProjetos) {
        this.trabalhaEmProjetos = trabalhaEmProjetos;
    }

    public boolean addTrabalhaEmProjeto(TrabalhaEmProjeto trabalhaEmProjeto) {
        return trabalhaEmProjetos.add(trabalhaEmProjeto);
    }


}

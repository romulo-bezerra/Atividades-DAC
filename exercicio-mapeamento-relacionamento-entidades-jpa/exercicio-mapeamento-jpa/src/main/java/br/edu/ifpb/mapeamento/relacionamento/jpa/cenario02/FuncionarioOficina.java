/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.relacionamento.jpa.cenario02;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author romulo
 */
@Entity
public class FuncionarioOficina implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String CPF;
    private String RG;
    private double salario;
    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    public FuncionarioOficina() {

    }

    public FuncionarioOficina(String nome, String CPF, String RG, double salario,
            Funcao funcao) {
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.salario = salario;
        this.funcao = funcao;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

}

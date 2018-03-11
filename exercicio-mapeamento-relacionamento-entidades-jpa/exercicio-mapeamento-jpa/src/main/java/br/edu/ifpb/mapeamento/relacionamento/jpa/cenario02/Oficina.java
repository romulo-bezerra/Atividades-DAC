/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.relacionamento.jpa.cenario02;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author romulo
 */
@Entity
public class Oficina implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private double saldo;
    @Embedded
    private Localizacao localizacao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Conserto> consertos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<FuncionarioOficina> funcionarios;

    public Oficina() {

    }

    public Oficina(double saldo, Localizacao localizacao) {
        this.consertos = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.saldo = saldo;
        this.localizacao = localizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public List<Conserto> getConsertos() {
        return consertos;
    }

    public void setConsertos(List<Conserto> consertos) {
        this.consertos = consertos;
    }

    public List<FuncionarioOficina> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<FuncionarioOficina> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public boolean adicionarConserto(Conserto conserto) {
        return this.consertos.add(conserto);
    }

    public boolean removerConserto(Conserto conserto) {
        return this.consertos.remove(conserto);
    }

    public boolean adicionarFuncionario(FuncionarioOficina funcionario) {
        return this.funcionarios.add(funcionario);
    }

    public boolean removerFuncionario(FuncionarioOficina funcionario) {
        return this.funcionarios.remove(funcionario);
    }

}

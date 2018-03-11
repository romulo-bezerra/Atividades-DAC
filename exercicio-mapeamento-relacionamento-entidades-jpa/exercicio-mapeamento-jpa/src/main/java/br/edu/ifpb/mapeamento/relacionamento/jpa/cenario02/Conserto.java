/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.relacionamento.jpa.cenario02;

import br.edu.ifpb.mapeamento.relacionamento.jpa.conversor.LocalDateConverter;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author romulo
 */
@Entity
public class Conserto implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    private double valor;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate realizacao;
    @OneToOne(cascade = CascadeType.ALL)
    private FuncionarioOficina funcionario;
    
    public Conserto(){
        
    }

    public Conserto(double valor, LocalDate realizacao, 
            FuncionarioOficina funcionario) {
        this.valor = valor;
        this.realizacao = realizacao;
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getRealizacao() {
        return realizacao;
    }

    public void setRealizacao(LocalDate realizacao) {
        this.realizacao = realizacao;
    }

    public FuncionarioOficina getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioOficina funcionario) {
        this.funcionario = funcionario;
    }
    
}

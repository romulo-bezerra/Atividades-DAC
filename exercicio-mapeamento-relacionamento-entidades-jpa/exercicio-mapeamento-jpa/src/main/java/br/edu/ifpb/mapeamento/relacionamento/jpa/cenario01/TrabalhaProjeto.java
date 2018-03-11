/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.relacionamento.jpa.cenario01;

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
public class TrabalhaProjeto implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private int qntHorasTrabalhadas;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate dataIngresso;

    @OneToOne(cascade = CascadeType.ALL)
    private Projeto projeto;

    @OneToOne(cascade = CascadeType.ALL)
    private Funcionario funcionario;

    public TrabalhaProjeto() {

    }

    public TrabalhaProjeto(int qntHorasTrabalhadas, LocalDate dataIngresso,
            Projeto projeto, Funcionario funcionario) {
        this.qntHorasTrabalhadas = qntHorasTrabalhadas;
        this.dataIngresso = dataIngresso;
        this.projeto = projeto;
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQntHorasTrabalhadas() {
        return qntHorasTrabalhadas;
    }

    public void setQntHorasTrabalhadas(int qntHorasTrabalhadas) {
        this.qntHorasTrabalhadas = qntHorasTrabalhadas;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}

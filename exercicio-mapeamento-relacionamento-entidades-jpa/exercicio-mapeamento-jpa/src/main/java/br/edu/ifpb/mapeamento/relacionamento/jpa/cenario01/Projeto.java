/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.relacionamento.jpa.cenario01;

import br.edu.ifpb.mapeamento.relacionamento.jpa.conversores.LocalDateConverter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

/**
 *
 * @author romulo
 */
@Entity
public class Projeto implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Lob
    private String descricao;
    private String area;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate dataInicio;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate dataPrevistaFim;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    public Projeto() {
    
    }

    public Projeto(String descricao, String area, LocalDate dataInicio,
            LocalDate dataPrevistaFim) {
        funcionarios = new ArrayList<>();
        this.descricao = descricao;
        this.area = area;
        this.dataInicio = dataInicio;
        this.dataPrevistaFim = dataPrevistaFim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataPrevistaFim() {
        return dataPrevistaFim;
    }

    public void setDataPrevistaFim(LocalDate dataPrevistaFim) {
        this.dataPrevistaFim = dataPrevistaFim;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public boolean adicionarFuncionario(Funcionario funcionario) {
        return funcionarios.add(funcionario);
    }

    public boolean removerFuncionarios(Funcionario funcionario) {
        return funcionarios.remove(funcionario);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.ternario.jpa.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author romulo
 */
@Entity
public class TrabalhaEmProjeto implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Empregado empregado;
    @ManyToOne
    private Departamento departamento;
    @ManyToOne
    private Projeto projeto;
    private int horas;

    public TrabalhaEmProjeto() {
    
    }

    public TrabalhaEmProjeto(Empregado empregado, Departamento departamento, 
            Projeto projeto, int horas) {
        this.empregado = empregado;
        this.departamento = departamento;
        this.projeto = projeto;
        this.horas = horas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.empregado);
        hash = 41 * hash + Objects.hashCode(this.departamento);
        hash = 41 * hash + Objects.hashCode(this.projeto);
        hash = 41 * hash + this.horas;
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
        final TrabalhaEmProjeto other = (TrabalhaEmProjeto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.horas != other.horas) {
            return false;
        }
        if (!Objects.equals(this.empregado, other.empregado)) {
            return false;
        }
        if (!Objects.equals(this.departamento, other.departamento)) {
            return false;
        }
        if (!Objects.equals(this.projeto, other.projeto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrabalhaEmProjeto{" + "id=" + id + ", empregado=" 
                + empregado + ", departamento=" + departamento 
                    + ", projeto=" + projeto + ", horas=" + horas + '}';
    }
    

}

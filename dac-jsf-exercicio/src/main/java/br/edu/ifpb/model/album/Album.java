
package br.edu.ifpb.model.album;

import br.edu.ifpb.model.banda.Banda;
import java.time.LocalDate;
import java.util.Objects;

public class Album {
    
    private String descricao;
    private LocalDate dataDeLancamento;
    private Banda banda;

    public Album(){
        
    }

    public Album(String descricao, LocalDate dataDeLancamento, Banda banda) {
        this.descricao = descricao;
        this.dataDeLancamento = dataDeLancamento;
        this.banda = banda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.descricao);
        hash = 23 * hash + Objects.hashCode(this.dataDeLancamento);
        hash = 23 * hash + Objects.hashCode(this.banda);
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
        final Album other = (Album) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.dataDeLancamento, other.dataDeLancamento)) {
            return false;
        }
        if (!Objects.equals(this.banda, other.banda)) {
            return false;
        }
        return true;
    }
    
}
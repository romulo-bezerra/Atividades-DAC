
package br.edu.ifpb.model.banda;

import br.edu.ifpb.model.integrante.Integrante;
import java.util.List;
import java.util.Objects;

public class Banda {
    
    private String nome;
    private List<Integrante> integrantes;
    
    public Banda(){
        
    }

    public Banda(String nome, List<Integrante> integrantes) {
        this.nome = nome;
        this.integrantes = integrantes;
    }
    
    public boolean addIntegrantes(Integrante i){
        return integrantes.add(i);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.integrantes);
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
        final Banda other = (Banda) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.integrantes, other.integrantes)) {
            return false;
        }
        return true;
    }
    
}
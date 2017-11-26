
package br.edu.ifpb.model.integrante;

import java.util.List;

public interface Integrantes {
    
    public boolean salvarIntegrante(Integrante i);
    public List<Integrante> listarIntegrantes();
    public boolean excluirIntegrante(Integrante i);
}

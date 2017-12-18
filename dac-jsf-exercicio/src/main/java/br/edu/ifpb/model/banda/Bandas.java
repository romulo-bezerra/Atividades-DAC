
package br.edu.ifpb.model.banda;

import java.util.List;

public interface Bandas {
    
    public boolean salvarBanda(Banda b);
    public List<Banda> listarBandas();
    public boolean excluirBanda(Banda b);
}

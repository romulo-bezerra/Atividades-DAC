
package br.edu.ifpb.infra.persistence.memory;

import br.edu.ifpb.model.banda.Banda;
import br.edu.ifpb.model.banda.Bandas;
import br.edu.ifpb.model.integrante.Integrante;
import java.util.ArrayList;
import java.util.List;

public class BandasEmMemoria implements Bandas{
    
    public static List<Banda> bandas = new ArrayList<>();
    
    @Override
    public boolean salvarBanda(Banda b) {
        return bandas.add(b);
    }

    @Override
    public List<Banda> listarBandas() {
        return bandas;
    }

    @Override
    public boolean excluirBanda(Banda b) {
        return bandas.remove(b);
    }
    
    
}
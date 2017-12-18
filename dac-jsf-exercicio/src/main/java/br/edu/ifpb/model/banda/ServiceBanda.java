
package br.edu.ifpb.model.banda;

import br.edu.ifpb.infra.persistence.memory.BandasEmMemoria;
import java.util.List;

public class ServiceBanda {
    
    private final Bandas bandaDAO = new BandasEmMemoria();
    
    public boolean salvarBanda(Banda b){
        return bandaDAO.salvarBanda(b);
    }
    
    public List<Banda> listarBandas(){
        return bandaDAO.listarBandas();
    }
    
    public boolean removerBanda(Banda b){
        return bandaDAO.excluirBanda(b);
    }
}

package br.edu.ifpb.web;

import br.edu.ifpb.model.banda.Banda;
import br.edu.ifpb.model.banda.ServiceBanda;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ControladorDeBanda {
    
    private Banda banda = new Banda();
    private final ServiceBanda serviceBanda = new ServiceBanda();
    
    
    public String salvarBanda(){
        if(serviceBanda.salvarBanda(banda)){
            return "cadastroBandas.xhtml";
        }
        return null;
    }
    
    public List<Banda> listarBandas(){
        return serviceBanda.listarBandas();
    }
    
    public String excluirBanda(Banda b){
        this.serviceBanda.removerBanda(b);
        return null;
    }
    
    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
    
}
package br.edu.ifpb.app.jsf;

import br.edu.ifpb.service.shared.Carrinho;
import br.edu.ifpb.service.shared.ServiceLookup;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class ControladorDeCarrinho implements Serializable {

    private String produto;

    private Carrinho carrinho;

    @PostConstruct
    public void init() {
        this.carrinho = new ServiceLookup()
                    .lookup("localhost", "3700", "java:global/service-core-stateful/CarrinhoOnline");
    }
    
    public String add() {
        this.carrinho.adicionarProduto(produto);
        this.produto = "";
        return null;
    }

    public String remove(String produto) {
        this.carrinho.removerProduto(produto);
        return null;
    }

    public String finalizarCompra() {
        this.carrinho.finalizarCompra();
        encerrarSessao();
        return "home.xhtml?faces-redirect=true";
    }

    public List<String> todosOsProdutos() {
        return this.carrinho.listarProdutos();
    }

    private void encerrarSessao() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        if (session != null) {
            session.invalidate();
        }
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

}

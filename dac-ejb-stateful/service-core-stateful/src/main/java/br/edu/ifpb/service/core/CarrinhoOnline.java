package br.edu.ifpb.service.core;

import br.edu.ifpb.service.shared.Carrinho;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@Remote(Carrinho.class)
public class CarrinhoOnline implements Carrinho {

    private List<String> produtos = new ArrayList<>();

    @Override
    public void adicionarProduto(String produto) {
        produtos.add(produto);
    }

    @Override
    public void removerProduto(String produto) {
        produtos.remove(produto);
    }

    @Override
    public List<String> listarProdutos() {
        return Collections.unmodifiableList(produtos);
    }
    
    @Remove
    @Override
    public void finalizarCompra() {
        produtos.removeAll(produtos);
    }

}

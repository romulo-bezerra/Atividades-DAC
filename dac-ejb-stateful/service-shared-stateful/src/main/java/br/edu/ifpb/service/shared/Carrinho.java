package br.edu.ifpb.service.shared;

import java.util.List;

public interface Carrinho {

    public void adicionarProduto(String produto);

    public void removerProduto(String produto);

    public List<String> listarProdutos();

    public void finalizarCompra();

}

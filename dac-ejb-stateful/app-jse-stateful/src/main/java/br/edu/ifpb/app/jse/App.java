package br.edu.ifpb.app.jse;

import br.edu.ifpb.service.shared.Carrinho;
import br.edu.ifpb.service.shared.ServiceLookup;

public class App {

    public static void main(String[] args) {

        Carrinho carrinho = new ServiceLookup()
                .lookup("localhost", "3700", 
                        "java:global/service-core-stateful/CarrinhoOnline");
        
        carrinho.adicionarProduto("sabão");
        carrinho.adicionarProduto("milho");
        carrinho.adicionarProduto("sabonete");

        System.out.println(carrinho.listarProdutos());
        
        carrinho.finalizarCompra();

    }
}

package br.edu.ifpb.service.shared;

import java.util.List;

public interface SalaDeBatepapo {

    public boolean addMensagem(String mensagem);

    public boolean rmvMensagem(String mensagem);

    public List<String> listarMensagens();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.service.core;

import br.edu.ifpb.service.shared.SalaDeBatepapo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Singleton;

/**
 *
 * @author romulo
 */
@Singleton
@Remote(SalaDeBatepapo.class)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Lock(LockType.READ)
public class SalaDeBatepapoOnline implements SalaDeBatepapo {
    
    List<String> mensagens;
    
    @PostConstruct
    public void initList(){
        mensagens = new ArrayList<>();
    }

    @Override
    @Lock(LockType.WRITE)
    public boolean addMensagem(String mensagem) {
        return mensagens.add(mensagem);
    }

    @Override
    @Lock(LockType.WRITE)
    public boolean rmvMensagem(String mensagem) {
        return mensagens.remove(mensagem);
    }

    @Override
    public List<String> listarMensagens() {
        return Collections.unmodifiableList(mensagens);
    }

}

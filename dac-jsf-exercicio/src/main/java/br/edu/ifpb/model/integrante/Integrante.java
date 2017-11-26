
package br.edu.ifpb.model.integrante;

public class Integrante {
    
    private String nome;
    private CPF cpf;
    
    public Integrante(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }
       
}
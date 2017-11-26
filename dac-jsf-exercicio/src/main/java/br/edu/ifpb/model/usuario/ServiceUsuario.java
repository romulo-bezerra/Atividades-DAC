
package br.edu.ifpb.model.usuario;

public class ServiceUsuario implements Autenticavel{

    @Override
    public boolean usuarioValido(Usuario u) {
        return "romulo".equalsIgnoreCase(u.getNome()) 
                && "123".equalsIgnoreCase(u.getSenha());
    }
    
}
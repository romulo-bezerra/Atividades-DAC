
package br.edu.ifpb.web;

import br.edu.ifpb.model.usuario.ServiceUsuario;
import br.edu.ifpb.model.usuario.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ControladorDeLogin implements Serializable{
 
    Usuario usuario = new Usuario();
    ServiceUsuario serviceUsuario = new ServiceUsuario();
    
    public String logar(){
        if(serviceUsuario.usuarioValido(usuario)){
            return "cadastro.xhtml";
        }
        return null;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
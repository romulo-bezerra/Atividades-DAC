package br.edu.ifpb.model.album;

import br.edu.ifpb.infra.persistence.memory.AlbunsEmMemoria;
import java.time.LocalDate;
import java.util.List;

public class ServiceAlbum {

    private final Albuns albumDAO = new AlbunsEmMemoria();

    public boolean salvarAlbum(Album a) {
        if (albumValido(a)) {
            return albumDAO.salvarAlbum(a);
        } else {
            return false;
        }
    }
    
    public List<Album> listarAlbuns(){
       return albumDAO.listarAlbuns();
    }

    public boolean albumValido(Album a) {
        return a.getDataDeLancamento() != null 
                && LocalDate.now().isBefore(a.getDataDeLancamento());
    }
    
    public boolean removerAlbum(Album a){
        return albumDAO.excluirAlbum(a);
    }
}
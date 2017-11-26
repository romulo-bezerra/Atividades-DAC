package br.edu.ifpb.web;

import br.edu.ifpb.model.album.Album;
import br.edu.ifpb.model.album.ServiceAlbum;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ControladorDeAlbum {

    private Album album = new Album();
    private final ServiceAlbum service = new ServiceAlbum();

    public String salvar() {
        if (service.salvarAlbum(album)) {
            return "listar.xhtml";
        }
        return null;
    }

    public List<Album> listarAlbuns() {
        return service.listarAlbuns();
    }
    
    public String removerAlbum(Album a){
        this.service.removerAlbum(a);
        return null;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}

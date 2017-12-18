
package br.edu.ifpb.infra.persistence.memory;

import br.edu.ifpb.model.album.Album;
import br.edu.ifpb.model.album.Albuns;
import br.edu.ifpb.model.integrante.Integrante;
import java.util.ArrayList;
import java.util.List;

public class AlbunsEmMemoria implements Albuns {
    
    public static List<Album> albuns = new ArrayList<>();
    
    @Override
    public boolean salvarAlbum(Album album) {
        return albuns.add(album);
    }

    @Override
    public List<Album> listarAlbuns() {
        return albuns;
    }

    @Override
    public boolean excluirAlbum(Album a) {
        return albuns.remove(a);
    }
    
}
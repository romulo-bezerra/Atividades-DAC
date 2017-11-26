
package br.edu.ifpb.model.album;

import java.util.List;

public interface Albuns {
    
    public boolean salvarAlbum(Album a);
    public List<Album> listarAlbuns();
    public boolean excluirAlbum(Album a);
    
}

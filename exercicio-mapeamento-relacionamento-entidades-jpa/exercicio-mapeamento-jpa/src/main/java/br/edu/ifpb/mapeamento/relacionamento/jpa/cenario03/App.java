/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.mapeamento.relacionamento.jpa.cenario03;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author romulo
 */
public class App {
    
    public static void main(String[] args) {
        
        MaterialDidatico materialDidatico  = new MaterialDidatico("X", 1, 
                "Titulo X", Date.valueOf(LocalDate.now()), "Livro", "Sr. X", 
                TipoMaterialDidatico.APOSTILA, true, 3.444);
        
        MaterialDidaticoDao materialDidaticoDao = new MaterialDidaticoDaoImpl();
        
        materialDidaticoDao.salvar(materialDidatico);
        
    }
    
}

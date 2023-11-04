
package com.tienda_v2.service;

import com.tienda_v2.domain.Categoria;
import java.util.*;


public interface CategoriaService {
    
     //Se obtiene un array List con todas las categorias de la tabla
    public List<Categoria> getCategorias(boolean activo);
    
    //Se obtiene una Categoria segun el Id pasado por parametro
    public Categoria getCategoria(Categoria categoria);
            
    //Se actualiza una categoria o se inserta una nueva... (Si no hay id es un insert)
    public void save(Categoria categoria);
    
    //Se elimina una categoria segun el id pasado
    
    public void delete(Categoria categoria);
    
    
}

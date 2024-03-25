package com.proyecto.service;

import com.proyecto.domain.ListaDeseos;
import java.util.List;

public interface ListaDeseosService {
    
    // Obtener una lista de deseos en un List
    List<ListaDeseos> getListaDeseos(boolean activos);
 
    // Obtener un objeto ListaDeseos a partir de su id
    ListaDeseos getListaDeseos(ListaDeseos listaDeseos);          
    
    // Insertar un nuevo objeto ListaDeseos si su id está vacío     
    // Actualizar un objeto ListaDeseos si su id NO está vacío     
    void save(ListaDeseos listaDeseos);          
    
    // Eliminar un objeto ListaDeseos que tiene el id pasado por parámetro     
    void delete(ListaDeseos listaDeseos);
}

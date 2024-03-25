package com.proyecto.service;

import com.proyecto.domain.Contactos;
import java.util.List;

public interface ContactosService {
    
    // Se obtiene un listado de contactoss en un List
    public List<Contactos> getContactos(boolean activos);
 
       // Se obtiene un Contactos, a partir del id de un contactos     
    public Contactos getContactos(Contactos contactos);          
    // Se inserta un nuevo contactos si el id del contactos esta vacío     
    // Se actualiza un contactos si el id del contactos NO esta vacío     
    public void save(Contactos contactos);          
    // Se elimina el contactos que tiene el id pasado por parámetro     
    public void delete(Contactos contactos);
}
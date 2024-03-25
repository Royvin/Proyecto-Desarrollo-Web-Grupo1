package com.proyecto.service.impl;

import com.proyecto.dao.ContactosDao;
import com.proyecto.domain.Contactos;
import com.proyecto.service.ContactosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactosServiceImpl implements ContactosService {
    
    @Autowired
    private ContactosDao contactosDao;

    @Override
    @Transactional(readOnly=true)
    public List<Contactos> getContactos(boolean activos) {
        var lista=contactosDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Contactos getContactos(Contactos contactos) {
        return contactosDao.findById(contactos.getIdContactos()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Contactos contactos) {
        contactosDao.save(contactos);
    }

    @Override
    @Transactional
    public void delete(Contactos contactos) {
        contactosDao.delete(contactos);
    }
}

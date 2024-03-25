package com.proyecto.service.impl;

import com.proyecto.dao.ListaDeseosDao;
import com.proyecto.domain.ListaDeseos;
import com.proyecto.service.ListaDeseosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ListaDeseosServiceImpl implements ListaDeseosService {

    @Autowired
    private ListaDeseosDao listaDeseosDao;

    @Override
    @Transactional(readOnly = true)
    public List<ListaDeseos> getListaDeseos(boolean activos) {
        List<ListaDeseos> lista = listaDeseosDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    //No se porque me da error
    @Override
    @Transactional(readOnly = true)
    public ListaDeseos getListaDeseos(ListaDeseos listaDeseos) {
        return listaDeseosDao.findById(listaDeseos.getIdListaDeseos()).orElse(null);
    }

    @Override
    @Transactional
    public void save(ListaDeseos listaDeseos) {
        listaDeseosDao.save(listaDeseos);
    }

    @Override
    @Transactional
    public void delete(ListaDeseos listaDeseos) {
        listaDeseosDao.delete(listaDeseos);
    }

    @Transactional(readOnly = true)
    public List<ListaDeseos> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
        return listaDeseosDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
}

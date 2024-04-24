package com.rgarmal.usuarios.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgarmal.usuarios.model.Establecimiento;
import com.rgarmal.usuarios.repositories.EstablecimientoRepository;
import com.rgarmal.usuarios.services.EstablecimientoServices;

@Service
public class EstablecimientoServiceImpl implements EstablecimientoServices{

    @Autowired
    EstablecimientoRepository repository;

    @Override
    public List<Establecimiento> findAll() {
        return repository.findAll();
    }

    @Override
    public Establecimiento findById(int codigo) {
        Optional<Establecimiento> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public Establecimiento save(Establecimiento establecimiento) {
        return repository.save(establecimiento);
    }

    @Override
    public Establecimiento update(int codigo, Establecimiento establecimiento) {
        Establecimiento findById = this.findById(codigo);
        if(findById != null){
            establecimiento.setCodigo(findById.getCodigo());
            return repository.save(establecimiento);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
    
}

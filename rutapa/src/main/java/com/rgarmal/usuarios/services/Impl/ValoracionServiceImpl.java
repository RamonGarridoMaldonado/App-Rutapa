package com.rgarmal.usuarios.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgarmal.usuarios.model.Valoracion;
import com.rgarmal.usuarios.repositories.ValoracionRepository;
import com.rgarmal.usuarios.services.ValoracionService;

@Service
public class ValoracionServiceImpl implements ValoracionService{

    @Autowired
    ValoracionRepository repository;

    @Override
    public List<Valoracion> findAll() {
        return repository.findAll();
    }

    @Override
    public Valoracion findById(int codigo) {
        Optional<Valoracion> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public Valoracion save(Valoracion valoracion) {
        return repository.save(valoracion);
    }

    @Override
    public Valoracion update(int codigo, Valoracion valoracion) {
        Valoracion findById = this.findById(codigo);
        if(findById != null){
            valoracion.setCodigo(findById.getCodigo());
            return repository.save(valoracion);
            
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
    
}

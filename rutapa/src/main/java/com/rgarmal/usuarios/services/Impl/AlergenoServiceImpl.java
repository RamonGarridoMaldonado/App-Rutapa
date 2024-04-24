package com.rgarmal.usuarios.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgarmal.usuarios.model.Alergeno;
import com.rgarmal.usuarios.repositories.AlergenoRepository;
import com.rgarmal.usuarios.services.AlergenoService;

@Service
public class AlergenoServiceImpl implements AlergenoService{

    @Autowired
    AlergenoRepository repository;

    @Override
    public List<Alergeno> findAll() {
        return repository.findAll();
    }

    @Override
    public Alergeno findById(int codigo) {
        Optional<Alergeno> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public Alergeno save(Alergeno alergeno) {
        return repository.save(alergeno);
    }

    @Override
    public Alergeno update(int codigo, Alergeno alergeno) {
        Alergeno findById = this.findById(codigo);
        if(findById != null){

            alergeno.setCodigo(findById.getCodigo());

            return repository.save(alergeno);
            
        }
        return null;
    }

    @Override
    public void deleteById(int codigo) {
        repository.deleteById(codigo);
    }    
}

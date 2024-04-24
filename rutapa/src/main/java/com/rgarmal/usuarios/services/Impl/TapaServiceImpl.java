package com.rgarmal.usuarios.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgarmal.usuarios.model.Tapa;
import com.rgarmal.usuarios.repositories.TapaRepository;
import com.rgarmal.usuarios.services.TapaServices;

@Service
public class TapaServiceImpl implements TapaServices {

    @Autowired
    TapaRepository repository;

    @Override
    public List<Tapa> findAll() {
        return repository.findAll();
    }

    @Override
    public Tapa findById(int codigo) {
        Optional<Tapa> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public Tapa save(Tapa tapa) {
        return repository.save(tapa);
    }

    @Override
    public Tapa update(int codigo, Tapa tapa) {
        Tapa findById = this.findById(codigo);
        if(findById != null){
            tapa.setCodigo(findById.getCodigo());
            return repository.save(tapa);
            
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}

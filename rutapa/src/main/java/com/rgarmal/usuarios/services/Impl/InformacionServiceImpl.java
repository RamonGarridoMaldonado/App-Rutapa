package com.rgarmal.usuarios.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rgarmal.usuarios.model.Informacion;
import com.rgarmal.usuarios.repositories.InformacionRepository;
import com.rgarmal.usuarios.services.InformacionService;

@Service
public class InformacionServiceImpl implements InformacionService {

    @Autowired
    InformacionRepository repository;

    @Override
    public List<Informacion> findAll() {
        return repository.findAll();
    }

    @Override
    public Informacion findById(int codigo) {
        Optional<Informacion> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public Informacion save(Informacion informacion) {
       return repository.save(informacion);
    }

    @Override
    public Informacion update(int codigo, Informacion informacion) {
       Informacion findById = this.findById(codigo);
        if(findById != null){
            informacion.setCodigo(findById.getCodigo());
            return repository.save(informacion);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}

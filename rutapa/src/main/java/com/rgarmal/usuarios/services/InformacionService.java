package com.rgarmal.usuarios.services;

import java.util.List;
import com.rgarmal.usuarios.model.Informacion;

public interface InformacionService {
    public List<Informacion> findAll();

    public Informacion findById(int codigo);

    public Informacion save(Informacion informacion);

    public Informacion update(int codigo, Informacion informacion);

    public void deleteById(int id);
}

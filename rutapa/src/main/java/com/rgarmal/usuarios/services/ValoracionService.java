package com.rgarmal.usuarios.services;

import java.util.List;

import com.rgarmal.usuarios.model.Valoracion;

public interface ValoracionService {
    public List<Valoracion> findAll();

    public Valoracion findById(int codigo);

    public Valoracion save(Valoracion valoracion);

    public Valoracion update(int codigo, Valoracion valoracion);

    public void deleteById(int id);
}

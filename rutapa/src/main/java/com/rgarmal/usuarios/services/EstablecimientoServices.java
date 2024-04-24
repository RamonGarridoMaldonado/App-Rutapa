package com.rgarmal.usuarios.services;

import java.util.List;

import com.rgarmal.usuarios.model.Establecimiento;

public interface EstablecimientoServices {
    public List<Establecimiento> findAll();

    public Establecimiento findById(int codigo);

    public Establecimiento save(Establecimiento usuario);

    public Establecimiento update(int codigo, Establecimiento establecimiento);

    public void deleteById(int id);
}

package com.rgarmal.gestion.services;

import java.util.List;

import com.rgarmal.gestion.model.Establecimiento;

public interface EstablecimientoServices {
    public List<Establecimiento> findAll();

    public Establecimiento findById(int codigo);

    public Establecimiento save(Establecimiento usuario);

    public void update(Establecimiento establecimiento);

    public void deleteById(int id);
}

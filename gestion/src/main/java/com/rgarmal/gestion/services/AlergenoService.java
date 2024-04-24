package com.rgarmal.gestion.services;

import java.util.List;

import com.rgarmal.gestion.model.Alergeno;


public interface AlergenoService {
    public List<Alergeno> findAll();

    public Alergeno findById(int codigo);

    public Alergeno save(Alergeno usuario);

    public void update(Alergeno Alergeno);

    public void deleteById(int id);
}

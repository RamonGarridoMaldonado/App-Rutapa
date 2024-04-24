package com.rgarmal.gestion.services;

import java.util.List;

import com.rgarmal.gestion.model.Tapa;

public interface TapaServices {
    public List<Tapa> findAll();

    public Tapa findById(int codigo);

    public Tapa save(Tapa tapa);

    public void update(Tapa tapa);

    public void deleteById(int id);
}

package com.rgarmal.usuarios.services;

import java.util.List;

import com.rgarmal.usuarios.model.Tapa;

public interface TapaServices {
    public List<Tapa> findAll();

    public Tapa findById(int codigo);

    public Tapa save(Tapa tapa);

    public Tapa update(int codigo, Tapa tapa);

    public void deleteById(int id);
}

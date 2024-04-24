package com.rgarmal.usuarios.services;

import java.util.List;
import com.rgarmal.usuarios.model.Alergeno;

public interface AlergenoService {
    public List<Alergeno> findAll();

    public Alergeno findById(int codigo);

    public Alergeno save(Alergeno usuario);

    public Alergeno update(int codigo, Alergeno Alergeno);

    public void deleteById(int id);
}

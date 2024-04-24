package com.rgarmal.usuarios.services;

import java.util.List;

import com.rgarmal.usuarios.model.Usuario;

public interface UsuarioService {
    public List<Usuario> findAll();

    public Usuario findById(String codigo);

    public Usuario save(Usuario usuario);

    public Usuario update(String codigo, Usuario usuario);

    public void deleteById(String id);
}

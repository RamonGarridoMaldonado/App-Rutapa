package com.rgarmal.usuarios.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgarmal.usuarios.model.Usuario;
import com.rgarmal.usuarios.repositories.UsuarioRepository;
import com.rgarmal.usuarios.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository repository;

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario findById(String codigo) {
        Optional<Usuario> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Usuario update(String codigo, Usuario usuario) {
        Usuario findById = this.findById(codigo);
        if(findById != null){
            usuario.setCodigo(findById.getCodigo());
            return repository.save(usuario);
            
        }
        return null;
    }

    @Override
    public void deleteById(String codigo) {
        repository.deleteById(codigo);
    }
}

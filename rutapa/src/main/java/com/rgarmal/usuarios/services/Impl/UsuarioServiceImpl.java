package com.rgarmal.usuarios.services.Impl;

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
    public Usuario update(String correo, Usuario usuario) {
        Usuario findById = this.findById(correo);
        if(findById != null){
            usuario.setCorreoElectronico(findById.getCorreoElectronico());
            return repository.save(usuario);
            
        }
        return null;
    }

    @Override
    public void deleteById(String codigo) {
        repository.deleteById(codigo);
    }
}

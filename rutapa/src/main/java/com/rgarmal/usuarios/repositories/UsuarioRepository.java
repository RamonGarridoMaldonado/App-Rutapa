package com.rgarmal.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rgarmal.usuarios.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String>{
    
}

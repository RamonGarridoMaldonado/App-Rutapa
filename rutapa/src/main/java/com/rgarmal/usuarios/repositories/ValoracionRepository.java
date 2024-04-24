package com.rgarmal.usuarios.repositories;

import org.springframework.stereotype.Repository;

import com.rgarmal.usuarios.model.Valoracion;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion,Integer>{
    
}

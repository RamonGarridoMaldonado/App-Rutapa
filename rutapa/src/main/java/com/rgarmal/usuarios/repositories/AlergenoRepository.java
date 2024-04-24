package com.rgarmal.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rgarmal.usuarios.model.Alergeno;

@Repository
public interface AlergenoRepository extends JpaRepository<Alergeno,Integer> {
    
}

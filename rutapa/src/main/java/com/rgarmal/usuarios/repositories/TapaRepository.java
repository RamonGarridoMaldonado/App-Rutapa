package com.rgarmal.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rgarmal.usuarios.model.Tapa;

@Repository
public interface TapaRepository extends JpaRepository<Tapa,Integer>{
    
}

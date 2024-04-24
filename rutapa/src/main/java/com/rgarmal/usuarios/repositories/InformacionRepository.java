package com.rgarmal.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rgarmal.usuarios.model.Informacion;

@Repository
public interface InformacionRepository extends JpaRepository<Informacion,Integer> {
    
}

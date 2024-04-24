package com.rgarmal.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rgarmal.usuarios.model.Establecimiento;

@Repository
public interface EstablecimientoRepository extends JpaRepository<Establecimiento,Integer> {
    
}

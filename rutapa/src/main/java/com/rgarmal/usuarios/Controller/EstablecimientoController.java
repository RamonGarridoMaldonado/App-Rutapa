package com.rgarmal.usuarios.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rgarmal.usuarios.model.Establecimiento;
import com.rgarmal.usuarios.services.Impl.EstablecimientoServiceImpl;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class EstablecimientoController {
    @Autowired
    EstablecimientoServiceImpl service;

    @GetMapping("/establecimientos")
    List<Establecimiento> all(){
        return service.findAll();
    }

    @GetMapping("/establecimientos/{codigo}")
    Establecimiento findEstablecimiento(@PathVariable int codigo){
        return service.findById(codigo);
    }

    @DeleteMapping("/establecimientos/{codigo}")
    void deleteEstablecimientos(@PathVariable int codigo){
        service.deleteById(codigo);
    }

    @PostMapping("/establecimientos")
    Establecimiento guardar(@RequestBody Establecimiento establecimiento){
        return service.save(establecimiento);
    }

    @PutMapping("/establecimientos/{codigo}")
    Establecimiento actualizar(@PathVariable int codigo, @RequestBody Establecimiento establecimiento){
        return service.update(codigo, establecimiento);
    }
}

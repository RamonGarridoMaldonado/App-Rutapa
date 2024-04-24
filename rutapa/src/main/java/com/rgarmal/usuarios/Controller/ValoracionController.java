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

import com.rgarmal.usuarios.model.Valoracion;
import com.rgarmal.usuarios.services.Impl.ValoracionServiceImpl;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ValoracionController {
    
    @Autowired
    ValoracionServiceImpl service;

    @GetMapping("/valoraciones")
    List<Valoracion> all(){
        return service.findAll();
    }

    @GetMapping("/valoraciones/{codigo}")
    Valoracion findValoracion(@PathVariable int codigo){
        return service.findById(codigo);
    }

    @DeleteMapping("/valoraciones/{codigo}")
    void deleteValoracion(@PathVariable int codigo){
        service.deleteById(codigo);
    }

    @PostMapping("/valoraciones")
    Valoracion guardar(@RequestBody Valoracion valoracion){
        return service.save(valoracion);
    }

    @PutMapping("/valoraciones/{codigo}")
    Valoracion actualizar(@PathVariable int codigo, @RequestBody Valoracion valoracion){
        return service.update(codigo, valoracion);
    }
}
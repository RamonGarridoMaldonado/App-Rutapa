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

import com.rgarmal.usuarios.model.Tapa;
import com.rgarmal.usuarios.services.Impl.TapaServiceImpl;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TapaController {

    @Autowired
    TapaServiceImpl service;

    @GetMapping("/tapas")
    List<Tapa> all(){
        return service.findAll();
    }

    @GetMapping("/tapas/{codigo}")
    Tapa findTapa(@PathVariable int codigo){
        return service.findById(codigo);
    }

    @DeleteMapping("/tapas/{codigo}")
    void deleteTapa(@PathVariable int codigo){
        service.deleteById(codigo);
    }

    @PostMapping("/tapas")
    Tapa guardar(@RequestBody Tapa tapa){
        return service.save(tapa);
    }

    @PutMapping("/tapas/{codigo}")
    Tapa actualizar(@PathVariable int codigo, @RequestBody Tapa tapa){
        return service.update(codigo, tapa);
    }
}

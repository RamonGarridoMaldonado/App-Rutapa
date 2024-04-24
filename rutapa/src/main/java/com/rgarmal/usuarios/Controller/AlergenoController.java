package com.rgarmal.usuarios.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rgarmal.usuarios.model.Alergeno;
import com.rgarmal.usuarios.model.Tapa;
import com.rgarmal.usuarios.model.Usuario;
import com.rgarmal.usuarios.services.Impl.AlergenoServiceImpl;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AlergenoController {
    @Autowired
    AlergenoServiceImpl service;

    @GetMapping("/alergenos")
    List<Alergeno> all(){
        return service.findAll();
    }

    @GetMapping("/alergenos/{codigo}")
    Alergeno findEstablecimiento(@PathVariable int codigo){
        return service.findById(codigo);
    }

    @PostMapping("/alergenos")
    Alergeno guardar(@RequestBody Alergeno alergeno){
        return service.save(alergeno);
    }

    @PutMapping("/alergenos/{codigo}")
    Alergeno actualizar(@PathVariable int codigo, @RequestBody Alergeno alergeno){
        return service.update(codigo, alergeno);
    }

    @DeleteMapping("/alergenos/{codigo}")
    void deleteAlergeno(@PathVariable int codigo) {
        service.deleteById(codigo);
    }
}

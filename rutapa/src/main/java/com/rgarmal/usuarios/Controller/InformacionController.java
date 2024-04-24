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
import com.rgarmal.usuarios.model.Informacion;
import com.rgarmal.usuarios.services.Impl.InformacionServiceImpl;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class InformacionController {

    @Autowired
    InformacionServiceImpl service;

    @GetMapping("/informacion")
    List<Informacion> all(){
        return service.findAll();
    }

    @GetMapping("/informacion/{codigo}")
    Informacion findTapa(@PathVariable int codigo){
        return service.findById(codigo);
    }

    @DeleteMapping("/informacion/{codigo}")
    void deleteTapa(@PathVariable int codigo){
        service.deleteById(codigo);
    }

    @PostMapping("/informacion")
    Informacion guardar(@RequestBody Informacion tapa){
        return service.save(tapa);
    }

    @PutMapping("/informacion/{codigo}")
    Informacion actualizar(@PathVariable int codigo, @RequestBody Informacion tapa){
        return service.update(codigo, tapa);
    }
}

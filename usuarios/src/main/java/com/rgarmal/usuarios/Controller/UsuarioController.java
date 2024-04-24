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

import com.rgarmal.usuarios.model.Usuario;
import com.rgarmal.usuarios.services.impl.UsuarioServiceImpl;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UsuarioController {
    @Autowired
    UsuarioServiceImpl service;

    @GetMapping("/usuarios")
    List<Usuario> all(){
        return service.findAll();
    }

    @GetMapping("/usuarios/{codigo}")
    Usuario findUsuario(@PathVariable String codigo){
        return service.findById(codigo);
    }

    @DeleteMapping("/usuarios/{codigo}")
    void deleteUsuario(@PathVariable String codigo){
        service.deleteById(codigo);
    }

    @PostMapping("/usuarios")
    Usuario guardar(@RequestBody Usuario usuario){
        return service.save(usuario);
    }

    @PutMapping("/usuarios/{codigo}")
    Usuario actualizar(@PathVariable String codigo, @RequestBody Usuario usuario){
        return service.update(codigo, usuario);
    }
}

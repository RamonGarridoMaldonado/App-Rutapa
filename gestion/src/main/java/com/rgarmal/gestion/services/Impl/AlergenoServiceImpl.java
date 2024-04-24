package com.rgarmal.gestion.services.Impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.rgarmal.gestion.model.Alergeno;
import com.rgarmal.gestion.services.AlergenoService;

@Service
public class AlergenoServiceImpl implements AlergenoService {

    @Value("${url.rutapa.rest.service}")
    String urlApi;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Alergeno> findAll() {
        Alergeno[] ca = restTemplate.getForObject(urlApi + "alergenos", Alergeno[].class);
        List<Alergeno> alergenos = Arrays.asList(ca);
        return alergenos;
    }

    @Override
    public Alergeno findById(int codigo) {
        Alergeno alergeno = restTemplate.getForObject(urlApi + "alergenos/" + codigo, Alergeno.class);
        return alergeno;
    }

    @Override
    public Alergeno save(Alergeno alergeno) {
        Alergeno alergeno2 = restTemplate.postForObject(urlApi + "alergenos", alergeno, Alergeno.class);
        return alergeno2;
    }

    @Override
    public void update(Alergeno alergeno) {
        restTemplate.put(urlApi + "alergenos/" + alergeno.getCodigo(), alergeno);
    }

    @Override
    public void deleteById(int id) {
       restTemplate.delete(urlApi + "alergenos/" + id);
    }
}

package com.rgarmal.gestion.services.Impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.rgarmal.gestion.model.Establecimiento;
import com.rgarmal.gestion.services.EstablecimientoServices;

@Service
public class EstablecimientoServiceImpl implements EstablecimientoServices{

    @Value("${url.rutapa.rest.service}")
    String urlApi;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Establecimiento> findAll() {
        Establecimiento[] ca = restTemplate.getForObject(urlApi + "establecimientos", Establecimiento[].class);
        List<Establecimiento> establecimientos = Arrays.asList(ca);
        return establecimientos;
    }

    @Override
    public Establecimiento findById(int codigo) {
        Establecimiento establecimiento = restTemplate.getForObject(urlApi + "establecimientos/" + codigo, Establecimiento.class);
        return establecimiento;
    }

    @Override
    public Establecimiento save(Establecimiento establecimiento) {
        Establecimiento establecimiento2 = restTemplate.postForObject(urlApi + "establecimientos", establecimiento, Establecimiento.class);
        return establecimiento2;
    }

    @Override
    public void update(Establecimiento establecimiento) {
        restTemplate.put(urlApi + "establecimientos/" + establecimiento.getCodigo(), establecimiento);
    }

    @Override
    public void deleteById(int id) {
        restTemplate.delete(urlApi + "establecimientos/" + id);
    }

    
    
}

package com.rgarmal.gestion.services.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import com.rgarmal.gestion.model.Tapa;
import com.rgarmal.gestion.services.TapaServices;

@Service
public class TapaServiceImpl implements TapaServices {

    @Value("${url.rutapa.rest.service}")
    String urlApi;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Tapa> findAll() {
        Tapa[] ca = restTemplate.getForObject(urlApi + "tapas", Tapa[].class);
        List<Tapa> tapas = Arrays.asList(ca);
        return tapas;
    }

    @Override
    public Tapa findById(int codigo) {
        Tapa tapa = restTemplate.getForObject(urlApi + "tapas/" + codigo, Tapa.class);
        return tapa;
    }

    @Override
    public Tapa save(Tapa tapa) {
        Tapa tapa2 = restTemplate.postForObject(urlApi + "tapas", tapa, Tapa.class);
        return tapa2;
    }

    @Override
    public void update(Tapa tapa) {
        restTemplate.put(urlApi + "tapas/" + tapa.getCodigo(), tapa);
    }

    @Override
    public void deleteById(int id) {
        restTemplate.delete(urlApi + "tapas/" + id);
    }
}

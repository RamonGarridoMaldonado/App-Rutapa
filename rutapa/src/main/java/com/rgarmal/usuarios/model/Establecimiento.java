package com.rgarmal.usuarios.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Establecimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nombre;

    @Column(name="direccion")
    private String dirección;

    @Column(name="descripcion")
    private String descripción;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lng")
    private String lng;
    
    @OneToOne(mappedBy = "establecimiento",fetch =  FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnoreProperties("establecimiento")
    Tapa tapa;
    
    public Establecimiento(int codigo, String nombre, String dirección, String descripción, String lat, String lng,
            Tapa tapa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.dirección = dirección;
        this.descripción = descripción;
        this.lat = lat;
        this.lng = lng;
        this.tapa = tapa;
    }

    public Establecimiento() {
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Establecimiento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public Tapa getTapa() {
        return tapa;
    }


    public void setTapa(Tapa tapa) {
        this.tapa = tapa;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Establecimiento other = (Establecimiento) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    

    
}

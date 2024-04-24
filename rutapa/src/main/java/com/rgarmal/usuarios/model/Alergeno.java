package com.rgarmal.usuarios.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Alergeno {

    @Id
    @GeneratedValue
    private int codigo;
    private String nombre;

    /*@ManyToMany(mappedBy = "alergenos",fetch =  FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Tapa> tapas;*/

    @Transient
    private boolean perteneceTapa;

    public Alergeno() {
    }

    public Alergeno(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        Alergeno other = (Alergeno) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    /*public List<Tapa> getTapas() {
        return tapas;
    }

    public void setTapas(List<Tapa> tapas) {
        this.tapas = tapas;
    }*/

    public boolean isPerteneceTapa() {
        return perteneceTapa;
    }

    public void setPerteneceTapa(boolean perteneceTapa) {
        this.perteneceTapa = perteneceTapa;
    }

}
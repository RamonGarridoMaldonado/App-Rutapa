package com.rgarmal.usuarios.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Tapa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nombre;
    private String descripcion;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL) 
    @JoinTable(name = "tapa_alergeno",joinColumns = @JoinColumn(name="tapa_id"),inverseJoinColumns = @JoinColumn(name="alergeno_id"))
    @JsonManagedReference
    private List<Alergeno> alergenos;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnoreProperties("tapa")
    Establecimiento establecimiento;

    private String igredientes;
    private boolean vegano;
    private boolean halal;

    public Tapa(String nombre, String descripcion, boolean vegano, boolean halal) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.vegano = vegano;
        this.halal = halal;
    }

    public Tapa() {
    }

    public Tapa(int codigo) {
        this.codigo = codigo;
    }

    public Tapa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isVegano() {
        return vegano;
    }

    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }

    public boolean isHalal() {
        return halal;
    }

    public void setHalal(boolean halal) {
        this.halal = halal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getIgredientes() {
        return igredientes;
    }

    public void setIgredientes(String igredientes) {
        this.igredientes = igredientes;
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
        Tapa other = (Tapa) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    
}

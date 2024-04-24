package com.rgarmal.gestion.model;

import java.util.List;

public class Tapa {

    private int codigo;
    private String nombre;
    private String descripcion;
    private List<Alergeno> alergenos;
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
    
    public List<Alergeno> getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(List<Alergeno> alergenos) {
        this.alergenos = alergenos;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
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

package com.rgarmal.gestion.model;

import java.util.List;

public class Alergeno {

    private int codigo;
    private String nombre;
    private List<Tapa> tapas;
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

    public List<Tapa> getTapas() {
        return tapas;
    }

    public void setTapas(List<Tapa> tapas) {
        this.tapas = tapas;
    }

    public boolean isPerteneceTapa() {
        return perteneceTapa;
    }

    public void setPerteneceTapa(boolean perteneceTapa) {
        this.perteneceTapa = perteneceTapa;
    }

    public Alergeno(int codigo) {
        this.codigo = codigo;
    }

    
}
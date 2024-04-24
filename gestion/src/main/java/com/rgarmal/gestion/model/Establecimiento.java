package com.rgarmal.gestion.model;

public class Establecimiento {
    
    private int codigo;
    private String nombre;
    private String direccion;
    private String descripcion;
    private Tapa tapa;
    
    public Establecimiento() {
    }

    public Establecimiento(int codigo) {
        this.codigo = codigo;
    }

    public Establecimiento(int codigo, String nombre, String direccion, String descripcion, Tapa tapa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.tapa = tapa;
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


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

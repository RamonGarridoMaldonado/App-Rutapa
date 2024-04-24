package com.rgarmal.usuarios.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Valoracion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private int valoracion;
    
    private String comentario;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Tapa tapa;

    public Valoracion() {
    }

    public Valoracion(int codigo, int valoracion, String comentario, Usuario usuario, Tapa tapa) {
        this.codigo = codigo;
        this.valoracion = valoracion;
        this.comentario = comentario;
        this.usuario = usuario;
        this.tapa = tapa;
    }
    
    public Valoracion(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getValoracion() {
        return valoracion;
    }
    public String getComentario() {
        return comentario;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public Tapa getTapa() {
        return tapa;
    }

    
}
package com.jm2dev.localidades;

public class Provincia {
    private Integer id;
    private String nombre;
    private Integer comunidadId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   

    public Integer getComunidadId() {
        return comunidadId;
    }

    public void setComunidadId(Integer comunidadId) {
        this.comunidadId = comunidadId;
    }
}

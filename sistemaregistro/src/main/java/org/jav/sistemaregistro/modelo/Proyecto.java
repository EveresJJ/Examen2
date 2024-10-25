package org.jav.sistemaregistro.modelo;


import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Required
    private String nombre;

    @Stereotype("TEXT_AREA")
    private String descripcion;

    @Required
    @Stereotype("DATE")
    private Date fechaInicio;

    @Stereotype("DATE")
    private Date fechaFin;

    @OneToMany(mappedBy = "proyecto")
    @ListProperties("nombre, fechaLimite, estado")  // Muestra nombre, fecha límite y estado de las tareas
    private List<Tarea> tareas;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
}

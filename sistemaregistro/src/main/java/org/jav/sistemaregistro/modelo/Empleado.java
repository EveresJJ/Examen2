package org.jav.sistemaregistro.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Required
    private String nombres;

    @Required
    private String apellidos;

    @Required
    @Stereotype("DATE")
    private Date fechaIngreso;

    @Required
    private String cargo;

    @Stereotype("EMAIL")
    private String email;

    @OneToMany(mappedBy = "empleado")
    @ListProperties("nombre, proyecto.nombre, fechaLimite, estado")  // Muestra nombre de la tarea, el proyecto y fecha límite
    private List<Tarea> tareas;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
}

package org.jav.sistemaregistro.modelo;



import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@View(name="Simple", members="nombre, estado")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Required
    private String nombre;

    @Stereotype("TEXT_AREA")
    private String descripcion;

    @Required
    @Stereotype("DATE")
    private Date fechaLimite;

    @ManyToOne
    @ReferenceView("Simple")  
    @DescriptionsList          // Desplegable con nombres de los proyectos
    @NoCreate @NoModify        
    private Proyecto proyecto;

    @ManyToOne
    @ReferenceView("Simple")
    @DescriptionsList(descriptionProperties = "nombres, apellidos")  // Desplegable con nombres y apellidos del empleado
    @NoCreate @NoModify        
    private Empleado empleado;

    @OneToMany(mappedBy = "tarea")
    @ListProperties("fecha, comentario") // Muestra los campos 'fecha' y 'comentario' en la vista de avances
    private List<Avance> avances;

    @Enumerated(EnumType.STRING)
    private EstadoTarea estado;

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

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Avance> getAvances() {
        return avances;
    }

    public void setAvances(List<Avance> avances) {
        this.avances = avances;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public enum EstadoTarea {
        PENDIENTE,
        EN_PROGRESO,
        COMPLETADA
    }
}

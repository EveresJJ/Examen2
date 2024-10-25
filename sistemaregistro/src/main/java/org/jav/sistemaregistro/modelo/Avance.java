package org.jav.sistemaregistro.modelo;



import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Avance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @ReferenceView("Simple")  // Vista simplificada de Tarea
    @DescriptionsList          // Muestra la lista de tareas disponibles
    private Tarea tarea;

    @Required
    @Stereotype("DATE")
    private Date fecha;

    @Stereotype("TEXT_AREA")
    private String comentario;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}


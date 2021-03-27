package com.programaciondos.prueba1.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String nombre;

    private String apellido;

    public Employee(int id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Employee(){
        
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

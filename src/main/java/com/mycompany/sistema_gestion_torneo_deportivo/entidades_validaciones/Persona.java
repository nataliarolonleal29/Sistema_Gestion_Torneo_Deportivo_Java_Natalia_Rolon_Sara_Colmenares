/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones;

/**
 *
 * @author Natalia Rolon Leal
 */
public abstract class Persona {
    protected String nombre;
    protected String documento;
    protected int edad;

    public Persona(String nombre, String documento, int edad) {
        setNombre(nombre);
        setDocumento(documento);
        setEdad(edad);
    }
    
    public abstract void mostrarRol();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        if(documento == null || documento.trim().isEmpty()){
            throw new IllegalArgumentException("El documento no puede estar vacío");
        }
        this.documento = documento.trim();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad <= 0 || edad > 100){
            throw new IllegalArgumentException("La edad debe ser un número entero mayor a 0");
        }
        this.edad = edad;
    }
    
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Posicion {
    
    private String nombre;

    public Posicion(String nombre) {
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre de la posición no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    @Override
    public String toString(){
        return nombre;
    }
    
    
    
    
    
}

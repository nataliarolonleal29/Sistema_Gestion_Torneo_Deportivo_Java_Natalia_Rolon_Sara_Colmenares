/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Entrenador extends Persona{
    private int añosExperiencia;

    public Entrenador(int añosExperiencia, String nombre, String documento, int edad) {
        super(nombre, documento, edad);
        setAñosExperiencia(añosExperiencia);
    }
    
    @Override
    public void mostrarRol() {
        System.out.println("Rol: Entrenador");
        System.out.println("Nombre: " + nombre);
        System.out.println("Años de experiencia: " + añosExperiencia);
        System.out.println("Edad: " + edad + "años");
        System.out.println("Documento: " + documento);
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        if(añosExperiencia < 0){
            throw new IllegalArgumentException("Los años de experiencia no pueden ser negativos");
        }
        this.añosExperiencia = añosExperiencia;
    }
    
    
    
    
}

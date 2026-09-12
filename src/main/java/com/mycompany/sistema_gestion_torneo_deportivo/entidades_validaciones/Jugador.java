/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Jugador extends Persona{
    private Posicion posicion;
    private int numeroCamiseta;

    public Jugador(Posicion posicion, int numeroCamiseta, String nombre, String documento, int edad) {
        super(nombre, documento, edad);
        setPosicion(posicion);
        setNumeroCamiseta(numeroCamiseta);
    }
   
    @Override
    public void mostrarRol() {
        System.out.println("Rol: Jugador");
        System.out.println("Nombre: " + nombre);
        System.out.println("Dorsal: " + numeroCamiseta);
        System.out.println("Posición: " + (posicion != null ? posicion.getNombre() : "Sin asignación"));
        System.out.println("Edad: " + edad + "años");
        System.out.println("Documento: " + documento);
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        if(posicion == null){
            throw new IllegalArgumentException("El jugador debe tener una posición asignada");
        }
        this.posicion = posicion;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        if(numeroCamiseta <= 0 || numeroCamiseta > 99){
            throw new IllegalArgumentException("El número de camiseta debe estar entre 1 y 99");
        }
        this.numeroCamiseta = numeroCamiseta;
    }
    
    
    
    
    
}

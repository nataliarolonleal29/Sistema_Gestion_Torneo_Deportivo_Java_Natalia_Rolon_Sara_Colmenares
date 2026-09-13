/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Equipo {
    
    private String nombre;
    private List<Jugador> jugadores;
    private Entrenador entrenador;

    public Equipo(String nombre) {
        setNombre(nombre);
        this.jugadores = new ArrayList<>();
    }
    
    public static boolean esNombreValido(String nombre){
        return nombre != null && !nombre.trim().isEmpty();
    }
    
    public void agregarJugador(Jugador jugador){
        if(jugador == null){
            throw new IllegalArgumentException("No se puede agregar un jugador nulo");
        }
        this.jugadores.add(jugador);
    }
    
    public void registrar(Jugador jugador){
            agregarJugador(jugador);
    }
    
    public void registrar(Entrenador entrenador){
        setEntrenador(entrenador);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(!esNombreValido(nombre)){
            throw new IllegalArgumentException("El nombre del equipo no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
    
    
    
    
}

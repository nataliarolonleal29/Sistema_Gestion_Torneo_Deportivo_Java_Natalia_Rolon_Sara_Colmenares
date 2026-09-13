/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Partido {
    
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private String fecha;
    private boolean jugado;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, String fecha) {
        if(equipoLocal == null || equipoVisitante == null){
            throw new IllegalArgumentException("Un partido requiere de dos equipos válidos");
        }
        if(equipoLocal.getNombre().equalsIgnoreCase(equipoVisitante.getNombre())){
            throw new IllegalArgumentException("Un equipo no puede jugar contra sí mismo");
        }
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        setFecha(fecha);
        this.golesLocal = 0;
        this.golesVisitante = 0;
        this.jugado = false;
    }
    
    public void registrarResultado(int golesLocal, int golesVisitante){
        setGolesLocal(golesLocal);
        setGolesVisitante(golesVisitante);
        this.jugado =  true;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }
    
    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }
    
    public int getGolesLocal() {
        return golesLocal;
    }
    
    public void setGolesLocal(int golesLocal) {
        if(golesLocal < 0){
            throw new IllegalArgumentException("Los goles del equipo local no pueden ser negativos");
        }
        this.golesLocal = golesLocal;
    }
    
    public int getGolesVisitante() {
        return golesVisitante;
    }
    
    public void setGolesVisitante(int golesVisitante) {
        if(golesVisitante < 0){
            throw new IllegalArgumentException("Los goles del equipo visitante no pueden ser negativos");

        }
        this.golesVisitante = golesVisitante;
    }    

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        if(fecha == null || fecha.trim().isEmpty()){
            throw new IllegalArgumentException("La fecha no puede estar vacía");
        }
        this.fecha = fecha.trim();
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }
    
    @Override
    public String toString(){
        String estado = jugado ? golesLocal + " - " + golesVisitante : "Pendiente";
        return equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre() + " (" + fecha + " ) -> " + estado;
    }
    
    
    
    
    
    
    
}

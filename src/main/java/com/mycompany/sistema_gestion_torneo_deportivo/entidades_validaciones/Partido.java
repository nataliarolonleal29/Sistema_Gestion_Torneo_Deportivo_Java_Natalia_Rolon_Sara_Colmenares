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
        this.equipoVisitante = 0;
        this.jugado = false;
    }
    
    
    
    
}

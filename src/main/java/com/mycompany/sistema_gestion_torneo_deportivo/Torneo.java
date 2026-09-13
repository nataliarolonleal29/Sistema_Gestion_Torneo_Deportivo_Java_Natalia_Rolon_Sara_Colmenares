/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_gestion_torneo_deportivo;

import com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones.Equipo;
import com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones.Partido;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Torneo {
    
    private String nombre;
    private List<Equipo> equipos;
    private List<Partido> partidos;
    
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del torneo no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }
    
    public Torneo(String nombre) {
        setNombre(nombre);
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public Equipo buscarEquipo(String nombreEquipo) {
    for (Equipo e : equipos) {
        if (e.getNombre().equalsIgnoreCase(nombreEquipo.trim())) {
            return e; // Encontrado
        }
    }
    return null; // No existe
    }
    public void agregarEquipo(Equipo equipo) {
    if (equipo == null) {
        throw new IllegalArgumentException("No se puede agregar un equipo nulo");
    }
    if (buscarEquipo(equipo.getNombre()) != null) {
        throw new IllegalArgumentException("Ya existe un equipo registrado con ese nombre.");
    }
    equipos.add(equipo);
    }
    public void programarPartido(String nombreLocal, String nombreVisitante, String fecha) {
    Equipo local = buscarEquipo(nombreLocal);
    Equipo visitante = buscarEquipo(nombreVisitante);

    if (local == null || visitante == null) {
        throw new IllegalArgumentException("Ambos equipos deben estar registrados en el torneo.");
    }

    Partido nuevoPartido = new Partido(local, visitante, fecha);
        partidos.add(nuevoPartido);
    }
    public String generarReporteFinal() {
    StringBuilder sb = new StringBuilder();
    
        sb.append("=========================================\n");
        sb.append("       REPORTE FINAL DEL TORNEO: ").append(nombre).append("\n");
        sb.append("=========================================\n");    
        sb.append("Total de equipos registrados: ").append(equipos.size()).append("\n");
        sb.append("Total de partidos jugados/programados: ").append(partidos.size()).append("\n\n");
        sb.append("--- LISTADO DE PARTIDOS ---\n");
        for (Partido p : partidos) {
            sb.append("- ").append(p.toString()).append("\n");
        }    
        sb.append("=========================================");
        return sb.toString();

    }
    
}

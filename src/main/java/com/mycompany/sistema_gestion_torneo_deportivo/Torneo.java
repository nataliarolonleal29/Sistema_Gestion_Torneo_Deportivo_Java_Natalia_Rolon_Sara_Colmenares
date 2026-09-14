/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_gestion_torneo_deportivo;

import com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones.Equipo;
import com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones.Jugador;
import com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones.Partido;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
            return e;
        }
    }
    return null;
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
    public Jugador buscarJugadorPorNombre(String nombreJugador) {
        if (nombreJugador == null || nombreJugador.trim().isEmpty()) {
            return null;
        }
        
        for (Equipo e : equipos) {
            for (Jugador j : e.getJugadores()) {
                if (j.getNombre().equalsIgnoreCase(nombreJugador.trim())) {
                    return j; 
                }
            }
        }
        return null;
        
        public static class EstadisticaEquipo implements Comparable<EstadisticaEquipo> {
        public Equipo equipo;
        public int partidosJugados;
        public int partidosGanados;
        public int partidosEmpatados;
        public int partidosPerdidos;
        public int golesFavor;
        public int golesContra;
        public int diferenciaGoles;
        public int puntos;

        public EstadisticaEquipo(Equipo equipo) {
            this.equipo = equipo;
        }

        @Override
        public int compareTo(EstadisticaEquipo otro) {
            // Ordenar de mayor a menor por puntos; si hay empate, por diferencia de goles
            if (this.puntos != otro.puntos) {
                return Integer.compare(otro.puntos, this.puntos);
            }
            return Integer.compare(otro.diferenciaGoles, this.diferenciaGoles);
        }
    }

    // 6. Método para calcular y ordenar la tabla de posiciones
    public List<EstadisticaEquipo> calcularTablaPosiciones() {
        List<EstadisticaEquipo> tabla = new ArrayList<>();
        
        // Inicializar estadísticas para cada equipo registrado
        for (Equipo e : equipos) {
            tabla.add(new EstadisticaEquipo(e));
        }

        // Recorrer los partidos para procesar solo los que ya se jugaron
        for (Partido p : partidos) {
            if (p.isJugado()) {
                EstadisticaEquipo estLocal = null;
                EstadisticaEquipo estVisitante = null;

                for (EstadisticaEquipo est : tabla) {
                    if (est.equipo == p.getEquipoLocal()) estLocal = est;
                    if (est.equipo == p.getEquipoVisitante()) estVisitante = est;
                }

                if (estLocal != null && estVisitante != null) {
                    estLocal.partidosJugados++;
                    estVisitante.partidosJugados++;

                    estLocal.golesFavor += p.getGolesLocal();
                    estLocal.golesContra += p.getGolesVisitante();
                    estVisitante.golesFavor += p.getGolesVisitante();
                    estVisitante.golesContra += p.getGolesLocal();

                    // Asignación de puntos (3 por ganar, 1 por empatar, 0 por perder)
                    if (p.getGolesLocal() > p.getGolesVisitante()) {
                        estLocal.partidosGanados++;
                        estLocal.puntos += 3;
                        estVisitante.partidosPerdidos++;
                    } else if (p.getGolesLocal() < p.getGolesVisitante()) {
                        estVisitante.partidosGanados++;
                        estVisitante.puntos += 3;
                        estLocal.partidosPerdidos++;
                    } else {
                        estLocal.partidosEmpatados++;
                        estLocal.puntos += 1;
                        estVisitante.partidosEmpatados++;
                        estVisitante.puntos += 1;
                    }
                }
            }
        }

        
        for (EstadisticaEquipo est : tabla) {
            est.diferenciaGoles = est.golesFavor - est.golesContra;
        }

        
        Collections.sort(tabla);
        return tabla;
    
        
    }
    
}

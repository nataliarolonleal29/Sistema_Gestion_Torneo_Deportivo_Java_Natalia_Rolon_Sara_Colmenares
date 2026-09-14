/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistema_gestion_torneo_deportivo;

import com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones.Entrenador;
import com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones.Equipo;
import com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones.Jugador;
import com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones.Partido;
import com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones.Posicion;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Sistema_Gestion_Torneo_Deportivo {

    private static Torneo torneo;

    public static void main(String[] args) {
        
       Scanner s = new Scanner(System.in);
       
       int opcion = 0; 
       do{
           System.out.println("=====MENU======");
           System.out.println("1. Crear un torneo");
           System.out.println("2. Registrar un equipo dentro del torneo");
           System.out.println("3. Registrar un jugador o un entrenador dentro de un equipo");
           System.out.println("4. Programar un partido entre dos equipos ya registrados");
           System.out.println("5. Registrar el resultado de un partido");
           System.out.println("6. Mostrar la tabla de posiciones");
           System.out.println("7. Buscar un jugador por nombre");
           System.out.println("8. Generar un reporte final del torneo");
           System.out.println("9. Salir");
           
           try {
                opcion = Integer.parseInt(s.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingresa un número válido.");
                continue; 
            }
            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingresa el nombre del torneo: ");
                    String nombreTorneo = s.nextLine();
                    try {
                        torneo = new Torneo(nombreTorneo);
                        System.out.println("¡Torneo '" + torneo.getNombre() + "' creado con éxito!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(">>> Error al crear el torneo: " + e.getMessage());
                    }
                } 
                
                case 2 -> {
                    if (torneo == null) {
                        System.out.println(">>> ¡Primero debes crear un torneo usando la opción 1!");
                        break;
                    }
                    System.out.print("Ingresa el nombre del equipo a registrar: ");
                    String nombreEquipo = s.nextLine();
                    try {
                        Equipo nuevoEquipo = new Equipo(nombreEquipo);
                        torneo.agregarEquipo(nuevoEquipo);
                        System.out.println("¡Equipo '" + nombreEquipo + "' registrado con éxito!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(">>> Error al registrar equipo: " + e.getMessage());
                    }
                }

                case 3 -> {
                    if (torneo == null) {
                        System.out.println(">>> ¡Primero debes crear un torneo!");
                        break;
                    }
                    System.out.print("Ingresa el nombre del equipo al que deseas agregar la persona: ");
                    String nombreEq = s.nextLine();
                    Equipo eq = torneo.buscarEquipo(nombreEq);
                    
                    if (eq == null) {
                        System.out.println(">>> Error: No se encontró un equipo con ese nombre.");
                        break;
                    }
                    
                    System.out.println("¿Qué deseas registrar? 1. Jugador | 2. Entrenador");
                    int tipo = 0;
                    try {
                        tipo = Integer.parseInt(s.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println(">>> Opción inválida.");
                        break;
                    }
                    
                    try {
                        if (tipo == 1) {
                            System.out.print("Nombre del jugador: ");
                            String nom = s.nextLine();
                            System.out.print("Documento: ");
                            String doc = s.nextLine();
                            System.out.print("Edad: ");
                            int edad = Integer.parseInt(s.nextLine());
                            System.out.print("Posición (ej. Delantero, Portero): ");
                            String nomPos = s.nextLine();
                            System.out.print("Número de camiseta (1-99): ");
                            int dorsal = Integer.parseInt(s.nextLine());
                            
                            Posicion pos = new Posicion(nomPos);
                            Jugador jugador = new Jugador(pos, dorsal, nom, doc, edad);
                            eq.registrar(jugador);
                            System.out.println("¡Jugador registrado con éxito en " + eq.getNombre() + "!");
                            
                        } else if (tipo == 2) {
                            System.out.print("Nombre del entrenador: ");
                            String nom = s.nextLine();
                            System.out.print("Documento: ");
                            String doc = s.nextLine();
                            System.out.print("Edad: ");
                            int edad = Integer.parseInt(s.nextLine());
                            System.out.print("Años de experiencia: ");
                            int exp = Integer.parseInt(s.nextLine());
                            
                            Entrenador entrenador = new Entrenador(exp, nom, doc, edad);
                            eq.registrar(entrenador);
                            System.out.println("¡Entrenador registrado con éxito en " + eq.getNombre() + "!");
                        } else {
                            System.out.println(">>> Opción de tipo inválida.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(">>> Error de validación: " + e.getMessage());
                    }
                }
                
                case 4 -> {
                    if (torneo == null) {
                        System.out.println(">>> ¡Primero debes crear un torneo!");
                        break;
                    }
                    System.out.print("Nombre del equipo local: ");
                    String local = s.nextLine();
                    System.out.print("Nombre del equipo visitante: ");
                    String visitante = s.nextLine();
                    System.out.print("Fecha del partido (ej. 2026-09-15): ");
                    String fecha = s.nextLine();
                    
                    try {
                        torneo.programarPartido(local, visitante, fecha);
                        System.out.println("¡Partido programado con éxito!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(">>> Error al programar partido: " + e.getMessage());
                    }
                }
                
                case 5 -> {
                    if (torneo == null) {
                        System.out.println(">>> ¡Primero debes crear un torneo!");
                        break;
                    }
                    List<Partido> partidos = torneo.getPartidos();
                    if (partidos.isEmpty()) {
                        System.out.println(">>> No hay partidos programados aún.");
                        break;
                    }
                    
                    System.out.println("\n--- LISTA DE PARTIDOS ---");
                    for (int i = 0; i < partidos.size(); i++) {
                        System.out.println((i + 1) + ". " + partidos.get(i));
                    }
                    
                    System.out.print("Elige el número del partido a registrar resultado: ");
                    try {
                        int index = Integer.parseInt(s.nextLine()) - 1;
                        if (index >= 0 && index < partidos.size()) {
                            Partido p = partidos.get(index);
                            System.out.print("Goles de " + p.getEquipoLocal().getNombre() + ": ");
                            int gLocal = Integer.parseInt(s.nextLine());
                            System.out.print("Goles de " + p.getEquipoVisitante().getNombre() + ": ");
                            int gVis = Integer.parseInt(s.nextLine());
                            
                            p.registrarResultado(gLocal, gVis);
                            System.out.println("¡Resultado registrado con éxito!");
                        } else {
                            System.out.println(">>> Número de partido inválido.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(">>> Por favor ingresa un número válido.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(">>> Error en goles: " + e.getMessage());
                    }
                }
                
                case 6 -> {
                    if (torneo == null) {
                        System.out.println(">>> ¡Primero debes crear un torneo!");
                        break;
                    }
                    List<Torneo.EstadisticaEquipo> tabla = torneo.calcularTablaPosiciones();
                    System.out.println("\n===== TABLA DE POSICIONES =====");
                    int pos = 1;
                    for (Torneo.EstadisticaEquipo est : tabla) {
                        System.out.println(pos++ + ". " + est.equipo.getNombre() + 
                                " | Pts: " + est.puntos + 
                                " | PJ: " + est.partidosJugados + 
                                " | PG: " + est.partidosGanados + 
                                " | PE: " + est.partidosEmpatados + 
                                " | PP: " + est.partidosPerdidos + 
                                " | GF: " + est.golesFavor + 
                                " | GC: " + est.golesContra + 
                                " | DIF: " + est.diferenciaGoles);
                    }
                }
                
                case 7 -> {
                    if (torneo == null) {
                        System.out.println(">>> ¡Primero debes crear un torneo!");
                        break;
                    }
                    System.out.print("Ingresa el nombre del jugador a buscar: ");
                    String nombreBuscado = s.nextLine();
                    Jugador j = torneo.buscarJugadorPorNombre(nombreBuscado);
                    if (j != null) {
                        System.out.println("\n--- INFORMACIÓN DEL JUGADOR ---");
                        j.mostrarRol();
                    } else {
                        System.out.println(">>> No se encontró ningún jugador con ese nombre.");
                    }
                }
                
                case 8 -> {
                    if (torneo == null) {
                        System.out.println(">>> ¡Primero debes crear un torneo!");
                        break;
                    }
                    String reporte = torneo.generarReporteFinal();
                    System.out.println(reporte);
                }
                
                case 9 -> {
                    System.out.println("Saliendo del sistema. ¡Mucho éxito con la entrega!");
                }
                
                default -> {
                    System.out.println(">>> Opción inválida. Intenta un número del 1 al 9.");
                }
            }  
        } while (opcion != 9);

        s.close();

        
        
    }
}

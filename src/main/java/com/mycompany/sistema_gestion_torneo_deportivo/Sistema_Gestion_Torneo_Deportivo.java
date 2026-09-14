/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistema_gestion_torneo_deportivo;

import com.mycompany.sistema_gestion_torneo_deportivo.entidades_validaciones.Equipo;
import java.util.Scanner;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Sistema_Gestion_Torneo_Deportivo {

    private static Torneo torneo;

    public static void main(String[] args) {
        
       Scanner s = new Scanner(System.in);
       
       int opcion; 
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
           opcion = s.nextInt();
           try {
                opcion = Integer.parseInt(s.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingresa un número válido.");
                continue; 
            }
            switch (opcion){
               case 1 -> {
                    System.out.print("Ingresa el nombre del torneo: ");
                    String nombreTorneo = s.nextLine();
                    try {
                        torneo = new Torneo(nombreTorneo);
                        System.out.println("¡Torneo " + torneo.getNombre()+ " creado con éxito!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error al crear el torneo: " + e.getMessage());
                    }
                } 
                case 2 -> {
                    if (torneo == null) {
                        System.out.println("¡Primero debes crear un torneo usando la opción 1!");
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
                    System.out.println("Opción en construcción... ¡Aquí agregarás jugadores o entrenadores!");
                }
                case 4 -> {
                    
                }
                case 8 -> {
                    if (torneo == null) {
                        System.out.println(">>> ¡Primero debes crear un torneo!");
                        break;
                    }
                    String reporte = torneo.generarReporteFinal();
                    System.out.println(reporte);
                }
                default -> {
                    System.out.println(">>> Opción inválida. Intenta un número del 1 al 9.");
                }
            }  
        } while (opcion != 9);

        s.close();

        
        
    }
}

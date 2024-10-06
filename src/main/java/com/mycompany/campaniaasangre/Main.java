package com.mycompany.campaniaasangre;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BancoSangre BancoDeSangre = new BancoSangre();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        
        do {
            
            limpiarPantalla();
            
            System.out.println("=== Menú de Gestión de Campañas de Donación ===");
            System.out.println("1. Agregar Campaña nueva");
            System.out.println("2. Agregar Donante a Campaña");
            System.out.println("3. Mostrar Donantes de una Campaña");
            System.out.println("4. Listar Campañas Actuales");
            System.out.println("5. Mostrar Inventario de Sangre");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = Integer.parseInt(reader.readLine());
            
            switch(opcion) {
                case 1 -> {
                    System.out.print("Ingrese la ubicación de la campaña (Por ejemplo: Hospital Van Buren): ");
                    String ubicacion = reader.readLine();
                    System.out.print("Ingrese el nombre de la campaña (Por ejemplo: Campaña Vecinos Solidarios): ");
                    String nombreCampania = reader.readLine();
                    System.out.print("Ingrese la fecha de la campaña (DD-MM-AAAA): ");
                    String fecha = reader.readLine();
                    
                    
                    // Crear nueva campaña
                    Campania nuevaCampania = new Campania(nombreCampania, ubicacion, fecha);
                    BancoDeSangre.agregarCampaña(nuevaCampania);
                    System.out.println("Campaña agregada correctamente.");
                }

                case 2 -> {
                    // Agregar donante a campaña
                    System.out.print("Ingrese la ubicación: ");
                    String ubicacionCampania = reader.readLine();
                    System.out.print("Ingrese el nombre de la campaña: ");
                    String nombreCampaniaDonante = reader.readLine();
                    
                    System.out.print("Ingrese nombre del donante: ");
                    String nombreDonante = reader.readLine();
                    System.out.print("Ingrese la edad del donante: ");
                    int edad = Integer.parseInt(reader.readLine());
                    System.out.print("Ingrese el RUT del donante: ");
                    String rut = reader.readLine();
                    System.out.print("Ingrese el género del donante (M/F): ");
                    String genero = reader.readLine();
                    System.out.print("Ingrese la dirección del donante: ");
                    String direccion = reader.readLine();
                    System.out.print("Ingrese el teléfono del donante: ");
                    String telefono = reader.readLine();
                    System.out.print("Ingrese el email del donante: ");
                    String email = reader.readLine();
                    System.out.print("Ingrese tipo de sangre (Ej: A, O, AB, B): ");
                    String tipoSangre = reader.readLine();
                    System.out.print("Ingrese factor RH (+ o -): ");
                    String factorRH = reader.readLine();
                    System.out.print("Ingrese cantidad donada (en litros): ");
                    double cantidadDonada = Double.parseDouble(reader.readLine());
                    
                    // Crear Donante
                    Persona nuevaPersona = new Persona(nombreDonante, edad, rut, genero, direccion, telefono, email);
                    Donante nuevoDonante = new Donante(nuevaPersona, tipoSangre, factorRH, cantidadDonada);
                    
                    // Registrar donante en la campaña
                    BancoDeSangre.registrarDonanteEnCampaña(nuevoDonante, ubicacionCampania, nombreCampaniaDonante);
                    System.out.println("Donante agregado a la campaña.");
                }

                case 3 -> {
                    // Mostrar donantes de una campaña
                    System.out.print("Ingrese la ubicación: ");
                    String ubicacionMostrar = reader.readLine();
                    System.out.print("Ingrese el nombre de la campaña: ");
                    String nombreCampaniaMostrar = reader.readLine();
                    BancoDeSangre.mostrarDonantesDeCampania(ubicacionMostrar, nombreCampaniaMostrar);
                }
                
                case 4 -> {
                    // Mostrar campañas guardadas
                    BancoDeSangre.listarCampanias();
                }

                case 5 -> // Mostrar inventario de sangre
                    BancoDeSangre.mostrarInventarioSangre();

                case 6 -> System.out.println("Saliendo del sistema...");

                default -> System.out.println("Opción no válida.");
            }
        }while(opcion != 6);
    }
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}

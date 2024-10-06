    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campaniaasangre;


import java.util.*;
import java.io.*;

public class BancoSangre {
    @SuppressWarnings("FieldMayBeFinal")
    private Map<String, List<Campania>> campañas;
    @SuppressWarnings("FieldMayBeFinal")
    private InventarioSangre inventarioDeSangre;
    
    public BancoSangre(){
        campañas = new HashMap<>();
        inventarioDeSangre = new InventarioSangre();
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public void cargarDatosIniciales() {
        String csvFile = "donantes.csv";
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Dividir la línea por comas
                String[] datos = line.split(cvsSplitBy);

                // Crear los objetos necesarios
                String nombre = datos[0];
                int edad = Integer.parseInt(datos[1]);
                String rut = datos[2];
                String genero = datos[3];
                String direccion = datos[4];
                String telefono = datos[5];
                String email = datos[6];
                String tipoSangre = datos[7];
                String factorRH = datos[8];
                double cantDonada = Double.parseDouble(datos[9]);
                String nombreCampania = datos[10];
                String hospital = datos[11];

                Persona persona = new Persona(nombre, edad, rut, genero, direccion, telefono, email);
                Donante donante = new Donante(persona, tipoSangre, factorRH, cantDonada);

                Campania campaña = buscarOCrearCampania(nombreCampania);

                campaña.agregarDonante(donante);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private Campania buscarOCrearCampania(String nombreCampania) {
        for (List<Campania> listaCampanias : campañas.values()) {
            for (Campania campania : listaCampanias) {
                if (campania.getNombre().equals(nombreCampania)) {
                    return campania;
                }
            }
        }
        // Si no se encuentra la campaña, se crea una nueva
        Campania nuevaCampania = new Campania(nombreCampania, "Hospital Desconocido", "Fecha Desconocida");
        campañas.computeIfAbsent("Hospital Desconocido", k -> new ArrayList<>()).add(nuevaCampania);
        return nuevaCampania;
    }
    
    private String generarClaveCampania(String hospital, String nombreCampania) {
        return hospital + "-" + nombreCampania;
    }
    
    public void agregarCampaña(Campania campaña) {
        String clave = generarClaveCampania(campaña.getUbicacion(), campaña.getNombre());
        List<Campania> listaCampañas = campañas.getOrDefault(clave, new ArrayList<>());
        listaCampañas.add(campaña);
        campañas.put(clave, listaCampañas);
}

    
    public void registrarDonanteEnCampaña(Donante donante, String ubicacion, String nombre) {
        String clave = generarClaveCampania(ubicacion, nombre);
        List<Campania> listaCampañas = campañas.get(clave);
    
        if(listaCampañas != null) {
            // Aquí podrías buscar la campaña adecuada en la lista si hay más de una
            Campania campaña = listaCampañas.get(0); // Esto asume que siempre hay al menos una
            campaña.agregarDonante(donante);
            inventarioDeSangre.agregarSangre(donante.getTipoSangre(), (int) donante.getCantDonada());
        } else {
            System.out.println("Campaña no encontrada.");
        }
    }

    
    public void registrarDonanteEnCampania(Donante donante, Campania campania) {
        campania.agregarDonante(donante);
        System.out.println("Donante registrado en la campaña: " + campania.getNombre());
    }
    
   public void mostrarDonantesDeCampania(String ubicacion, String nombre) {
       String clave = generarClaveCampania(ubicacion, nombre);
        List<Campania> listaCampanias = campañas.get(clave); // Obtener la lista de campañas asociada a la clave
        if (listaCampanias != null && !listaCampanias.isEmpty()) {
            Campania campania = listaCampanias.get(0); // Si solo hay una campaña, tomamos la primera
            // Mostrar los donantes de la campaña
            System.out.println("Donantes de la campaña " + campania.getNombre() + " en el hospital " + ubicacion + ":");
            for (Donante d : campania.getDonantesRegistrados()) {
                System.out.println(d.getDetalles());
            }
        } else {
            System.out.println("Campaña no encontrada.");
        }
   }
   
   public void listarCampanias() {
    if (campañas.isEmpty()) {
        System.out.println("No hay campañas registradas.");
        return;
    }

    System.out.println("Listado de campañas:");
    for (Map.Entry<String, List<Campania>> entry : campañas.entrySet()) {
        String clave = entry.getKey();
        List<Campania> listaCampanias = entry.getValue();

        for (Campania campania : listaCampanias) {
            System.out.println("Nombre: " + campania.getNombre() + ", Hospital: " + campania.getUbicacion() + ", Fecha: " + campania.getFecha());
        }
    }
}

    
    public void mostrarInventarioSangre() {
        inventarioDeSangre.mostrarInventario();
    }
}

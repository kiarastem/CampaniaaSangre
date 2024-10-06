/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campaniaasangre;

import java.util.*;

public class InventarioSangre {
    @SuppressWarnings("FieldMayBeFinal")
    private Map<String, Integer> reservasSangre;
    
    public InventarioSangre(){
        reservasSangre = new HashMap<>();
        
        reservasSangre.put("A+", 0);
        reservasSangre.put("A-", 0);
        reservasSangre.put("B+", 0);
        reservasSangre.put("B-", 0);
        reservasSangre.put("O+", 0);
        reservasSangre.put("O-", 0);
        reservasSangre.put("AB+", 0);
        reservasSangre.put("AB-", 0);
}
    
    public void agregarSangre(String tipoSangre, int cantidad) {
        if(reservasSangre.containsKey(tipoSangre)){
            reservasSangre.put(tipoSangre, reservasSangre.get(tipoSangre) + cantidad);
        }
        else {
            System.out.println("Tipo de sangre no válido");
        }
    }
    
    public int obtenerCantidadSangre(String tipoSangre) {
        return reservasSangre.getOrDefault(tipoSangre, 0);
    }
    
    public void mostrarInventario() {
        System.out.println("Inventario de reservas de sangre:");
        for(Map.Entry<String, Integer> entry : reservasSangre.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " unidades");
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campaniaasangre;


import java.util.*;

public class BancoSangre {
    private Map<String, Campania> campañas;
    private InventarioSangre inventarioDeSangre;
    
    public BancoSangre(){
        campañas = new HashMap<>();
        inventarioDeSangre = new InventarioSangre();
    }
    
    public void agregarCampaña(Campania campaña){
        campañas.put(campaña.getUbicacion(), campaña);
    }
    
    public void registrarDonanteEnCampaña(Donante donante, String ubicacion){
        Campania campaña = campañas.get(ubicacion);
        if(campaña != null) {
            campaña.agregarDonante(donante);
            inventarioDeSangre.agregarSangre(donante.getTipoSangre(), donante.getCantDonada());
        }
        else {
            System.out.println("Campaña no encontrada.");
        }
    }
    
    public void mostrarCampañasYDonantes(){
        for(Campania campaña : campañas.values()) {
            System.put.println("Campaña en: " + campaña.getUbicacion());
            for(Donante d : campaña.getDonantesRegistrados()) {
                System.out.println(" - " + d.getDetalles());
            }
        }
    }
    
    public void mostrarInventarioSangre() {
        inventarioDeSangre.mostrarInventario();
    }
}

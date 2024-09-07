package com.mycompany.campaniaasangre;
import java.util.*;

public class Campania {
    private String nombre;
    private String ubicacion;
    private String fecha;
    private List<Donante> donantes;
    
    public Campania(String nombre, String ubicacion, String fecha) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.donantes = new ArrayList<>();
    }
    
    public void agregarDonante(Donante donante){
        donantes.add(donante);
    }
    
    public List<Donante> getDonantesRegistrados(){
        return donantes;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getUbicacion () {
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

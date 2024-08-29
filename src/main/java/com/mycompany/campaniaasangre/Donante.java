package com.mycompany.campaniaasangre;

public class Donante {
    private Persona persona;
    private String tipoSangre;
    private String factorRH;
    private double cantDonada;
    
    public Donante(Persona persona, String tipoSangre, String factorRH, double cantDonada) {
        this.persona = persona;
        this.tipoSangre = tipoSangre;
        this.factorRH = factorRH;
        this.cantDonada = cantDonada;
    }
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        if (tipoSangre == "A"|| tipoSangre == "B"|| tipoSangre == "AB"|| tipoSangre == "O") {
            this.tipoSangre = tipoSangre;
        }
    }

    public String getFactorRH() {
        return factorRH;
    }

    public void setFactorRH(String factorRH) {
        if (factorRH == "+" || factorRH == "-") {
            this.factorRH = factorRH;
        }
    }

    public double getCantDonada() {
        return cantDonada;
    }

    public void setCantDonada(double cantDonada) {
        this.cantDonada = cantDonada;
    }
}

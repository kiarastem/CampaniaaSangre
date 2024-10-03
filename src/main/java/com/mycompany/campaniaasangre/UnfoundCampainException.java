
package com.mycompany.campaniaasangre;

public class UnfoundCampainException extends Exception
{
    public UnfoundCampainException() 
    {
        super("Campaña no encontrada.");
    }
}

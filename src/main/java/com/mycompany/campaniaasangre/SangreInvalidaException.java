
package com.mycompany.campaniaasangre;

public class SangreInvalidaException extends Exception
{
    public SangreInvalidaException() 
    {
        super("Tipo de sangre no valido");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio.clase;

import controlador.PrestamoControlador;
import modelo.PrestamoModelo;
import vista.PrestamoVista;

/**
 *
 * @author Nicolas Herrera
 */
public class EJERCICIOCLASE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        PrestamoVista vista = new PrestamoVista();
        PrestamoModelo modelo = new PrestamoModelo();
        PrestamoControlador controlador = new PrestamoControlador(modelo, vista);

    }
    
}

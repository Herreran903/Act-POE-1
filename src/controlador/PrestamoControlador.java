/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.PrestamoModelo;
import vista.PrestamoVista;

/**
 *
 * @author Nicolas Herrera
 */
public class PrestamoControlador 
{
    private PrestamoModelo modelo;
    private PrestamoVista vista;

    public PrestamoControlador(PrestamoModelo auxModelo, PrestamoVista auxVista) 
    {
        this.modelo = auxModelo;
        this.vista = auxVista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        this.vista.addBtnCalcularListener(new CalcularListener());
        this.vista.addBtnNuevoListener(new CalcularListener());

    }
    
    
    class CalcularListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) 
        {
                    
            if(e.getActionCommand().equalsIgnoreCase("CalcularTabla"))
            {
                int montoPrestamo;
                int meses;

                try
                {
                    montoPrestamo = vista.getMontoPrestamo();
                    meses = vista.getMeses();

                    modelo.setMontoPrestamo(montoPrestamo);
                    modelo.setCantidadMeses(meses);
                    modelo.establecerTasaDeInteres();
                    modelo.establecerCuota();
                    modelo.generarDatosAmortizacion();
                    modelo.generarDatosCuotaFija();

                    vista.activarControles(false);
                    String datosNombreAmortizacion[] = {"Mes", "Saldo", "Interes", "Cuota", "Abono", "Saldo Final"};
                    vista.generarTablaAmortizacion(modelo.getDatosAmortizacion(), datosNombreAmortizacion);
                    String datosNombreCuotaFija[] = {"Monto", "Cuota", "Tasa", "Meses"};
                    vista.generarTablaCuotaFija(modelo.getDatosCuotaFija(), datosNombreCuotaFija);
                    vista.interesTotales(modelo.getInteresesTotales());

                } 
                catch(NumberFormatException ex)
                {
                    vista.displayErrorMessage("Necesita ingresar 2 numeros");
                }
           }
           if(e.getActionCommand().equalsIgnoreCase("NuevoPrestamo"))
           {
                vista.activarControles(true);
                vista.desactivarControles(false);
           }
           
           /*if(e.getActionCommand().equalsIgnoreCase("nuevo")){
               vista.activarControles(true);
           }
           
           if(e.getActionCommand().equalsIgnoreCase("cancelar")){
                vista.activarControles(false);
           }*/
           
        }
        
    }
    
}

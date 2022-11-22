/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.PrestamoModelo;
import vista.PrestamoVista;

/**
 *
 * @author Nicolas Herrera
 */
public class PrestamoControlador 
{
    private final PrestamoModelo modelo;
    private final PrestamoVista vista;

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
                    
                    String datosNombreAmortizacion[] = {"Mes", "Saldo", "Interes", "Cuota", "Abono", "Saldo Final"};
                    DefaultTableModel modelTabla = new DefaultTableModel(modelo.getDatosAmortizacion(), datosNombreAmortizacion); 
                    vista.generarTablaAmortizacion(modelTabla);
                    
                    String datosNombreCuotaFija[] = {"Monto", "Cuota", "Tasa", "Meses"};
                    DefaultTableModel modelTabla1 = new DefaultTableModel(modelo.getDatosCuotaFija(), datosNombreCuotaFija); 
                    vista.generarTablaCuotaFija(modelTabla1);
                    
                    vista.interesTotales(modelo.getInteresesTotales());
                    
                    vista.pagTabla();
                } 
                catch(NumberFormatException ex)
                {
                    vista.displayErrorMessage("Necesita ingresar 2 numeros");
                }
           }
           if(e.getActionCommand().equalsIgnoreCase("NuevoPrestamo"))
           {
                vista.pagIngresoDatos();
           }
        } 
    }
}

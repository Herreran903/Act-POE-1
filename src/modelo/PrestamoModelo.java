/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Nicolas Herrera
 */
public class PrestamoModelo 
{
    private double montoPrestamo;
    private double cantidadMeses;
    private double tasaInteres;
    private double cuota;
    private double interesesTotales;
    private Object[][] datosAmortizacion;
    private Object[][] datosCuotaFija;
    
    public PrestamoModelo() 
    {
        this.montoPrestamo = 0;
        this.cantidadMeses = 0;
        this.interesesTotales = 0;
        aaaa
    }
    
    public PrestamoModelo(int auxMontoPrestamo, int auxCantidadMeses)
    {
        this.montoPrestamo = auxMontoPrestamo;
        this.cantidadMeses = auxCantidadMeses;
    }
    
    public void setMontoPrestamo(int auxMontoPrestamo) 
    {
        this.montoPrestamo = auxMontoPrestamo;
    }
    
    public void setCantidadMeses(int auxCantidadMeses) 
    {
        this.cantidadMeses = auxCantidadMeses;
    }
    
    public void establecerTasaDeInteres()
    {
        if(montoPrestamo < 1500000)
        {
            if(cantidadMeses < 12)
            {
                tasaInteres = 2.5;
            }
            else
            {
                tasaInteres = 1.8;
            }
        }
        else if(1500000 <= montoPrestamo && montoPrestamo <= 3000000)
        {
            if(cantidadMeses < 12)
            {
                tasaInteres = 1.9;
            }
            else
            {
                tasaInteres = 1.7;
            }
        }
        else if(montoPrestamo > 3000000)
        {
            tasaInteres = 1.5;
        }
    }
    
    public void establecerCuota()
    {
        double auxCuota = montoPrestamo * (((Math.pow(1 + (tasaInteres/100), cantidadMeses) * (tasaInteres/100))/((Math.pow(1 + (tasaInteres/100), cantidadMeses)) - 1)));
        cuota = (double)Math.round(auxCuota * 1000) /1000;  
    }
    
    public int getcantidadMeses()
    {
        return (int)cantidadMeses;
    }
    
    public double gettasaInteres()
    {
        return tasaInteres;
    }
    
    public int getMontoPrestamo()
    {
        return (int)montoPrestamo;
    }
    
    public Object[][] getDatosAmortizacion()
    {
        return datosAmortizacion;
    }
    
    public Object[][] getDatosCuotaFija()
    {
        return datosCuotaFija;
    }
    
    public double cuota()
    {
        return cuota;
    }    
    
    public void generarDatosAmortizacion()
    {
        double auxMontoPrestamo = montoPrestamo;
        datosAmortizacion = new Object[(int)cantidadMeses][6];
        for(int fila = 0; fila < datosAmortizacion.length; fila++)
        {
            double auxIntereses = auxMontoPrestamo * (tasaInteres/100);
            double intereses = (double)Math.round(auxIntereses * 1000) /1000;
            
            interesesTotales = interesesTotales + intereses;
            
            double auxAbono = cuota - intereses;
            double abono = (double)Math.round(auxAbono * 1000) /1000;
            
            double auxSaldoFinal = auxMontoPrestamo - abono;   
            double saldoFinal = (double)Math.round(auxSaldoFinal * 1000) /1000;
            
            datosAmortizacion[fila][0] = fila+1;
            datosAmortizacion[fila][1] = Math.round(auxMontoPrestamo);
            datosAmortizacion[fila][2] = Math.round(intereses);
            datosAmortizacion[fila][3] = Math.round(cuota);
            datosAmortizacion[fila][4] = Math.round(abono);
            datosAmortizacion[fila][5] = Math.round(saldoFinal);
            
            auxMontoPrestamo = saldoFinal; 
        }
    }
    
    public void generarDatosCuotaFija()
    {
        datosCuotaFija = new Object[1][4];
        datosCuotaFija[0][0] = Math.round(montoPrestamo);
        datosCuotaFija[0][1] = Math.round(cuota);
        datosCuotaFija[0][2] = tasaInteres;
        datosCuotaFija[0][3] = Math.round(cantidadMeses);
    }
    
    public double getInteresesTotales()
    {
        return Math.round(interesesTotales * 1000) /1000;
    }
}

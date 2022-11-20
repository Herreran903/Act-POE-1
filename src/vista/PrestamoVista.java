/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Nicolas Herrera
 */
public class PrestamoVista extends JFrame
{
    private Color rojoClaro;
    private Color blancoClaro;
    
    private JPanel jpCentral;
    private JScrollPane jpTabla1;
    private JScrollPane jpTabla;
    private JPanel jpSuperior;
    private JPanel jpInferior;
    private JPanel jpDerecha;
    private JPanel jpIzquierda;
    private JTable jtTablaAmortizacion;
    private JTable jtTablaCuotaFija;
    private JLabel lblCantidadMeses;
    private JTextField txfCantidadMeses;
    private JLabel lblMontoPrestamo;
    private JTextField txfMontoPrestamo;
    private JButton btnCalcularTabla;
    private JButton btnNuevoPrestamo;
    private JLabel lblInteresesTotales;
    
    public PrestamoVista()
    {
        inicializarComponentes();
    }
    
    private void inicializarComponentes()
    {
        setTitle("PRESTAMO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,700);
        setLocationRelativeTo(null);
        //setResizable(false);
        setLayout(null);
        
        lblInteresesTotales = new JLabel();
        
        rojoClaro = new Color(244,110,81);
        blancoClaro = new Color(250,250,250);
        
        this.getContentPane().setLayout(new BorderLayout());
        
        jpSuperior = new JPanel();
        jpSuperior.setBounds(0,0,300,300);
        jpSuperior.setBackground(rojoClaro);
        
        jpInferior = new JPanel();
        jpInferior.setBackground(rojoClaro);
        
        jpCentral = new JPanel();
        jpCentral.setLayout(new GridBagLayout());
        jpCentral.setBackground(blancoClaro);

        jpDerecha = new JPanel();
        jpDerecha.setBackground(rojoClaro);
        
        jpIzquierda = new JPanel();
        jpIzquierda.setBackground(rojoClaro);
                 
        GridBagConstraints gbc = new GridBagConstraints();
        
        lblMontoPrestamo = new JLabel("MONTO PRESTAMO", SwingConstants.CENTER);
        lblMontoPrestamo.setFont(new Font("Arial", 1, 40));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        jpCentral.add(lblMontoPrestamo, gbc);
        
        txfMontoPrestamo = new JTextField();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jpCentral.add(txfMontoPrestamo, gbc);
        
        lblCantidadMeses = new JLabel("MESES", SwingConstants.CENTER);
        lblCantidadMeses.setFont(new Font("Arial", 1, 40));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 6;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        jpCentral.add(lblCantidadMeses, gbc);
        
        txfCantidadMeses = new JTextField();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        jpCentral.add(txfCantidadMeses, gbc);  
        
        btnCalcularTabla = new JButton("CalcularTabla");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.CENTER;
        jpCentral.add(btnCalcularTabla, gbc);
        
        btnNuevoPrestamo = new JButton("NuevoPrestamo");
        btnNuevoPrestamo.setEnabled(false);
        gbc.gridx = 5;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.CENTER;
        jpCentral.add(btnNuevoPrestamo, gbc);
        
        this.getContentPane().add(jpSuperior, BorderLayout.NORTH);
        this.getContentPane().add(jpInferior, BorderLayout.SOUTH);
        this.getContentPane().add(jpCentral, BorderLayout.CENTER);
        this.getContentPane().add(jpDerecha, BorderLayout.WEST);
        this.getContentPane().add(jpIzquierda, BorderLayout.EAST);
    }
    
    public int getMontoPrestamo()
    {
        return Integer.parseInt(txfMontoPrestamo.getText());
    }
    
    public int getMeses()
    {
        return Integer.parseInt(txfCantidadMeses.getText());
    }
    
    public void addBtnCalcularListener(ActionListener listenControles){
        btnCalcularTabla.addActionListener(listenControles);
    }
    
    public void addBtnNuevoListener(ActionListener listenControles){
        btnNuevoPrestamo.addActionListener(listenControles);
    }
    
    public void displayErrorMessage(String erroMessage){
        JOptionPane.showMessageDialog(this, erroMessage);
    }
    
    public void activarControles(boolean estado)
    {
        txfMontoPrestamo.setText("");
        txfCantidadMeses.setText("");
        lblMontoPrestamo.setEnabled(estado);
        lblMontoPrestamo.setVisible(estado);
        txfMontoPrestamo.setEnabled(estado);
        txfMontoPrestamo.setVisible(estado);   
        lblCantidadMeses.setEnabled(estado);
        lblCantidadMeses.setVisible(estado);        
        txfCantidadMeses.setEnabled(estado);
        txfCantidadMeses.setVisible(estado);
        btnNuevoPrestamo.setEnabled(!estado);
        btnCalcularTabla.setEnabled(estado);
        lblInteresesTotales.setVisible(!estado);   
    }
    
    public void desactivarControles(boolean estado)
    {
        if(btnNuevoPrestamo.getActionCommand().equalsIgnoreCase("NuevoPrestamo"))
        {   
            
            lblInteresesTotales.setText("");
            lblInteresesTotales.setVisible(false);   
            jpTabla1.setVisible(estado);
            jpTabla.setVisible(estado);
            jpTabla1= null;
            jpTabla = null;
            jtTablaAmortizacion = null;
            jtTablaCuotaFija = null;
        }
    }
    
    public void generarTablaAmortizacion(Object[][] datosFila, String[] datosNombre)
    {
        jtTablaAmortizacion = new JTable(datosFila, datosNombre);
        jtTablaAmortizacion.setEnabled(false);
        jpTabla =  new JScrollPane(jtTablaAmortizacion);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        jpCentral.add(jpTabla, gbc);
    }
    
    public void generarTablaCuotaFija(Object[][] datosFila, String[] datosNombre)
    {
        jtTablaCuotaFija = new JTable(datosFila, datosNombre);
        jtTablaCuotaFija.setEnabled(false);
        jpTabla1 =  new JScrollPane(jtTablaCuotaFija);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        jpCentral.add(jpTabla1, gbc);
    }
    
    public void interesTotales(double interesesTotales)
    {   
        lblInteresesTotales.setText(""+interesesTotales);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        jpCentral.add(lblInteresesTotales, gbc);
    }
           
}

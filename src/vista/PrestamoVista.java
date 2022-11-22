/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nicolas Herrera
 */
public class PrestamoVista extends JFrame
{
    private Color rojoClaro;
    private Color blancoClaro;
    final static String tablaPanel = "CardTable";
    final static String ingresoDataPanel = "CardData";
    GridBagConstraints gbc = new GridBagConstraints();
    
    private JPanel jpCentral;
    private JPanel jpIngresoData;
    private JPanel jpTabla;
    private JScrollPane jspTabla1;
    private JScrollPane jspTabla;
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
    private JLabel lblTablas;
    
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
        setLayout(new BorderLayout());
        
        //Componentes Adicionales
        
        rojoClaro = new Color(244,110,81);
        blancoClaro = new Color(250,250,250);
        
        //Componentes JFrame
        
        jpSuperior = new JPanel();
        jpSuperior.setBackground(rojoClaro);
        
        jpInferior = new JPanel();
        jpInferior.setBackground(rojoClaro);
        
        jpCentral = new JPanel();
        jpCentral.setLayout(new CardLayout());
        
        jpDerecha = new JPanel();
        jpDerecha.setBackground(rojoClaro);
        
        jpIzquierda = new JPanel();
        jpIzquierda.setBackground(rojoClaro);
        
        //Componentes jpIngresoData
        
        jpIngresoData = new JPanel();
        jpIngresoData.setLayout(new GridBagLayout());
        jpIngresoData.setBackground(blancoClaro);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        jpIngresoData.add(Box.createGlue(), gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        jpIngresoData.add(Box.createGlue(), gbc);
        
        lblMontoPrestamo = new JLabel("MONTO PRESTAMO", SwingConstants.CENTER);
        lblMontoPrestamo.setFont(new Font("Arial", 1, 40));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        jpIngresoData.add(lblMontoPrestamo, gbc);
        
        txfMontoPrestamo = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        jpIngresoData.add(txfMontoPrestamo, gbc);
        
        lblCantidadMeses = new JLabel("MESES", SwingConstants.CENTER);
        lblCantidadMeses.setFont(new Font("Arial", 1, 40));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        jpIngresoData.add(lblCantidadMeses, gbc);
        
        txfCantidadMeses = new JTextField();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        jpIngresoData.add(txfCantidadMeses, gbc);  
        
        btnCalcularTabla = new JButton("CalcularTabla");
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.CENTER;
        jpIngresoData.add(btnCalcularTabla, gbc);
        
        // Componentes jpTabla
        
        jpTabla = new JPanel();
        jpTabla.setLayout(new GridBagLayout());
        jpTabla.setBackground(blancoClaro);
        
        jspTabla =  new JScrollPane(jtTablaAmortizacion);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        jpTabla.add(jspTabla, gbc);
        
        jspTabla1 =  new JScrollPane(jtTablaCuotaFija);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jpTabla.add(jspTabla1, gbc);

        jtTablaAmortizacion = new JTable();
        jtTablaAmortizacion.getTableHeader().setFont(new Font("Arial", 1, 11));
        jtTablaAmortizacion.getTableHeader().setReorderingAllowed(false);
        jtTablaAmortizacion.getTableHeader().setResizingAllowed(false);
        jtTablaAmortizacion.setFont(new Font("Arial", 1, 10));
        jtTablaAmortizacion.setEnabled(false);  
        
        jtTablaCuotaFija = new JTable();
        jtTablaCuotaFija.getTableHeader().setFont(new Font("Arial", 1, 11));
        jtTablaCuotaFija.getTableHeader().setReorderingAllowed(false);
        jtTablaCuotaFija.getTableHeader().setResizingAllowed(false);
        jtTablaCuotaFija.setFont(new Font("Arial", 1, 10));
        jtTablaCuotaFija.setBackground(blancoClaro);
        jtTablaCuotaFija.setEnabled(false);
        
        lblTablas = new JLabel("TABLAS", SwingConstants.CENTER);
        lblTablas.setFont(new Font("Arial", 1, 40));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jpTabla.add(lblTablas, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        jpTabla.add(Box.createGlue(), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        jpTabla.add(Box.createGlue(), gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        jpTabla.add(Box.createGlue(), gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        jpTabla.add(Box.createGlue(), gbc);

        btnNuevoPrestamo = new JButton("NuevoPrestamo");
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        jpTabla.add(btnNuevoPrestamo, gbc);
        
        lblInteresesTotales = new JLabel();
        lblInteresesTotales.setFont(new Font("Arial", 1, 15));
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        jpTabla.add(lblInteresesTotales, gbc);
        
        //Adicion de los Jpanel a jpCentral y JFrame
        
        jpCentral.add(jpIngresoData, ingresoDataPanel);
        jpCentral.add(jpTabla, tablaPanel);
        
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
    
    public void addBtnCalcularListener(ActionListener listenControles)
    {
        btnCalcularTabla.addActionListener(listenControles);
    }
    
    public void addBtnNuevoListener(ActionListener listenControles)
    {
        btnNuevoPrestamo.addActionListener(listenControles);
    }
    
    public void displayErrorMessage(String erroMessage)
    {
        JOptionPane.showMessageDialog(this, erroMessage);
    }
    
    public void pagTabla()
    {
        CardLayout a = (CardLayout)jpCentral.getLayout();
        a.show(jpCentral, tablaPanel);
        
    }
    
    public void pagIngresoDatos()
    {
        setTitle("PRESTAMO");
        txfMontoPrestamo.setText("");
        txfCantidadMeses.setText("");
        CardLayout a = (CardLayout)jpCentral.getLayout();
        a.show(jpCentral, ingresoDataPanel);
    }
    
    public void generarTablaAmortizacion(DefaultTableModel data)
    {
        setTitle("TABLAS");
        jtTablaAmortizacion.setModel(data);
        jtTablaAmortizacion.setPreferredScrollableViewportSize(new Dimension(jtTablaAmortizacion.getPreferredSize().width, jtTablaAmortizacion.getRowHeight() * 12));
        jspTabla.getViewport().add(jtTablaAmortizacion);   
    }
    
    public void generarTablaCuotaFija(DefaultTableModel data)
    {
        jtTablaCuotaFija.setModel(data);
        jtTablaCuotaFija.setPreferredScrollableViewportSize(new Dimension(jtTablaCuotaFija.getPreferredSize().width, jtTablaCuotaFija.getRowHeight() * 1));
        jspTabla1.getViewport().add(jtTablaCuotaFija);       
    }
    
    public void interesTotales(double interesesTotales)
    {   
        lblInteresesTotales.setText("INTERESES TOTALES: "+interesesTotales);
    }
           
}

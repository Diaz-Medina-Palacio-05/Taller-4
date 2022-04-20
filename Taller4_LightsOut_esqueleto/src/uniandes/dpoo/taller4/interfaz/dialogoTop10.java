package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class dialogoTop10 extends JDialog
{
	private JList listaTop10;
	private DefaultListModel<String> model;
	private panelScroll panelAbajo;
	private JPanel panelArriba;

	
	public dialogoTop10(ArrayList<JPanel> datos)
	{
		setSize(200, 205);
		setLocationRelativeTo(null);
		setTitle("TOP 10");
		setLayout(new BorderLayout());
		
		Color Blanco = new Color(255, 255, 255);
		
		panelArriba = new JPanel();
		panelArriba.setBackground(new Color(0, 150, 238));
		panelArriba.setLayout(new GridLayout(1, 3));
		panelArriba.add(new JLabel());
		JLabel nombre = new JLabel("#  Nombre");
		nombre.setForeground(Blanco);
		panelArriba.add(nombre);
		panelArriba.add(new JLabel());
		
		
		panelAbajo = new panelScroll(datos);
		panelAbajo.setAlignmentX(CENTER_ALIGNMENT);
		panelAbajo.setAlignmentY(CENTER_ALIGNMENT);
		add(panelArriba, BorderLayout.NORTH);
		add(panelAbajo, BorderLayout.CENTER);
		
	}
	
}

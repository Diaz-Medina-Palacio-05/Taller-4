package uniandes.dpoo.taller4.interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class VentanaPrincipal extends JFrame
{
	private VentanaAjustes panelArriba;
	private VentanaMenu panelDerecho;
	private VentanaInfo panelAbajo;
	private VentanaTablero panelCentro;
	private Tablero logica;
	private ArrayList<JPanel> Top10;
	
	public VentanaPrincipal() throws Exception
	{
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("LIGHTS OUT");
		
		setLayout(new BorderLayout());
		
		panelArriba = new VentanaAjustes(this);
		add(panelArriba, BorderLayout.NORTH);
		
		panelDerecho = new VentanaMenu(this);
		add(panelDerecho, BorderLayout.EAST);
		
		panelAbajo = new VentanaInfo(this);
		add(panelAbajo, BorderLayout.SOUTH);	
		
		panelCentro = new VentanaTablero(this);
		add(panelCentro, BorderLayout.CENTER);
		
		Top10 = generarTop10();
	}
	
	
	
	
	private ArrayList<JPanel> generarTop10() throws Exception
	{
		File jugadores = new File("./data/top10.csv");
		BufferedReader br = new BufferedReader(new FileReader(jugadores));
		String line = br.readLine();
		String[] info;
		String datos;
		ArrayList<JPanel> l = new ArrayList<JPanel>();
		Integer i = 1;
		Integer x = 0;
		
		Color Verde = new Color(0, 255, 54);
		Color Azul = new Color(0, 0, 255);
		Font Negrilla = new Font("Arial", Font.BOLD, 15);
		
		while (line != null)
		{
			info = line.split(";");
			JPanel formato = new JPanel();
			formato.setLayout(new GridLayout(1, 6));
			JLabel nombre = new JLabel (info[0]);
			JLabel puntaje = new JLabel (info[1]);
			JLabel posicion = new JLabel (i.toString());
			if (x == 0 || x == 1 || x == 2)
			{
				nombre.setForeground(Verde);
				nombre.setFont(Negrilla);
				
				puntaje.setForeground(Verde);
				puntaje.setFont(Negrilla);
				
				posicion.setForeground(Verde);
				posicion.setFont(Negrilla);
			}
			else if (x == 3)
			{
				nombre.setForeground(Azul);
				nombre.setFont(Negrilla);
				
				puntaje.setForeground(Azul);
				puntaje.setFont(Negrilla);
				
				posicion.setForeground(Azul);
				posicion.setFont(Negrilla);
			}
			
			formato.add(new JLabel());
			formato.add(posicion);
			formato.add(nombre);
			formato.add(new JLabel());
			formato.add(puntaje);
			formato.add(new JLabel());
			l.add(formato);
			x++;
			i++;
			line = br.readLine();
		}
		return l;
	}




	public static void main(String[] args) throws Exception
	{
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}


	public void nuevojuego() 
	{
		Integer tamaño = panelArriba.tamaño();
		Integer dificultad = panelArriba.dificultad();
		logica = new Tablero(tamaño);
		logica.desordenar(dificultad);
		panelCentro.crearCantidades(tamaño);
		panelCentro.actualizar(logica);
	}
	
	public void reiniciar()
	{
		logica.reiniciar();
		panelCentro.actualizar(logica);
	}

	public ArrayList darTop10() throws Exception 
	{
		return Top10;
	}
	
	public void actualizarJugador(String nombre) 
	{
		panelAbajo.setJugador(nombre);
		panelCentro.setMovidas(0);
		actualizarJugadas(0);
	}
	
	public void actualizarJugadas(Integer numero) 
	{
		panelAbajo.setJugadas(numero);
	}
}

package uniandes.dpoo.taller4.interfaz;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

import uniandes.dpoo.taller4.modelo.Tablero;

public class VentanaPrincipal extends JFrame
{
	private VentanaAjustes panelArriba;
	private VentanaMenu panelDerecho;
	private VentanaInfo panelAbajo;
	private VentanaTablero panelCentro;
	private Tablero logica;
	
	public VentanaPrincipal()
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
	}
	
	
	
	
	public static void main(String[] args)
	{
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}


	public void nuevojuego() 
	{
		Integer tama�o = panelArriba.tama�o();
		Integer dificultad = panelArriba.dificultad();
		logica = new Tablero(tama�o);
		logica.desordenar(dificultad);
		panelCentro.crearCantidades(tama�o);
		panelCentro.actualizar(logica);
	}
	
	public void reiniciar()
	{
		logica.reiniciar();
		panelCentro.actualizar(logica);
	}

	public void darTop10() 
	{
		// TODO Auto-generated method stub
		
	}
	
}

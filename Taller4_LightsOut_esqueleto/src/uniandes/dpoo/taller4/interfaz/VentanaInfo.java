package uniandes.dpoo.taller4.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class VentanaInfo extends JPanel
{
	private VentanaPrincipal principal;

	private JLabel lblJugadas;
	private JTextField Jugadas;
	private JLabel lblJugador;
	private JTextField Jugador;
	
	public VentanaInfo (VentanaPrincipal principal)
	{
		this.principal = principal;
		setBorder(new TitledBorder("Información del Juego"));
		setLayout(new GridLayout(1, 4));
		
		lblJugadas = new JLabel("Jugadas");
		Jugadas = new JTextField("0");
		lblJugador = new JLabel("Jugador");
		Jugador = new JTextField();
		
		Jugadas.setEditable(false);
		Jugador.setEditable(false);
		
		add(lblJugadas);
		add(Jugadas);
		add(lblJugador);
		add(Jugador);
	}
	
	public void setJugadas(Integer movidas)
	{
		String mov = movidas.toString();
		Jugadas.setText(mov);
	}
	
	public void setJugador(String nombre)
	{
		Jugador.setText(nombre);
	}

	
}

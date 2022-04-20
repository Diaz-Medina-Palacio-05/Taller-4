package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class VentanaMenu extends JPanel implements ActionListener
{
	private VentanaPrincipal principal;
	
	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop10;
	private JButton btnCambiarJugador;
	private dialogoTop10 dialTop10;
	private dialogoCambio dialChange;
	private static final String NUEVO = "NUEVO";
	private static final String TOP10 = "TOP10";
	private static final String REINICIAR = "REINICIAR";
	private static final String CHANGE = "CAMBIAR JUGADOR";
	
	public VentanaMenu(VentanaPrincipal principal)
	{
		this.principal = principal;
		
		setBorder(new TitledBorder("Menú"));
		setLayout(new GridLayout(15, 1));
		
		btnNuevo = new JButton("NUEVO");
		btnReiniciar = new JButton("REINICIAR");
		btnTop10 = new JButton("TOP-10");
		btnCambiarJugador = new JButton("Cambiar Jugador");
		
		Color Azul = new Color(0, 150, 238);
		Color Blanco = new Color(255, 255, 255);
		
		btnNuevo.setBackground(Azul);
		btnNuevo.setForeground(Blanco);
		btnNuevo.setOpaque(true);
		btnNuevo.setBorderPainted(false);
		btnReiniciar.setBackground(Azul);
		btnReiniciar.setForeground(Blanco);
		btnReiniciar.setOpaque(true);
		btnReiniciar.setBorderPainted(false);
		btnTop10.setBackground(Azul);
		btnTop10.setForeground(Blanco);
		btnTop10.setOpaque(true);
		btnTop10.setBorderPainted(false);
		btnCambiarJugador.setBackground(Azul);
		btnCambiarJugador.setForeground(Blanco);
		btnCambiarJugador.setOpaque(true);
		btnCambiarJugador.setBorderPainted(false);
		
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(btnNuevo);
		add(new JLabel());
		add(btnReiniciar);
		add(new JLabel());
		add(btnTop10);
		add(new JLabel());
		add(btnCambiarJugador);
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		
		btnNuevo.addActionListener(this);
		btnNuevo.setActionCommand(NUEVO);
		
		btnTop10.addActionListener(this);
		btnTop10.setActionCommand(TOP10);
		
		btnReiniciar.addActionListener(this);
		btnReiniciar.setActionCommand(REINICIAR);
		
		btnCambiarJugador.addActionListener(this);
		btnCambiarJugador.setActionCommand(CHANGE);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{

		String comando = e.getActionCommand();
		if (comando.equals(NUEVO))
		{
			principal.nuevojuego();
		}
		else if (comando.equals(TOP10))
		{
			try {
				dialTop10 = new dialogoTop10(principal.darTop10());
			} catch (Exception e1) {
				System.out.println("ERROR 0713");
				e1.printStackTrace();
			}
			dialTop10.setVisible(true);
		}
		else if (comando.equals(REINICIAR))
		{
			principal.reiniciar();
		}
		else if (comando.equals(CHANGE))
		{
			dialChange = new dialogoCambio(principal);
			dialChange.setVisible(true);
		}
	}

}

package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class dialogoCambio extends JDialog implements ActionListener
{
	private JTextField nuevoNombre;
	private JButton btnAceptar;
	private JLabel lblIngresar;
	private VentanaPrincipal principal;
	private static final String NOMBRE = "NOMBRE";
	
	public dialogoCambio(VentanaPrincipal principal)
	{
		this.principal = principal;
		setSize(220, 210);
		setLocationRelativeTo(null);
		setTitle("Nuevo Jugador");
		setLayout(new GridLayout(2, 3));
		
		lblIngresar = new JLabel("Ingrese su nombre:");
		nuevoNombre = new JTextField();
		btnAceptar = new JButton("Aceptar");
		
		add(lblIngresar);
		add(nuevoNombre);
		add(new JLabel());
		add(new JLabel());
		add(btnAceptar);
		add(new JLabel());
		
		btnAceptar.addActionListener(this);
		btnAceptar.setActionCommand(NOMBRE);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		if (comando.equals(NOMBRE))
		{
			String var = nuevoNombre.getText();
			principal.actualizarJugador(var);
		}
		
	}
	
}

package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class VentanaAjustes extends JPanel implements ActionListener
{
	private VentanaPrincipal principal;
	private JLabel lblMatriz;
	private JComboBox<String> comboMatriz;
	private JLabel lblDificultad;
	private JRadioButton radioFacil;
	private JRadioButton radioMedio;
	private JRadioButton radioDificil;
	
	public VentanaAjustes(VentanaPrincipal principal)
	{
		this.principal = principal;
		setLayout(new GridLayout(1, 8));
		setBackground(new Color(0, 150, 238));
		
		ButtonGroup j = new ButtonGroup();
		
		lblMatriz = new JLabel("Tamaño:");
		comboMatriz = new JComboBox<String>();
		lblDificultad = new JLabel("Dificultad:");
		radioFacil = new JRadioButton("Fácil");
		radioMedio = new JRadioButton("Medio");
		radioDificil = new JRadioButton("Difícil");
		
		j.add(radioFacil);
		j.add(radioDificil);
		j.add(radioMedio);
		
		Color Blanco = new Color(255, 255, 255);
		Font Negrilla = new Font("Arial", Font.BOLD, 15);
		
		lblMatriz.setForeground(Blanco);
		lblMatriz.setFont(Negrilla);
		lblDificultad.setForeground(Blanco);
		lblDificultad.setFont(Negrilla);
		radioFacil.setForeground(Blanco);
		radioMedio.setForeground(Blanco);
		radioDificil.setForeground(Blanco);

		comboMatriz.addItem("3x3");
		comboMatriz.addItem("5x5");
		comboMatriz.addItem("9x9");
		
		add(new JLabel());
		add(lblMatriz);
		add(comboMatriz);
		add(lblDificultad);
		add(radioFacil);
		add(radioMedio);
		add(radioDificil);
		add(new JLabel());
		
		radioFacil.setSelected(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	
	public Integer tamaño ()
	{
		Integer indice = comboMatriz.getSelectedIndex();
		Integer seleccion;
		if (indice == 0)
		{
			seleccion = 3;
		}
		else if (indice == 1)
		{
			seleccion = 5;
		}
		else
		{
			seleccion = 9;
		}
		return seleccion;
	}
	
	public Integer dificultad()
	{
		Integer dificultad;
		if (radioFacil.isSelected())
		{
			dificultad = 4;
		}
		else if (radioMedio.isSelected())
		{
			dificultad = 8;
		}
		else 
		{
			dificultad = 16;
		}
		
		return dificultad;
	}
}

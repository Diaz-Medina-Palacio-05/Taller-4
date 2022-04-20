package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class panelScroll extends JScrollPane
{
	private JList<JPanel> listaTop10;
	private DefaultListModel<JPanel> model;
	
	public panelScroll(ArrayList<JPanel> datos)
	{
		model = new DefaultListModel<JPanel>();
		listaTop10 = new JList<JPanel>();
		JPanel panelLista = new JPanel();
		panelLista.setLayout(new GridLayout(datos.size(), 1));
		
		for(JPanel dato: datos)
		{
			panelLista.add(dato);
		}
		setViewportView(panelLista);
	}
}

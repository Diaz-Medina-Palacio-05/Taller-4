package uniandes.dpoo.taller4.interfaz;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;

public class dialogoTop10 extends JDialog
{
	private JList listaTop10;
	private DefaultListModel<String> model;
	
	public dialogoTop10()
	{
		setSize(300, 150);
		setLocationRelativeTo(null);
		setTitle("TOP 10");
		
		model = new DefaultListModel<String>();
		listaTop10 = new JList<String>();
		model.addElement("Hello");
		listaTop10.setModel(model);
		add(listaTop10);
	}
	
}

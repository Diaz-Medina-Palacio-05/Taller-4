package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class VentanaTablero extends JPanel implements MouseListener 
{
	private Tablero principal;
	private Integer[][] cantidades;
	private Integer movidas;
	private VentanaPrincipal ventanaPrincipal;
	
	public VentanaTablero(VentanaPrincipal ventanaPrincipal) 
	{
		addMouseListener(this);
		this.ventanaPrincipal = ventanaPrincipal;
		movidas = 0;
	}

	public void actualizar(Tablero p)
	{
		principal = p;
		repaint();
	}
	
	public void paint(Graphics g)
	{
		if (principal != null)
		{
			Integer tamaño = principal.darTablero().length;
			Integer tamBloqueX = getWidth() / tamaño;
			Integer tamBloqueY = getHeight() / tamaño;

			Graphics2D g2D = (Graphics2D) g;

			Color negro = new Color(0,0,0);
			Color amarillo = new Color(255, 255, 0);
			Color verde = new Color (0,255,0);


			for (Integer i = 0; i < tamaño; i++)
			{
				for (Integer j = 0; j < tamaño; j++)
				{
					Rectangle2D.Float bloque = new Rectangle2D.Float(i*tamBloqueX, j*tamBloqueY, tamBloqueX, tamBloqueY);
					if (principal.darTablero()[i][j] == true)
					{
						g2D.setColor(amarillo);
						g2D.fill(bloque);
						g2D.setColor(verde);
						g2D.draw(bloque);
					}
					else
					{
						g2D.setColor(negro);
						g2D.fill(bloque);
						g2D.setColor(verde);
						g2D.draw(bloque);
					}
				}
			}
		}
	}
	
	public void crearCantidades(Integer tamaño)
	{
		cantidades = new Integer[tamaño][tamaño];
		for (int i = 0; i < cantidades.length; i++) {
			for (int j = 0; j < cantidades.length; j++) {
				cantidades[i][j]=0;
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
	int click_x = e.getX();
	int click_y = e.getY();
	int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
	cantidades[casilla[0]][casilla[1]]++;
	movidas++;
	ventanaPrincipal.actualizarJugadas(movidas);
	principal.jugar(casilla[0], casilla[1]);
	System.out.println("jugo:"+casilla[0]+","+casilla[1]+"--"+cantidades[casilla[0]][casilla[1]]);
	repaint();
	
	}
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
	int ladoTablero = principal.darTablero().length;
	int altoPanelTablero = getHeight();
	int anchoPanelTablero = getWidth();
	int altoCasilla = altoPanelTablero / ladoTablero;
	int anchoCasilla = anchoPanelTablero / ladoTablero;
	int fila = (int) (y / altoCasilla);
	int columna = (int) (x / anchoCasilla);
	return new int[] { fila, columna };
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setMovidas(int i) 
	{
		movidas = i;
	}
		
	
	
}

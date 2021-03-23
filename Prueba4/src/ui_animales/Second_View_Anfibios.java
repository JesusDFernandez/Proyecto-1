package ui_animales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Second_View_Anfibios {
	
	//ATRIBUTOS
	private JPanel panel;
	private JLabel titulo;
	private JButton volver;
	private JTextArea lista = new JTextArea();
    private JScrollPane panelDeslizable = new JScrollPane();
     
	   

	
	public Second_View_Anfibios(String arreglo, String name) {
		panel = new JPanel(new BorderLayout());

		titulo = new JLabel(".:Lista de Anfibios"+ name);

		lista = new JTextArea();

		lista.setText(arreglo);
		
		JPanel pNorth = crearPNorth();
		JPanel pCenter = crearPCenter();
		JPanel pSouth = crearPSouth();
		
		panel.add(pNorth, BorderLayout.NORTH);
		panel.add(pCenter, BorderLayout.CENTER);
		panel.add(pSouth, BorderLayout.SOUTH);
		
	}
	

	//GETTER - getJPanel()
	public JPanel getJPanel() {
		return this.panel;
	}
	
	//GETTER - getVolver()
	public JButton getVolver() {
		return this.volver;
	}
	
	//METODO - crearPNorth()
	public JPanel crearPNorth() {
		JPanel p = new JPanel(new FlowLayout());
		
		p.add(titulo);
	
		return p;
	}
	


	//METODO - crearPCenter()
	public JPanel crearPCenter() {
		JPanel p = new JPanel(new BorderLayout());
		
		// agregando el scrollpane al area de texto
		panelDeslizable.setViewportView(lista);
		// agregando a la ventana el contenedor scrollpane
		p.add(panelDeslizable,BorderLayout.CENTER);

		return p;
	}
	
	//METODO - crearPSouth()
	public JPanel crearPSouth() {
		JPanel p = new JPanel(new FlowLayout());
		volver = new JButton("Volver");
		volver.addMouseListener(new Evento());
		p.add(volver);
		
		return p;
	}
	
	class Evento extends MouseAdapter{
		
		public void mouseEntered(MouseEvent e) {
			
		}
		
		public void mouseExited(MouseEvent e) {
			
		}
		
		public void mousePressed(MouseEvent e) {
			
		}
	}

}	

package ui_animales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Second_View_Reptiles {
	
	//ATRIBUTOS
	private JPanel panel;
	private JLabel titulo;
	private JButton volver;
	private JTextArea lista = new JTextArea();
    private JScrollPane panelDeslizable = new JScrollPane();
    
    
	public Second_View_Reptiles(String arreglo, String name) {
		panel = new JPanel(new BorderLayout());

		titulo = new JLabel(".:Lista de Reptiles" + name);
		
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
		JPanel pR = new JPanel(new FlowLayout());
		
		pR.add(titulo);
		
		return pR;
	}
	
	//METODO - crearPCenter()
	public JPanel crearPCenter() {
		JPanel pR = new JPanel(new BorderLayout());
		// agregando el scrollpane al area de texto
		panelDeslizable.setViewportView(lista);
		// agregando a la ventana el contenedor scrollpane
		pR.add(panelDeslizable,BorderLayout.CENTER);
		
		
		return pR;
	}
	
	//METODO - crearPSouth()
	public JPanel crearPSouth() {
		JPanel pR = new JPanel(new FlowLayout());
		volver = new JButton("Volver");
		volver.addMouseListener(new Evento());
		pR.add(volver);
		
		return pR;
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

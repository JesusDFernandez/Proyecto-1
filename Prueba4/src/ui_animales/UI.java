package ui_animales;

import javax.swing.*;
import animales.*;

import java.awt.*;
import java.awt.event.*;


public class UI {
	
	//ATRIBUTOS
	private JFrame view;
	private JPanel panel;
	private JLabel titulo, menu;
	private JButton listaM, listaR, listaA, listaAves, editarM, editarR, editarA, editarAves;

	
	//CONSTRUCTOR
	public UI() {
		
		//JFRAME
		view = new JFrame(" Lista de Mamiferos ");
		panel = new JPanel(new BorderLayout());
		
		view.add(panel);
		
		//PANELES
		JPanel pNorth = crearPNorth();
		JPanel pCenter = crearPCenter();
		JPanel pSouth = crearPSouth();
		
		
		panel.add(pNorth, BorderLayout.NORTH);
		panel.add(pCenter, BorderLayout.CENTER);
		panel.add(pSouth, BorderLayout.SOUTH);
		
		//.:EVENTOS:.
		//EVENTO DE LISTA MAMIFEROS
		listaM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	
				Second_View_Mamiferos s1 = new Second_View_Mamiferos(Lista_Mamiferos.getInstances().escribirAnimal(Lista_Mamiferos.getInstances().getLista()),":.");
				view.setContentPane(s1.getJPanel());
				
				s1.getVolver().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
					
						view.setContentPane(panel);
					}
				});
				
				view.invalidate();
				view.validate();
			}
		});
		
		//EVENTO DE LISTA REPTILES
		listaR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				Second_View_Reptiles s2 = new Second_View_Reptiles(Lista_Reptiles.getInstances().escribirAnimal(Lista_Reptiles.getInstances().getLista()),":.");
				view.setContentPane(s2.getJPanel());
				
				s2.getVolver().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
		
						view.setContentPane(panel);
					}
				});
				
				view.invalidate();
				view.validate();
			}
		});
		
		//EVENTO DE LISTA ANFIBIOS
		listaA.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				Second_View_Anfibios s2 = new Second_View_Anfibios(Lista_Anfibios.getInstances().escribirAnimal(Lista_Anfibios.getInstances().getLista()),":.");
				view.setContentPane(s2.getJPanel());
				
				s2.getVolver().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
		
						view.setContentPane(panel);
					}
				});
				
				view.invalidate();
				view.validate();
			}
		});	
		
		//EVENTO DE LISTA AVES
		listaAves.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				Second_View_Aves s2 = new Second_View_Aves(Lista_Aves.getInstances().escribirAnimal(Lista_Aves.getInstances().getLista()),":.");
				view.setContentPane(s2.getJPanel());
				
				s2.getVolver().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
		
						view.setContentPane(panel);
					}
				});
				
				view.invalidate();
				view.validate();
			}
		});	
		//EVENTO DE EDITAR MAMIFEROS
		editarM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	
				Third_View_Mamiferos t3 = new Third_View_Mamiferos();
				view.setContentPane(t3.getJPanel());
				
				t3.getVolver().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {

						view.setContentPane(panel);
					}
				});
				
				view.invalidate();
				view.validate();
				
			}
		});
		
		//EVENTO DE EDITAR REPTILES
		editarR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				Third_View_Reptiles t4 = new Third_View_Reptiles();
				view.setContentPane(t4.getJPanel());
				
				t4.getVolver().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {

						view.setContentPane(panel);
					}
				});
				
				view.invalidate();
				view.validate();
				
			}
		});	
		//EVENTO DE EDITAR ANFIBIOS
		editarA.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				Third_View_Anfibios t4 = new Third_View_Anfibios();
				view.setContentPane(t4.getJPanel());
				
				t4.getVolver().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {

						view.setContentPane(panel);
					}
				});
				
				view.invalidate();
				view.validate();
				
			}
		});	
		
		
		//EVENTO DE EDITAR AVES
		editarAves.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				Third_View_Aves t4 = new Third_View_Aves();
				view.setContentPane(t4.getJPanel());
				
				t4.getVolver().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {

						view.setContentPane(panel);
					}
				});
				
				view.invalidate();
				view.validate();
				
			}
		});	
		view.setBounds(400, 150, 600, 460);
		view.setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	//FIN UI
	
	//.:METODOS:.
	
	//METODO - crearPNorth()
	private JPanel crearPNorth() {
		JPanel p = new JPanel(new FlowLayout());
		titulo = new JLabel("ZOOLOGICO");
		p.add(titulo);
		
		return p;
	}
	
	//METODO - crearPCenter()
	private JPanel crearPCenter() {
		JPanel p = new JPanel(new BorderLayout());
		
		JPanel center_titulo = centerTitulo();
		JPanel center_boton = centerBoton();
		p.add(center_titulo, BorderLayout.NORTH);
		p.add(center_boton, BorderLayout.CENTER);
		
		return p;
	}
	
	//SUB-METODO - centerTitulo()
	private JPanel centerTitulo() {
		JPanel p = new JPanel(new FlowLayout());
		menu = new JLabel(".:MENU:.");
		p.add(menu);
		
		return p;
	}
	
	//SUB-METODO - centerBoton()
	private JPanel centerBoton() {
		JPanel p = new JPanel(null);

		editarM = new JButton("1.- MAMIFEROS");
		editarM.setBounds(50, 15, 210, 30);
		editarM.addMouseListener(new Evento());
		p.add(editarM);
				
		editarR = new JButton("2.- REPTILES");
		editarR.setBounds(50, 70, 210, 30);
		editarR.addMouseListener(new Evento());
		p.add(editarR);
		
		editarA = new JButton("3.- ANFIBIOS");
		editarA.setBounds(50, 125, 210, 30);
		editarA.addMouseListener(new Evento());
		p.add(editarA);
		
		editarAves = new JButton("4.- AVES");
		editarAves.setBounds(50, 175, 210, 30);
		editarAves.addMouseListener(new Evento());
		p.add(editarAves);
		
		listaM = new JButton("1.- Mostrar Lista de Mamiferos");
		listaM.setBounds(330, 15, 210, 30);
		listaM.addMouseListener(new Evento());
		p.add(listaM);
		
		listaR = new JButton("2.- Mostrar Lista de Reptiles");
		listaR.setBounds(330, 70, 210, 30);
		listaR.addMouseListener(new Evento());
		p.add(listaR);
				
		listaA = new JButton("3.- Mostrar Lista de Anfibios");
		listaA.setBounds(330, 125, 210, 30);
		listaA.addMouseListener(new Evento());
		p.add(listaA);		

		listaAves = new JButton("4.- Mostrar Lista de Aves");
		listaAves.setBounds(330, 175, 210, 30);
		listaAves.addMouseListener(new Evento());
		p.add(listaAves);		

		
		return p;
	}
	
	//METODO - crearPSouth()
	private JPanel crearPSouth() {
		JPanel p = new JPanel(new FlowLayout());
		return p;
	}
	
	//CLASS EVENTO
	class Evento extends MouseAdapter{
		
		public void mouseEntered(MouseEvent e) {
	
		}
		
		public void mouseExited(MouseEvent e) {

		}
		
		public void mousePressed(MouseEvent e) {

		}
	}
}

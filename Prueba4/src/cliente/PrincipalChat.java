package cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

import ui_animales.Second_View_Anfibios;
import ui_animales.Second_View_Aves;
import ui_animales.Second_View_Mamiferos;
import ui_animales.Second_View_Reptiles;



public class PrincipalChat extends JFrame {
	

	public JTextField campoTexto; //Para mostrar mensajes de los usuarios
	public JTextArea areaTexto; //Para ingresar mensaje a enviar
	private static ServerSocket servidor; //
	private static Socket cliente; //Socket para conectarse con el cliente
	private static String ip = "127.0.0.1"; //ip a la cual se conecta
	private JScrollPane panelDeslizable = new JScrollPane();
	private JLabel titulo;
	private JButton listaM, listaR, listaA, listaAves;
    public PrincipalChat() {
    	  
    	    
  
        setTitle("Cliente"); //Establece titulo al Frame
        
        titulo = new JLabel(".:CHAT:.");

    	JPanel pNorth = crearPNorth();
		add(pNorth, BorderLayout.NORTH);
		
		JPanel pCenter = crearPCenter();
		add(pCenter, BorderLayout.CENTER);
			
		JPanel pSouth = crearPSouth();
		add(pSouth, BorderLayout.SOUTH);
     
        areaTexto.setForeground(Color.BLACK); 
        campoTexto.setForeground(Color.BLACK); 
    	//.:EVENTOS:.
		//EVENTO DE LISTA MAMIFEROS
		listaM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Second_View_Mamiferos().setVisible(true);
				
			
			}
		});
		
		//EVENTO DE LISTA REPTILES
		listaR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				new Second_View_Reptiles().setVisible(true);
				
			
			}
		});
		
		//EVENTO DE LISTA ANFIBIOS
		listaA.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				new Second_View_Anfibios().setVisible(true);
				
			
			}
		});	
		
		//EVENTO DE LISTA AVES
		listaAves.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				new Second_View_Aves().setVisible(true);;
			
			}
		});	
 
        setSize(430, 390); //Establecer tamano a ventana
        setVisible(true); //Pone visible la ventana
    

}
    
    
	//METODO - crearPNorth()
	public JPanel crearPNorth() {
		JPanel p = new JPanel(new FlowLayout());
		
		p.add(titulo);
	
		return p;
	}
    
	//METODO - crearPCenter()
	public JPanel crearPCenter() {
		JPanel p = new JPanel(new FlowLayout());
	
        areaTexto = new JTextArea(); 
        areaTexto.setEditable(false);
      	areaTexto.setBackground(Color.LIGHT_GRAY); 
     	areaTexto.setPreferredSize(new Dimension(380,210));

      	p.add(areaTexto);
		// agregando el scrollpane al area de texto
		panelDeslizable.setViewportView(areaTexto);
		// agregando a la ventana el contenedor scrollpane
      	
		p.add(panelDeslizable,BorderLayout.CENTER);		
      
		p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
		
		listaM = new JButton("Buscar Mamiferos");
		listaM.setBounds(200, 15, 10, 30);
		listaM.addMouseListener(new Evento());
		p.add(listaM);
		
		listaR = new JButton("Buscar Reptiles     ");
		listaR.setBounds(330, 70, 10, 30);
		listaR.addMouseListener(new Evento());
		p.add(listaR);
				
		listaA = new JButton("Buscar Anfibios     ");
		listaA.setBounds(330, 125, 210, 30);
		listaA.addMouseListener(new Evento());
		p.add(listaA);		

		listaAves = new JButton("Buscar Aves           ");
		listaAves.setBounds(330, 175, 210, 30);
		listaAves.addMouseListener(new Evento());
		p.add(listaAves);		
	
		
		return p;
	}
	
	
	//METODO - crearPSouth()
	public JPanel crearPSouth() {
		JPanel p = new JPanel(new FlowLayout());
	  		     

        campoTexto = new JTextField(); 
        campoTexto.setEditable(false); 
      	campoTexto.setPreferredSize(new Dimension(280,30));
       	p.add(campoTexto);

	    
		return p;
	}

 
    public void mostrarMensaje(String mensaje) {
        areaTexto.append(mensaje + "\n");
    } 
    public void habilitarTexto(boolean editable) {
        campoTexto.setEditable(editable);
    }
    

	//CLASS EVENTO
	private class Evento extends MouseAdapter{
		
		public void mouseEntered(MouseEvent e) {
	
		}
		
		public void mouseExited(MouseEvent e) {

		}
		
		public void mousePressed(MouseEvent e) {

		}
	}
   
    	
    
}

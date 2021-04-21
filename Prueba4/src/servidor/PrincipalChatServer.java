package servidor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import cliente.PrincipalChat;
import cliente.ThreadEnvia;
import cliente.ThreadRecibe;


public class PrincipalChatServer extends JFrame{
	
	public JTextField campoTexto; //Para mostrar mensajes de los usuarios
	public JTextArea areaTexto; //Para ingresar mensaje a enviar
	private static ServerSocket servidor; //
	private static Socket conexion; //Socket para conectarse con el cliente
	private static String ip = "127.0.0.1"; //ip a la cual se conecta
	private JScrollPane panelDeslizable = new JScrollPane();
	private JLabel titulo;
	private static PrincipalChatServer main; 
	private static Socket cliente; //Socket para conectarse con el cliente
	
    public PrincipalChatServer(){
       /* super("Servidor"); //Establece titulo al Frame
        
        
        campoTexto = new JTextField(); //crea el campo para texto
        
        campoTexto.setEditable(false); //No permite que sea editable el campo de texto
        add(campoTexto, BorderLayout.NORTH); //Coloca el campo de texto en la parte superior
        
        areaTexto = new JTextArea(4,4); //Crear displayArea
        areaTexto.setEditable(false);
        
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        
        
        areaTexto.setBackground(Color.orange); //Pone de color cyan al areaTexto
        areaTexto.setForeground(Color.BLACK); //pinta azul la letra en el areaTexto
        campoTexto.setForeground(Color.BLACK); //pinta toja la letra del mensaje a enviar
        
        
        //Crea menu Archivo y submenu Salir, ademas agrega el submenu al menu
        JMenu menuArchivo = new JMenu("Archivo"); 
        JMenuItem salir = new JMenuItem("Salir");
        menuArchivo.add(salir); //Agrega el submenu Salir al menu menuArchivo
        
        JMenuBar barra = new JMenuBar(); //Crea la barra de menus
        setJMenuBar(barra); //Agrega barra de menus a la aplicacion
        barra.add(menuArchivo); //agrega menuArchivo a la barra de menus
        
        //Accion que se realiza cuando se presiona el submenu Salir
        salir.addActionListener(new ActionListener() { //clase interna anonima
                public void actionPerformed(ActionEvent e) {
                    System.exit(0); //Sale de la aplicacion
                }
        });
        
        setSize(300, 320); //Establecer tamano a ventana
        setVisible(true); //Pone visible la ventana
        
   	*/
    	  
        setTitle("Servidor"); //Establece titulo al Frame
        
        titulo = new JLabel(".:CHAT:.");

    	JPanel pNorth = crearPNorth();
		add(pNorth, BorderLayout.NORTH);
		
		JPanel pCenter = crearPCenter();
		add(pCenter, BorderLayout.CENTER);
		
		JPanel pSouth = crearPSouth();
		add(pSouth, BorderLayout.SOUTH);
     
        areaTexto.setForeground(Color.BLACK); //pinta azul la letra en el displayArea
        campoTexto.setForeground(Color.BLACK); //pinta toja la letra del mensaje a enviar
       
                
        setSize(400, 400); //Establecer tamano a ventana
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
		JPanel p = new JPanel(new BorderLayout());
		
        areaTexto = new JTextArea(); //Crear displayArea
        areaTexto.setEditable(false);
      	areaTexto.setBackground(Color.LIGHT_GRAY); //Pone de color cyan al displayAre
     //	areaTexto.setPreferredSize(new Dimension(280,30));
      	p.add(areaTexto);
		// agregando el scrollpane al area de texto
		panelDeslizable.setViewportView(areaTexto);
		// agregando a la ventana el contenedor scrollpane
      	
		p.add(panelDeslizable,BorderLayout.CENTER);

		return p;
	}
	//METODO - crearPSouth()
	public JPanel crearPSouth() {
		JPanel p = new JPanel(new FlowLayout());


	     
	    JButton button = new JButton("CONECTAR");		
        
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
		
				   PrincipalChat main = new PrincipalChat(); //Instanciacion de la clase Principalchat
			        main.setLocation(1000,400);   //Centrar el JFrame
			       
			        ExecutorService executor = Executors.newCachedThreadPool(); //Para correr los threads
			 
			        try {
			            main.mostrarMensaje("Buscando Servidor ...");
			            cliente = new Socket(InetAddress.getByName(ip), 11111); //comunicarme con el servidor
			            main.mostrarMensaje("Conectado a :" + cliente.getInetAddress().getHostName());
			    
			            main.habilitarTexto(true); //habilita el texto
			            
			            //Ejecucion de los Threads
			            executor.execute(new ThreadRecibe(cliente, main));
			            executor.execute(new ThreadEnvia(cliente, main)); 
			            
			        } catch (IOException ex) {
			            Logger.getLogger(PrincipalChat.class.getName()).log(Level.SEVERE, null, ex);
			        } //Fin del catch
			        finally {
			        }
			        executor.shutdown();
        
       
    }  
    	});
        campoTexto = new JTextField(); //crea el campo para texto
        campoTexto.setEditable(false); //No permite que sea editable el campo de texto
      	campoTexto.setPreferredSize(new Dimension(250,30));
      	
       	p.add(campoTexto);
	    p.add(button);
	    
		return p;
	} 
    
    
    //Para mostrar texto en displayArea
    public void mostrarMensaje(String mensaje) {
    	
    	areaTexto.append(mensaje + "\n");
    	

    } 
    public void habilitarTexto(boolean editable) {
        campoTexto.setEditable(editable);
    }
 
    	
 

 

    }

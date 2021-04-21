package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import servidor.PrincipalChatServer;
import servidor.ThreadEnvia;
import servidor.ThreadRecibe;
import ui_animales.*;

public class Main {
		
	private static ServerSocket servidor; //
	private static Socket conexion; //Socket para conectarse con el cliente
	
	public static void main(String[] args) {
			
		UI ui = new UI();

	   PrincipalChatServer main = new PrincipalChatServer(); //Instanciacion de la clase Principalchat
	    main.setLocation(1000,0);   //Centrar el JFrame
	    main.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //habilita cerrar la ventana
	    ExecutorService executor = Executors.newCachedThreadPool(); //Para correr los threads

	    try {
	        //main.mostrarMensaje("No se encuentra Servidor");
	        servidor = new ServerSocket(11111, 100); 
	        main.mostrarMensaje("Esperando Cliente ...");

	        //Bucle infinito para esperar conexiones de los clientes
	        while (true){
	            try {
	                conexion = servidor.accept(); //Permite al servidor aceptar conexiones        

	                //main.mostrarMensaje("Conexion Establecida");
	                main.mostrarMensaje("Conectado a : " + conexion.getInetAddress().getHostName());

	                main.habilitarTexto(true); //permite escribir texto para enviar

	                //Ejecucion de los threads
	                executor.execute(new ThreadRecibe(conexion, main)); //client
	                executor.execute(new ThreadEnvia(conexion, main));
	            } catch (IOException ex) {
	                Logger.getLogger(PrincipalChatServer.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    } catch (IOException ex) {
	        Logger.getLogger(PrincipalChatServer.class.getName()).log(Level.SEVERE, null, ex);
	    } //Fin del catch
	    finally {
	    }
	    executor.shutdown();
	    
	   
	
	}
}
package ui_animales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import animales.*;
import main.conectar;

public class Third_View_Aves {
	
	//ATRIBUTOS
	private JPanel panel;
	private JLabel edad, nombrecientifico, nombrecomun, titulo, lbuscar;
	private JTextField tfEdad, tfNombrecientifico, tfNombrecomun, tfBuscar;
	private JButton incluir, modificar, eliminar, buscar, volver;
	
	//CONSTRUCTOR
	public Third_View_Aves() {
		panel = new JPanel(new BorderLayout());
		
		//BOTON 'INCLUIR'
		incluir = new JButton("Ingresar");
		incluir.setBounds(430, 110, 90, 25);
		incluir.addMouseListener(new Evento());
		incluir.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
					
				if(tfEdad.getText().isEmpty() || tfNombrecientifico.getText().isEmpty() || tfNombrecomun.getText().isEmpty()) {
					JOptionPane.showMessageDialog(panel, "Complete todos los Campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
	
					String e = tfEdad.getText();
					String name = tfNombrecientifico.getText();
					String namec = tfNombrecomun.getText();

					Aves np = new Aves(e, name, namec);
					Lista_Aves.getInstances().getLista().add(np);

				       try {
				            PreparedStatement pst = cn.prepareStatement("INSERT INTO aves(nombrecientifico,nombrecomun,edad) VALUES (?,?,?)");
				            pst.setString(1, tfNombrecientifico.getText());
				            pst.setString(2, tfNombrecomun.getText());
				            pst.setString(3, tfEdad.getText());
				          
				            pst.executeUpdate();
				                   
	
			
				        }catch (Exception e1){
				            
				        }					
					
					
					tfEdad.setText("");
					tfNombrecientifico.setText("");
					tfNombrecomun.setText("");
					
					modificar.setVisible(false);
					eliminar.setVisible(false);
					
					JOptionPane.showMessageDialog(panel, "Animal Ingresado con Exito", 
							"Ingreso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		
		// BOTON 'MODIFICAR'
		modificar = new JButton("Modificar");
		modificar.setBounds(430, 110, 90, 25);
		modificar.setVisible(false);
		modificar.addMouseListener(new Evento());
		modificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String c = tfBuscar.getText();

				for (int i = 0; i < Lista_Aves.getInstances().getLista().size(); i++) {
					if (c.equalsIgnoreCase(Lista_Aves.getInstances().getLista().get(i).getNombrecomun())) {

						Lista_Aves.getInstances().getLista().get(i).setEdad(tfEdad.getText());
						Lista_Aves.getInstances().getLista().get(i).setNombrecientifico(tfNombrecientifico.getText());
						Lista_Aves.getInstances().getLista().get(i).setNombrecomun(tfNombrecomun.getText());

						
								
					}
				}

				
		    	try {
		    		PreparedStatement pst = cn.prepareStatement("UPDATE aves SET nombrecientifico='"+tfNombrecientifico.getText()+"',edad='"+tfEdad.getText()+"' WHERE nombrecomun='"+tfBuscar.getText()+"'");
		    		pst.executeUpdate();
		    		
		            pst.setString(1, tfNombrecientifico.getText().trim());
		            pst.setString(2, tfNombrecomun.getText().trim());
		            pst.setString(3, tfEdad.getText().trim());
		            
		       
		        } catch (Exception e) {
		        }
				
				tfEdad.setText("");
				tfNombrecientifico.setText("");
				tfNombrecomun.setText("");
				tfBuscar.setText("");
				
				JOptionPane.showMessageDialog(panel, "Animal Modificado con Exito", 
						"Modificacion", JOptionPane.INFORMATION_MESSAGE);
				
				incluir.setBounds(430, 110, 90, 25);
				modificar.setVisible(false);
				eliminar.setVisible(false);
			}
		});
		
		
		// BOTON 'ELIMINAR'
		eliminar = new JButton("Eliminar");
		eliminar.setBounds(430, 170, 90, 25);
		eliminar.setVisible(false);
		eliminar.addMouseListener(new Evento());
		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String c = tfBuscar.getText();

				for (int i = 0; i < Lista_Aves.getInstances().getLista().size(); i++) {
					if (c.equalsIgnoreCase(Lista_Aves.getInstances().getLista().get(i).getNombrecomun())) {

						Lista_Aves.getInstances().getLista().remove(i);
						
					}
				}
				
				
			     try {
			            
			            PreparedStatement pst = cn.prepareStatement("delete from aves where nombrecomun = ?");
			            
			            pst.setString(1, tfBuscar.getText().trim());
			            pst.executeUpdate();
	
			            
			        } catch (Exception e) {
			        }
				
				
				tfEdad.setText("");
				tfNombrecientifico.setText("");
				tfNombrecomun.setText("");

				tfBuscar.setText("");
				
				JOptionPane.showMessageDialog(panel, "Animal Eliminado con Exito", 
						"Eliminacion", JOptionPane.INFORMATION_MESSAGE);
				
				incluir.setBounds(430, 110, 90, 25);
				modificar.setVisible(false);
				eliminar.setVisible(false);
			}
		});
		
		
		// BOTON 'BUSCAR'
		buscar = new JButton("Buscar");
		buscar.setBounds(460, 260, 90, 25);
		buscar.addMouseListener(new Evento());
		buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(tfBuscar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(panel, "Ingrese el Nombre Comun", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else {
					incluir.setBounds(430, 50, 90, 25);
					modificar.setVisible(true);
					eliminar.setVisible(true);
					
					String c = tfBuscar.getText();
					
					for (int i = 0; i < Lista_Aves.getInstances().getLista().size(); i++) {
						if (c.equalsIgnoreCase(Lista_Aves.getInstances().getLista().get(i).getNombrecomun())) {

							tfEdad.setText(Lista_Aves.getInstances().getLista().get(i).getEdad());
							tfNombrecientifico.setText(Lista_Aves.getInstances().getLista().get(i).getNombrecientifico());
							tfNombrecomun.setText(Lista_Aves.getInstances().getLista().get(i).getNombrecomun());
														
						}
					}
					
					
				      try{

				            PreparedStatement pst = cn.prepareStatement("select * from aves where nombrecomun = ?");
				            pst.setString(1, tfBuscar.getText().trim());
				            
				            ResultSet rs = pst.executeQuery();
				            
				            if(rs.next()){ 
				            	tfNombrecomun.setText(rs.getString("nombrecomun"));
				                tfNombrecientifico.setText(rs.getString("nombrecientifico"));
				                tfEdad.setText(rs.getString("edad"));
				            } else {
				                
				            }
				            
				        }catch (Exception e){
				            
				        }
					
					
					if(tfEdad.getText().isEmpty() && tfNombrecientifico.getText().isEmpty() && tfNombrecomun.getText().isEmpty()) {
						modificar.setVisible(false);
						eliminar.setVisible(false);
						incluir.setBounds(430, 110, 90, 25);
						JOptionPane.showMessageDialog(panel, "Animal No Encontrado", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		JPanel pNorth = crearPNorth();
		JPanel pCenter = crearPCenter();
		JPanel pSouth = crearPSouth();
		
		panel.add(pNorth, BorderLayout.NORTH);
		panel.add(pCenter, BorderLayout.CENTER);
		panel.add(pSouth, BorderLayout.SOUTH);
	}
	//FIN - PANEL
	
	//.:METODOS:.
	//GETTER - getJPanel
	public JPanel getJPanel() {
		return this.panel;
	}
	
	//GETTER - getVolver()
	public JButton getVolver() {
		return this.volver;
	}
	
	//GETTER - getBuscar()
	public JButton getBuscar() {
		return this.buscar;
	}
	
	//METODO - crearPNorth()
	private JPanel crearPNorth() {
		JPanel p = new JPanel(new FlowLayout());
		p.setBackground(Color.WHITE);
		titulo = new JLabel(".:AVES:.");
		p.add(titulo);
		return p;
	}
	
	//METODO - crearPCenter()
	private JPanel crearPCenter() {
		JPanel p = new JPanel(null);
				
		//EDAD
		edad = new JLabel("Edad  :");
		edad.setBounds(80, 160, 50, 40);
		p.add(edad);
		
		tfEdad = new JTextField();	
		tfEdad.setBounds(130, 170, 250, 25);	
		p.add(tfEdad);
		
		//NOMBRE CIENTIFICO
		nombrecientifico = new JLabel("Nombre Cientifico :");
		nombrecientifico.setBounds(10, 40, 150, 40);
		p.add(nombrecientifico);
		
		tfNombrecientifico = new JTextField();
		tfNombrecientifico.setBounds(130, 50, 250, 25);
		p.add(tfNombrecientifico);
		
		//NOMBRE COMUN

		nombrecomun = new JLabel("Nombre Comun :");
		nombrecomun.setBounds(20, 100, 150, 40);
		p.add(nombrecomun);
		
		tfNombrecomun = new JTextField();
		tfNombrecomun.setBounds(130, 110, 250, 25);
		p.add(tfNombrecomun);
		
		//BOTONES
		
		p.add(incluir);
		p.add(modificar);
		p.add(eliminar);
		
		//BUSCAR
		lbuscar = new JLabel("Buscar (por Nombre Comun): ");
		lbuscar.setBounds(10, 250, 200, 40);
		p.add(lbuscar);
		
		tfBuscar = new JTextField();
		tfBuscar.setBounds(180, 260, 250, 25);
		p.add(tfBuscar);
		
		p.add(buscar);
		return p;
		
	}
	
	//METODO - crearPSouth()
	private JPanel crearPSouth() {
		JPanel p = new JPanel(new FlowLayout());
		p.setBackground(Color.WHITE);
		
		volver = new JButton("Volver");
		volver.addMouseListener(new Evento());
		p.add(volver);
		
		return p;
	}
	
	//CLASS EVENTO
	class Evento extends MouseAdapter{
		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == incluir) {
	
			}
			else if(e.getSource() == buscar) {
	
			}
			else if(e.getSource() == volver) {
				
			}
			else if(e.getSource() ==  modificar) {
				
			}
			else if(e.getSource() == eliminar) {
				
			}
		}
		
		public void mouseExited(MouseEvent e) {
			if(e.getSource() == incluir) {
			
			}
			else if(e.getSource() == buscar) {
				
			}
			else if(e.getSource() == volver) {
				
			}
			else if(e.getSource() == modificar) {
				
			}
			else if(e.getSource() == eliminar) {
				
			}

		}
		
		public void mousePressed(MouseEvent e) {
			if(e.getSource() == incluir) {
				
			}
			else if(e.getSource() == buscar) {
				
			}
			else if(e.getSource() == volver) {
			
			}
			else if(e.getSource() == modificar) {
				
			}
			else if(e.getSource() == eliminar) {
				
			}
		}
	}
    conectar cc= new conectar();
    Connection cn= cc.conexion();
}

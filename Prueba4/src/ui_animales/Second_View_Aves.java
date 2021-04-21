package ui_animales;

	import java.awt.FlowLayout;
   import java.awt.event.KeyAdapter;
   import java.awt.event.KeyEvent;
   import java.sql.ResultSet;
   import java.sql.Statement;
   import javax.swing.JButton;
   import javax.swing.JLabel;
   import javax.swing.JScrollPane;
   import javax.swing.JTable;
   import javax.swing.JTextField;
   import javax.swing.table.DefaultTableModel;
   import javax.swing.table.TableRowSorter;
   import java.sql.*;
   import javax.swing.*;
   import java.awt.event.ActionEvent;
   import java.awt.event.ActionListener;
   import main.conectar;


   public class Second_View_Aves extends JFrame {
  
      DefaultTableModel modelo = new DefaultTableModel();
      {
           
         modelo.addColumn("nombrecomun");
         modelo.addColumn("nombrecientifico");
         modelo.addColumn("edad");
                          
      }
      
      private JTextField jtffiltro;
      
      public Second_View_Aves() {

         JTable tabla = new JTable(modelo);
         final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel> ( modelo ) ;
         tabla.setRowSorter (sorter) ;
         JScrollPane scroll = new JScrollPane(tabla);

         String nombre_categ;
      
         
         setLayout(new FlowLayout());
            
         add(new JLabel("REGISTRO A BUSCAR "),new FlowLayout());
      
         JLabel label = new JLabel("REGISTRO");
        
 
         jtffiltro = new JTextField(20);
         setLayout(new FlowLayout());
      
         add(jtffiltro );
         jtffiltro.addKeyListener(
                new KeyAdapter() {
                   @Override
                   public void keyReleased(KeyEvent e) {
                     busqueda(jtffiltro.getText());
                  
                    
                  }
               });
        

      
         JButton bt = new JButton("buscar");
         setLayout(new FlowLayout());
         add(bt);
        
         bt.addActionListener (
                new ActionListener () {
                   public void actionPerformed ( ActionEvent e ) {
                     String text =  jtffiltro.getText () ;
                     if ( text.length () == 0 ) {
                        sorter.setRowFilter ( null ) ;
                     }
                     else {
                        sorter.setRowFilter ( RowFilter.regexFilter ( text )) ;
                     }
                  }
               }) ;
           
      
         setLayout(new FlowLayout());
         add(scroll);
         setLayout(new FlowLayout());
      
         cargardatos();
         
         setSize(500, 600);
         
      }
  
       private void presionCajaDeTexto() {
         busqueda(jtffiltro.getText());
      
      }
  
   	
  

       public void cargardatos(){
      
      
         try {

            Statement stmt = cn.createStatement();
        
        
            modelo.setRowCount(0);
            ResultSet  result= stmt.executeQuery("select * from aves");

            Object[] fila = new Object[3];
        
         	
         	
            while (result.next()) {
            
            
            
               fila[0] = result.getString("nombrecomun");
               fila[1] = result.getString("nombrecientifico");
               fila[2] = result.getString("edad");
               modelo.addRow(fila);
            
            }
            cn.close();
         }
             catch (Exception e) {
               e.printStackTrace();
            }
      }//fin del metodoo
   	
   	
   	
   	
   	
   	
       public void busqueda(String nombre_categ) {
         try {
   
            Statement s = cn.createStatement();
        
        
            modelo.setRowCount(0);
            ResultSet rs = s.executeQuery("select * from aves where nombrecomun like '%"+nombre_categ+"%'");
        
      
            Object[] fila = new Object[3];
        
		
         	
            while (rs.next()) {
            
            
            
               fila[0] = rs.getString("nombrecomun");
               fila[1] = rs.getString("nombrecientifico");
               fila[2] = rs.getString("edad");
               modelo.addRow(fila);
            
            
            }
        
            cn.close();
         }
             catch (Exception e) {
               e.printStackTrace();
            }
      }//fin del metodoo
      conectar cc= new conectar();
   Connection cn= cc.conexion();
}
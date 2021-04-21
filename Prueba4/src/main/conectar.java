package main;



import java.sql.Connection;
import java.sql.DriverManager;

public class conectar {
	
	private String driverDB = "org.postgresql.Driver";
	private String dbName = "ZOOLOGICO";
	private String urlDB = "jdbc:postgresql://localhost:5432/" + this.dbName;
	private String userDB = "postgres";
	private String passDB = "30010058";
    Connection conectar=null;
    public Connection conexion(){
        try {
			Class.forName(driverDB);
			this.conectar = DriverManager.getConnection(urlDB, userDB, passDB);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
}

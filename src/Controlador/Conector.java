package Controlador;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conector {
    
    private static Connection conexion;
    private static  Conector istancia;
    private static final String url = "jdbc:mysql://localhost:3306/metodologia";
    private static final String user = "root";
    private static final String password ="Perro16tonto";
    
    private Conector(){}
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion =  DriverManager.getConnection(url, user, password);
            if(conexion!=null){
                System.out.println("Conexion Exitosa");
                return conexion;
            }else{
                System.out.println("ERROR no se pudo conectar");
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
      return conexion;
    }
    public void cerrarconexion() throws SQLException{
        try {
            conexion.close();
            System.out.println("Se desconecto de la base");
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            conexion.close();
        }finally{
            conexion.close();
        }
    }
    
    public static Conector getInstance(){
        if(istancia==null){
            istancia = new Conector();
        }
        return istancia;
    }
    public void comprobar(){
        int numero;
    }
}

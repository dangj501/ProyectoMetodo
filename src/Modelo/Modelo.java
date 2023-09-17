package Modelo;

import Controlador.Conector;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Modelo {
    private static Conector cn = Conector.getInstance();
    private static Connection conexion;
    public Modelo(){}
    
    public boolean verificarUsuario(String usuario, String contrasena){
        boolean verificacion =false;
        try {
               conexion = cn.conectar();
               Statement stm;
                String sql ="select * from usuarios " 
                        + "where usuario= '"+usuario+"' and contrasena='"+contrasena+"'";
                stm = conexion.createStatement();
                ResultSet resultado = stm.executeQuery(sql);
                if(resultado.next()){
                    verificacion = true;
                }else{
                   verificacion = false;
                }
                cn.cerrarconexion();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        return verificacion;
    }

    public ResultSet getProductos() {
        ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "select * from Producto;";
            rs= smt.executeQuery(sql);
            //cn.cerrarconexion();
        } catch (Exception e) {e.printStackTrace();}
        return rs;
    }

    public ResultSet getConsumidores() {
        ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "select * from Consumidor;";
            rs= smt.executeQuery(sql);
            //cn.cerrarconexion();
        } catch (Exception e) {e.printStackTrace();}
        return rs;
    }

    public ResultSet getProductores() {
         ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "select * from Productor;";
            rs= smt.executeQuery(sql);
            //cn.cerrarconexion();
        } catch (Exception e) {e.printStackTrace();}
        return rs;
    }
    
    public ResultSet getProducido() {
         ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "select * from Producido;";
            rs= smt.executeQuery(sql);
            //cn.cerrarconexion();
        } catch (Exception e) {e.printStackTrace();}
        return rs;
    }
    
    public ResultSet getConsumidos() {
         ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "select * from Consumido;";
            rs= smt.executeQuery(sql);
            //cn.cerrarconexion();
        } catch (Exception e) {e.printStackTrace();}
        return rs;
    }

    public int agregarConsumidor(String nombre, String telefon) throws SQLException {
        int id =0;
        ResultSet resultado;
        PreparedStatement ps;
        conexion = cn.conectar();
        ps= conexion.prepareStatement("Insert into Consumidor (idc, nombrec, telefono) Values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,null);
        ps.setString(2, nombre);
        ps.setString(3, telefon);
        ps.executeUpdate();
        
        resultado = (ResultSet) ps.getGeneratedKeys();
        if(resultado.next()){
            id= resultado.getInt(1);
        }
        return id;
    }

    public void editarConsumidor(int id, String nombre, String telefon) throws SQLException {
        PreparedStatement ps;
        conexion = cn.conectar();
        ps = conexion.prepareStatement("update Consumidor set nombreC='"+nombre+"',Telefono='"+telefon+"' where idc='"+id+"';");
        ps.executeUpdate();
    }

    public void eliminarConsumidor(Object valueAt) {
        PreparedStatement ps=null;
        String sql = "delete from Consumidor "+"where idc='"+valueAt+"';";
        try {
            conexion = cn.conectar();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public int agregarProductor(String nombre, String telefon) throws SQLException {
        int id =0;
        ResultSet resultado;
        PreparedStatement ps;
        conexion = cn.conectar();
        ps= conexion.prepareStatement("Insert into Productor (idp, nombreE, telefono) Values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,null);
        ps.setString(2, nombre);
        ps.setString(3, telefon);
        ps.executeUpdate();
        
        resultado = (ResultSet) ps.getGeneratedKeys();
        if(resultado.next()){
            id= resultado.getInt(1);
        }
        return id;
    }

    public void editarProductor(int id, String nombre, String telefon) throws SQLException {
        PreparedStatement ps;
        conexion = cn.conectar();
        ps = conexion.prepareStatement("update Productor set nombreE='"+nombre+"',Telefono='"+telefon+"' where idP='"+id+"';");
        ps.executeUpdate();
    }

    public void eliminarProductor(Object valueAt) {
        PreparedStatement ps=null;
        String sql = "delete from Productor "+"where idp='"+valueAt+"';";
        try {
            conexion = cn.conectar();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public int agregarProducto(int precio,String nombre) throws SQLException {
        int id =0;
        ResultSet resultado;
        PreparedStatement ps;
        conexion = cn.conectar();
        ps= conexion.prepareStatement("Insert into Producto (id, precio, nombreP) Values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,null);
        ps.setInt(2, precio);
        ps.setString(3, nombre);
        ps.executeUpdate();
        
        resultado = (ResultSet) ps.getGeneratedKeys();
        if(resultado.next()){
            id= resultado.getInt(1);
        }
        return id;
    }

    public void editarProducto(int id, String nombre, int precio) throws SQLException {
         PreparedStatement ps;
        conexion = cn.conectar();
        ps = conexion.prepareStatement("update Producto set precio='"+precio+"',nombreP='"+nombre+"' where id='"+id+"';");
        ps.executeUpdate();
    }

    public void eliminarProducto(Object valueAt) {
        PreparedStatement ps=null;
        String sql = "delete from Producto "+"where id='"+valueAt+"';";
        try {
            conexion = cn.conectar();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public void agregarConsumido(int IdC, int Id) throws SQLException {
        PreparedStatement ps;
        conexion = cn.conectar();
        ps= conexion.prepareStatement("Insert into Consumido (IDC, id) Values (?,?)");
        ps.setInt(1,IdC);
        ps.setInt(2, Id);
        ps.executeUpdate();
    }

    public void eliminarConsumido(Object valueAt, Object valueAt0) {
    }

    public void agregarProducido(int IdC, int Id) throws SQLException {
        PreparedStatement ps;
        conexion = cn.conectar();
        ps= conexion.prepareStatement("Insert into Producido (IDP, id) Values (?,?)");
        ps.setInt(1,IdC);
        ps.setInt(2, Id);
        ps.executeUpdate();
    }

    public void eliminarProducido(Object valueAt, Object valueAt0) {
    }
    
}

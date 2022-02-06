/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mpm.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author Jose Fortin
 */
public class ProductoModelo {
     private Connection _conexion1 = null;
    
    public ProductoModelo(){
        _conexion1 = ConexionBDD.getConexion();
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS productos"
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " nombre TEXT NOT NULL,"
                + " precio DECIMAL(10,2),"
                + " cantidad NUMERIC,"
                + " observacion TEXT);";
        try{
            Statement comando = _conexion1.createStatement();
            int resultado = comando.executeUpdate(sqlCreateTable);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
       public ArrayList<Producto> obtenerProductos(){
       try{
            ArrayList productos = new ArrayList<Producto>();
            Statement comandoSQL = _conexion1.createStatement();
    
            ResultSet registroEnTabla = comandoSQL.executeQuery("SELECT * FROM productos;");
            while (registroEnTabla.next()){
                Producto productoActual = new Producto();
                productoActual.setId(registroEnTabla.getInt("id"));
                productoActual.setNombre(registroEnTabla.getString("nombre"));
                productoActual.setObservacion(registroEnTabla.getString("Observacion"));
                productoActual.setCantidad(registroEnTabla.getInt("Cantidad"));
                productoActual.setPrecio(registroEnTabla.getDouble("precio"));
                  
                productos.add(productoActual);
            }
            return productos;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return new ArrayList<Producto>();
        }
}

 public int agregarProducto (Producto nuevoProducto){
 try{
   
     String insertSql = "INSERT INTO productos (nombre,observacion,cantidad,precio) values(?,?,?,?);";
     PreparedStatement comandoSQL = _conexion1.prepareStatement(insertSql);
     comandoSQL.setString(1, nuevoProducto.getNombre());
     comandoSQL.setString(2, nuevoProducto.getObservacion());
     comandoSQL.setInt(3, nuevoProducto.getCantidad());
     comandoSQL.setDouble(4, nuevoProducto.getPrecio());
     
     int RegistroAfectados = comandoSQL.executeUpdate();
     comandoSQL.close();
     return RegistroAfectados;
 }catch (Exception ex){
     System.err.println(ex.getMessage());
    
     return 0;
 }
 }
 
 public int actualizarProducto (Producto updateProducto){
 try{
   
     String updateSql = "UPDATE productos set nombre==?,observacion=?, cantidad=?, precio=? where id=?;";
     PreparedStatement comandoSQL = _conexion1.prepareStatement(updateSql);
     comandoSQL.setString(1, updateProducto.getNombre());
     comandoSQL.setString(2,updateProducto.getObservacion());
     comandoSQL.setInt(3, updateProducto.getCantidad());
     comandoSQL.setDouble(4, updateProducto.getPrecio());
     comandoSQL.setInt(5, updateProducto.getId());
      
     int RegistroAfectados = comandoSQL.executeUpdate();
     comandoSQL.close();
     return RegistroAfectados;
 }catch (Exception ex){
     System.err.println(ex.getMessage());
     return 0;
 }
 }
  public int deleteProducto (int id){
 try{
   
     String deleteSql = "DELETE FROM productos where id=?;";
     PreparedStatement comandoSQL = _conexion1.prepareStatement(deleteSql);
     comandoSQL.setInt(1,id);
     
     int RegistroAfectados = comandoSQL.executeUpdate();
     comandoSQL.close();
     return RegistroAfectados;
 }catch (Exception ex){
     System.err.println(ex.getMessage());
     return 0;
 }
 }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mpm.dao;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Jose Fortin
 */
public class ConexionBDD {
    
     private static Connection _conexion1 = null ; 
     private ConexionBDD(){
         
     }
     public static Connection getConexion(){
         try {
             if(_conexion1 == null){
                 Class.forName("org.sqlite.JDBC");
                 _conexion1 = DriverManager.getConnection("jdbc:sqlite:inventarioPanaderia.db");
             }
             return _conexion1;
         } catch(Exception ex){
             System.err.println("Error: "+ ex.getMessage());
             return null;
         }
     }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.panaderiaproductos;
import java.util.Scanner;

/**
 *
 * @author Jose Fortin
 */
public class Funciones {
     public static void separador(){
        System.out.println(new String(new char[80]).replace("\0","-"));
    }
    public static void print(String text){
        System.out.println(text);
    }
    public static void encabezado(String text){
        separador();
        print(text);
        separador();
    }
    public static void menu (){
        separador();
        String menu = "L| Lista\tI|Insertar\t A|Actualizar\tE|Eliminar\tS| Salir";
        separador();
        print(menu);
    
    }
    
    public static String capturarCampo(Scanner escribir, String leyenda, String valorPredeterminado){
        
            
        print(leyenda + "(" + valorPredeterminado +" )");
        String input = escribir.nextLine();
        
        if(input.isEmpty() || input.contentEquals(valorPredeterminado)){
            return valorPredeterminado;
        }
        return input;
    }
    public static void printEncabezadoTabla (){
   
        print(String.format("%s\t%s\t%s","ID","PRODUCTO","PRECIO"));
        separador();
    }
}

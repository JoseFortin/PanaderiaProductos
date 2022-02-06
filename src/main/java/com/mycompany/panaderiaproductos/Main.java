/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.panaderiaproductos;

import static com.mycompany.panaderiaproductos.Funciones.encabezado;

import com.mpm.dao.ConexionBDD;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

import com.mpm.dao.Producto;
import com.mpm.dao.ProductoModelo;
import java.sql.Connection;

/**
 *
 * @author Jose Fortin
 */

public class Main {
    
  private Connection _conexion1 = null;
   private static Scanner escribir = new Scanner(System.in);
   private static ProductoModelo model= new ProductoModelo();
    public static void main ( String[] args ) {
    
       Funciones.encabezado("ADMINISTRACION DE PRUDUCTOS (PANADERIA FORTIN)");
        String menuOption = "L";
        while (!menuOption.contentEquals("S")){
            switch(menuOption){
                case "L":
                    mostrarListado();
                    break;
                case "I":
                   insertarUnProducto();
                   break;
                case "A":
                    actualizarProducto();
                   break;
                case "E":
                    eliminarProducto();
                    break;
                default:
                   Funciones.print("Opcion no encontrada!!!");
                   break;
           }
        
           Funciones.menu();
            menuOption = escribir.nextLine().toUpperCase();
        }
    
     
    }   
        private static void mostrarListado(){
            Funciones.printEncabezadoTabla();
             ArrayList<Producto>productos = model.obtenerProductos();
             for(int i = 0; i< productos.size(); i++){
                 Funciones.print(productos.get(i).getRow());
                 Funciones.separador();    
             }
        }

     private static void insertarUnProducto(){
        Producto nuevoProducto = new Producto();
        Funciones.encabezado("Nuevo Producto");
        nuevoProducto.setNombre(Funciones.capturarCampo(escribir,"Nombre:","Producto (Torta)"));
        nuevoProducto.setPrecio(Double.parseDouble(Funciones.capturarCampo(escribir,"Precio:","100.00")));
        nuevoProducto.setCantidad(Integer.parseInt(Funciones.capturarCampo(escribir, "Cantidad","10")));
        nuevoProducto.setObservacion(Funciones.capturarCampo(escribir, "Observación",""));
      int insertado = model.agregarProducto(nuevoProducto);
      if(insertado > 0){
          Funciones.print("El Producto Agrego Satisfactoriamente");
      }
       Funciones.separador();
     }
   
    
    private static void actualizarProducto() {
        int actualizado = 0;
        int inexistente = 1;
        Producto productoActualizado = new Producto();
        ArrayList<Producto> productos = model.obtenerProductos();

        Funciones.encabezado("Actualizar un Producto");
        Funciones.print("Ingrese ID del registro a actualizar: ");
        int capturarId = Integer.parseInt(escribir.nextLine());

        for (int i = 0; i < productos.size(); i++) {
            if (capturarId == (productos.get(i).getId())) {
                productoActualizado.setNombre(Funciones.capturarCampo(escribir, "Nombre", productos.get(i).getNombre()));
                productoActualizado.setPrecio(Double.parseDouble(Funciones.capturarCampo(escribir, "Precio", Double.toString(productos.get(i).getPrecio()))));
                productoActualizado.setCantidad(Integer.parseInt(Funciones.capturarCampo(escribir, "Cantidad",Integer.toString(productos.get(i).getCantidad()))));
                productoActualizado.setObservacion(Funciones.capturarCampo(escribir, "Observacion", productos.get(i).getObservacion()));
                productoActualizado.setId(productos.get(i).getId());
                Funciones.separador();

                actualizado = model.actualizarProducto(productoActualizado);
            }
        }

        if (actualizado > 0) {
            Funciones.print("El producto ha sido actualizado correctamente");
        }
     
            Funciones.separador();
    }
    
    private static void eliminarProducto() {
        int prodborrado = 0;
        ArrayList<Producto> productos = model.obtenerProductos();

        Funciones.encabezado("Eliminar Un Producto ");
        Funciones.print("Ingrese ID del producto a eliminar: ");
        int Idproducto = Integer.parseInt(escribir.nextLine());

        for (int a = 0; a < productos.size(); a++) {
            if (Idproducto == (productos.get(a).getId())) {
                Funciones.print("Nombre: " + productos.get(a).getNombre() + "\n Precio: "+ productos.get(a).getPrecio() + "\n Cantidad: "+ productos.get(a).getCantidad() + "\n Observacion: "+ productos.get(a).getObservacion());
                Funciones.print("¿Desea eliminar el producto? S/N: ");
                String confirmar = escribir.nextLine().toUpperCase();
                
                if (confirmar.contentEquals("S")) {
                    Funciones.separador();

                    prodborrado = model.deleteProducto(Idproducto);
                } else {
                   Funciones.print("El Producto no se Elimino");
                    break;
                }
            }
        }

        if (prodborrado > 0) {
            Funciones.print("El Producto ha sido eliminado de manera correcta");
        }

    }
   
}

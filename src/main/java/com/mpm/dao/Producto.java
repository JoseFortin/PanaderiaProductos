/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mpm.dao;

/**
 *
 * @author Jose Fortin
 */
public class Producto {

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    /**
     * @return the _precio
     */
    public double getPrecio() {
        return _precio;
    }

    /**
     * @param _precio the _precio to set
     */
    public void setPrecio(double _precio) {
        this._precio = _precio;
    }

    /**
     * @return the _cantidad
     */
    public int getCantidad() {
        return _cantidad;
    }

    /**
     * @param _cantidad the _cantidad to set
     */
    public void setCantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    /**
     * @return the _observacion
     */
    public String getObservacion() {
        return _observacion;
    }

    /**
     * @param _observacion the _observacion to set
     */
    public void setObservacion(String _observacion) {
        this._observacion = _observacion;
    }

    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }
    
    public String getRow() {
        return String.format("%d\t%s\t%f", _id, _nombre,_precio);
    }
    private String _nombre;
    private double _precio;
    private int _cantidad;
    private String _observacion;
    private int _id;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.up.edu.practica02.controlador;

import ec.up.edu.practica02.modelo.Persona;

/**
 *
 * @author ESTUDIANTE
 */
public interface IControlador {
    public final int MAX_OBJECTCS = 10;
    
    public abstract void create(Persona obj);//C
    public abstract Persona read(Persona obj);//R
    public abstract void update(Persona obj);//U
    public abstract void delete(Persona obj);//D
}

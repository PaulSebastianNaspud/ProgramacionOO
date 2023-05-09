/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.up.edu.practica02.controlador;
//import de la clase persona

import ec.up.edu.practica02.modelo.Persona;

//interface basado en el CRUD (create read update delete)
public interface IControlador {

    //Creacion de una constante, la cual no se ha usado por que se han guardado los objetos en ArrayList
    public final int MAX_OBJECTCS = 10;

    //metodo abastrac create que recibe un parametro del tipo Persona 
    public abstract void create(Persona obj);//C
    //metodo abastrac read que recibe un parametro del tipo Persona y devuelve una persona 

    public abstract Persona read(Persona obj);//R
    //metodo abstract update que recibe un parametro del tipo Persona 

    public abstract void update(Persona obj);//U
    
    //metodo abastract deleta que recibe un parametro del tipo Persona 
    public abstract void delete(Persona obj);//D
}

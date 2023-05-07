/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.up.edu.practica02.controlador;

import ec.up.edu.practica02.modelo.Cancion;
import ec.up.edu.practica02.modelo.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estem
 */
public class ControladorPersona implements IControlador{
    private List<Persona> personas;

    public ControladorPersona() {
        this.personas = new ArrayList();
    }
    
    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    public void imprimir(){
        for(Persona persona: personas){
            System.out.println(persona);
        }
    }

    public Persona buscarPorNombre(String valor){
        
        for(int i = 0; i<personas.size();i++){
            if (personas.get(i).getNombre().equals(valor)){
                return personas.get(i);
            }
        }
        return null;
    }
    
    public Persona buscarPorTituloDeCancion(String valor){
        Cancion buscador;
        for (int i = 0; i < personas.size(); i++) {
         
        }
        return null;
    }

    @Override
    public void create(Persona obj) {
        personas.add((Persona) obj);
    }

    @Override
    public Persona read(Persona obj) {      
        if(obj.getNombre() instanceof String){
            String nombre = (String) obj.getNombre();
            for (Persona persona : personas) {
                if (persona.getNombre().equals(nombre)) {
                    return persona;
                }
            }
        }
        return null;        
    }

    @Override
    public void update(Persona obj) {
        String nombre = ((Persona) obj).getNombre();
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            if (persona.getNombre().equals(nombre)) {
                personas.set(i, (Persona) obj);
                break;
            }
        }

    }
        
    
    @Override
    public void delete(Persona obj) {
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
                if (persona.equals((Persona) obj)) {
                    personas.remove(i);
                    break;
                }
            }
    }
      
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.up.edu.practica02.controlador;

import ec.up.edu.practica02.modelo.Cancion;
import ec.up.edu.practica02.modelo.Cantante;
import ec.up.edu.practica02.modelo.Compositor;
import ec.up.edu.practica02.modelo.Disco;
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

    public Persona buscarPorNombreDeDisco(String valor){
        for(Persona persona : personas ){
            if (persona instanceof Cantante){
                Cantante cantanteCasting = (Cantante) persona;
                    for (Disco disco : cantanteCasting.getDiscografia()){
                        if (disco.getNombre().equals(valor)){
                            System.out.println(persona);
                            return persona;
                        }
                    }
                }
            }
        
        return null;
    }
    
    public Persona buscarPorTituloDeCancion(String valor){
        for(Persona persona : personas){
            if(persona instanceof Compositor){
                Compositor compositorCasting = (Compositor) persona;
                for(Cancion cancion: compositorCasting.getTop100Billaboar()){
                    if (cancion.getTitulo().equals(valor)){
                        System.out.println(persona);
                        return persona;
                    }
                }
            }
        }
        return null;
    }
    public Persona buscarPorCodigoCompositor(int codigo){
        for (Persona persona: personas){
            if(persona instanceof Compositor){                
                Compositor compositorCasting = (Compositor) persona;
                if (compositorCasting.getCodigo() == codigo){
                    return persona;
                }
            }
        }
        return null;
    }
    public Persona buscarPorCodigoCantante(int codigo){
        for (Persona persona: personas){
            if (persona instanceof Cantante){
                Cantante cantanteCasting = (Cantante) persona;
                if (cantanteCasting.getCodigo() == codigo ){
                    return persona;
                }
            }

        }
        return null;
    }

    @Override
    public String toString() {
        return "ControladorPersona{" + "personas=" + personas + '}';
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
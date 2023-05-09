/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.up.edu.practica02.controlador;
//import de las bibliotecas nescesarias

import ec.up.edu.practica02.modelo.Cancion;
import ec.up.edu.practica02.modelo.Cantante;
import ec.up.edu.practica02.modelo.Compositor;
import ec.up.edu.practica02.modelo.Disco;
import ec.up.edu.practica02.modelo.Persona;
import java.util.ArrayList;
import java.util.List;

//implementacion de la clase IControlador en controladorPersona
public class ControladorPersona implements IControlador {

    //atributo de las relaciones, una lista de personas
    private List<Persona> personas;
    
    //contructor de la clase, y la inicializacion de la lista como ArrayList
    public ControladorPersona() {
        this.personas = new ArrayList();
    }
    
    //get and set de el atributo de la clase
    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    //metodo imprimir no resive parametros
    public void imprimir() {
        for (Persona persona : personas) { //for each de la lista de las personas
            System.out.println(persona); //imprimir cada objeto de la lista
        }
    }
    
    /*
      metodo buscarPorNombreDeDisco, el cual recibe un parametro String, da un return de una 
      persona que cumpla con la condicion de un Cantente tener el disco, y de un mensaje 
      de los datos de las personas
    */
    public Persona buscarPorNombreDeDisco(String valor) {  
        for (Persona persona : personas) { //for each de la lista de las personas
            if (persona instanceof Cantante) { // if, que compara personas con una instancia de un Cantente 
                Cantante cantanteCasting = (Cantante) persona; //downcasting indirecto de Persona a Canrante
                //for aech de la lista discografia utilizando cantanteCasting para acceder a la lista 
                for (Disco disco : cantanteCasting.getDiscografia()) { 
                    //comparar Strings hasta que se cumpla la condicion atraves del get
                    if (disco.getNombre().equals(valor)) { 
                        System.out.println(persona); //mensaje a cosola si existe
                        return persona; //return de persona
                    }
                }
            }
        }

        return null; // si no exite, return null
    }
    
    /*
      metodo buscarPorTituloDeCancion, el cual recibe un parametro String, da un return de una 
      persona que cumpla con la condicion de un Compositor tener el titulo de la cancion, y da 
      un mensaje de los datos de las personas
    */
    public Persona buscarPorTituloDeCancion(String valor) {
        for (Persona persona : personas) {  //for each de la lsita personas
            //toma de deciciones para que entre solo instancias indirectas de un objeto compositor
            if (persona instanceof Compositor) {
                Compositor compositorCasting = (Compositor) persona; // downcasting indirecto de Persona a Compositor
                for (Cancion cancion : compositorCasting.getTop100Billaboar()) {
                    //comparar Strings hasta que se cumpla la condicion atraves del get
                    if (cancion.getTitulo().equals(valor)) {
                        System.out.println(persona); //mensaje a cosola si existe
                        return persona; //retunr de persona
                    }
                }
            }
        }
        return null; // si no existe, return null
    }
    
    /*
      metodo buscarPorCodigoCompositor,que recibe un int de parametro y da un return de la persona
      que cumpla con la condicion de un Compositor, tener el codigo de la persona buscada y da un
      return de las persona
    */
    public Persona buscarPorCodigoCompositor(int codigo) {
        for (Persona persona : personas) { //for each de la lista personas
            //toma de decisiones para que entren instancias inderectas de un objeto compositor
            if (persona instanceof Compositor) {
                Compositor compositorCasting = (Compositor) persona;//downcasting indrirecto de Personas a Compositor 
                //comparar ints hasta que se cumpla la condicion atraves del get
                if (compositorCasting.getCodigo() == codigo) {
                    return persona; //retunr  de persona
                }
            }
        }
        return null; // si no existe, retunrn null
    }
    /*
      metodo buscarPorCodigoCantante,que recibe un int de parametro y da un return de la persona
      que cumpla con la condicion de un Cantante, tener el codigo de la persona buscada y da un
      return de las persona
    */
    public Persona buscarPorCodigoCantante(int codigo) {
        for (Persona persona : personas) { // for each de la lista personas
            //toma de decisiones para que entren instancias inderectas de un objeto Cantante
            if (persona instanceof Cantante) {
                Cantante cantanteCasting = (Cantante) persona;//downcasting indrirecto de Personas a Cantante 
                if (cantanteCasting.getCodigo() == codigo) {
                    return persona;//retunt de persona, si existe 
                }
            }
        }
        return null;
    }
    /*
      metodos de la interface CRUDE
    */
    
    //metodo create, para crear instacias personas en la lista personas
    @Override
    public void create(Persona obj) {
        personas.add((Persona) obj); //añadir personas
    }
    
    //metodo read recibe un objeto persona y devuelve un objeto personas
    @Override
    public Persona read(Persona obj) {
        if (obj.getNombre() instanceof String) {
            String nombre = (String) obj.getNombre();
            for (Persona persona : personas) {
                if (persona.getNombre().equals(nombre)) {
                    return persona;
                }
            }
        }
        return null;
    }
    
    //metodo update, cambia de poscicion de un onjeto en la lista
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
    
    // metodo delete, borra un objeto de la lista personas
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

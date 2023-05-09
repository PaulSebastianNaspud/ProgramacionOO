/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.up.edu.practica02.modelo;

//import de las bibliotecas nescesarias
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//clase Cantante hereda de la clase abstract Persona
public class Cantante extends Persona {
    
    //atributos private de la clase y encapsulamiento
    private String nombreArtistico;
    private String generoMusical;
    private int numeroDeSensillos;
    private int numeroDeConciertos;
    private int numeroDeGiras;
    //atributo private de relacion con la clase Disco y encapsulamiento
    private List<Disco> discografia;
    
    /*
      constructor de los atributo junto con los atributos de la clase Persona, super de la clase persona 
      e inicializacion de la List discografias como ArrayList
    */
    public Cantante(String nombreArtistico, String generoMusical, int numeroDeSensillos, int numeroDeConciertos, int numeroDeGiras, int codigo, String nombre, String apellido, int edad, double salario, String nacionalidad) {
        super(codigo, nombre, apellido, edad, salario, nacionalidad);
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.numeroDeSensillos = numeroDeSensillos;
        this.numeroDeConciertos = numeroDeConciertos;
        this.numeroDeGiras = numeroDeGiras;
        this.discografia = new ArrayList();
    }
    
    //get and set
    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getNumeroDeSensillos() {
        return numeroDeSensillos;
    }

    public void setNumeroDeSensillos(int numeroDeSensillos) {
        this.numeroDeSensillos = numeroDeSensillos;
    }

    public int getNumeroDeConciertos() {
        return numeroDeConciertos;
    }

    public void setNumeroDeConciertos(int numeroDeConciertos) {
        this.numeroDeConciertos = numeroDeConciertos;
    }

    public int getNumeroDeGiras() {
        return numeroDeGiras;
    }

    public void setNumeroDeGiras(int numeroDeGiras) {
        this.numeroDeGiras = numeroDeGiras;
    }

    public List<Disco> getDiscografia() {
        return discografia;
    }

    public void setDiscografia(List<Disco> discografia) {
        this.discografia = discografia;
    }

    /*
      metodo agregar disco, el cual recibe los tres parametro, ciendo nescesarios para inicalizar los objetos
      dicos, el metodo agrega discos a la lista discogografia del objeto Cantante
    */
    public  void agregarDisco(int codigo, String nombre, int anioDeLanzamiento) {
        Disco disco = new Disco(codigo, nombre, anioDeLanzamiento);
        discografia.add(disco);
    }
    
    /*
      sobrescritura del metodo calcular salario de la clase padre, tiene condiciones que suman cantidades al 
      salario del cantante, para obtener el salario final, accede al atributo salario de la clase Persona 
      atraves del super de la herencia y returna el salario final
    */
    @Override
    public double calcularSalario() {
        if (numeroDeSensillos > 10 && numeroDeGiras > 3) {
        } else if (numeroDeSensillos > 1 || numeroDeSensillos <= 10) {
            return (super.getSalario() + 1000);
        } else if (numeroDeGiras > 0 || numeroDeGiras < 4) {
            return (super.getSalario() + super.getSalario() * 0.05);
        } else if (discografia.size() >= 5) {
            return (super.getSalario() + super.getSalario() * 0.03);
        }
        return super.getSalario();
    }
    
    //metodo toString de la clase para imprimir textos en consola
    @Override
    public String toString() {
        return "Cantante{" + super.toString() + "nombreArtistico=" + nombreArtistico + ", generoMusical=" + generoMusical + ", numeroDeSensillos=" + numeroDeSensillos + ", numeroDeConciertos=" + numeroDeConciertos + ", numeroDeGiras=" + numeroDeGiras + ", discografia=" + discografia + '}';
    }
    
    //metodo hashCode de todos los atributos de la clase para comparar objetos
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nombreArtistico);
        hash = 31 * hash + Objects.hashCode(this.generoMusical);
        hash = 31 * hash + this.numeroDeSensillos;
        hash = 31 * hash + this.numeroDeConciertos;
        hash = 31 * hash + this.numeroDeGiras;
        hash = 31 * hash + Objects.hashCode(this.discografia);
        return hash;
    }
    
    //metodo equals de todos los atributos de la clase para comparar attributos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cantante other = (Cantante) obj;
        if (this.numeroDeSensillos != other.numeroDeSensillos) {
            return false;
        }
        if (this.numeroDeConciertos != other.numeroDeConciertos) {
            return false;
        }
        if (this.numeroDeGiras != other.numeroDeGiras) {
            return false;
        }
        if (!Objects.equals(this.nombreArtistico, other.nombreArtistico)) {
            return false;
        }
        if (!Objects.equals(this.generoMusical, other.generoMusical)) {
            return false;
        }
        return Objects.equals(this.discografia, other.discografia);
    }
}

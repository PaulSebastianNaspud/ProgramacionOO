/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.up.edu.practica02.modelo;

import java.util.Objects;

//creacionde de la clase Disco
public class Disco {
    
    //atributos private de la clase y encapsulamiento
    private int codigo;
    private String nombre;
    private int anioDeLanzamiento;

    //contructor de la clase Disco
    public Disco(int codigo, String nombre, int anioDeLanzamiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.anioDeLanzamiento = anioDeLanzamiento;
    }

    //get and set de todos los atributos de la clase
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioDeLanzamiento() {
        return anioDeLanzamiento;
    }

    public void setAnioDeLanzamiento(int anioDeLanzamiento) {
        this.anioDeLanzamiento = anioDeLanzamiento;
    }

    //metodo toString con todos los atributos de la clase para imprimir en consala texto
    @Override
    public String toString() {
        return "Disco{" + "codigo=" + codigo + ", nombre=" + nombre + ", anioDeLanzamiento=" + anioDeLanzamiento + '}';
    }

    //hashCode de la clase para comparar objetos
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codigo;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + this.anioDeLanzamiento;
        return hash;
    }

    //equals de la clase para comparar objetos
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
        final Disco other = (Disco) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.anioDeLanzamiento != other.anioDeLanzamiento) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.up.edu.practica02.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author estem
 */
public class Compositor extends Persona {

    private int numeroDeComposiciones;

    private List<Cancion> cancionesTop100Billaboar;
    private List<Cantante> clientes;

    public Compositor(int numeroDeComposiciones, int codigo, String nombre, String apellido, int edad, double salario, String nacionalidad) {
        super(codigo, nombre, apellido, edad, salario,nacionalidad);
        this.numeroDeComposiciones = numeroDeComposiciones;
        this.cancionesTop100Billaboar = new ArrayList();
        this.clientes = new ArrayList();
    }
    

    public int getNumeroDeComposiciones() {
        return numeroDeComposiciones;
    }

    public void setNumeroDeComposiciones(int numeroDeComposiciones) {
        this.numeroDeComposiciones = numeroDeComposiciones;
    }

    public List<Cancion> getTop100Billaboar() {
        return cancionesTop100Billaboar;
    }

    public void setTop100Billaboar(List<Cancion> Top100Billaboar) {
        this.cancionesTop100Billaboar = Top100Billaboar;
    }

    public List<Cantante> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cantante> clientes) {
        this.clientes = clientes;
    }
    
    //metodos
    public void agregarCancion(int codigo,String titulo,String letra,double tiempoEnMinutos){
        Cancion cancion = new Cancion(codigo, titulo, letra, codigo);
        cancionesTop100Billaboar.add(cancion);   
    }
    
    public void agregarCliente(Cantante cliente){
        clientes.add(cliente);
    }
    
    @Override
    public double calcularSalario() {
        if (numeroDeComposiciones > 5) {
            return (super.getSalario() + 300);
        } else if (cancionesTop100Billaboar.size() >= 1 || cancionesTop100Billaboar.size() <= 3) {
            return (super.getSalario()*1.1);
        } else if (cancionesTop100Billaboar.size() >=4 || cancionesTop100Billaboar.size()<=6){
            return (super.getSalario()*1.2);
        } else if (cancionesTop100Billaboar.size() > 6){
            return (super.getSalario());
        }
        return super.getSalario();
    }

    @Override
    public String toString() {
        return "Compositor{" + super.toString()+ "numeroDeComposiciones=" + numeroDeComposiciones + ", cancionesTop100Billaboar=" + cancionesTop100Billaboar + ", clientes=" + clientes + '}';
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.numeroDeComposiciones;
        hash = 31 * hash + Objects.hashCode(this.cancionesTop100Billaboar);
        hash = 31 * hash + Objects.hashCode(this.clientes);
        return hash;
    }

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
        final Compositor other = (Compositor) obj;
        if (this.numeroDeComposiciones != other.numeroDeComposiciones) {
            return false;
        }
        if (!Objects.equals(this.cancionesTop100Billaboar, other.cancionesTop100Billaboar)) {
            return false;
        }
        return Objects.equals(this.clientes, other.clientes);
    }
}

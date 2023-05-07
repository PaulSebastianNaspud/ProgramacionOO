/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.up.edu.practica02.vista;

import ec.up.edu.practica02.controlador.ControladorPersona;
import ec.up.edu.practica02.modelo.Cantante;
import ec.up.edu.practica02.modelo.Compositor;
import ec.up.edu.practica02.modelo.Persona;
import java.util.Scanner;

/**
 *
 * @author ESTUDIANTE
 */
public class Main {

    public static void main(String[] args) {
        ControladorPersona controladorPersona = new ControladorPersona();
        Scanner entrada = new Scanner(System.in);
        
        int opcion = 0;
        do{
            System.out.println("\n Menu \n1. Ingreso de Cantante \n2. Ingreson de COmpositor \n4. Imprimir \n7. Salir");
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    entrada.nextLine();//salto de nextInt
                    System.out.println("Ingresar el nombre del cantante: ");
                    String nombre = entrada.nextLine();
                    System.out.println("Ingresar el apelldo del cantante: ");
                    String apellido = entrada.nextLine();
                    System.out.println("Ingresar la edad del cantante: ");
                    int edad = entrada.nextInt();
                    entrada.nextLine();//salto de nextInt
                    System.out.println("Ingresar la nacionalidad del cantante: ");
                    String nacionalidad = entrada.nextLine();
                    System.out.println("Ingresar el salario del cantante: ");
                    double salario = Double.parseDouble(entrada.nextLine());
                    entrada.nextLine();//salto
                    System.out.println("Ingresar el codigo del cantante: ");
                    int codigo = entrada.nextInt();
                    entrada.nextLine();//salto de nextInt
                    System.out.println("Ingresar el nombre artistico del cantante: ");
                    String nombreArtistico = entrada.nextLine();
                    System.out.println("Ingresar el genero musical del cantante: ");
                    String generoMusical = entrada.nextLine();
                    System.out.println("Ingresar el numero de sensillos: ");
                    int nSensillos = Integer.parseInt(entrada.nextLine());
                    System.out.println("Ingresar el numero de conciertos del cantante: ");
                    int nConciertos = Integer.parseInt(entrada.nextLine());
                    System.out.println("Ingresar el numero de giras del cantante: ");
                    int nGiras = entrada.nextInt();
                    Persona cantante = new Cantante(nombreArtistico, generoMusical, nSensillos, nConciertos, nGiras, codigo, nombre, apellido, edad, salario,nacionalidad);
                    Cantante cantanteCasting = (Cantante) cantante;
                    for (int i = 0; i < nSensillos; i++) {
                        System.out.println("Ingresar el codigo del disco: ");
                        int codigo2 = entrada.nextInt();
                        System.out.println("Ingresar el año de lanzamiento:");
                        int anioDeLanzamiento = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Ingresar el nombre del disco: ");
                        String nomreCancion =entrada.nextLine();
                        cantanteCasting.agregarDisco(codigo2, nomreCancion, anioDeLanzamiento);
                    }
                    controladorPersona.create(cantante);
                    break;
                case 2:
                    entrada.nextLine();//salto de nextInt
                    System.out.println("Ingresar el nombre del compositor: ");
                    nombre = entrada.nextLine();
                    System.out.println("Ingresar el apelldo del compositor: ");
                    apellido = entrada.nextLine();
                    System.out.println("Ingresar la edad del compositor: ");
                    edad = entrada.nextInt();
                    entrada.nextLine();//salto de nextInt
                    System.out.println("Ingresar la nacionalidad del compositor: ");
                    nacionalidad = entrada.nextLine();
                    System.out.println("Ingresar el salario del compositor: ");
                    salario = Double.parseDouble(entrada.nextLine());
                    entrada.nextLine();//salto
                    System.out.println("Ingresar el codigo del compositor: ");
                    codigo = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Ingresat el numero de sensillo del compositor; ");
                    int nDeComposiciones = entrada.nextInt();
                    
                    Persona compositor = new Compositor(nDeComposiciones, codigo, nombre, apellido, edad, salario, nacionalidad);
                    
                    controladorPersona.create(compositor);
                    break;
                case 3:
                    
                case 4:
                    controladorPersona.imprimir();
                case 7:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            
        }while(opcion != 7);          
    }
}

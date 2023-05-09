    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.up.edu.practica02.vista;

import ec.up.edu.practica02.controlador.ControladorPersona;
import ec.up.edu.practica02.controlador.IControlador;
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
        IControlador controladorPersona = new ControladorPersona();
        ControladorPersona controladorPerCast = (ControladorPersona) controladorPersona;
        Scanner entrada = new Scanner(System.in);
        
        
        int opcion = 0;
        do{
            System.out.println("\n Menu \n1. Ingreso de Cantante \n2. Ingreson de Compositor \n3. Agregar Clientes \n4. Imprimir"
                    + " \n5. Buscqueda de cantante por el nombre del disco \n6. Busqueda de compositor por nombre de cancion \n7. Salir");
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
                    for (int i = 0; i < nSensillos; i++) {
                        Cantante cantanteCasting = (Cantante) cantante;
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
                    System.out.println("Ingresar el codigo del compositor: ");
                    codigo = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Ingresat el numero de composiciones del compositor; ");
                    int nDeComposiciones = entrada.nextInt();
                    entrada.nextLine();
                    Persona compositor = new Compositor(nDeComposiciones, codigo, nombre, apellido, edad, salario, nacionalidad);
                    for (int i = 0; i < nDeComposiciones; i++) {
                        Compositor compositorCasting = (Compositor) compositor;
                        System.out.println("Ingresar el codigo de la cacion: ");
                        int codigo2 = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Ingresar el titulo de la cancion: ");
                        String titulo = entrada.nextLine();
                        System.out.println("Ingresar la laetra de la canciom: ");
                        String letra = entrada.nextLine();
                        System.out.println("Ingresar el tiempo de duracion de la cancion: ");
                        double tiempoEnMinutos = Double.parseDouble(entrada.nextLine());
                        compositorCasting.agregarCancion(codigo2, titulo, letra,tiempoEnMinutos);
                    }
                    controladorPersona.create(compositor);
                    break;
                case 3:
                    System.out.println("Ingresar el codigo de la cantante a agregar: ");
                    codigo = entrada.nextInt();
                    Cantante cantanteCasting = (Cantante) controladorPerCast.buscarPorCodigoCantante(codigo);
                    System.out.println("Ingresar el codiigo del compositor al cual se quiere agregar: ");
                    codigo = entrada.nextInt();
                    Compositor compositorCasting = (Compositor) controladorPerCast.buscarPorCodigoCompositor(codigo);
                    if (compositorCasting instanceof Persona && compositorCasting instanceof Persona ){
                        compositorCasting.agregarCliente(cantanteCasting);
                    }
                    break;
                case 4:
                    controladorPerCast.imprimir();
                    break;
                case 5:
                    entrada.nextLine();
                    System.out.println("Ingresar el nombre del disco: ");
                    String valor = entrada.nextLine();
                    controladorPerCast.buscarPorNombreDeDisco(valor);
                    break;
                case 6:
                    entrada.nextLine();
                    System.out.println("Ingresar el titulo de la cancion: ");
                    String titulo = entrada.nextLine();
                    controladorPerCast.buscarPorTituloDeCancion(titulo);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            
        }while(opcion != 7);          
    }
}

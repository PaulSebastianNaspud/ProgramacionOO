/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.up.edu.practica02.vista;

//import nescesarios
import ec.up.edu.practica02.controlador.ControladorPersona;
import ec.up.edu.practica02.controlador.IControlador;
import ec.up.edu.practica02.modelo.Cantante;
import ec.up.edu.practica02.modelo.Compositor;
import ec.up.edu.practica02.modelo.Persona;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //instanciar objetos 
        //instancia controladorPersona que implementa la interface controlador
        IControlador controladorPersona = new ControladorPersona();
        //down casting para acceder a los metodos de la clase ControladorPersona
        ControladorPersona controladorPerCast = (ControladorPersona) controladorPersona;
        //instanciar el objeto scanner para introducir datos por teclado
        Scanner entrada = new Scanner(System.in);
        
        int opcion = 0; //inicializar una variabele int que entre al bucle do while
        do { //bucle do- whilw con condicion falso de int = 7 para salir del bucle
            //menu con 7 opciones
            System.out.println("\n Menu \n1. Ingreso de Cantante \n2. Ingreson de Compositor \n3. Agregar Clientes \n4. Imprimir"
                    + " \n5. Buscqueda de cantante por el nombre del disco \n6. Busqueda de compositor por nombre de cancion \n7. Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:  //caso1 Ingresar Cantante
                    entrada.nextLine();//posible salro de nextInt
                    //Ingresar datos por teclado con el Scanner
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
                    
                    //instaciar un objeto persona atraves del polimorfismo
                    Persona cantante = new Cantante(nombreArtistico, generoMusical, nSensillos, nConciertos, nGiras, codigo, nombre, apellido, edad, salario, nacionalidad);
                    System.out.println("Ingrese el numero de discos del cantante: ");
                    int cantidad = entrada.nextInt();//numero de discos del cantante
                    for (int i = 0; i < cantidad; i++) { //for para ingreasr los datos por teclado del dico
                        Cantante cantanteCasting = (Cantante) cantante; //downCasting para acceder a los metodos de Cantante
                        System.out.println("Ingresar el codigo del disco: ");
                        int codigo2 = entrada.nextInt();
                        System.out.println("Ingresar el año de lanzamiento:");
                        int anioDeLanzamiento = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Ingresar el nombre del disco: ");
                        String nomreCancion = entrada.nextLine();
                        //utilizar el metdodo agregarDisco para aañadir discos a la lista del objeto
                        cantanteCasting.agregarDisco(codigo2, nomreCancion, anioDeLanzamiento); 
                    }
                    //llamar al metodo calcularSalario para calcular el salrio final y utiliazcion de los metodos sobrescritos abstract
                    cantante.calcularSalario();
                    //create cantanete en la lista personas
                    controladorPersona.create(cantante);
                    break;
                case 2:
                    entrada.nextLine();//posible salto de nextInt
                    //Ingresar datos por teclado con el Scanner
                    System.out.println("Ingresar el nombre del compositor: ");
                    nombre = entrada.nextLine();
                    System.out.println("Ingresar el apelldo del compositor: ");
                    apellido = entrada.nextLine();//salto nextInt
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
                    
                    //instaciar un objeto persona atraves del polimorfismo
                    Persona compositor = new Compositor(nDeComposiciones, codigo, nombre, apellido, edad, salario, nacionalidad);
                    System.out.println("Ingesar las cantidades de canciones del compositor: ");
                    cantidad = entrada.nextInt(); 
                    entrada.nextLine();//salto nextInt
                    for (int i = 0; i < cantidad; i++) {  //for para ingreasar datos por teclado para llenar la lista de canciones
                        Compositor compositorCasting = (Compositor) compositor;  //downcasting para acceder a los metodos de la clase Composiotr
                        System.out.println("Ingresar el codigo de la cacion: ");
                        int codigo2 = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Ingresar el titulo de la cancion: ");
                        String titulo = entrada.nextLine();
                        System.out.println("Ingresar la la letra de la canciom: ");
                        String letra = entrada.nextLine();
                        System.out.println("Ingresar el tiempo de duracion de la cancion: ");
                        double tiempoEnMinutos = Double.parseDouble(entrada.nextLine());
                        //llamar el metodo abstract agregarCancion de la clase Persona
                        compositorCasting.agregarCancion(codigo2, titulo, letra, tiempoEnMinutos);
                    }
                    compositor.calcularSalario(); // llamar al metodo calcular salario
                    controladorPersona.create(compositor);//agregar compositores a la lista personas
                    break;
                case 3:
                    //agregar clientes
                    entrada.nextLine();//posible salto de de nextInt
                    System.out.println("Ingresar el codigo de la cantante a agregar: ");//dato por teclado
                    codigo = entrada.nextInt();
                    //downcastin de Persona a cantente, de la persona que pueda cumplir y que quiera el usuario
                    Cantante cantanteCasting = (Cantante) controladorPerCast.buscarPorCodigoCantante(codigo);
                    System.out.println("Ingresar el codiigo del compositor al cual se quiere agregar: ");//dato por teclado
                    codigo = entrada.nextInt();
                    //downcastin de Persona a compositor, de la persona que pueda cumplir y que quiera el usuario
                    Compositor compositorCasting = (Compositor) controladorPerCast.buscarPorCodigoCompositor(codigo);
                    //if para combertir objetos que sean instancias de los datos que inggreso el usuario
                    if (compositorCasting instanceof Persona && compositorCasting instanceof Persona) {
                        compositorCasting.agregarCliente(cantanteCasting);//llamar al metodo agregarCliente
                    }
                    break;
                case 4:
                    controladorPerCast.imprimir();//imprimier la lista de personas
                    break;
                case 5:
                    //buscarPorNombreDeDisco
                    entrada.nextLine();//posible nextInt
                    System.out.println("Ingresar el nombre del disco: ");//dato por teclado
                    String valor = entrada.nextLine();
                    controladorPerCast.buscarPorNombreDeDisco(valor);//llamar al metodo buscarPorNombreDeDisco
                    break;
                case 6:
                    //buscarPorTituloDeCancion
                    entrada.nextLine();//posible nextInt
                    System.out.println("Ingresar el titulo de la cancion: ");//dato por teclado
                    String titulo = entrada.nextLine();
                    controladorPerCast.buscarPorTituloDeCancion(titulo);//llamar al metodo buscarPorTituloDeCancion
                    break;
                case 7:
                    break;//terminat el bucle
                default:
                    System.out.println("Opcion no valida");//mesanje para opcoin no valida
                    break;
            }
        } while (opcion != 7);//condicion para el fin del bucle
    }
}

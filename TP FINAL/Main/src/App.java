import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.Stack;

//Crear mensajes por consola para cada metodo especifico, demostrando su funcion
public class App {

    public static boolean disponible;
    public static int eleccion;
    public static String eleccionArchivo, RutaGeneral;
    public static Scanner sc = new Scanner(System.in);
    public static Archvos biblioteca = new Archvos();
    static File Raiz = new File("C:\\Pepe\\");
    static File desarrolloPersonal = new File("C:\\Pepe\\Tematicas\\Desarollo personal\\");
    public static File historias = new File("C:\\Pepe\\Tematicas\\Historias\\");
    public static File matematicas = new File("C:\\Pepe\\Tematicas\\Matematicas\\");
    public static File misticos = new File("C:\\Pepe\\Tematicas\\Misticos\\");
    public static File otros = new File("C:\\Pepe\\Tematicas\\Otros\\");
    public static File reservado = new File("C:\\Pepe\\Reservado\\");
    public static Scanner eleccionAr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        Presentar();

        switch (eleccion) {
            // 1 para ver el catalogo
            case 1:
                VerCatalogo();
                // 2 para agregar libro
            case 2:
                AgregarLibro();
                // 0 para salir
            case 0:
                break;

        }

    }

    public static void Presentar() {
        // Presentacion del programa
        System.out.println("Bienvenido a la biblioteca SAPE \n " +
                "Saber, Aprender, Pensar, Enseñar");
        System.out.println("* 1.Ver catalogo\n" +
                "* 2.Crear un libro\n" +
                "* 0.Salir");
        eleccion = sc.nextInt();

    }

    public static void AgregarLibro() {
        // La opcion del switch
        Agregar();

    }

    public static void Agregar() {
        // Pedirle al usuario los datos del libro para creaer el archivo tipo file

    }

    public static void SacarLibro() {
        // Opcion de BuscarNombre

    }

    public static void VerCatalogo() {
        // Opcion del switch
        // Posiblemente de error por haber utilizado la misma variable en el switch
        // anterior y no ser limpiado, en caso de milagro, no se toca gente
        System.out.println("Ingrese \n" +
                "* 1.Mostrar todo el catalogo\n" +
                "* 2.Mostrar los temas disponibles\n" +
                "* 3.Mostrar los libros disponibles\n" +
                "* 4.Mostrar los libros reservados\n" +
                "* 5.Buscar libros por nombre");
        eleccion = sc.nextInt();

        switch (eleccion) {
            // 1 para ver todos los archivos
            case 1:
                Archvos.MostrarArchivos(Raiz);
                // 2 para filtrar los generos de los libros
            case 2:
                Temario();
                // 3 para filtrar los libros por los que tengan el estado "disponible" en true
                // TERMINAR
            case 3:

        }

    }

    public static void Temario() {
        // Va a contener los temas de los libros (Una clase general)
        System.out.println("Ingrese\n" +
                "* 1.Ver los libros de desarrollo personal\n" +
                "* 2.Ver los libros de tematica historias\n" +
                "* 3.Ver los libros de tematica matematicas\n" +
                "* 4.Ver los libros de tematica misticos\n" +
                "* 5.Ver los libros de otras tematicas");

        eleccion = sc.nextInt();

        switch (eleccion) {
            // 1 para Informatica
            case 1:
                MostrarArchivos(desarrolloPersonal);
                break;
            // 2 para ver Finanzas
            case 2:
                MostrarArchivos(historias);
                break;
            // 3 para ver Idiomas
            case 3:
                MostrarArchivos(matematicas);
                break;
            // 4 para ver Historia
            case 4:
                MostrarArchivos(misticos);
                break;
            // 5 para ver Otros
            case 5:
                MostrarArchivos(otros);
                break;

        }

    }

    public static void Todo() {
        // La llamada al array que contenga todos los libros
    }

    public static void FiltrarNombre() {
        // Se va a utilizar para encontar un libro en especifico
        // Llamar al metodo mostrar archivos

    }

    public static void LeerLibro() {
        // Opcion despues de elegir las tematicas o ver todos los libros

    }

    public static boolean Disponible() {
        // Retorna el estado del libro para utilizarse en
        Libros libros = new Libros();
        return libros.disponible;
    }

    public static void FiltrarLibro() {
        // Retorna el stack de los libros disponibles filtrados por la funcion
        // "Disponible"
    }

    public static void MostrarArchivos(File Ruta) {
        RutaGeneral = Ruta.getAbsolutePath();
        if (Ruta.exists()) {
            for (File ArchDire : Ruta.listFiles()) {

                if (ArchDire.isFile()) {

                    biblioteca.SacarTXT(ArchDire.getName());
                }

                else if (ArchDire.isDirectory()) {
                    System.out.println(ArchDire.getName() + ": ");
                    MostrarArchivos(ArchDire);
                }
            }
        } else {
            System.out.println("la re puta que te re mil pario");
        }
        // Esto va a estar despues del metodo FiltrarNombre
        // TERMINAR Y MEJORAR, LA OPCION 2 NO LLEVA A NADA Y LA 1 ESTA MAL ESCRITA
        System.out.println("presione 1 para leer el libro");
        System.out.println("presione 2 para retirar el libro");
        eleccion = sc.nextInt();
        switch (eleccion) {
            case 1:
                RetirarLibro(RutaGeneral);
                break;

        }

    }

    public static void RetirarLibro(String RutaGeneral) {
        // Este metodo se va a utilizar para mover archivos entre directorios para
        // simular el estado de reservado, se decidio esto ya que era la ruta mas simple
        // a la hora de
        System.out.println("Ingrese el nombre del libro que desee reservar");
        eleccionArchivo = eleccionAr.nextLine();
        Path origen = Path.of(RutaGeneral + "\\" + eleccionArchivo + ".txt");
        Path destino = Path.of(reservado.getAbsolutePath());
        try {

            Path mover = Files.move(origen, destino.resolve(origen.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Se movio el puto archivo" + mover);
            // Este try se utiliza ya que el metodo Path no deja usarse si no es asi. PATH
            // es nombre de puta, onda "candy"
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);

        }

    }
}

// Valen dijo que esta quedando facherito 18:35Hs El dolar llego a $1020 de
// venta, ivo se quiere cortar los huevos
// Planteo: En el diagrama de flujo se acordo que el buscar un libro por su
// nombre sea una opcion a parte, pero al considerarlo, se decidio que se
// ejecute el metodo despues de mostrar la tematica, al que no le guste, se la
// come. A ivo no le gusta la idea, se queja escandalosamente
// El mago lo volvio a hacer, casi pierde la batalla (cago aguado)

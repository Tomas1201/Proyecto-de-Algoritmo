package PruebaArchivos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;


public class Archvos {
static String NombreTematica;
static Scanner sc = new Scanner(System.in);
static File Raiz = new File("C:\\Pepe\\");
	public Archvos() {
	}
public static void main(String[]args) throws IOException {
//	File Archivo = new File("C:\\Users\\Tomas1201\\Desktop\\Archivo.txt");
//	System.out.print(Archivo.exists());
	
	System.out.println("Ingrese una tematica: ");
	NombreTematica = sc.nextLine();	
	CrearTematica(NombreTematica);
	System.out.println("Crea un libro: ");
	
	CrearLibro(sc.nextLine(), sc.nextLine());
	
	System.out.println("Busque un Libro: ");
	String Libro = sc.nextLine()+".txt";
	BuscarLibro(Raiz, Libro);
	
	MostrarArchivos(Raiz);
}



//Busca si ya existe algun directorio con el nombre ingresado
public static void CrearTematica(String Tematica) {
	File TematicaC = new File("C:\\Pepe\\"+Tematica+"\\");
	if(TematicaC.exists()) {
		System.out.println("Ya existe una tematica con ese nombre.");		
	}
	else {
		boolean estado =TematicaC.mkdir();
//		System.out.println(estado);
	}
}



//Busca si existe algun libro con ese nombre
public static void BuscarLibro(File DirectorioActual, String Libro) {
	
	if(DirectorioActual.exists()) {
		for(File archivoOrSubdirectorio : DirectorioActual.listFiles()) {
			
			 if (archivoOrSubdirectorio.isFile()) {
				 
                 // Si el nombre del archivo coincide con el nombre buscado
                 if (archivoOrSubdirectorio.getName().equals(Libro)) {
                	 
                     // Imprimimos la ubicación del archivo
                     System.out.println(archivoOrSubdirectorio.getAbsolutePath());
                    
                     return;
                    
                     }}
			 //Si no lo encuentra en la carpeta actual busca en sus subcarpetas
			 else{
	 BuscarLibro(archivoOrSubdirectorio, Libro);
}
		}
	}
}
//Crea un archivo y escribe dentro el nombre del propio libro y su autor
public static void CrearLibro(String NombreLibro, String Autor) throws IOException {
	FileWriter Libro = null;
	PrintWriter Fuma = null;
	try {
		Libro = new FileWriter("C:\\Users\\Tomas1201\\Desktop\\"+NombreLibro+".txt");
		Fuma =  new PrintWriter(Libro);
		Fuma.println(NombreLibro);
		Fuma.println("");
		Fuma.println("Escrito por: "+Autor);
	} catch (IOException e) {
		e.printStackTrace();
	}finally {Libro.close();}
	File Libro1 = new File("C:\\Users\\Tomas1201\\Desktop\\"+NombreLibro+".txt");
	System.out.println("Se a creado el libro");
	
}


public static void MostrarArchivos(File Ruta) {
	
	for(File ArchDire : Ruta.listFiles()) {
		
		if(ArchDire.isFile()) {
			
			
			SacarTXT(ArchDire.getName());
		}
		
		else if(ArchDire.isDirectory()) {
			System.out.println(ArchDire.getName()+": ");
			MostrarArchivos(ArchDire);
		}
	}
}

public static void SacarTXT(String Nombre) {
	int Longitud = Nombre.length();
		String Renombre = Nombre.substring(0, Longitud - 4);
		System.out.println("* "+Renombre);

}

public static void Reservar(String Libro) {
	
}
}

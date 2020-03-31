package act8;

import java.io.File;
import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;

import control.EntradaDatos;

/**
 * 
 * @author Pablo Gutierrez Martinez - DAM
 *
 */
public class Test {

	public static void main(String[] args) {

		lecturaLibro("src/act7/Libros");
//		lecturaLibro("src/act5");	//Tambien se podria usar con otros directorios
		
	}
	
	/**
	 * Este metodo imprime por pantalla el contenido del fichero elegido de entre todos los archivos del directorio especificado (los nombres de las variables usadas viene orientado a usarlo de cara a los archivos con los datos de libros del ejercicio anterior pero tambien se podria usar con otro directorio)
	 * @param directoryPath - Ruta del directorio donde se encuentran todos los archivos con los datos de los libros.
	 */
	public static void lecturaLibro(String directoryPath){
		
		File directory = null;
		
		FileReader reader = null;
		
		int cont = 0;
		
		try {
			
			directory = new File(directoryPath);
			
			String[] librosArray = directory.list();
			
			for (String string : librosArray) {
				
				System.out.println(cont + ": " + string);
				cont++;
			}
			
			System.out.println("Introduzca el numero correspondiente al archivo que quiere leer: ");
			int opcion = EntradaDatos.pedirInt_Parametros(0, librosArray.length - 1);
			
			reader = new FileReader(directoryPath + "/" + librosArray[opcion]);
			
			cont = 0;
			
			while ((cont = reader.read()) != -1) {
				
				System.out.print((char) cont);
				
			}

			
//			List<String> librosList = new ArrayList<>();
//			
//			Collections.addAll(librosList, librosArray);		
//			
//			librosList.stream().forEach(x -> {System.out.println(cont + ": " + x); cont++;});
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	} 

}

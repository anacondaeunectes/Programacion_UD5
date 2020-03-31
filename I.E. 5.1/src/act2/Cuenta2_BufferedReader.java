	package act2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import act1.Cuenta;

/**
 * 
 * @author Pablo Gutierrez Martinez - DAM
 *
 */
public class Cuenta2_BufferedReader {

	public static void main(String[] args) {

		cuentaPalabrasLinea("src/act2/ejemplo.txt");
		
	}
	
	/**
	 * Este metodo busca aprovecharse del metodo creado en la act 1. Lee cada linea del archivo,a través del metodo readLine() de la clase BufferedReader, y la almacena en un String. Acto seguido crea un archivo "temporal" y 
	 * escribe sobre esa linea almacenada, solo esa linea, para poder definitivamente llamar al metodo de la act anterior con ese archivo "temp" como parametro. De esta forma, y con un bucle, cuenta las palabras de cada linea, 
	 * almacenada cada vez en el fichero "temp".
	 * @param filePath - Ruta del archivo a leer.
	 */
	public static void cuentaPalabrasLinea(String filePath) {
		
		BufferedReader reader = null;
		FileWriter writer = null;
		File temp = null;

		
		try {
			
			reader = new BufferedReader(new FileReader(filePath));
			
			String line;
			
			int cont = 1;
			
			
			
			while ((line = reader.readLine()) != null) {
				
				temp = new File("temp.txt");
			
				writer = new FileWriter(temp);
				
				writer.write(line);
				
				writer.flush();
				
				System.out.println("Linea " + cont + ": Contiene " + Cuenta.cuentaPalabras(temp));
				
				cont++;
				
			}
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}finally {

			try {
				
				writer.close();
				reader.close();
				temp.delete(); //se encarga de borrar el ultimo archivo "temp" creado ya que no es necesario fuera del algoritmo del programa. Solo es necesario borrar el ultimo ya que los demas se van sobrescribiendo unos a otros. 
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
		}
		
	}

}

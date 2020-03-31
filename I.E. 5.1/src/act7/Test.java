package act7;

import java.io.File;
import java.io.FileWriter;
import java.time.Year;

import control.EntradaDatos;

/**
 * 
 * @author Pablo Gutierrez Martinez - DAM
 *
 */
public class Test {

	public static void main(String[] args) {
		
			registroLibro("src/act7/Libros");
		
	}

	/**
	 * Este metodo crea archivos con datos de libros, cada archivo contiene los datos de un libro, y los almacena en el directorio espedificado. En caso de que el codigo de un nuevo libro coincida con uno anterior, el anterior sera sobreescrito.
	 * @param directoryPath - Ruta del directorio donde se van a escribir los archivos
	 */
	public static void registroLibro(String directoryPath) {
		
		FileWriter writer = null;
		
		try {
			
			Libro libro = createBook(true);
			
			if (compareBookIndex(directoryPath, libro.getCodigo())) {
				
				int cd = libro.getCodigo();
				
				System.out.println("Codigo repetido. Procediendo a sobreescribir libro:");
				
				libro = createBook(false);
				
				libro.setCodigo(cd);
			}
			
			writer = new FileWriter(directoryPath + "/Libro" + libro.getCodigo()+ ".txt");
			
			writer.write("Codigo: " + libro.getCodigo() + "\nISBN: " + libro.getISBN() + "\nTitulo: " + libro.getTitulo() + "\nAutor: " + libro.getAutor() + "\nEditorial: " + libro.getEditorial() + "\nAno de Edicion: " + libro.getAnoEdicion().getValue());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				writer.close();
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Este metodo pide al usuario todos los datos necesarios para crear un libro segun el ejercicio. De cara al caso en el que se repita el codigo, recibe un booleano como parametro para pedir o no un codigo.
	 * @param flag - Booleano que representa si el codigo se ha repetido o no. 
	 * @return Devuelve un objeto libro con todos los valores que se han pedido.
	 */
	private static Libro createBook(boolean flag) {
		
		int codigo;
		
		if (flag) {
			
			System.out.println("Introduzca el codigo de su libro:");
			codigo = EntradaDatos.pedirInt();
		}else {
			
			codigo = 0;
		}
		
		System.out.println("Introduzca el ISBN de su libro:");
		String ISBN = EntradaDatos.pedirString();
		
		System.out.println("Introduzca el titulo:");
		String titulo = EntradaDatos.pedirString();
		
		System.out.println("Introduzca el autor");
		String autor= EntradaDatos.pedirString();
		
		System.out.println("Introduzca la editorial");
		String editorial= EntradaDatos.pedirString();
		
		System.out.println("Introduzca el ano de la version");
		Year anoEdicion = Year.of(EntradaDatos.pedirInt_Parametros(1000, 2020)); 
		
		Libro libro = new Libro(codigo, ISBN, titulo, autor, editorial, anoEdicion);
		
		return libro;
	}
	
	/**
	 * Este metodo compara que el codigo pasado por parametro no coincida con ninguno de los codigos implicitos en los nombres de los ficheros con los datos de cada libro. 
	 * @param directoryPath - Ruta del directorio que contiene los libros cuyo codigo va a comparar
	 * @param codigo - codigo a comparar
	 * @return <ul>
	 * 		   	<li>true: significa que hay una coincidencia</li>
	 * 		 	<li>false: no hay coincidencias. No se repite el codigo</li>
	 * 		   </ul>		
	 */
	private static boolean compareBookIndex(String directoryPath, int codigo) {
		
		File file = null;
		
		try {
			
			file = new File(directoryPath);
			
			String[] filesNames = file.list();
			
			
			
			for (String string : filesNames) {
				
				string = string.replaceAll("\\D","");
				
				if (Integer.parseInt(string) == codigo){
					
					return true;
				}
				
			}
			
					
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
		
	}
}

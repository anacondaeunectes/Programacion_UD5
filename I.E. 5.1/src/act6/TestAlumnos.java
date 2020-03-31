package act6;

import java.io.CharArrayWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Pablo Gutierrez Martinez - DAM
 *
 */
public class TestAlumnos {

	public static void main(String[] args) {

		alumnos("src/act6/alumnos.txt");
		
	}
	
	/**
	 * Este metodo lee un archivo cuyo contenido es el de una serie de alumnos con nommbres, apellidos y notas media. Por un lado imprime por pantalla aquellos alumnos cuya nota media sea superior a 5 (superior pero no igual)y por otro, calcula la media de las notas medias de todos los alumnos.	
	 * @param filePath - Ruta del archivo.
	 */
	public static void alumnos(String filePath) {	
		
		FileReader reader = null;
		
		CharArrayWriter writer = null;
		
		List<String> alumnosAprobados = new ArrayList<>();
		
		int c = 0;
		try {
			reader = new FileReader(filePath);
			
			writer = new CharArrayWriter();
			
			//Este bucle busca separar los datos de cada alumno usando la como (cuyo valor ASCII es 44) como separador. Luego, lo agrega a la coleccion creada anteriormente y resetea el buffer del writer.
			while ((c = reader.read()) != -1) {
				
				if (c != 44) {
					
					writer.write(c);
				}else {
					
					alumnosAprobados.add(writer.toString());
					writer.reset();
				}
			}
			
			alumnosAprobados.add(writer.toString());
			
			System.out.println("Estos son los alumnos aprobados:");
			
			//Convierto la coleccion que guarda los datos de cada alumno en Stream para filtrar. Reduzco cada entrada de la coleccion a solo numeros y puntos (ya que las notas pueden ser valores racionales) y lo "parseo" a Double. Luego filtro que el resultado sea mayor o igual a cinco y lo imprimo.
			alumnosAprobados.stream().filter(x -> Double.parseDouble(x.replaceAll("[^\\.0123456789]","")) > 5.0).forEach(System.out::println);
			
			System.out.println("\nLa media de todos los alumnos es: ");
			
			//Al igual que antes, reduzco cada entrada al valor de las notas (en double) y sumo todas para luego dividirlas entre el numero de entradas de la coleccion. Todo esto a traves de Stream. 
			System.out.println(alumnosAprobados.stream().mapToDouble(x -> Double.parseDouble(x.replaceAll("[^\\.0123456789]",""))).sum()/alumnosAprobados.stream().count());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}

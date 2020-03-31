package act4;

import java.io.FileReader;

/**
 * 
 * @author Pablo Gutierrez Martinez - DAM
 *
 */
public class Test {

	public static void main(String[] args) {

		lecturaArchivo("src/act4/ej4.txt");
	}
	
	/**
	 * Este metodo lee a traves de un FileReader caracter a caracter el contenido del archivo cuya ruta ha sido pasada por parametro. Imprime cada caracter por pantalla.
	 * @param filePath - Ruta relativa del archivo. Partimos del directorio del proyecto.
	 */
	public static void lecturaArchivo(String filePath) {
		
		FileReader reader = null;
		
		int c = 0;
		
		try {
			
			reader = new FileReader(filePath);
			
			while ((c = reader.read()) != -1) {
				
				System.out.print((char)c);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				
				reader.close();
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
		}
		
	}

}

package act1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Pablo Gutierrez Martinez - DAM
 *
 */
public class Cuenta {

	public static void main(String[] args) {
		
		File file = new File("src/Text.txt");
		
		System.out.println(cuentaPalabras(file));
			
	}
	
	
	/**
	 * Metodo que cuenta las palabras que contiene un archivo siempre y cuando no haya espacios dobles o espacios al inicio o final del texto recogido.(ver como implementar trim())
	 * @param filePath - Ruta del archivo
	 * @return - Devuelve un int que representa las palabras contadas
	 */
	public static int cuentaPalabras(File file) {
		
		int cont = 0;
		
		int c = 0;
		
		FileReader reader = null;
		
		try {
			
			reader = new FileReader(file);
			
			while ((c = reader.read())  != -1) {
				
				if (c == 32) {
					cont++;
				}
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}finally {

			try {
				
				reader.close();
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
		}
		
		return cont + 1;
	}

}

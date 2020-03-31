package act3;

import java.io.FileReader;

/**
 * 
 * @author Pablo Gutierrez Martinez - DAM
 *
 */
public class Test {

	public static void main(String[] args) {

		buscarCaracterPorLinea('p', "src/act2/ejemplo.txt");
	}
	
	/**
	 * Este metodo evalua cada linea del archivo leido para saber si contiene o no un caracter.
	 * @param c - Caracter a evaluar
	 * @param filePath - Ruta del archivo a leer
	 */
	public static void buscarCaracterPorLinea(char c, String filePath) {
		
		FileReader reader = null;
		
		int n = 0;
		
		int contLinea = 1;
		
		boolean contiene = false;
		
		try {
			
			reader = new FileReader(filePath);
			
			while ((n = reader.read()) != -1) {
				
				if (n == c) {
					
					contiene = true;
				}
				
				//Evalua que sea un salto de linea o ya no se puedan leer nada mas. Si NO se cumple la condicion, no hace nada. Si se cumple, actua en consecuencia de si se ha encontrado o no al caracter en esa linea (a traves del booleano "contiene") y resetea el booleano "contiene" 
				if (n == 10 || reader.ready() == false) {
					
					if (contiene) {
						
						System.out.println("La linea " + contLinea + " SI contiene el caracter `" + c +"'");
						
						contiene = false;
					}else {
						
						System.out.println("La linea " + contLinea + " NO contiene el caracter `" + c +"'");
					}
					
					contLinea++;
				}
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

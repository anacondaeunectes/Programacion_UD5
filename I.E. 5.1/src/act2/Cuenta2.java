package act2;

import java.io.FileReader; 

/**
 * 
 * @author Pablo Gutierrez Martinez - DAM
 *
 */
public class Cuenta2 {

	public static void main(String[] args) {

		cuentaPalabrasLinea("src/act2/ejemplo.txt");
		
	}
	
	/**
	 * Este metodo cuenta las palabras de cada linea de un fichero. Para ello, lee y cuenta todas las palabras hasta quese encuentre con el caracter que marca el salto de linea, "\n" (codigo 10 en ASCII) 
	 * @param filePath - Ruta del archivo a leer.
	 */
	public static void cuentaPalabrasLinea(String filePath) {
		
		FileReader reader = null;
		
		int c = 0;
		
		int cont = 1;
		
		int cont2 = 1;
		
		try {
			
			reader = new FileReader(filePath);
			
			while ((c = reader.read()) != -1) {
				
				if (c == 32) {
					
					cont++;
				}
				
				if (c == 10) {
					
					System.out.println("Linea " + cont2 + ": Contiene " + cont);
					
					cont = 1;
					
					cont2 ++;
				}
				
			}
			
			System.out.println("Linea " + cont2 + ": Contiene " + cont);
			
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

package act5;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * 
 * @author Pablo Gutierrez Martinez - DAM
 *
 */
public class Test {
	
	public static void main(String[] args) {

		A_Mayusculas("src/act4/ej4.txt");
	}
	
	
	/**
	 * Este metodo lee el contenido de un archivo caracter a caracter, obvia los numeros y otros caracteres y se quedan con los caracteres alfabeticos. Los que se encuentren en minusculas los pasa a mayusculas. Respeta los espacios.
	 * @param filePath - Ruta relativa del archivo. Partimos del directorio del proyecto.
	 */
	public static void A_Mayusculas(String filePath) {
		
		FileReader reader = null;
		
		FileWriter writer = null;
		
		try {
			
			reader = new FileReader(filePath);
			
			writer = new FileWriter("src/act5/resultado_A_Mayusculas.txt");
			
			int c = 0;
			
			while ((c = reader.read()) != -1) {
				
				if ((c > 96 && c < 123)) {
					
					//Uso la clase Wrapper, o envolvente, del tipo primitivo "char", Character, para realizar la conversion a mayusculas. 
					c = Character.toUpperCase(c);
					writer.write(c);
				}else if ((c > 64 && c < 91) || c == 32) {
					
					writer.write(c);
				}
				
			}
			
			System.out.println("Archivo generado");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				
				reader.close();
				writer.close();
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
		}
	}

}

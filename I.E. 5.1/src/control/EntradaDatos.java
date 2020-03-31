package control;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * 
 * @author Pablo Gutierrez Martinez - DAM
 *
 */
public class EntradaDatos {

	static Scanner entrada = new Scanner(System.in);

	
	public static double pedirDouble() {
		
		double num = 0;
		boolean ok=false;
		
		do {
			try {
				num = entrada.nextDouble();
				ok=true;
				
			} catch (Exception e) {
				System.out.println("Numero no valido. Por favor, vuelva a introducirlo: ");
				ok=false;
			}
			
			entrada.nextLine();
		} while (ok==false);
		
		return num;
	}
	
	public static int pedirInt(){
		
		int num = 0;
		boolean ok=true;
		
		do {
			try {
				
				ok=true;
				num = entrada.nextInt();

				
			} catch (Exception e) {
				System.out.println("Numero no valido. Por favor, vuelva a introducirlo: ");
				ok=false;
			}
			
			entrada.nextLine();
		}while(ok==false);
		
		
		
		return num;
	}
	
	public static int pedirInt_Parametros(int min, int max) {
		
		String frase = "Numero no valido. Por favor, vuelva a introducirlo: ";
		int num = 0;
		boolean ok=true;
		
		do {
			
			do {
				try {
					num = entrada.nextInt();
					ok=true;
					
				} catch (Exception e) {
					System.out.println(frase);
					ok=false;
				}
				entrada.nextLine();
			}while(ok==false);
		
			if (num < min || num > max) {
				
				ok=false;
				System.out.println(frase);
			}
			
		} while(ok==false);
		
		
		
		return num;
	}
	
	public static String pedirString() {
		
		String cadena = entrada.nextLine();
		
		return cadena;
		
	}
	
	public static LocalDate pedirFecha(int annoInicio, int annoLimite) {
		
		System.out.println("Introduzca un anno:");
		int year = pedirInt_Parametros(annoInicio, annoLimite);
		System.out.println("Introduzca un mes:");
		int month = pedirInt_Parametros(1, 12);
		System.out.println("Introduzca un dia:");
		int dayOfMonth = pedirInt_Parametros(1, 31);
		
		return LocalDate.of(year, month, dayOfMonth);
	}
	
//	public static String comprobarDNI(String a) {
//		
//		boolean ok = true;
//		
//		do {
//			ok=true;
//			
//			//Patter para el DNI espanol. Curioso que la letra final no pueda ser ninguna de las excepciones mostradas abajo. Entiendo que por posible malentendidos.
//			if (a.matches("[0-9]{7}[a-zA-Z]")==true) {
//				System.out.println("Introduzca solo 9 numeros, por favor.");
//				a=pedirString();
//				ok=false;
//			}
//		} while (ok);
//		return a;
//	}
	
}

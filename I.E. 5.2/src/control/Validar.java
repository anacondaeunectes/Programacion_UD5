package control;

import java.time.LocalDate;
import java.util.Scanner;
import gestionVideoclub.Plataforma;

/**
 * 
 * @author Pablo Gutierrez Martinez - DAM
 *
 */
public class Validar {

	static Scanner entrada = new Scanner(System.in);
	
	public static Plataforma pedirPlataforma() {
		
		Plataforma plataforma = null;
		String entrada;
		
		do {
				entrada = pedirString();
				
				for (int j = 0; j < Plataforma.values().length; j++) {
					
					plataforma = entrada.equalsIgnoreCase(Plataforma.values()[j].toString()) ? Plataforma.values()[j] : null;
					
					if (plataforma != null) {
						break;
					}
				}
				
				if (plataforma == null) {
					System.out.println("Plataforma no valida. Ha de ser una de las siguientes: DS, WII, XBOX, PS2, PS3, PS4 o PC. Por favor, vuelva a introducirla: ");
				}
			
		} while (plataforma == null);
		
		return plataforma;
		
	}

	
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
	
	public static LocalDate pedirFecha(LocalDate fechaMinima, LocalDate fechaMaxima) {
		
		boolean ok=true;
		LocalDate fecha = null;
		
		do {
			
			try {
				fecha = LocalDate.parse(Validar.pedirString());
				ok=true;
				
				if (fecha.isAfter(fechaMaxima) || fecha.isBefore(fechaMinima)) {
					 ok = false;
				}
				
			} catch (Exception e) {
				System.out.println("Fecha no valida. Por favor, vuelva a introducir otra fecha:");
				ok = false;
			}
			
		} while (!ok);
		
		return fecha;
	}
	
	
}

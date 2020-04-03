package gestionVideoclub;

import control.Validar;

public class MenuDemo {
	
	static VideojuegoDAO vjDAO = new VideojuegoDAO();

	public static void main(String[] args) {
		
		int opcion = 0;
		
		do {
			
			System.out.println("================================================");
			System.out.println("    ======== Gestion de Videojuegos ========    ");
			System.out.println("================================================");
			System.out.println("\n\t1.- Anadir un videojuego.");
			System.out.println("\t2.- Listar videojuegos.");
			System.out.println("\t3.- Borrar un videojuego");
			System.out.println("\t4.- Guardar datos en fichero.");
			System.out.println("\t5.- Recuperar datos desde fichero");
			System.out.println("\n\t0.- Salir de la aplicacion");
			
			System.out.println("================================================");
			System.out.println("Introduzca la opcion elegida:");
			
			switch (opcion = Validar.pedirInt_Parametros(0, 5)) {
			case 1:
				anadirVideojuego();
				break;
				
			case 2:
				vjDAO.getAll().values().stream().forEach(System.out::println);
				break;
				
			case 3:
				borrarVideojuego();
				break;
				
			case 4:
				anadirVideojuego();
				break;
				
			case 5:
				anadirVideojuego();
				break;
				
			}
			
		} while (opcion != 0);
		
		
	}
	
	private static void anadirVideojuego() {
		
		if (vjDAO.getAll().size() < 10) {
			
			Videojuego temp = vjDAO.create();
			
			vjDAO.getAll().put(temp.getCodigo(), temp);
			
			System.out.println("\nSe ha creado el nuevo videojuego.\n");
		}else {
			
			System.out.println("Se ha alcanzado el numero maximo de videojuegos a almacenar(10). Para anadir un nuevo videojuego, debera borrar uno de los almacenados.\nVolviendo al menu...");
		}
		
	}
	
	private static void borrarVideojuego() {
		
		if (vjDAO.getAll().isEmpty()) {
			System.out.println("Imposible borrar. No se han encontrado videojuegos.");
		}else {
		
			System.out.println("Por favor, introduzca el codigo del videojuego a borrar: ");
			int rmv = Validar.pedirInt();

			
			if (vjDAO.getAll().values().stream().anyMatch(x -> x.getCodigo() == rmv)) {
				
				Videojuego temp = vjDAO.getAll().values().stream().filter(x -> x.getCodigo() == rmv).findAny().get();
				
				System.out.println("Se va a proceder a borrar de la lista:\n");
				
				vjDAO.get(rmv).toString();
				
				System.out.println("¿Desea continuar con el borrado? (S/N):");
				
				if (pedirConfirmacion()) {
					
					vjDAO.remove(temp.getCodigo());
				}else {
					
					System.out.println("Operacion cancelada. Volviendo al menu...");
				}
				
			}else {
				
				System.out.println("Videojuego no encontrado. El codigo introducido no hace referencia a ninguno de los videojuegos almacenados. ¿Que desea hacer?\n");
				System.out.println("1. Introducir otro codigo");
				System.out.println("2. Listar los videojuegos almacenados");
				System.out.println("3. Volver al menu");
				
				switch (Validar.pedirInt_Parametros(1, 3)) {
				case 1:
					borrarVideojuego();break;
				
				case 2:
//					listarVideojuegos();
					vjDAO.getAll().values().stream().forEach(System.out::println);
					borrarVideojuego();break;
					
				case 3:
					//TODO: aqui vendria una llamada al menu
					break;
				}
			}
		}
		
		
	}
	
	private static boolean pedirConfirmacion() {
		String ok;
		boolean flag = false;
		do {
			
			ok = Validar.pedirString();
			
			if (ok.equalsIgnoreCase("s")) {
			
				flag = true;
			}else if(ok.equalsIgnoreCase("n")) {
				
				flag = false;
			}else {
				
				System.out.println("Error. Por favor, introduzca una opcion (S/N):");
				
			}
		} while (!ok.equalsIgnoreCase("s") && !ok.equalsIgnoreCase("n"));
		
		return flag;
	}
		
	

}

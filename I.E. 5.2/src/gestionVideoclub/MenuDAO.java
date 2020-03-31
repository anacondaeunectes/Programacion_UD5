package gestionVideoclub;

import control.Validar;

public class MenuDAO {
	
	

	public static void anadirVideojuego(Videojuego videojuego) {
		
		if (VideojuegoDAO.list.size() < 10) {
			
			VideojuegoDAO.list.add(videojuego);
			
			System.out.println("\nSe ha creado el nuevo videojuego.\n");
		}else {
			
			System.out.println("Se ha alcanzado el numero maximo de videojuegos a almacenar(10). Para anadir un nuevo videojuego, debera borrar uno de los almacenados.\nVolviendo al menu...");
		}
		
	}
	
	public static void borrarVideojuego() {
		
		if (VideojuegoDAO.list.isEmpty()) {
			System.out.println("Imposible borrar. No se han encontrado videojuegos.");
		}else {
		
			System.out.println("Por favor, introduzca el codigo del videojuego a borrar: ");
			int rmv = Validar.pedirInt();

			
			if (VideojuegoDAO.list.stream().anyMatch(x -> x.getCodigo() == rmv)) {
				
				Videojuego temp = VideojuegoDAO.list.stream().filter(x -> x.getCodigo() == rmv).findAny().get();
				
				System.out.println("Se va a proceder a borrar de la lista:\n");
				
				VideojuegoDAO.ficharVideojuego(rmv);
				
				System.out.println("¿Desea continuar con el borrado? (S/N):");
				
				if (pedirConfirmacion()) {
					
					VideojuegoDAO.remove(temp);
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
					VideojuegoDAO.listarVideojuegos();
					borrarVideojuego();break;
					
				case 3:
					//TODO: aqui vendria una llamada al menu
					break;
				}
			}
		}	
	}
	

	
}

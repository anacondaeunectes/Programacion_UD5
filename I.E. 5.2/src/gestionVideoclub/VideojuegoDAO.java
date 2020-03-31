package gestionVideoclub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import control.Validar;

public class VideojuegoDAO implements InterfaceVideojuegoDAO{
	
	private List<Videojuego> list;
	
	public VideojuegoDAO() {
		
		list = new ArrayList<>();
	}
	
	
	/**
	 * Este metodo crea y devuelve un videojuego cuyos atributos, a excepcion del codigo(se genera automaticamente), son introducidos por el usuario  
	 * @return el objeto Videojuego creado.
	 */
	public Videojuego create() {
		
		System.out.println("Por favor, proceda a introducir los datos del videojuego: ");
		
		System.out.println("Introduzca el titulo del videojuego:");
		String titulo = Validar.pedirString();
		
		System.out.println("\nIntroduzca la fecha de lanzamiento del videojuego(YYYY-MM-DD):");
		LocalDate fechaLanzamiento = Validar.pedirFecha(LocalDate.of(1948, 12, 14), LocalDate.now());
		
		System.out.println("\nIntroduzca la plataforma del videojuego:");
		Plataforma plataforma = Validar.pedirPlataforma();
		
		return new Videojuego(titulo, fechaLanzamiento, plataforma);
	}
	

	public void anadirVideojuego() {
		
		if (list.size() < 10) {
			
			list.add(create());
			
			System.out.println("\nSe ha creado el nuevo videojuego.\n");
		}else {
			
			System.out.println("Se ha alcanzado el numero maximo de videojuegos a almacenar(10). Para anadir un nuevo videojuego, debera borrar uno de los almacenados.\nVolviendo al menu...");
		}
		
	}
	
	public List<Videojuego> getAll() {
		
		return list;
//		list.stream().forEach(System.out::println);
		
	}
	
	public Videojuego get(int codigoVideojuego) {
		
		return list.stream().filter(x -> x.getCodigo() == codigoVideojuego).findAny().get();
//		System.out.println(list.stream().filter(x -> x.getCodigo() == codigoVideojuego).findAny().get().toString());
		
	}
	
	
	public void remove(Videojuego videojuego) {
		
		list.remove(videojuego);
	}
	
	public void borrarVideojuego() {
		
		if (list.isEmpty()) {
			System.out.println("Imposible borrar. No se han encontrado videojuegos.");
		}else {
		
			System.out.println("Por favor, introduzca el codigo del videojuego a borrar: ");
			int rmv = Validar.pedirInt();

			
			if (list.stream().anyMatch(x -> x.getCodigo() == rmv)) {
				
				Videojuego temp = list.stream().filter(x -> x.getCodigo() == rmv).findAny().get();
				
				System.out.println("Se va a proceder a borrar de la lista:\n");
				
				get(rmv).toString();
				
				System.out.println("¿Desea continuar con el borrado? (S/N):");
				
				if (pedirConfirmacion()) {
					
					list.remove(temp);
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
					getAll().stream().forEach(System.out::println);
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

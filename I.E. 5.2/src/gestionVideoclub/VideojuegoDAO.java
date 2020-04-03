package gestionVideoclub;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import control.Validar;

public class VideojuegoDAO implements InterfaceVideojuegoDAO{
	
	private Map<Integer, Videojuego> list;
	
	static int codigo = 1;
	
	public VideojuegoDAO() {
		
		list = new HashMap<>();
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
	
	public Map<Integer, Videojuego> getAll() {
		
		return list;
//		list.stream().forEach(System.out::println);
		
	}
	
	public Videojuego get(int codigoVideojuego) {
		
		return list.values().stream().filter(x -> x.getCodigo() == codigoVideojuego).findAny().get();
//		System.out.println(list.stream().filter(x -> x.getCodigo() == codigoVideojuego).findAny().get().toString());
		
	}
	
	
	public void remove(int code) {
		
		list.remove(code);
	}
	
	
 
	
}

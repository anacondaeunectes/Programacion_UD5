package gestionVideoclub;

import java.util.Map;

/**
 * 
 * @author anaco
 *
 */
public interface InterfaceVideojuegoDAO {
	
	public Videojuego create();
	
	public void remove(int a);

	public Map<Integer, Videojuego> getAll();
	
	public Videojuego get(int code);
	
}

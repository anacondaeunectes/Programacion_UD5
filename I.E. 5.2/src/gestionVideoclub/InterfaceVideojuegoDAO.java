package gestionVideoclub;

import java.util.List;

public interface InterfaceVideojuegoDAO {
	
	public Videojuego create();
	
	public void remove(Videojuego a);

	public List<Videojuego> getAll();
	
	public Videojuego get(int code);
	
}

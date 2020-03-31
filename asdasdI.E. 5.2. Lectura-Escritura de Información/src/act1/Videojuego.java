package act1;

import java.io.Serializable;
import java.time.LocalDate;

public class Videojuego implements Serializable{

	private int codigo;
	private String titulo;
	private LocalDate fechaLanzamiento;
	private /*Plataforma*/ String plataforma;
	
	
	public Videojuego(int codigo, String titulo, String plataforma) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.plataforma = plataforma;
	}
	
	
	
	
	
	
}

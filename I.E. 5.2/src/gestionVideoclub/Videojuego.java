package gestionVideoclub;

import java.io.Serializable;
import java.time.LocalDate;


public class Videojuego implements Serializable{
	
	static int cont = 1;
	
	private int codigo;
	private String titulo;
	private LocalDate fechaLanzamiento;
	private Plataforma plataforma;
	
	
	public Videojuego(String titulo, LocalDate fechaLanzamiento, Plataforma plataforma) {
		this.codigo = cont++;
		this.titulo = titulo;
		this.fechaLanzamiento = fechaLanzamiento;
		this.plataforma = plataforma;
	}


	public int getCodigo() {
		return codigo;
	}


	public String getTitulo() {
		return titulo;
	}



	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}



	public Plataforma getPlataforma() {
		return plataforma;
	}




	@Override
	public String toString() {
		return "Codigo del videojuego: " + codigo + "\nNombre del videojuego: " + titulo + "\nPlataforma: " + plataforma + "\nFecha de lanzamiento: " + fechaLanzamiento + "\n";
	}
	
	
}

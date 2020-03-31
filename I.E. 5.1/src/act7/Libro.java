package act7;

import java.time.Year;


/**
 * Esta clase representa a un libro segun los datos especificados en el ejercicio.
 * @author Pablo Gutierrez Martinez - DAM
 *
 */
public class Libro {

	private int codigo;
	private String ISBN;
	private String titulo;
	private String autor;
	private String editorial;
	private Year anoEdicion;
	
	public Libro(int codigo, String iSBN, String titulo, String autor, String editorial, Year anoEdicion) {
		
		this.codigo = codigo;
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.anoEdicion = anoEdicion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Year getAnoEdicion() {
		return anoEdicion;
	}

	public void setAnoEdicion(Year anoEdicion) {
		this.anoEdicion = anoEdicion;
	}
	
	

	
	
	
	
}

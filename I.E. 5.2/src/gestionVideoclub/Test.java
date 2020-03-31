package gestionVideoclub;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {

//		System.out.println(Validar.pedirFecha(LocalDate.of(1948, 12, 14), LocalDate.now()));
//		System.out.println(Validar.pedirPlataforma());
		
		Videojuego a1 = new Videojuego("a1", LocalDate.now(),Plataforma.DS);
		Videojuego a2 = new Videojuego("b2", LocalDate.now(),Plataforma.DS);
		Videojuego a3 = new Videojuego("c3", LocalDate.now(),Plataforma.DS);
		Videojuego a4 = new Videojuego("c3", LocalDate.now(),Plataforma.DS);
		Videojuego a5 = new Videojuego("c3", LocalDate.now(),Plataforma.DS);
		Videojuego a6 = new Videojuego("c3", LocalDate.now(),Plataforma.DS);
		Videojuego a7 = new Videojuego("c3", LocalDate.now(),Plataforma.DS);
		Videojuego a8 = new Videojuego("c3", LocalDate.now(),Plataforma.DS);
		Videojuego a9 = new Videojuego("c3", LocalDate.now(),Plataforma.DS);
		Videojuego a10 = new Videojuego("c3", LocalDate.now(),Plataforma.DS);
		
		VideojuegoDAO a = new VideojuegoDAO();
		
		a.getAll().add(a1);
		a.getAll().add(a2);
		a.getAll().add(a3);
		a.getAll().add(a4);
		a.getAll().add(a5);
		a.getAll().add(a6);
		a.getAll().add(a7);

		
		

		
//		VideojuegoDAO.listarVideojuegos();

		a.borrarVideojuego();
		
		
//		MenuDAO.anadirVideojuego(VideojuegoDAO.create());
				
				
//		VideojuegoDAO.listarVideojuegos();
		
		
		a.borrarVideojuego();
		
//		VideojuegoDAO.listarVideojuegos();
	}
	

}

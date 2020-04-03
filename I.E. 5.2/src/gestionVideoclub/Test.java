package gestionVideoclub;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		
		VideojuegoDAO cc = new VideojuegoDAO();
		
		
		
		
		

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
		
		
//		a.anadirVideojuego();
		
		System.out.println(a.getAll().toString());
		
//		a.get(0);
		
		
		a.getAll().put(a1.getCodigo(), a1);
		a.getAll().put(a2.getCodigo(), a2);
		a.getAll().put(a3.getCodigo(), a3);
		a.getAll().put(a4.getCodigo(), a4);
		a.getAll().put(a5.getCodigo(), a5);
		a.getAll().put(a6.getCodigo(), a6);
		
		

		
//		VideojuegoDAO.listarVideojuegos();

		a.borrarVideojuego();
				
		a.anadirVideojuego();		
		
//		VideojuegoDAO.listarVideojuegos();
		
		
		a.borrarVideojuego();
		
//		VideojuegoDAO.listarVideojuegos();
	}
	

}

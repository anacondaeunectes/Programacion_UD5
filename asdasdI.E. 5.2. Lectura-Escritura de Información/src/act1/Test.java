package act1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		Videojuego a1 = new Videojuego(1, "a", "DS");
		Videojuego a2 = new Videojuego(2, "b", "DS");
		Videojuego a3 = new Videojuego(3, "c", "DS");
		Videojuego a4 = new Videojuego(4, "d", "DS");
		
		ArrayList<Videojuego> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		
		
		FileOutputStream fos = null;
		
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("prueba.txt");
			oos = new ObjectOutputStream(fos);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
		
//		try{
//			
//			FileOutputStream fs = new FileOutputStream("videojue.txt");
//			ObjectOutputStream oos = new ObjectOutputStream(fs);
//			
//			for (int i=0;i<4;i++){
//				
//				Videojuego temp = list.get(i);
//				oos.writeObject(temp);
//			}
//			
//			if (oos != null){
//				oos.close();
//				fs.close();
//				
//			}
//		}catch(IOException e){
//			e.printStackTrace();
//		}

	}

}

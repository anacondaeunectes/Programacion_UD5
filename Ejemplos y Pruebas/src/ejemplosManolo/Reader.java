package ejemplosManolo;

import java.io.CharArrayReader;
import java.io.IOException;

public class Reader {

	public static void main(String[] args) {

		CharArrayReader reader = null;
			
			try {
				
				char[] charray = {'M', 'o', 'r', 'e', 'n', 'o'};
				
				reader = new CharArrayReader(charray);		
				
				int c = 0;
				
//				reader.read(); //Si lo descomento, leera un caracter y por tanto el resultado será ahora 5.
				
				System.out.println(reader.read(charray));
				
			} catch (IOException e) {

				e.printStackTrace();
			}finally {

				try {
					
					reader.close();
					
				} catch (Exception e2) {
					
					e2.printStackTrace();
				}
			}
			
			
		}
	
}

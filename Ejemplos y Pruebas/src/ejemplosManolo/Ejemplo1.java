package ejemplosManolo;
import java.io.*;
public class Ejemplo1{
	
	public static void main(String[] args) throws IOException{
		
		String s = new String("En un lugar de la mancha de cuyo nombre no quiero acordarme, ");
		s = s + "no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, ";
		s = s + "adarga antigua, rocín flaco y galgo corredor...";
		
//En vez de usar un char[], podría usar un String para ir almacenando la lectura del StringReader pero entiendo que, por como funciona un String y su reasignacion, es "mejor" usar un char[]
		char[] arr = new char[s.length()];
		//String p;
		
		
		int car = 0;
		
		StringReader flujoInput = new StringReader(s);
		
		//Este metodo lee cada caracter y devuelve el numero Ascii correspondiente
//		System.out.println(flujoInput.read(arr));	
//		System.out.println(flujoInput.read());
		
		CharArrayWriter flujoOutput = new CharArrayWriter();
		
		try{
				
			while ((car = flujoInput.read()) != -1){
				
			flujoOutput.write(car);
			}
			
			//p = flujoOutput.toString();
			arr = flujoOutput.toCharArray();
			//System.out.println(p);
			System.out.println(arr);
			
			}catch (IOException e) {
				
			e.printStackTrace();
			
			}finally{
				
			flujoInput.close();
			flujoOutput.close();
		}
	}
}
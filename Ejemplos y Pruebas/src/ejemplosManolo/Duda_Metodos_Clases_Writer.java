package ejemplosManolo;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

public class Duda_Metodos_Clases_Writer {

	public static void main(String[] args) throws IOException {

//		
//		
//		CharArrayWriter	buf = new CharArrayWriter();
//		
//		//Similitud entre metodos write() y append(). Ver "Glosario UD5" - Drive
//		buf.write(76);
//		buf.append('L');
//		
//		System.out.println(buf.toString());
//		System.out.println(buf.size());
//
//		buf.reset();
//		
//		//Tras el reseteo, se vacia el bufer y, por tanto, no imprime nada.
//		
//		System.out.println(buf.toString());
//		
////----------------------------------------------------------------------------------------------
//		
//		OutputStreamWriter a = new OutputStreamWriter(System.out);
//		//Agrego al buffer el caracter 'L'
//		a.write(76);
//		
//		//System.out.println(a.toString());
//		System.out.println(a.getEncoding());//Retorna el encode usado	
//		
//		
//		//El metodo flush() descarga todo lo que haya en el buffer.
//		a.flush();
//		
//		//El metodo close(), ademas de cerrar el buffer, descarga todo lo que quede en este. De este modo, al llamar a close(), no "descargara" la 'L'(ya que y alo ha "descargado" antes), pero si el salto de carro y la 'b'
//		a.write(13);//Agrega un \n al buffer
//		a.write(98);//Agrega el caracter 'b'
//		a.close(); 

//----------------------------------------------------------------------------------------------
		
		String s = "En un lugar de la mancha de cuyo nombre no quiero acordarme, ";
		
		StringWriter writer = new StringWriter();
		
		writer.write(s);
		
		System.out.println(writer.toString());
		
		StringBuffer bb = writer.getBuffer();
		
//		System.out.println(bb.toString());
	
	}

}

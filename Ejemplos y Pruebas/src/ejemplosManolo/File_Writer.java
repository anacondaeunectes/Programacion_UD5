package ejemplosManolo;

import java.io.FileWriter;

public class File_Writer {

	public static void main(String[] args) {

		FileWriter writer = null ;
		
		try {
			writer = new FileWriter("ggg.txt");
			
			writer.write("hola ggg quasdade tal");
//			writer.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			try {
				writer.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}

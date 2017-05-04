import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class createFile {
	  public static void main(String[] args) throws IOException {
	        String text = "Hello world";
	        BufferedWriter output = null;
	        try {
	            File file = new File("output/example.txt");
	            output = new BufferedWriter(new FileWriter(file));
	            output.write(text);
	        } catch ( IOException e ) {
	            e.printStackTrace();
	        } finally {
	          if ( output != null ) {
	            output.close();
	          }
	        }
	    }
}
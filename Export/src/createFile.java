import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;


public class createFile {
	 @Test
	  public static void main(String[] args) throws IOException {
	        String text = "Hello world";
	        BufferedWriter output = null;
	        try {
	            File file = new File("output/customer.txt");
	            output = new BufferedWriter(new FileWriter(file));
	            output.write("ID,Last name,First Name,Email");
	            output.write("\r\n");
	            for (int i=0;i<200;i++)
	            {
		        output.write(i+ ","); 
		        output.write("Last name" + i + ",");
		        output.write("First name" + i + ",");
		        output.write("Email" + i + ","); 
	            output.write("\r\n");
	            }
	        } catch ( IOException e ) {
	            e.printStackTrace();
	        } finally {
	          if ( output != null ) {
	            output.close();
	          }
	        }
	    }
}
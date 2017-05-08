import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

public class GenerateFileWithData {
	public static void main(String args[]) throws IOException {
		String numberLineFile;
		String fileName;
		String fileSeparator;
		int numberLine;

		numberLineFile = JOptionPane.showInputDialog("Saisir le nombre de ligne du fichier :");
		fileName = JOptionPane.showInputDialog("Saisir le nom du fichier :");
		fileSeparator = JOptionPane.showInputDialog("Entrer le separateur que vous voulez :");
		numberLine = Integer.parseInt(numberLineFile);

        BufferedWriter output = null;
        try {
            File file = new File("output/" + fileName + ".txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write("ID,Last name,First Name,Email,Gender");
            output.write("\r\n");
            for (int i=0;i<numberLine;i++)
            {
	        output.write(i+ ","); 
	        output.write("Last name" + i + ",");
	        output.write("First name" + generateRandomString(8) + ",");
	        output.write("Email" + i + "@yahoo.fr,"); 
	        //O unknown, 1 Male and 2 female
	        output.write(generateRandomNumber(2)); 
            output.write("\r\n");
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
          if ( output != null ) {
            output.close();
          }
        }
        
        try {
            File file = new File("output/purchase.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write("ID,Purchase label,Price,Amount");
            output.write("\r\n");
            for (int i=0;i<200;i++)
            {
	        output.write(i+ ","); 
	        output.write("Label" + i + ",");
	        output.write(i*5 + ",");
	        output.write("1"+ ","); 
            output.write("\r\n");
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
          if ( output != null ) {
            output.close();
          }
        }

		System.exit(0);
	}

	/**
	 * Generation of random number
	 * @param in_valeurMax
	 * @return
	 */
	private static int generateRandomNumber(int in_valeurMax) {
		Random r = new Random();
		return r.nextInt(in_valeurMax);
	}
	
	/**
	 * Generate a random string
	 * @param characters
	 * @param length
	 * @return
	 */
	private static String generateRandomString(int length)
	{
		String characters= "abcdefghijklmnopqrstuvwxyz";
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
			Random rng = new Random();
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
     
}

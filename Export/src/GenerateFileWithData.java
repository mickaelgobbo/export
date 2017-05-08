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
		final String fileSeparator;
		int numberLine;

		numberLineFile = JOptionPane.showInputDialog("Saisir le nombre de ligne du fichier :");
		fileName = JOptionPane.showInputDialog("Saisir le nom du fichier :");
		fileSeparator = JOptionPane.showInputDialog("Entrer le separateur que vous voulez :");
		numberLine = Integer.parseInt(numberLineFile);

		BufferedWriter output = null;
		try {
			File file = new File("output/" + fileName + ".txt");
			output = new BufferedWriter(new FileWriter(file));
			if (fileSeparator.isEmpty()) {
				output.write("ID,Last name,First Name,Email,Gender");
			} else {
				output.write(replaceStringWithSeparator("ID,Last name,First Name,Email,Gender", fileSeparator));
			}
			output.write("\r\n");
			for (int i = 0; i < numberLine; i++) {
				//output.write(i + ",");
				output.write(i);
				output.write(",");
				//addSeparator(output,fileSeparator);
				output.write("Last name" + i + ",");
				output.write("First name" + generateRandomString(8) + ",");
				output.write("Email" + i + "@yahoo.fr,");
				// O unknown, 1 Male and 2 female
				output.write(generateRandomNumber(2));
				output.write("\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				output.close();
			}
		}

		try {
			File file = new File("output/purchase.txt");
			output = new BufferedWriter(new FileWriter(file));
			output.write("ID,Purchase label,Price,Amount");
			output.write("\r\n");
			for (int i = 0; i < 200; i++) {
				output.write(i + ",");
				output.write("Label" + i + ",");
				output.write(i * 5 + ",");
				output.write("1" + ",");
				output.write("\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				output.close();
			}
		}

		System.exit(0);
	}

	/**
	 * Generation of random number
	 * 
	 * @param in_valeurMax
	 * @return
	 */
	private static int generateRandomNumber(int in_valeurMax) {
		Random r = new Random();
		return r.nextInt(in_valeurMax);
	}

	/**
	 * Generate a random string
	 * 
	 * @param characters
	 * @param length
	 * @return
	 */
	private static String generateRandomString(int length) {
		String characters = "abcdefghijklmnopqrstuvwxyz";
		char[] text = new char[length];
		for (int y = 0; y < length; y++) {
			Random rng = new Random();
			text[y] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}

	/**
	 * Thie function replace in the string a value with the right separator
	 * 
	 * @param in_value
	 * @param in_separator
	 * @return
	 */
	private static String replaceStringWithSeparator(String in_value, String in_separator) {
		return in_value.replace(",", in_separator);
	}
	
	/**
	 * Add the right separator in the file
	 * @param File
	 * @param in_fileSeparator
	 * @throws IOException
	 */
	private static void addSeparator(BufferedWriter File,String in_fileSeparator) throws IOException {
		if (in_fileSeparator.isEmpty()) {
			File.write(",");
		} else {
			File.write(in_fileSeparator);
		}
	}	
	
}

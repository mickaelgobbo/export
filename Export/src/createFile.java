
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class createFile {
	  public static void main(String[] args) throws IOException {
		    Path path = Paths.get("users.txt");
		    byte[] contents = Files.readAllBytes(path);

		    Path newPath = Paths.get("newUsers.txt");
		    byte[] newContents = "aaa".getBytes();
		    Files.write(newPath, contents, StandardOpenOption.CREATE);
		    Files.write(newPath, newContents, StandardOpenOption.APPEND);
		  }
}

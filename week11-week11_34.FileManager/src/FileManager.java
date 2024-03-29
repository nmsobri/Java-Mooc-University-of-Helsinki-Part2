
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

	public List<String> read(String file) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(file));
		List<String> lines = new ArrayList<String>();

		while (scanner.hasNextLine()) {
			lines.add(scanner.nextLine());
		}

		return lines;
	}

	public void save(String file, String text) throws IOException {
		FileWriter fw = new FileWriter(file);
		fw.write(text + "\n");
		fw.close();
	}

	public void save(String file, List<String> texts) throws IOException {
		FileWriter fw = new FileWriter(file);

		for (String text : texts) {
			fw.write(text + "\n");
		}

		fw.close();
	}
}

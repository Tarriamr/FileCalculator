import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;

public class ReaderFileImpl implements ReaderFile {

    public FileReader readerFile(String filepath) {
        try {
            Path path = Path.of(filepath.trim());
            return new FileReader(path.toString());
        } catch (FileNotFoundException exception) {
            System.out.println("You don't write the correct file path.");
            return null;
        }
    }
}

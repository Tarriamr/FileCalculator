import java.io.FileNotFoundException;
import java.io.FileReader;

public interface ReaderFile {

    FileReader readerFile(String filePath) throws FileNotFoundException;
}

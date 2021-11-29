import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReaderFileImplTest {

    private final ReaderFile readerFile = new ReaderFileImpl();

    @Test
    public void checkIfFileExistReturnNotNull() throws FileNotFoundException {

        //given
        final String correctFilePath = "src/test/resources/example.txt";

        //when
        FileReader fileReader = readerFile.readerFile(correctFilePath);

        //then
        assertNotNull(fileReader);
    }

    @Test
    public void checkIfFileNotExistGivenNull() throws FileNotFoundException {

        //given
        final String incorrectFilePath = "src/test/resources/incorrect.txt";

        //when
        FileReader fileReader = readerFile.readerFile(incorrectFilePath);

        //then
        assertNull(fileReader);
    }

    @Test
    public void checkIfPathIsEmptyGivenNull() throws FileNotFoundException {

        //given
        final String emptyFilePath = "";

        //when
        FileReader fileReader = readerFile.readerFile(emptyFilePath);

        //then
        assertNull(fileReader);
    }

    @Test
    public void checkIfPathIsWhiteSpaceGivenNull() throws FileNotFoundException {

        //given
        final String whiteSpaceFilePath = "     ";

        //when
        FileReader fileReader = readerFile.readerFile(whiteSpaceFilePath);

        //then
        assertNull(fileReader);
    }
}

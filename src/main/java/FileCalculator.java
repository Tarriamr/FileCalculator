import java.util.Scanner;

public class FileCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ImportFileService importFileService = new ImportFileServiceImpl();

        System.out.println("""
                Hello.
                This program calculates the solution of the functions you give in the file.
                Write the path for your file:
                """);

        String file = scanner.nextLine();


        Row result = importFileService.taskCalculations(1, new Row(), file);

        System.out.printf("""

                %d functions have been calculated.
                The result of these calculations is: %s
                """, result.getRowNumber() - 1, result.getValue());
    }
}

package Commands;

import java.io.FileReader;
import java.util.Scanner;

public class Close {
    public void close(){
        Scanner scanner = new Scanner(System.in);
        try {
            FileReader fileReader = new FileReader(String.valueOf(scanner));
            int i;
            while ((i = fileReader.read()) != -1)
                System.out.print((char)i);
            fileReader.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

    }
}

package Commands;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Open {
    public String open() {
        String data = null;
        try {
            Scanner scanner = new Scanner(System.in);
            File myFile = new File(String.valueOf(scanner));
            Desktop desktop = Desktop.getDesktop();
            if (myFile.exists()) {
                desktop.open(myFile);
            }
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                data = reader.nextLine();
            }
        } catch (Exception e) {
            System.out.println("An error has occurred while opening the file");
            e.printStackTrace();
        }
        return data;
    }
}


package Commands;

import org.w3c.dom.Document;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Open extends Command {
    String fileName = null;
    StringBuilder data = null;

    public Open(Context context) {
        super(context);
    }

    public String execute() {
        //TODO-проверка дали зададеният индекс се вмества с масива или е по голям от размера на масива(грешка)
        fileName = context.getCommandOptions()[1];
        System.out.println(fileName);
        try {
            FileInputStream myFile = new FileInputStream(fileName);
            context.setDoc(context.getDocumentBuilder().parse(myFile));
            context.setFileName(fileName);
            myFile.close();
            return "The file was opened successfully";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public String getFileName() {
        return fileName;
    }
}


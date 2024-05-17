package Application;

import Commands.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.TransformerException;
import java.io.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Application {
    public static final int MAX_COMMAND_OPTIONS_NUMBER = 10;
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        Context context = new Context();

        Map<String, Command> menu = new HashMap();
        menu.put("open", new Open(context));
        menu.put("close", new Close(context));
        menu.put("save", new Save(context));
        menu.put("saveas", new SaveAs(context));
        menu.put("help", new Help(context));
        menu.put("exit", new Exit(context));
        //TODO-Iterator foreach


        String command;
        Scanner input = new Scanner(System.in);
        do {

            System.out.print(">");
            command = input.nextLine();
            String[] commandOptions = command.strip().split("\\s+", MAX_COMMAND_OPTIONS_NUMBER);
            context.setCommandOptions(commandOptions);
            if (commandOptions.length>0 && commandOptions[0] != null && commandOptions[0].length() != 0){
                Command cmd = menu.get(commandOptions[0]);
                if (cmd != null){
                System.out.println(menu.get(commandOptions[0]).execute());
                }
                else{
                    System.out.println("Invalid command");
                }
            }
        }
        while (!context.done);
    }
}

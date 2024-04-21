package Application;

import Commands.*;
import Menu.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Open open = new Open();
        Close close = new Close();
        Save save = new Save();
        SaveAs saveAs = new SaveAs();
        Help help = new Help();
        Exit exit = new Exit();

        Map<String,Runnable> menu = new HashMap();
        menu.put("open",open::open);
        menu.put("close",close::close);
        menu.put("save",save::save);
        menu.put("saveas",saveAs::saveas);
        menu.put("help",help::help);
        menu.put("exit",exit::exit);

        String option;
    do {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an option:");
        option = input.nextLine();

        menu.get(option);
    }
    while (option == "exit");
    }
}

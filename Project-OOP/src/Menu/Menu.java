package Menu;

import Commands.*;

import java.util.HashMap;
import java.util.Map;


public class Menu {
    Open open = new Open();
    Close close = new Close();
    Save save = new Save();
    SaveAs saveAs = new SaveAs();
    Help help = new Help();
    Exit exit = new Exit();
    public void menu() {
        Map<String,Runnable> menu = new HashMap();
        menu.put("open",open::open);
        menu.put("close",close::close);
        menu.put("save",save::save);
        menu.put("saveas",saveAs::saveas);
        menu.put("help",help::help);
        menu.put("exit",exit::exit);
    }
}

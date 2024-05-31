package Commands;

import Application.Command;
import Application.Context;

public class Close extends Command {
    String fileName = null;

    public Close(Context context) {
        super(context);
        helpString = "closes currently opened file";
        cmdString = "";
    }

    public String execute(){
        context.setDoc(null);
        String res = "Successfully closed "+context.getFileName();
        context.setFileName(null);
       return res;
    }
}

package unnamed;

import fileStuff.TextFile;

import java.util.Scanner;


//TODO: remove sc.next----
public class CommandHandler{
    private String command;
    private Scanner sc;
    private Log log;

    public CommandHandler(Scanner sc, Log log){
        this.sc = sc;
        this.log = log;
        command = "write";
    }

    public boolean handleCommand(String command){
        command = command.toLowerCase();
        this.command = command;
        switch (command) {
            case "write":
                write();
                break;
            case "edit":
                edit();
                break;
            case "delete":
                delete();
                break;
            case "quit":
                return true;
            case "save":
                save();
                break;

            default:
                System.out.println("~~invalid command~~");
                break;
        }
        return false;
    }

    //TODO: might have to implement try/catch
    private void save(){
        String fileLoc = sc.nextLine();
        TextFile tf = new TextFile(fileLoc);
        tf.write(log.getData());
    }

    private void delete(){
        int lineIndex;
        String ans = "";
        System.out.println("~~Enter Line Number To Delete~~");
        lineIndex = sc.nextInt();
        log.printLine(lineIndex);
        System.out.println("~~Would You Like To Delete This Line?~~");
        ans = sc.nextLine().toLowerCase();
        if(ans == "yes" || ans == "y" || ans == "ok")
            log.removeLine(lineIndex);
    }

    private void edit() {
        int lineIndex;
        System.out.println("~~Enter Line Number To Edit~~");
        lineIndex = sc.nextInt();
        log.printLine(lineIndex);
        log.changeLine(lineIndex, sc.nextLine());
    }

    private void write(){
    }

    public String getCommand() {
        return command; 
    }
}

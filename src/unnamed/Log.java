package unnamed;

import java.util.ArrayList;

public class Log{
    String title;
    ArrayList<String> log;

    public Log(String title){
        this.title = title;
        log = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS : Adds string to ArrayList, if null adds empty string
    public void addLine(String line){
        if(line == null)
            log.add("");
        else
            log.add(line);
    }

    //TODO: add try catch / if statements to keep lineIndex within bounds of log
    //REQUIRES: index within bounds of arrayList
    //MODIFIES: this
    //EFFECTS : replaces string at index with new string, if string is null replaces with empty string
    public void changeLine(int lineIndex, String newLine){
        if(newLine == null)
            log.add(lineIndex, "");
        else
            log.add(lineIndex, newLine);
    }

    //REQUIRES: index within bounds of arrayList
    //MODIFIES: this
    //EFFECTS : removes element from arrayList at index
    public void removeLine(int lineIndex){
        log.remove(lineIndex);
    }

    //REQUIRES: index within bounds
    //EFFECTS : returns element of arrayList at index
    public String getLine(int lineIndex){
        return log.get(lineIndex);
    }

    //EFFECTS : returns arrayList size
    public int getNumberOfLines(){
        return log.size();
    }

    //EFFECTS : returns title variable
    public String getTitle(){
        return title;
    }

    //TODO: add try catch / if statements to keep lineIndex within bounds of log
    //REQUIRES: index within bounds of arrayList
    //EFFECTS : prints string element from array list at index as well as the index
    public void printLine(int lineIndex){
        System.out.print(lineIndex + ": " + log.get(lineIndex));
    }

    //EFFECTS : calls printLine method for each element in arrayList
    public void printLog(){
        for(int i = 0; i < log.size(); i++){
            printLine(i);
            System.out.println();
        }
    }
}

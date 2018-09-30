package unnamed;

import java.util.ArrayList;

public class Log{
    private String title;
    private ArrayList<String> lineList;

    public Log(String title){
        this.title = title;
        lineList = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS : Adds string to ArrayList, if null adds empty string
    public void addLine(String line){
        if(line == null)
            lineList.add("");
        else
            lineList.add(line);
    }

    //TODO: add try catch / if statements to keep lineIndex within bounds of log
    //REQUIRES: index within bounds of arrayList
    //MODIFIES: this
    //EFFECTS : replaces string at index with new string, if string is null replaces with empty string
    public void changeLine(int lineIndex, String newLine){
        if(newLine == null)
            lineList.add(lineIndex, "");
        else
            lineList.add(lineIndex, newLine);
    }

    //REQUIRES: index within bounds of arrayList
    //MODIFIES: this
    //EFFECTS : removes element from arrayList at index
    public void removeLine(int lineIndex){
        lineList.remove(lineIndex);
    }

    //REQUIRES: index within bounds
    //EFFECTS : returns element of arrayList at index
    public String getLine(int lineIndex){
        return lineList.get(lineIndex);
    }

    //EFFECTS : returns arrayList size
    public int getNumberOfLines(){
        return lineList.size();
    }

    //EFFECTS : returns title variable
    public String getTitle(){
        return title;
    }

    //TODO: add try catch / if statements to keep lineIndex within bounds of log
    //REQUIRES: index within bounds of arrayList
    //EFFECTS : prints string element from array list at index as well as the index
    public void printLine(int lineIndex){
        System.out.print(lineIndex + ": " + lineList.get(lineIndex));
    }

    //EFFECTS : calls printLine method for each element in arrayList
    public void printLog(){
        for(int i = 0; i < lineList.size(); i++){
            printLine(i);
            System.out.println();
        }
    }

    public ArrayList<String> getData(){
        return lineList;
    }
}

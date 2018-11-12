package unnamed;

import java.util.ArrayList;
import java.util.List;

public class Log{
    private String title;
    private ArrayList<String> lineList;
    private ProgramLoop programLoop;
    //private Boolean withNewLine;

    public Log(String title, ProgramLoop programLoop){
        this.programLoop = programLoop;
        this.title = title;
        lineList = new ArrayList<>(0);
        //withNewLine = true;
    }

    /*
    public Log(String title, Boolean withNewLine){
        this.title = title;
        lineList = new ArrayList<>(0);
        this.withNewLine = withNewLine;
    }*/

    //MODIFIES: this
    //EFFECTS : Adds input to log. adds a new line character to the end if
    public void addLine(String line){
        /*if(withNewLine) {
            if (line == null)
                lineList.add("\\n");
            else
                lineList.add(line + "\\n");
        }else{*/
            if (line == null)
                lineList.add("");
            else
                lineList.add(line + "");
        //}
    }

    //TODO: add try catch / if statements to keep lineIndex within bounds of log
    //REQUIRES: index within bounds of arrayList
    //MODIFIES: this
    //EFFECTS : replaces string at index with new string, if string is null replaces with empty string
    public void changeLine(int lineIndex, String newLine){
        /*if(withNewLine) {
            if (newLine == null)
                lineList.set(lineIndex, "\\n");
            else
                lineList.set(lineIndex, newLine + "\\n");
        }else{*/
            if (newLine == null)
                lineList.set(lineIndex, "");
            else
                lineList.set(lineIndex, newLine);
        //}
    }
/*
    public void newLineOff(){
        withNewLine = false;
    }

    public void newLineOn(){
        withNewLine = true;
    }*/

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

    /*
    public Boolean getWithNewLine(){
        return withNewLine;
    }*/

    public void LoadData(List<String> data){
        lineList = (ArrayList)data;
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
        if(lineList.isEmpty())
            return;
        System.out.print(lineIndex + ": " + lineList.get(lineIndex));
    }

    //EFFECTS : calls printLine method for each element in arrayList
    public void printLog(){
        if(lineList.isEmpty())
            return;
        for(int i = 0; i < lineList.size(); i++){
            printLine(i);
            System.out.println();
        }
    }

    public boolean isEmpty(){
        return lineList.isEmpty();
    }

    //////////////////////////////////////////////////////////
    public List<String> getData(){
        return lineList;
    }
    //////////////////////////////////////////////////////////
}

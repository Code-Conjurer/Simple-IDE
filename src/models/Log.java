package models;

import ui.ConsoleDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Log extends Observable{
    private String title;
    private ArrayList<String> data;
    private ConsoleDisplay console;
    //private Boolean withNewLine;

    public Log(ConsoleDisplay console, String title){
        this.title = title;
        this.console = console;
        data = new ArrayList<>(0);
        //withNewLine = true;
    }

    /*
    public Log(String title, Boolean withNewLine){
        this.title = title;
        data = new ArrayList<>(0);
        this.withNewLine = withNewLine;
    }*/

    //MODIFIES: this
    //EFFECTS : Adds input to log. adds a new line character to the end if
    public void addLine(String line){
            if (line == null)
                data.add("");
            else
                data.add(line + "");
        setNotify();
        console.println();
        //}
    }
    public void addLineWithoutNotify(String line){
            if (line == null)
                data.add("");
            else
                data.add(line + "");
        console.println();
        //}
    }

    //TODO: add try catch / if statements to keep lineIndex within bounds of log
    //REQUIRES: index within bounds of arrayList
    //MODIFIES: this
    //EFFECTS : replaces string at index with new string, if string is null replaces with empty string
    public void changeLine(int lineIndex, String newLine){
        /*if(withNewLine) {
            if (newLine == null)
                data.set(lineIndex, "\\n");
            else
                data.set(lineIndex, newLine + "\\n");
        }else{*/
            if (newLine == null)
                data.set(lineIndex, "");
            else
                data.set(lineIndex, newLine);
            setNotify();///////////////////////////////////////////////////////////////////////////////////////////////
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
        data.remove(lineIndex);
        setNotify();///////////////////////////////////////////////////////////////////////////////////////////////
    }

    //REQUIRES: index within bounds
    //EFFECTS : returns element of arrayList at index
    public String getLine(int lineIndex){
        return data.get(lineIndex);
    }

    /*
    public Boolean getWithNewLine(){
        return withNewLine;
    }*/

    //EFFECTS : returns arrayList size
    public int getNumberOfLines(){
        return data.size();
    }

    //EFFECTS : returns title variable
    public String getTitle(){
        return title;
    }

    //TODO: add try catch / if statements to keep lineIndex within bounds of log
    //REQUIRES: index within bounds of arrayList
    //EFFECTS : prints string element from array list at index as well as the index
    public void printLine(int lineIndex){
        if(data.isEmpty())
            return;
        console.print(lineIndex + ": " + data.get(lineIndex));
        // System.out.print(lineIndex + ": " + data.get(lineIndex));
    }

    //TODO: implement printing class to increase cohesion
    public void print(List<String> list){

    }

    //EFFECTS : calls printLine method for each element in arrayList
    public void printLog(){
        if(data.isEmpty())
            return;
        for(int i = 0; i < data.size(); i++){
            printLine(i);
            console.println();
            //System.out.println();
        }
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    //////////////////////////////////////////////////////////
    public List<String> getData(){
        return data;
    }

    private void setNotify(){
        setChanged();
        notifyObservers(data);
    }

    public void loadData(ArrayList<String> newData){
        data = newData;
        setNotify();
    }

    public void loadData(List<String> data){
        this.data = (ArrayList)data;
        setNotify();
    }
    public void loadDataWithoutNotify(List<String> data){
        this.data = (ArrayList)data;
    }

    //////////////////////////////////////////////////////////
}

package commands;

import unnamed.Log;

public class Delete extends LogCommand{


    public Delete(Log log) {
        super.log = log;
        super.name = "delete";
    }

    @Override
    public void run(int lineNumber, String input){

    }

}

/*
if(super.isWaiting){
            super.resumeAfterInput();
        }else{
            System.out.println("~~Enter line number to delete~~");
            super.waitForInput();
            return;
        }
 */
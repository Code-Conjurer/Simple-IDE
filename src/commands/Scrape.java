package commands;

import models.SingleArgCommand;
import models.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Scrape extends SingleArgCommand {

    public Scrape(){
        super("scrape");
    }

    public void execute(Log log, String url){
        //"https://www.ugrad.cs.ubc.ca/~cs210/2018w1/welcomemsg.html"
        if(!log.isEmpty()){
            System.out.println("Log must be empty");
        }
        try {
            runHelper(log, new URL(url));
        }catch (IOException e){
            System.out.println(e);
        }
    }

    private void runHelper(Log log, URL url) throws MalformedURLException, IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                log.addLine(line);
            }

        } finally {

            if (br != null) {
                br.close();
            }
        }
    }

}

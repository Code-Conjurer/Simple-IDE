package ui;

import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;

public class ConsolePrinter extends OutputStream {

    private TextArea output;

    public ConsolePrinter(TextArea ta){
        this.output = ta;
    }

    @Override
    public void write(int i) throws IOException{
        output.appendText(String.valueOf((char) i));
    }
}

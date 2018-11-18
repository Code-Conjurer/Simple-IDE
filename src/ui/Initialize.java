package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import unnamed.ProgramLoop;


public class Initialize extends Application {

    private ProgramLoop programLoop;
    private StackPane root;
    private BorderPane borderPane;
    private VBox vBox;
    private CommandBar commandBar;
    private EditorRegion textArea;

    private TextArea consoleDisplay;

    public Initialize(){
        programLoop = new ProgramLoop();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Simple Text Editor");
        /*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });*/

        root = new StackPane();
        //GridPane gp = new GridPane();
        borderPane = new BorderPane();
        vBox = new VBox();
        commandBar = new CommandBar();
        textArea = new EditorRegion();
        consoleDisplay = new TextArea();

        consoleDisplay.setEditable(false);

        borderPane.setPadding(new Insets(10));
        vBox.setPrefHeight(10);

        vBox.getChildren().add(0, textArea);
        vBox.getChildren().add(1, commandBar);

        borderPane.setCenter(vBox);
        borderPane.setBottom(consoleDisplay);

        //borderPane.setBottom();
        root.getChildren().add(borderPane);

        //root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}

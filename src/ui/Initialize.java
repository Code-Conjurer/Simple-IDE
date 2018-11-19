package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.LogEngine;


public class Initialize extends Application {

    private StackPane root;
    private BorderPane borderPane;
    private VBox vBox;
    private CommandBar commandBar;
    private EditRegion textArea;
    private LogEngine logEngine;

    private ConsoleDisplay consoleDisplay;

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
        consoleDisplay = new ConsoleDisplay();
        logEngine = new LogEngine(consoleDisplay);

        textArea = new EditRegion(logEngine);
        commandBar = new CommandBar(logEngine);

        setupScreen();
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    private void setupScreen(){
        root = new StackPane();
        borderPane = new BorderPane();
        vBox = new VBox();

        borderPane.setPadding(new Insets(10));
        vBox.setPrefHeight(10);

        vBox.getChildren().add(0, textArea);
        vBox.getChildren().add(1, commandBar);

        borderPane.setCenter(vBox);
        borderPane.setBottom(consoleDisplay);

        //borderPane.setBottom();
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(borderPane);
        root.getChildren().add(anchorPane);
    }

    public static void main(String[] args){
        launch(args);
    }
}

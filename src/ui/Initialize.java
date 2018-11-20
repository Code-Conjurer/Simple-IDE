package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.LogEngine;

public class Initialize extends Application {

    private StackPane root;
    private BorderPane borderPane;
    private VBox vBox;
    private CommandBar commandBar;
    private EditRegion textArea;
    private LogEngine logEngine;

    private final int SCREEN_WIDTH = 700;
    private final int SCREEN_HEIGHT = 500;
    private final String STYLE =
                    "-fx-control-inner-background:#000000; " +
                    "-fx-font-family: Consolas; " +
                    "-fx-highlight-fill: #00ff00; " +
                    "-fx-highlight-text-fill: #000000; " +
                    "-fx-text-fill: #00ff00; " +
                    "-fx-border-color: #00ff00;" ;

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

        consoleDisplay.setStyle(STYLE);
        textArea.setStyle(STYLE);
        commandBar.setStyle(STYLE);

        setupScreen();
        primaryStage.setScene(new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT));
        primaryStage.setMaxWidth(SCREEN_WIDTH);
        primaryStage.setMaxHeight(SCREEN_HEIGHT);

        primaryStage.setMinWidth(SCREEN_WIDTH);
        primaryStage.setMinHeight(SCREEN_HEIGHT);
        primaryStage.show();
    }

    private void setupScreen(){
        root = new StackPane();
        borderPane = new BorderPane();
        vBox = new VBox();

        textArea.setWrapText(true);
        textArea.setMinWidth(SCREEN_WIDTH);
        commandBar.setMinWidth(SCREEN_WIDTH);
        consoleDisplay.setMinWidth(SCREEN_WIDTH);

        textArea.setMinHeight(SCREEN_HEIGHT - 250);
        //commandBar.setMinHeight(SCREEN_WIDTH);
        consoleDisplay.setMinHeight(SCREEN_HEIGHT - 350);
        //borderPane.setPadding(new Insets(10));
        //vBox.setPrefHeight(10);

        vBox.getChildren().add(0, textArea);
        vBox.getChildren().add(1, commandBar);

        borderPane.setCenter(vBox);
        borderPane.setBottom(consoleDisplay);
        borderPane.setStyle("-fx-background-color: grey;");
        //borderPane.set

        Insets insets = new Insets(10);
        //Insets borderPaneGap = new Insets();
        //borderPane.setMargin(consoleDisplay, borderPaneGap);

        //borderPane.setBottom();
        //AnchorPane anchorPane = new AnchorPane();
        //anchorPane.getChildren().add(borderPane);
        //root.getChildren().add(anchorPane);
        root.getChildren().add(borderPane);
    }

    public static void main(String[] args){
        launch(args);
    }
}

package fr.sae.aquilius;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = FXMLLoader.load(Main.class.getResource("vue1.fxml"));
            Scene scene = new Scene(root,960,640);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            root.requestFocus();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
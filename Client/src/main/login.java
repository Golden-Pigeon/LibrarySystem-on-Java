package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class login extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../lib/FXML/loginUI.fxml"));
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.getIcons().add(new Image("src/icon.png"));
        primaryStage.setTitle("XDU图书管理系统 ver1.0.0");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}

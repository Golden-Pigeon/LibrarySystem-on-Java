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
        Parent root = FXMLLoader.load(getClass().getResource("loginUI.fxml"));
        primaryStage.setTitle("XDUͼ�����ϵͳ ver1.0.0");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("src/icon.png"));

        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}

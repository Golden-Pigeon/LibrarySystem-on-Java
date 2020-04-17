package lib;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class mainUI
{
    public mainUI(Socket client, String UID) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/mainUI.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("XDU图书管理系统 ver1.0.0");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("src/icon.png"));
        primaryStage.showAndWait();
    }

}

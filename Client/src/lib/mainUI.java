package lib;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.Socket;

public class mainUI
{
    public mainUI(Socket client, String UID) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/mainUI.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("XDU图书管理系统 ver1.0.0");
        Scene scene = new Scene(root, 1280, 720);//stage scene
        scene.setFill(null);//透明化
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.getIcons().add(new Image("src/icon.png"));//图标
        primaryStage.getScene().getStylesheets().add("lib/css/main.css");
        primaryStage.showAndWait();
    }

}

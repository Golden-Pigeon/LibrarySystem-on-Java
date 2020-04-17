package interfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainUI extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("mainUI.fxml"));
        primaryStage.setTitle("XDUͼ�����ϵͳ ver1.0.0");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.setResizable(false);

        primaryStage.show();
    }
}

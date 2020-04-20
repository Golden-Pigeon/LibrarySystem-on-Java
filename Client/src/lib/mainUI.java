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
        Parent root = FXMLLoader.load(getClass().getResource("FXML/mainUI.fxml"));//����FXML
        Stage primaryStage = new Stage();
        primaryStage.setTitle("XDUͼ�����ϵͳ ver1.0.0");
        Scene scene = new Scene(root, 1280, 720);//stage scene
        scene.setFill(null);//͸����
        primaryStage.setScene(scene);
        primaryStage.getScene().getStylesheets().add("lib/css/main.css");//����CSS
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);//�ޱ߿�
        primaryStage.initModality(Modality.APPLICATION_MODAL);//����Ϊ�����ʹ���
        primaryStage.getIcons().add(new Image("src/icon.png"));//ͼ��
        primaryStage.showAndWait();
    }

}

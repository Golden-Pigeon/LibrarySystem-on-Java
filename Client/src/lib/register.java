package lib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class register extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/registerUI.fxml"));//导入FXML
        primaryStage.setTitle("注册界面");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.getScene().getStylesheets().add("lib/css/register.css");//导入CSS
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);//无边框化
        primaryStage.initStyle(StageStyle.TRANSPARENT);//弹窗型窗口
        primaryStage.getIcons().add(new Image("src/icon.jpeg"));
        primaryStage.showAndWait();
    }
}

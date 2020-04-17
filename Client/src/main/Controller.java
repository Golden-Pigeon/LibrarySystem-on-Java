package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller
{
    @FXML
    public Button loginBtn = new Button();

    @FXML
    public Button registerBtn = new Button();

    @FXML
    public TextField username = new TextField();
    @FXML
    public PasswordField password = new PasswordField();

    public void loginButtonAction(ActionEvent e) throws Exception
    {
        lib.login lgn = new lib.login();
        if(lgn.getInfo(username.getText(),password.getText()))
            lgn.start(new Stage());
        else return;
    }

    public void registerButtonAction(ActionEvent e) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("loginUI.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("×¢²á½çÃæ");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.getIcons().add(new Image("src/icon.png"));
        primaryStage.showAndWait();
    }

}

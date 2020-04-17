package main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller
{
    @FXML
    public Button loginBtn;

    @FXML
    public Button registerBtn;

    @FXML
    public TextField username = new TextField();
    @FXML
    public PasswordField password = new PasswordField();

    public void registerButtonAction(ActionEvent e) throws Exception
    {

    }

    public void loginButtonAction(ActionEvent e) throws IOException
    {

    }

}

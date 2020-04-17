package lib.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginUIController
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
        {
            lgn.start(new Stage());

        }
        else return;
    }

    public void registerButtonAction(ActionEvent e) throws Exception
    {

    }

}

package lib.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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

    @FXML
    public GridPane root = new GridPane();

    public void loginButtonAction(ActionEvent e) throws Exception
    {
        lib.login lgn = new lib.login();
        if(lgn.getInfo(username.getText(),password.getText()))
        {
            Stage rootS = (Stage)root.getScene().getWindow();//获取根stage的引用
            //Platform.setImplicitExit(false);//设置窗体隐藏后不会自动退出
            rootS.hide();//隐藏窗体
            lgn.start(new Stage());
        }
        else return;
    }

    public void registerButtonAction(ActionEvent e) throws Exception
    {
        lib.register rgs = new lib.register();
        rgs.start(new Stage());
    }

}

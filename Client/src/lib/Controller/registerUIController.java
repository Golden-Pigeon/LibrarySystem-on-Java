package lib.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class registerUIController
{
    boolean flag = false;
    @FXML
    public Button exit = new Button();
    @FXML
    public AnchorPane root = new AnchorPane();
    public void exitButtonAction()
    {
        Stage rootS = (Stage)root.getScene().getWindow();
        rootS.close();
    }
    @FXML
    public Button register = new Button();
    public void registerButtonAction()
    {
        if(!flag)
        {
            arttnba3.MyWindows.messageWin("���Ȼ�ȡ��֤�룡","������Ϣ",0);
        }
    }
    @FXML
    public Button verify = new Button();
    public void verifyButtonAction()
    {
        flag = true;
    }
}

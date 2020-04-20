package lib.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;

public class MUIController
{
    @FXML
    public Button exit = new Button();
    public void exitButtonAction()
    {
        int n = arttnba3.MyWindows.confirmWin("��ȷ��Ҫ�˳���","�˳���ʾ",0);
        if(n==0)
            System.exit(0);
        else
            return;
    }
    @FXML
    public AnchorPane root = new AnchorPane();
    @FXML
    public Button minimize = new Button();
    public void miniButtonAction()
    {
        Stage stage = (Stage) root.getScene().getWindow();//��ȡ��stage
        stage.setIconified(true);
    }
}

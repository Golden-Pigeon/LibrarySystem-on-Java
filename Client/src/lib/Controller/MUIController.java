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
        int n = arttnba3.MyWindows.confirmWin("你确定要退出吗？","退出提示",0);
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
        Stage stage = (Stage) root.getScene().getWindow();//获取根stage
        stage.setIconified(true);
    }
}

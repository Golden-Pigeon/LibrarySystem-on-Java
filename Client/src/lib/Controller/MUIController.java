package lib.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.lang.*;

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
}

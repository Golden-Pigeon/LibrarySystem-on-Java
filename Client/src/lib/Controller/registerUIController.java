package lib.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class registerUIController
{
    @FXML
    public Button exit = new Button();
    @FXML
    public AnchorPane root = new AnchorPane();
    public void exitButtonAction()
    {
        Stage rootS = (Stage)root.getScene().getWindow();
        rootS.close();
    }
}

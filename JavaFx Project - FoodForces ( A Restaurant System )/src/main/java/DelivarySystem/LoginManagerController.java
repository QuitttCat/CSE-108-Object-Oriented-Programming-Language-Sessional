package DelivarySystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import util.LoginDTO;

public class LoginManagerController {
    private Client client;

    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private Button LoginAsManager;

    @FXML
    private Button Quit;

    @FXML
    private PasswordField passID;

    @FXML
    private TextField restaurantName;

    @FXML
    void OnLoginAsManager(ActionEvent event) {
        LoginDTO loginDTO=new LoginDTO();
        loginDTO.setUserName(restaurantName.getText());
        loginDTO.setPassword(passID.getText());
        loginDTO.setManager(true);
        try{
            client.getSocketWrapper().write(loginDTO);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    @FXML
    void OnReset(ActionEvent event) {
        restaurantName.clear();
        passID.clear();
    }

    @FXML
    void OnQuit(ActionEvent event) {
        client.showLoginType();
    }

}

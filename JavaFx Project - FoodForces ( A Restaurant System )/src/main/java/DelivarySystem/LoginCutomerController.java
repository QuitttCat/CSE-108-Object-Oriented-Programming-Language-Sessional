package DelivarySystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.LoginDTO;

public class LoginCutomerController {
    private Client client;

    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private Button Quit;

    @FXML
    private Button customerNameSubmit;

    @FXML
    private TextField customerName;

    @FXML
    void OnQuit(ActionEvent event) {
        client.showLoginType();
    }
    @FXML
    void onReset(ActionEvent event) {
        customerName.clear();
    }

    @FXML
    void OncustomerNameSubmit(ActionEvent event) {
        LoginDTO loginDTO=new LoginDTO();
        loginDTO.setUserName(customerName.getText());
        loginDTO.setCustomer(true);
        try{
            client.getSocketWrapper().write(loginDTO);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

}

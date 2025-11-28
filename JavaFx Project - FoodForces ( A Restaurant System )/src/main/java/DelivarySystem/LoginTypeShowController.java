package DelivarySystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginTypeShowController {
    private Client client;

    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private Button LoginAsCustomer;

    @FXML
    private Button LoginAsManager;

    @FXML
    private Button Quit;

    @FXML
    void OnLoginAsCustomer(ActionEvent event) {
        client.showLoginCustomer();
    }

    @FXML
    void OnLoginAsManager(ActionEvent event) {
        client.showLoginManager();
    }

    @FXML
    void OnQuit(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        thisStage.close();

    }

}

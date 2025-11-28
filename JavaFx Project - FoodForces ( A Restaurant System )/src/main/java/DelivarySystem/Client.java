package DelivarySystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.LoginDTO;
import util.SocketWrapper;

import java.io.IOException;
import java.security.PrivateKey;

public class Client extends Application {
    private Stage stage;
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    private SocketWrapper socketWrapper;

    public SocketWrapper getSocketWrapper() {
        return socketWrapper;
    }
    private RestaurantDetailsShowingController restaurantDetailsShowingController;

    public void setSocketWrapper(SocketWrapper socketWrapper) {
        this.socketWrapper = socketWrapper;
    }
    @Override
    public void start(Stage primaryStage) {
        try {

            stage = primaryStage;
            connectToServer();
            showLoginType();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    private void connectToServer()  {
        try {
            String serverAddress = "127.0.0.1";
            int serverPort = 33333;
            socketWrapper=new SocketWrapper(serverAddress,serverPort);
            new ReadThreadClient(this);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void showLoginType()  {
        try {
            // XML Loading using FXMLLoader
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("LoginTypeShowController.fxml"));
            //Parent root = loader.load();
            AnchorPane anchorPane=loader.load();

            // Loading the controller
            LoginTypeShowController controller = loader.getController();
            controller.setClient(this);
            // Set the primary stage
            stage.setTitle("Login Options");
            stage.setScene(new Scene(anchorPane));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void showLoginCustomer()  {
        try {
            // XML Loading using FXMLLoader
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("LoginCutomerController.fxml"));
            //Parent root = loader.load();
            AnchorPane anchorPane=loader.load();

            // Loading the controller
            LoginCutomerController controller = loader.getController();
            controller.setClient(this);
            // Set the primary stage
            stage.setTitle("Login As Customer");
            stage.setScene(new Scene(anchorPane));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void showLoginManager()  {
        try {
            // XML Loading using FXMLLoader
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("LoginManagerController.fxml"));
            //Parent root = loader.load();
            AnchorPane anchorPane=loader.load();

            // Loading the controller
            LoginManagerController controller = loader.getController();
            controller.setClient(this);
            // Set the primary stage
            stage.setTitle("Login As Restaurant Manager");
            stage.setScene(new Scene(anchorPane));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void showUpdate(Restaurant restaurant)  {
        try {
            // XML Loading using FXMLLoader
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("RestaurantDetailsShowingController.fxml"));
            Parent root = loader.load();

            // Loading the controller
            restaurantDetailsShowingController = loader.getController();
            restaurantDetailsShowingController.setClient(this);
            restaurantDetailsShowingController.initialize(restaurant);
            // Set the primary stage
            stage.setTitle("update");
            stage.setScene(new Scene(root, 1000, 600));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void cutomerSearchInterface(LoginDTO loginDTO){
        try {
            // XML Loading using FXMLLoader
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CustomerOrderingFoodController.fxml"));
            Parent root = loader.load();

            // Loading the controller
            CustomerOrderingFoodController controller = loader.getController();
            controller.setClient(this);
            controller.initialize(loginDTO);
            // Set the primary stage
            stage.setTitle("update");
            stage.setScene(new Scene(root, 1000, 600));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void cutomerFoodOrderingInterface(LoginDTO loginDTO){
        try {
            // XML Loading using FXMLLoader
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("foodCartController.fxml"));
            AnchorPane anchorPane=loader.load();
           // Parent root = loader.load();

            // Loading the controller
            FoodCartController controller = loader.getController();
            controller.setClient(this);
            controller.initialize(loginDTO);
            // Set the primary stage
            stage.setTitle("update");
            stage.setScene(new Scene(anchorPane));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void RefreshingRestaurantInterface(Order order){
        try{
        restaurantDetailsShowingController.realTimeRefresh(order);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void showLoginAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Alert");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The Restaurant name and ID you provided did not match!!!");
        alert.showAndWait();
    }
    public static void main(String[] args) {
        launch(args);
    }


}

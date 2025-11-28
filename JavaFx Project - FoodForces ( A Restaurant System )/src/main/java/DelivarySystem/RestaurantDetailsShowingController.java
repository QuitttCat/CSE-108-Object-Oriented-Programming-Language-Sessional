package DelivarySystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDetailsShowingController {

    @FXML
    private Label name;

    @FXML
    private ListView<String> orderedList;

    private Client client;

    public void setClient(Client client) {
        this.client = client;
    }
    private Restaurant restaurant;

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    ObservableList<String> orderDetails= FXCollections.observableArrayList();
    public void initialize(Restaurant restaurant){

        name.setText(restaurant.getName());

        //List<String> orders=new ArrayList<>();
        for(Order order:restaurant.getOrderList()) {
            for (Food food : order.getFoodList()) {
                orderDetails.add(order.getCustomerName() + " ordered " + food.getName() + " x" + food.getFoodOrderCount());
            }
        }
        orderedList.setItems(orderDetails);
        this.restaurant=restaurant;
    }
    public void realTimeRefresh(Order order)
    {
        restaurant.getOrderList().add(order);
        for (Food food : order.getFoodList()) {
            orderDetails.add(order.getCustomerName() + " ordered " + food.getName() + " x" + food.getFoodOrderCount());
        }
        orderedList.refresh();
    }

    @FXML
    void OnLogOut(ActionEvent event) throws IOException {
        RestaurantLogOutRequest restaurantLogOutRequest=new RestaurantLogOutRequest();
        restaurantLogOutRequest.setRestaurantName(restaurant.getName());
        client.getSocketWrapper().write(restaurantLogOutRequest);
        client.showLoginManager();
    }
}

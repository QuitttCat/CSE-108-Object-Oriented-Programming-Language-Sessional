package DelivarySystem;

import java.io.Serializable;

public class FoodOrderReq implements Serializable {
    private String restaurantName;
    private Order order;

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}

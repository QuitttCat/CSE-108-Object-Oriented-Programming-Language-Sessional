package DelivarySystem;

import java.io.Serializable;

public class RestaurantLogOutRequest implements Serializable {
    private  String restaurantName;

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }
}

package DelivarySystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    String customerName;
    List<Food> foodList;

    public Order(){
        foodList=new ArrayList<>();
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}

package DelivarySystem;


import java.io.Serializable;

public class Food implements Serializable {
    private int RestaurantId;
    private String Category;
    private String Name;
    private double Price;

    public int foodOrderCount;


    public Food(Food selectedItem){
        foodOrderCount=0;
    }
    public Food(String [] array){
        foodOrderCount=1;
        RestaurantId=Integer.parseInt(array[0]);
        Category=array[1];
        Name=array[2];
        Price=Double.parseDouble(array[3]);
    }
    public Food(int RestaurantID,String Category,String Name,double Price){
        foodOrderCount=1;
        this.RestaurantId=RestaurantID;
        this.Category=Category;
        this.Name=Name;
        this.Price=Price;
    }
    public Food(String Category,String Name,double Price){
        foodOrderCount=1;
        this.Category=Category;
        this.Name=Name;
        this.Price=Price;
    }



    public int getRestaurantId() {
        return RestaurantId;
    }

    public String getCategory() {
        return Category;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setRestaurantId(int restaurantId) {
        RestaurantId = restaurantId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setFoodOrderCount(int foodOrderCount) {
        this.foodOrderCount = foodOrderCount;
    }

    public int getFoodOrderCount() {
        return foodOrderCount;
    }
}

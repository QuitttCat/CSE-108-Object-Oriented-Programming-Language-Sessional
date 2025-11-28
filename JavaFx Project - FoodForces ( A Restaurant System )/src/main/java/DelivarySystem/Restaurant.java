package DelivarySystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Restaurant implements Serializable {

    private int Id;
    private String Name;
    private double Score;
    private String Price;
    private String ZipCode;
    private String[] Categories;

    public Restaurant()
    {
        foodList=new ArrayList<>();
        Categories=new String[3];
    }

    private List<Food> foodList;
    private List<Order> orderList;



    public Restaurant(String [] array){
        foodList=new ArrayList<>();
        orderList=new ArrayList<>();
        Id=Integer.parseInt(array[0]);
        Name=array[1];
        Score=(Double.parseDouble(array[2]));
        Price=array[3];
        ZipCode=array[4];
        Categories=new String[3];
        Categories[0]=array[5];
        Categories[1]=array[6];
        Categories[2]=array[7];
    }

    public Restaurant(int Id,String Name,double Score,String Price,String ZipCode,String Category1,String Category2,String Category3){
        foodList=new ArrayList<>();
        orderList=new ArrayList<>();
        this.Id=Id;
        this.Name=Name;
        this.Score=Score;
        this.Price=Price;
        this.ZipCode=ZipCode;
        Categories=new String[3];
        Categories[0]=Category1;
        Categories[1]=Category2;
        Categories[2]=Category3;

    }

    public Restaurant(String Name,double Score,String Price,String ZipCode,String Category1,String Category2,String Category3){
        foodList=new ArrayList<>();
        orderList=new ArrayList<>();
        this.Name=Name;
        this.Score=Score;
        this.Price=Price;
        this.ZipCode=ZipCode;
        Categories=new String[3];
        Categories[0]=Category1;
        Categories[1]=Category2;
        Categories[2]=Category3;

    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public double getScore() {
        return Score;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public String getPrice() {
        return Price;
    }

    public String[] getCategories() {
        return Categories;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setScore(double score) {
        Score = score;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public void setCategories(String[] categories) {
        Categories = categories;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}

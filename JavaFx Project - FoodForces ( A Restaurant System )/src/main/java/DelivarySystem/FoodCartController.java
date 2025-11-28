package DelivarySystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import util.LoginDTO;

import java.util.ArrayList;
import java.util.List;

public class FoodCartController {

    @FXML
    private TableColumn<Food,Integer> CartAmount;

    @FXML
    private TableView<Food> CartTable;

    @FXML
    private TableView<Food> FoodTable;

    @FXML
    private TableColumn<Food,Double> Price;

    @FXML
    private TableColumn<Food, String> cartName;

    @FXML
    private TableColumn<Food,String> category;

    @FXML
    private TableColumn<Food,String> name;
    @FXML
    private ChoiceBox<String> foodSearchMethods;
    @FXML
    private TextField SearchBarFood;
    @FXML
    private Label totalprice;

    @FXML
    void SearchFoods(KeyEvent event) {
        String choice=foodSearchMethods.getValue();
        if(choice.equals("Search By Name")){
            try {
                List<Food> foodList =searchFoodByName(SearchBarFood.getText());
                ObservableList<Food> restaurantObservableList= FXCollections.observableArrayList(foodList);
                FoodTable.setItems(restaurantObservableList);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        if(choice.equals("Search By Category")){
            try {
                List<Food> foodList =searchFoodByCategory(SearchBarFood.getText());
                ObservableList<Food> restaurantObservableList= FXCollections.observableArrayList(foodList);
                FoodTable.setItems(restaurantObservableList);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
    private double total=0;
    @FXML
    void AddToCart(ActionEvent event) {
        Food food=FoodTable.getSelectionModel().getSelectedItem();
        if(!cartList.isEmpty()) {
            for (Food f : cartList) {
                if (f.getName().equals(food.getName())) {
                    f.setFoodOrderCount(1 + f.getFoodOrderCount());
                    total += f.getPrice();
                    totalprice.setText("Total price :" + total);
                    CartTable.refresh();
                    return;
                }
            }
        }
        cartList.add(food);
        total+=food.getPrice();
        totalprice.setText("Total price :"+total);

    }

    @FXML
    void Back(ActionEvent event) {
        client.cutomerSearchInterface(loginDTO);
    }

    @FXML
    void RemoveFromCart(ActionEvent event) {
        Food food=CartTable.getSelectionModel().getSelectedItem();
        for(Food f:cartList){
            if(f.getName().equals(food.getName()) && f.getFoodOrderCount()>1){
                f.setFoodOrderCount(-1+f.getFoodOrderCount());
                total-=f.getPrice();
                totalprice.setText("Total price :"+total);
                CartTable.refresh();
                return;
            }
        }
        cartList.remove(food);
        total-=food.getPrice();
        totalprice.setText("Total price :"+total);
    }

    @FXML
    void orderPlace(ActionEvent event) {
        FoodOrderReq foodOrderReq=new FoodOrderReq();
        foodOrderReq.setRestaurantName(loginDTO.getRestaurant().getName());
        Order order=new Order();
        order.setCustomerName(loginDTO.getUserName());
        List<Food> foods=new ArrayList<>(cartList);
        //order.setFoodList(orderedFoodList);
        order.setFoodList(foods);
        foodOrderReq.setOrder(order);
        try {
            client.getSocketWrapper().write(foodOrderReq);
            System.out.println("Order Placed");
            cartList.clear();
            CartTable.refresh();
            total=0;
            totalprice.setText("Total price :"+total);
            for(Food food:loginDTO.getRestaurant().getFoodList()) {
                System.out.println(food.getFoodOrderCount());
                food.setFoodOrderCount(1);
            }
            ObservableList<Food> observableList = FXCollections.observableArrayList(loginDTO.getRestaurant().getFoodList());
            FoodTable.setItems(observableList);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    private LoginDTO loginDTO;

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    private Client client;

    public void setClient(Client client) {
        this.client = client;
    }
    ObservableList<Food> cartList = FXCollections.observableArrayList();
    public void initialize(LoginDTO loginDTO){
        totalprice.setText("Total price :"+0);
        String [] prompt=new String[2];
        prompt[0]="Search By Name";
        prompt[1]="Search By Category";
        foodSearchMethods.getItems().addAll(prompt);
        this.loginDTO=loginDTO;
        List<Food> foodList=new ArrayList<>(this.loginDTO.getRestaurant().getFoodList());
        name.setCellValueFactory(new PropertyValueFactory<Food, String>("Name"));
        category.setCellValueFactory(new PropertyValueFactory<Food, String>("Category"));
        Price.setCellValueFactory(new PropertyValueFactory<Food, Double>("Price"));

        cartName.setCellValueFactory(new PropertyValueFactory<Food, String>("Name"));
        CartAmount.setCellValueFactory(new PropertyValueFactory<Food, Integer>("foodOrderCount"));

        ObservableList<Food> observableList = FXCollections.observableArrayList(foodList);

        CartTable.setItems(cartList);
        FoodTable.setItems(observableList);
        //System.out.println(loginDTO.getUserName());
    }
    public List<Food> searchFoodByName(String foodName)
    {
        List<Food> searchResult=new ArrayList<>();
        for(Food food : loginDTO.getRestaurant().getFoodList())
        {
            if(food.getName().toLowerCase().contains(foodName.toLowerCase()))
            {
                searchResult.add(food);
            }
        }
        return  searchResult;
    }
    public List<Food> searchFoodByCategory(String foodCategory)
    {
        List<Food> searchResult=new ArrayList<>();
        for(Food food : loginDTO.getRestaurant().getFoodList())
        {
            if(food.getCategory().toLowerCase().contains(foodCategory.toLowerCase()))
            {
                searchResult.add(food);
            }
        }
        return  searchResult;
    }
}

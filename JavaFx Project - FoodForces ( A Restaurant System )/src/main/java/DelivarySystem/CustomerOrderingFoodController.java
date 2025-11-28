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

public class CustomerOrderingFoodController {
    private LoginDTO loginDTO;

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }
    private Client client;

    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private ChoiceBox<String> choicebox;
    @FXML
    private TableView<Restaurant> RestaurantTable;

    @FXML
    private TableColumn<Restaurant, String> name;

    @FXML
    private TableColumn<Restaurant,String> price;

    @FXML
    private TableColumn<Restaurant, Double> score;
    @FXML
    private TableColumn<Restaurant,String> zipcode;



    @FXML
    private TextField searchBar;

    @FXML
    private Button Search;
    @FXML
    private TextField highScore;

    @FXML
    private TextField lowScore;


    @FXML
    private ChoiceBox<String> searchChoiceMethods;


    @FXML
    void OnSearchSubmit(ActionEvent event) {
        double low= Double.parseDouble(lowScore.getText());
        double high= Double.parseDouble(highScore.getText());
        try {

            List<Restaurant> restaurantList =searchRestaurantByScore(low,high);
            ObservableList<Restaurant> restaurantObservableList= FXCollections.observableArrayList(restaurantList);
            RestaurantTable.setItems(restaurantObservableList);
            Search.setVisible(false);
            lowScore.setVisible(false);
            highScore.setVisible(false);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void OnSearchWithScoreRange(ActionEvent event) {
        Search.setVisible(true);
        lowScore.setVisible(true);
        highScore.setVisible(true);
    }


    @FXML
    void OnDetailsShow(ActionEvent event) {
       loginDTO.setRestaurant(RestaurantTable.getSelectionModel().getSelectedItem());
       client.cutomerFoodOrderingInterface(loginDTO);
    }

    @FXML
    void OnQuit(ActionEvent event) {
        client.showLoginCustomer();
    }

    @FXML
    void OnSearchBar(KeyEvent event) {
        String choice=choicebox.getValue();
        if(choice.equals("Search By Name")){
            try {

                List<Restaurant> restaurantList =searchRestaurantByName(searchBar.getText());
                ObservableList<Restaurant> restaurantObservableList= FXCollections.observableArrayList(restaurantList);
                RestaurantTable.setItems(restaurantObservableList);
            }
            catch (Exception e){
                System.out.println(e);
            }

        }
        else if(choice.equals("Search By Price")){
            try {

                List<Restaurant> restaurantList =searchRestaurantByPrice(searchBar.getText());
                ObservableList<Restaurant> restaurantObservableList= FXCollections.observableArrayList(restaurantList);
                RestaurantTable.setItems(restaurantObservableList);
            }
            catch (Exception e){
                System.out.println(e);
            }

        }
        else if(choice.equals("Search By Zipcode")) {
            try {

                List<Restaurant> restaurantList =searchRestaurantByZipCode(searchBar.getText());
                ObservableList<Restaurant> restaurantObservableList= FXCollections.observableArrayList(restaurantList);
                RestaurantTable.setItems(restaurantObservableList);
            }
            catch (Exception e){
                System.out.println(e);
            }


        }
        else if(choice.equals("Search By Category")){
            try {

                List<Restaurant> restaurantList =searchRestaurantByCategory(searchBar.getText());
                ObservableList<Restaurant> restaurantObservableList= FXCollections.observableArrayList(restaurantList);
                RestaurantTable.setItems(restaurantObservableList);
            }
            catch (Exception e){
                System.out.println(e);
            }


        }

    }
    public void initialize(LoginDTO loginDTO){
        Search.setVisible(false);
        this.loginDTO=loginDTO;
        String [] prompt=new String[4];
        prompt[0]="Search By Name";
        prompt[1]="Search By Price";
        prompt[2]="Search By Zipcode";
        prompt[3]="Search By Category";
        choicebox.getItems().addAll(prompt);
        name.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("Name"));
        score.setCellValueFactory(new PropertyValueFactory<Restaurant,Double>("Score"));
        price.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("Price"));
        zipcode.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("ZipCode"));
        //updating my previous code
        ObservableList<Restaurant> restaurantObservableList=FXCollections.observableArrayList(loginDTO.getRestaurantList());
        RestaurantTable.setItems(restaurantObservableList);


    }
    public List<Restaurant> searchRestaurantByName(String restaurantName)
    {
        List<Restaurant> searchResult=new ArrayList<>();
        for(Restaurant restaurant : loginDTO.getRestaurantList())
        {
            if(restaurant.getName().toLowerCase().contains(restaurantName.toLowerCase()))
            {
                searchResult.add(restaurant);
            }
        }
        return  searchResult;
    }
    public List<Restaurant >searchRestaurantByPrice(String restaurantPrice)
    {
        List<Restaurant> searchResult=new ArrayList<>();
        for(Restaurant restaurant : loginDTO.getRestaurantList())
        {
            if(restaurant.getPrice().equals(restaurantPrice))
            {
                searchResult.add(restaurant);
            }
        }
        return searchResult;
    }
    public List<Restaurant >searchRestaurantByZipCode(String restaurantZipCode)
    {
        List<Restaurant> searchResult=new ArrayList<>();
        for(Restaurant restaurant : loginDTO.getRestaurantList())
        {
            if(restaurant.getZipCode().contains(restaurantZipCode))
            {
                searchResult.add(restaurant);
            }
        }
        return searchResult;
    }

    public List<Restaurant> searchRestaurantByCategory(String category){
        List<Restaurant> searchResult=new ArrayList<>();
        for(Restaurant restaurant : loginDTO.getRestaurantList())
        {
            for(String check:restaurant.getCategories())
            {
                if(check.toLowerCase().contains(category.toLowerCase())){
                    searchResult.add(restaurant);
                }
            }
        }
        return searchResult;
    }
    public List<Restaurant> searchRestaurantByScore(double lowScore,double highScore)
    {
        List<Restaurant> searchResult=new ArrayList<>();
        for(Restaurant restaurant : loginDTO.getRestaurantList())
        {
            if(restaurant.getScore()>=lowScore && restaurant.getScore()<=highScore)
            {
                searchResult.add(restaurant);
            }
        }
        return searchResult;
    }





}

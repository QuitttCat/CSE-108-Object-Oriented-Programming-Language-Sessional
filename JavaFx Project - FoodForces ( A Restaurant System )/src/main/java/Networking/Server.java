package Networking;

import DelivarySystem.*;
import util.LoginDTO;
import util.SocketWrapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, SocketWrapper> clientMap;

    private List<Restaurant> restaurantList=new ArrayList<>();
    private List<Food> foodList=new ArrayList<>();

    private HashMap<String ,String> restaurantPassword=new HashMap<>();

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public HashMap<String, String> getRestaurantPassword() {
        return restaurantPassword;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    private static final String INPUT_FILE_NAME="restaurant.txt";
    private static final String OUTPUT_FILE_NAME="restaurant.txt";
    private static final String INPUT_FILE_NAME_2="food.txt";
    private static final String OUTPUT_FILE_NAME_2="food.txt";


    Server() {
        clientMap = new HashMap<>();
        try {
            serverSocket = new ServerSocket(33333);
            System.out.println("Server Started!!!");

            BufferedReader br=new BufferedReader(new FileReader(INPUT_FILE_NAME));
            while (true){
                String line=br.readLine();
                //System.out.println(line);
                if(line==null) break;
                String [] info=line.split(",",-1);
                restaurantPassword.put(info[1],info[0]);
                restaurantList.add(new Restaurant(info));
            }
            br.close();
            System.out.println("Restaurant list loaded to the server!!!");
            br=new BufferedReader(new FileReader(INPUT_FILE_NAME_2));
            while (true){
                String line=br.readLine();
                //System.out.println(line);
                if(line==null) break;
                String [] info=line.split(",",-1);
                foodList.add(new Food(info));
            }
            br.close();
            System.out.println("Food list loaded to the server!!!");
            for(Restaurant restaurant:restaurantList){
                List<Food> foods=new ArrayList<>();
                for(Food food:foodList){
                    if(restaurant.getId()== food.getRestaurantId()){
                        foods.add(food);
                        //System.out.println(restaurant.getName()+" added the food :"+food.getName());
                    }
                }
                restaurant.setFoodList(foods);
                System.out.println("Restaurant "+restaurant.getName()+" loaded it's foodlist!!!");
            }
            new RestaurantSignUp(restaurantList,foodList,restaurantPassword);
            System.out.println("new thread opened for addiing food and restaurant");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client just slid into the server!!!");
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) {
        try {
            SocketWrapper socketWrapper = new SocketWrapper(clientSocket);
            new ReadThreadServer(clientMap, socketWrapper,restaurantList,foodList,restaurantPassword);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}

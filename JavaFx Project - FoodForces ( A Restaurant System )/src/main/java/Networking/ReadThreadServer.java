package Networking;


import DelivarySystem.Food;
import DelivarySystem.FoodOrderReq;
import DelivarySystem.Restaurant;
import DelivarySystem.RestaurantLogOutRequest;
import util.LoginDTO;
import util.SocketWrapper;
import java.io.*;
import java.util.HashMap;
import java.util.List;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private SocketWrapper socketWrapper;
    private List<Restaurant> restaurantList;
    private List<Food> foodList;
    public HashMap<String, SocketWrapper> clientMap;
    private HashMap<String ,String> restaurantPassword;


    public ReadThreadServer(HashMap<String, SocketWrapper> map, SocketWrapper socketWrapper,List<Restaurant> restaurantList,List<Food> foodList,HashMap<String ,String> restaurantPassword) {
        this.clientMap = map;
        this.restaurantPassword=restaurantPassword;
        this.foodList=foodList;
        this.restaurantList=restaurantList;
        this.socketWrapper = socketWrapper;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = socketWrapper.read();
                if(o instanceof LoginDTO){
                    LoginDTO loginDTO= (LoginDTO) o;
                    {
                        if(loginDTO.isCustomer()){
                            loginDTO.setFoodList(foodList);
                            loginDTO.setRestaurantList(restaurantList);
                            socketWrapper.write(loginDTO);
                        }
                        else if (loginDTO.isManager()) {
                            if(restaurantPassword.containsKey(loginDTO.getUserName())) {
                                String pass = restaurantPassword.get(loginDTO.getUserName());
                                if (pass.equals(loginDTO.getPassword())) {
                                    loginDTO.setStatus(true);
                                    for (Restaurant restaurant : restaurantList) {
                                        if (restaurant.getName().equals(loginDTO.getUserName())) {
                                            loginDTO.setRestaurant(restaurant);
                                            break;
                                        }
                                    }
                                    clientMap.put(loginDTO.getUserName(), socketWrapper);
                                    socketWrapper.write(loginDTO);
                                }
                                else{
                                    loginDTO.setStatus(false);
                                    socketWrapper.write(loginDTO);
                                }

                            }
                            else{
                                loginDTO.setStatus(false);
                                socketWrapper.write(loginDTO);
                            }
                        }


                    }

                }
                else if (o instanceof FoodOrderReq) {
                    FoodOrderReq foodOrderReq=(FoodOrderReq) o;
                    for(Restaurant restaurant:restaurantList){
                        if(restaurant.getName().equals(foodOrderReq.getRestaurantName())){
                            restaurant.getOrderList().add(foodOrderReq.getOrder());
                        }
                    }
                    if(clientMap.containsKey(foodOrderReq.getRestaurantName())) {
                        clientMap.get(foodOrderReq.getRestaurantName()).write(foodOrderReq.getOrder());
                    }

                }
                else if(o instanceof RestaurantLogOutRequest){
                    RestaurantLogOutRequest restaurantLogOutRequest=(RestaurantLogOutRequest) o;
                    clientMap.remove(restaurantLogOutRequest.getRestaurantName());
                }
                /*if (o instanceof Message) {
                    Message obj = (Message) o;
                    String to = obj.getTo();
                    SocketWrapper nu = clientMap.get(to);
                    if (nu != null) {
                        nu.write(obj);
                    }

                }*/
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                socketWrapper.closeConnection();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}



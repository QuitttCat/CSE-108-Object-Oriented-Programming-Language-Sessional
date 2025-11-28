package Networking;

import DelivarySystem.Food;
import DelivarySystem.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RestaurantSignUp implements Runnable{
     private List<Food> foodList;
     private Thread th;
     private List<Restaurant> restaurantList;
    private HashMap<String ,String> restaurantPassword;


    public RestaurantSignUp(List<Restaurant> restaurantList, List<Food> foodList, HashMap<String,String>restaurantPassword){
         this.restaurantList=restaurantList;
         this.restaurantPassword=restaurantPassword;
         this.foodList=foodList;
         this.th = new Thread(this);
         th.start();
     }
     public void run(){
         try{
             int choice;
             Scanner scanner = new Scanner(System.in);
             while (true){

                 System.out.println("Main Menu:");
                 System.out.println("1) Add Restaurant");
                 System.out.println("2) Add Food Item to the Menu");
                 System.out.print("Enter your choice : ");
                 choice = scanner.nextInt();
                 scanner.nextLine(); // Consume the newline character
                 if(choice==1){
                     System.out.println();

                     System.out.print("Enter Restaurant Name: ");
                     String restaurantName=scanner.nextLine();

                    System.out.print("Enter Restaurant Id: ");
                    int restaurantId=scanner.nextInt();
                    scanner.nextLine();

                     System.out.print("Enter Restaurant Score: ");
                     double restaurantScore=scanner.nextDouble();
                     scanner.nextLine();

                     System.out.print("Enter Restaurant Price: ");
                     String restaurantPrice5=scanner.nextLine();

                     System.out.print("Enter Restaurant Zip Code: ");
                     String restaurantZipCode=scanner.nextLine();

                     System.out.print("Enter Category 1: ");
                     String cat1=scanner.nextLine();

                     System.out.print("Enter Category 2: ");
                     String cat2=scanner.nextLine();

                     System.out.print("Enter Category 3: ");
                     String cat3=scanner.nextLine();

                     Restaurant restaurant=new Restaurant(restaurantId,restaurantName,restaurantScore,restaurantPrice5,restaurantZipCode,cat1,cat2,cat3);
                     boolean flag=true;
                     for(Restaurant restaurant1:restaurantList){
                         if(restaurant1.getName().equals(restaurant.getName())){
                             flag=false;
                         }
                     }

                     if(flag) {
                         restaurantList.add(restaurant);
                         restaurantPassword.put(restaurantName, String.valueOf(restaurantId));
                         System.out.println("Restaurant added successfully!");
                     }
                     else System.out.println("Restaurant addition was unsuccessful.Please try with valid credentials!");



                 }
                 else if(choice==2){
                     System.out.println();
                     System.out.print("Enter Restaurant Id: ");
                     int restaurantId=scanner.nextInt();
                     scanner.nextLine();

                     System.out.print("Enter Food Category: ");
                     String foodCategory=scanner.nextLine();

                     System.out.print("Enter Food Name: ");
                     String foodName=scanner.nextLine();

                     System.out.print("Enter Food Price: ");
                     double foodPrice=scanner.nextDouble();
                     scanner.nextLine();
                     boolean flag=true;
                     Restaurant restaurantRef=new Restaurant();
                     Food food=new Food(restaurantId,foodCategory,foodName,foodPrice);
                     for(Restaurant restaurant:restaurantList){
                         for(Food food1:foodList){
                             if(restaurantId==restaurant.getId()){
                                 restaurantRef=restaurant;
                                 if(food1.getName().equals(food.getName()))flag=false;
                             }
                         }
                     }
                     if(flag) {
                         System.out.println("Food added successfully!");
                         restaurantRef.getFoodList().add(food);
                     }
                     else System.out.println("Food addition was unsuccessful.Please try again  with valid credentials!");



                 }

             }

         }
         catch (Exception e){
             System.out.println(e);
         }
     }
}

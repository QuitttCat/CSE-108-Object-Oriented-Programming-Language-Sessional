package DelivarySystem;

import java.io.IOException;
import javafx.application.Platform;
import util.LoginDTO;
import util.SocketWrapper;

public class ReadThreadClient implements Runnable{
    private Thread thr;
    private  Client main;

    public ReadThreadClient(Client main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = main.getSocketWrapper().read();
                if (o != null) {
                    if(o instanceof LoginDTO) {
                        LoginDTO loginDTO= (LoginDTO) o;
                        if(loginDTO.isCustomer()){
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    main.cutomerSearchInterface(loginDTO);
                                }
                            });
                        }
                        else if(loginDTO.isManager()){
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    if(loginDTO.isStatus()) {
                                        main.showUpdate(loginDTO.getRestaurant());
                                    }
                                    else {
                                        main.showLoginAlert();
                                    }
                                }
                            });

                        }

                        // the following is necessary to update JavaFX UI components from user created threads

                    }
                    else if(o instanceof Order){
                        Order order=(Order) o;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                main.RefreshingRestaurantInterface(order);
                            }
                        });


                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                main.getSocketWrapper().closeConnection();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}

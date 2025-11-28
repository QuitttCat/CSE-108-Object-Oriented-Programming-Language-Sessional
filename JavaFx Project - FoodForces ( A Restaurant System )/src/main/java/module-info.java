module com.example.foodforces {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.foodforces to javafx.fxml;
    exports com.example.foodforces;

    opens DelivarySystem to javafx.fxml;
    exports  DelivarySystem;

    opens Networking to javafx.fxml;
    exports Networking;

    opens util to javafx.fxml;
    exports util;
}
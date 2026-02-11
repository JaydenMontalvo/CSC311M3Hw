module com.farmingdale.w3labcsc311 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.farmingdale.w3labcsc311 to javafx.fxml;
    exports com.farmingdale.w3labcsc311;
}
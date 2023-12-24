module com.github.zerrakoth.qrcodegenerator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.github.zerrakoth.qrcodegenerator to javafx.fxml;
    exports com.github.zerrakoth.qrcodegenerator;
}
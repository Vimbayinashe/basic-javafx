module com.gui.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.gui.javafx to javafx.fxml;
    exports com.gui.javafx;
}
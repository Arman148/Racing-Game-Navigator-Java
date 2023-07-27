module gui.project1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens gui.project1 to javafx.fxml;
    exports gui.project1;
}
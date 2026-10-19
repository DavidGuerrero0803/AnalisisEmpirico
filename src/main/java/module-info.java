module uabc.david.analisisempirico {
    requires javafx.controls;
    requires javafx.fxml;


    opens uabc.david.analisisempirico to javafx.fxml;
    exports uabc.david.analisisempirico;
}
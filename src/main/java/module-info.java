module com.conway.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.conway.gameoflife to javafx.fxml;
    exports com.conway.gameoflife;
}
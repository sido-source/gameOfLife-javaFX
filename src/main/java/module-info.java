module com.conway.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.conway.gameoflife to javafx.fxml;
    exports com.conway.gameoflife;
    exports com.conway.gameoflife.enums;
    opens com.conway.gameoflife.enums to javafx.fxml;
    exports com.conway.gameoflife.views;
    opens com.conway.gameoflife.views to javafx.fxml;
}
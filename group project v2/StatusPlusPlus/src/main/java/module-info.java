module com.example.statusplusplus {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.statusplusplus.TestDrivers to javafx.fxml;
    opens com.example.statusplusplus.Classes to javafx.fxml;
    opens com.example.statusplusplus to javafx.fxml;
    exports com.example.statusplusplus.Classes;
    exports com.example.statusplusplus.DatabaseModels;
    exports com.example.statusplusplus.TestDrivers;
}
module com.example.financetracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires charm.glisten;

    opens com.example.financetracker to javafx.fxml;
    opens model to javafx.base;
    exports com.example.financetracker;
}
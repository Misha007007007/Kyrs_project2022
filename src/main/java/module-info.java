module com.example.kyrs_project1 {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;

        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
            requires eu.hansolo.tilesfx;
    requires java.sql;

    opens com.example.kyrs_project1 to javafx.fxml;
    exports com.example.kyrs_project1;
    exports com.example.kyrs_project1.Controllers;
    opens com.example.kyrs_project1.Controllers to javafx.fxml;
}
module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.sql;

    exports com;
    exports com.dbconnect;
    exports com.controller;
    exports com.model.dao;
    exports com.model.entities;
    
    opens com to javafx.graphics;
    opens com.controller to javafx.fxml;
    opens com.model.dao to javafx.base;
    opens com.model.entities to javafx.base;
}

module com.employee {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    // requires de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
    // requires transitive;

    opens com.employee to javafx.fxml;
    opens com.employee.Model to javafx.base;
    exports com.employee;
}

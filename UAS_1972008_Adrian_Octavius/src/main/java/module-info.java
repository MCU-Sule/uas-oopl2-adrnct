module com.example.uas_1972008_adrian_octavius {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.persistence;
    requires java.naming;

    opens com.example.uas_1972008_adrian_octavius to javafx.fxml;
    exports com.example.uas_1972008_adrian_octavius;
    exports com.example.uas_1972008_adrian_octavius.Model;
}
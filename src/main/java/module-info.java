module com.bdd.guijavafxfxmlorderwinbdd {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.bdd.guijavafxfxmlorderwinbdd to javafx.fxml;
    exports com.bdd.guijavafxfxmlorderwinbdd;
}

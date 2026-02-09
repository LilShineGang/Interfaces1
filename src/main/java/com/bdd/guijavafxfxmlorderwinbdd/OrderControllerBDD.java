package com.bdd.guijavafxfxmlorderwinbdd;

import java.io.IOException;
import javafx.fxml.FXML;

public class OrderControllerBDD {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void openCalculator() throws IOException {
        App.setRoot("src/main/resources/com/bdd/guijavafxfxmlorderwinbdd/fxml/calculatorBDD");
    }
}

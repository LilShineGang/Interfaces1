package com.bdd.guijavafxfxmlorderwinbdd;

import java.io.IOException;
import javafx.fxml.FXML;

public class OrderControllerBDD {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
package com.bdd.guijavafxfxmlorderwinbdd;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginControllerBDD {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}

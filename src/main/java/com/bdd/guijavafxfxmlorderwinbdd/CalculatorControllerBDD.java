package com.bdd.guijavafxfxmlorderwinbdd;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorControllerBDD {

    @FXML private TextField display; 
    @FXML private TextField memoryDisplay; 
    @FXML private ToggleButton powerButton;
    
    private double num1 = 0;
    private String operator = "";
    private boolean start = true;
    private double memoryValue = 0;

    @FXML
    public void initialize() {
        memoryDisplay.setEditable(false);
        display.setEditable(false);
    }

    @FXML
    private void handlePower(ActionEvent event) {
        if (!powerButton.isSelected()) {
            display.setText("");
            memoryDisplay.setText("");
            num1 = 0;
            operator = "";
            start = true;
        } else {
            display.setText("0");
        }
    }

    @FXML
    private void processNumbers(ActionEvent event) {
        if (!powerButton.isSelected()) return;
        
        String value = ((Button)event.getSource()).getText();
        if (start) {
            display.setText("");
            start = false;
        }
        display.setText(display.getText() + value);
    }

    @FXML
    private void processOperators(ActionEvent event) {
        if (!powerButton.isSelected() || display.getText().isEmpty()) return;

        String value = ((Button)event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty()) return;
            operator = value;
            num1 = Double.parseDouble(display.getText());
            display.setText("");
        } else {
            if (operator.isEmpty()) return;
            double num2 = Double.parseDouble(display.getText());
            calculate(num1, num2, operator);
            operator = "";
            start = true;
        }
    }

    private void calculate(double n1, double n2, String op) {
        switch (op) {
            case "+": display.setText(String.valueOf(n1 + n2)); break;
            case "-": display.setText(String.valueOf(n1 - n2)); break;
            case "*": display.setText(String.valueOf(n1 * n2)); break;
            case "/": 
                if (n2 == 0) display.setText("Error: Div 0");
                else display.setText(String.valueOf(n1 / n2)); 
                break;
            case "^": display.setText(String.valueOf(Math.pow(n1, n2))); break;
            case "%": display.setText(String.valueOf(n1 % n2)); break; 
        }
    }

    @FXML
    private void handleAdvancedOperator(ActionEvent event) {
        if (!powerButton.isSelected() || display.getText().isEmpty()) return;
        String op = ((Button)event.getSource()).getText();
        double currentVal = Double.parseDouble(display.getText());

        switch(op) {
            case "sqr(x)":
                if (currentVal < 0) display.setText("Error: Neg Sqr"); 
                else display.setText(String.valueOf(Math.sqrt(currentVal)));
                break;
            case "1/x":
                if (currentVal == 0) display.setText("Error: Div 0");
                else display.setText(String.valueOf(1 / currentVal));
                break;
            case "+/-":
                display.setText(String.valueOf(currentVal * -1));
                break;
        }
        start = true;
    }

    @FXML
    private void handleClear() {
        display.setText("0");
        operator = "";
        num1 = 0;
        start = true;
    }

    @FXML
    private void handleDelete() { 
        String current = display.getText();
        if (current.length() > 0) {
            display.setText(current.substring(0, current.length() - 1));
        }
    }

    @FXML private void handleMS() { 
        memoryValue = Double.parseDouble(display.getText()); 
        memoryDisplay.setText(String.valueOf(memoryValue)); 
    }
    @FXML private void handleMC() { 
        memoryValue = 0; 
        memoryDisplay.setText(""); 
    }
    @FXML private void handleMR() { 
        display.setText(String.valueOf(memoryValue)); 
        start = true;
    }
    @FXML private void handleMPlus() {
        memoryValue += Double.parseDouble(display.getText());
        memoryDisplay.setText(String.valueOf(memoryValue));
    }
    @FXML private void handleMMinus() {
        memoryValue -= Double.parseDouble(display.getText());
        memoryDisplay.setText(String.valueOf(memoryValue));
    }

    @FXML 
    private void handleFactorial() {
        if (!powerButton.isSelected() || display.getText().isEmpty()) return;
        try {
            int n = Integer.parseInt(display.getText());
            if (n < 0) display.setText("Error: Neg Fact");
            else display.setText(String.valueOf(factorial(n)));
        } catch (NumberFormatException e) {
            display.setText("Error: Int only");
        }
        start = true;
    }
    
    private long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    @FXML
    private void handlePrime() {
        if (!powerButton.isSelected() || display.getText().isEmpty()) return;
        try {
            int n = Integer.parseInt(display.getText());
            if (isPrime(n)) display.setText("Is Prime");
            else display.setText("Not Prime");
        } catch (NumberFormatException e) {
            display.setText("Error: Int only");
        }
        start = true;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
package calculator.gui;

import javafx.fxml.FXML;
import calculator.logic.Calculator;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CalculatorController {

    private Calculator calculator = new Calculator();

    @FXML
    private TextField display;

    @FXML
    private void onDigitPressed(ActionEvent event) {
    Button button = (Button) event.getSource();
    display.appendText(button.getText());

    }

    @FXML
    private void onClearPressed(ActionEvent event) {
        calculator.clear();
        display.clear();
    }

    @FXML
    private void onOperatorPressed(ActionEvent event) {
        String text = display.getText();
        if(text.isEmpty()) {
            return;
        }
    Button button = (Button) event.getSource();
    double num1 = Double.parseDouble(display.getText());
    calculator.setNum1(num1);
    calculator.setOperator(button.getText().charAt(0));
    display.appendText(" " + button.getText() + " ");
    }

    @FXML
    private void onEqualsPressed(ActionEvent event) {
        String[] parts = display.getText().split(" ");
        double num2 = Double.parseDouble(parts[parts.length - 1]);
        calculator.setNum2(num2);
        try{
            double result = calculator.calculate();
            display.setText(String.valueOf(result));
        } catch(ArithmeticException e) {
            display.setText("Division by 0!");
        }
    }

    @FXML
    private void onDeletePressed(ActionEvent event) {
        String text = display.getText();
        if(!text.isEmpty()) {
            display.setText(text.substring(0, text.length()-1));
        }

    }
}

package calculator.gui;

import javafx.fxml.FXML;
import calculator.logic.Calculator;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CalculatorController {

    private Calculator calculator = new Calculator();

    private boolean showingError = false;

    @FXML
    private TextField display;

    @FXML
    private void onDigitPressed(ActionEvent event) {
        if(showingError) {
            display.clear();
            showingError = false;
        }
    Button button = (Button) event.getSource();
    display.appendText(button.getText());

    }

    @FXML
    private void onClearPressed(ActionEvent event) {
        calculator.clear();
        display.clear();
        showingError = false;
    }

    @FXML
    private void onOperatorPressed(ActionEvent event) {
        if(showingError){
            return;
        }
        String text = display.getText();
        if(text.isEmpty() || text.contains(" ")) {
            return;
        }
    Button button = (Button) event.getSource();
    double num1 = Double.parseDouble(text);
    calculator.setNum1(num1);
    calculator.setOperator(button.getText().charAt(0));
    display.appendText(" " + button.getText() + " ");
    }

    @FXML
    private void onEqualsPressed(ActionEvent event) {
        if(showingError) {
            return;
        }
        String text = display.getText();
        String[] parts = text.split(" ");
        if(parts.length <3) {
            return;
        }
        double num2 = Double.parseDouble(parts[parts.length - 1]);
        calculator.setNum2(num2);
        try{
            double result = calculator.calculate();
            display.setText(String.valueOf(result));
        } catch(ArithmeticException e) {
            display.setText("Division by 0!");
            showingError = true;
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

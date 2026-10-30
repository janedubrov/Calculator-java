package calculator.logic;

public class Calculator {
    private double num1;
    private double num2;
    private double result;
    private char operator;

    public void setNum1(double num1) {
        this.num1 = num1;
    }
    public void setNum2(double num2) {
        this.num2 = num2;
    }
    public void setOperator(char operator) {
        this.operator = operator;
    }

    public double calculate(){
        switch(operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 -num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if(num2 == 0){
                    throw new ArithmeticException("Division by 0! ");
                }
                result = num1 / num2;
                break;
        }
        num1 = result;
        return result;
    }

    public void clear() {
        num1 = 0;
        num2 = 0;
        result = 0;
        operator = ' ';
    }
}

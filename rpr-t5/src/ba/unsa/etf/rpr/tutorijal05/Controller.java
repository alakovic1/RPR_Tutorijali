package ba.unsa.etf.rpr.tutorijal05;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;

public class Controller {

    private enum Operator {ADD, SUB, MUL, DIV, MOD, EQU};
    private SimpleStringProperty number;
    private Operator operator = Operator.EQU;
    private double result = 0;
    private boolean oClear = false;
    private boolean temp = false;

    public Controller() {
        number = new SimpleStringProperty();
        number.set("0");
    }

    public SimpleStringProperty numberProperty() {
        return number;
    }

    public String getNumber() {
        return number.get();
    }

    private void buildNumber(String num) {
        if(oClear) {
            numberProperty().setValue("");
            oClear = false;
        }

        if((getNumber().equals("0") && !num.equals("."))) {
            numberProperty().setValue("");

        }
        temp=true;
        numberProperty().setValue(getNumber().concat(num));
    }

    private double parseNumber(String num) {
        return Double.parseDouble(num);
    }

    private void operate(Operator o) {
        double operand = parseNumber(getNumber());
        if(temp) {
            switch (operator) {
                case EQU: {
                    result = operand;
                    temp = false;
                    break;
                }
                case ADD: {
                    result += operand;
                    temp = false;
                    break;
                }
                case SUB: {
                    result -= operand;
                    temp = false;
                    break;
                }
                case MUL: {
                    result *= operand;
                    temp = false;
                    break;
                }
                case DIV: {
                    result /= operand;
                    temp = false;
                    break;
                }
                case MOD: {
                    result %= operand;
                    temp = false;
                    break;
                }
            }
        }
        numberProperty().setValue("" + result);
        oClear = true;
        operator = o;
    }

    public void za0(ActionEvent actionEvent) {
        buildNumber("0");
    }

    public void za1(ActionEvent actionEvent) {
        buildNumber("1");
    }

    public void za2(ActionEvent actionEvent) {
        buildNumber("2");
    }

    public void za3(ActionEvent actionEvent) {
        buildNumber("3");
    }

    public void za4(ActionEvent actionEvent) { buildNumber("4"); }

    public void za5(ActionEvent actionEvent) {
        buildNumber("5");
    }

    public void za6(ActionEvent actionEvent) {
        buildNumber("6");
    }

    public void za7(ActionEvent actionEvent) {
        buildNumber("7");
    }

    public void za8(ActionEvent actionEvent) {
        buildNumber("8");
    }

    public void za9(ActionEvent actionEvent) {
        buildNumber("9");
    }

    public void zaTacku(ActionEvent actionEvent) {
        if(!numberProperty().get().contains(".")) buildNumber(".");
    }

    public void zaPlus(ActionEvent actionEvent) {

        operate(Operator.ADD);
    }

    public void zaMinus(ActionEvent actionEvent) {
        operate(Operator.SUB);
    }

    public void zaMnozenje(ActionEvent actionEvent) {
        operate(Operator.MUL);
    }

    public void zaDijeljenje(ActionEvent actionEvent) {
        operate(Operator.DIV);
    }

    public void zaModul(ActionEvent actionEvent) {
        operate(Operator.MOD);
    }

    public void zaJednako(ActionEvent actionEvent) {
        operate(Operator.EQU);
    }

}
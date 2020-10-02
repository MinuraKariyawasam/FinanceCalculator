package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
        import javafx.scene.control.TextInputControl;


public class Calculators{
    public static void main(String[] args){

    }
    public static void keyBordKeys(Node nodeName, Button buttonName){
        String outputValue = buttonName.getText();
        ((TextInputControl) nodeName).replaceSelection(outputValue);
    }

    public static void decimalPoint(Node nodeName, Button buttonName){
        if (nodeName instanceof TextInputControl) {
            buttonName.setFocusTraversable(false);
            String outputValue = buttonName.getText();
            String checkDecimal = ((TextInputControl) nodeName).getText();
            if (checkDecimal.indexOf('.') == -1) {
                ((TextInputControl) nodeName).replaceSelection(outputValue);
            } else {
                ((TextInputControl) nodeName).replaceSelection("");
            }

        }
    }

    public static void delButton(Node nodeName){
        if (nodeName instanceof TextInputControl) {
            if (((TextInputControl) nodeName).getLength() > 0) {
                ((TextInputControl) nodeName).setText(((TextInputControl) nodeName).getText(0, ((TextInputControl) nodeName).getText().length() - 1));
            }
        }
    }
}
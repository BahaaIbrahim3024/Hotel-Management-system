/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmanage.Controller;
import javafx.scene.control.TextField;

/**
 *
 * @author ibaha
 */
public class Validation {
        public void ValidateNumber(TextField tf){
        tf.textProperty().addListener(e -> {
            if (!tf.getText().matches("\\d*")) {    //if not match a number character
                tf.setText(tf.getText().replaceAll("[^\\d]", ""));//replace it with nothing
            }
        });
    }
        
   
    public void ValidateName(TextField tf){
        tf.textProperty().addListener(e -> {
            if (tf.getText().matches("[\\!-\\@\\[-\\`\\{-\\~]")) { //matches number or symbol
                tf.setText(tf.getText().replaceAll("[\\!-\\@\\[-\\`\\{-\\~]", ""));//replace it with nothing
            }
        });
    }

    
    public void ValidatePhone(TextField tf){
        tf.textProperty().addListener(e -> {
            if (tf.getText().matches("[\\!-\\*\\:-\\~ \\, \\/]+")){    //match phone number if doesn't contain 0->9 . - +
                tf.setText(tf.getText().replaceAll("[\\!-\\*\\:-\\~ \\, \\/]+", ""));//replace it with nothing
            }
        });
    }

    
    public void ValidateEmail(TextField tf){
        tf.textProperty().addListener(e -> {
            if (tf.getText().matches("[ \\!-\\* \\, \\/\\:-\\?\\[-\\^\\`\\{-\\~]+")){    //matches if does contain space , symbols except for @ + - _ .
                tf.setText(tf.getText().replaceAll("[ \\!-\\* \\, \\/\\:-\\?\\[-\\^\\`\\{-\\~]+", ""));//replace it with nothing
            }
        });
    }
}

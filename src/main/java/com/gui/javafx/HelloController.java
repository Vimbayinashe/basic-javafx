package com.gui.javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.function.UnaryOperator;

public class HelloController {
    Model model;
    public TextField textField1;
    public Canvas canvas;

    @FXML   //Important annotation
    private Label welcomeText;

    @FXML
    private CheckBox checkBox1;

    //we cannot use a constructor to initialise  HelloController's fields, use initialize() method instead
    public void initialize() {
        model = new Model();

        //binding text in Model (using textProperty()) with textField in Controller
        model.textProperty().bindBidirectional(textField1.textProperty());
        welcomeText.textProperty().bind(model.textProperty());

        //textField1.setDisable(true);    //disabled text field (grey in gui)
        //textField1.disableProperty().bind(checkBox1.selectedProperty().not());

        //initialise a field
        //textField1.setText("Hej");
    }

    @FXML
    protected void onHelloButtonClick() {
        model.setText("Button pressed");
//        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onCheckBoxChecked() {
//        welcomeText.setText("Checkbox is " + checkBox1.isSelected());
    }


    //if we connect method to more than one checkbox -> e & getSource required
    /*
        public void onCheckBoxChecked(ActionEvent actionEvent) {
            if(actionEvent.getSource() == checkBox1)                //getSource -> element id
                welcomeText.setText("Clicked on checkbox");
        }
     */

    //action -> the elements default "action", a checkbox is checked or unchecked by click, spacebar, voice controls
    //rea
    // lly cool - automatic accessibility

    //an onMouseClicked method requires a MouseEvent argument
    public void onMouseClicked(MouseEvent mouseEvent) {
//        System.out.println(mouseEvent.getX() + ": " + mouseEvent.getY());
//        System.out.println(mouseEvent.getScreenX() + ": " + mouseEvent.getScreenY());
    }

    public void keyTyped(KeyEvent keyEvent) {
//        System.out.println(keyEvent.getCharacter());
//        String text = textField1.getText();
//
//
////        if (text.length() > 5)
////            textField1.setText(text.substring(0, text.length() - 1));
//        // ! cursor moves to Home after 5 characters
//
//        //limit field to 5 characters maximum
//        textField1.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
//                if (textField1.getText().length() >= 5)
//                    textField1.setText(oldValue);
//            }
//        });

    }

    public void canvasClicked(MouseEvent event) {
        var context = canvas.getGraphicsContext2D();
        context.fillOval(event.getX(), event.getY(), 25, 25);

    }
}


// Unary equivalent of addLister
/*
     UnaryOperator<TextFormatter.Change> filter = change -> {
            if(change.getText().equals("a"))
                change.setText("Hej");
            else
                change.setText("");
            return change;
        };

        TextFormatter<String> formatter = new TextFormatter<>(TextFormatter.IDENTITY_STRING_CONVERTER,"",filter);
        textField1.setTextFormatter(formatter);
 */
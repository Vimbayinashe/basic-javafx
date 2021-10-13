package com.gui.javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
    //sometimes better to create static method in Model, when we need several models,  -> avoid creating several new
    // Model objects

    private StringProperty text;

    public Model() {
        this.text = new SimpleStringProperty();
    }

    //JavaFX requires getText() & setText() and not text() & text(String t) in "newer" Java Clean Code
    public String getText() {
        return text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
        //registers new value for text & also notifys other properties bound to StringProperty text.
    }

    public StringProperty textProperty() {
        return text;
    }
}

/*
 *  In View -> access model's methods using model.methodName();
 *  the view can be replaceable with a console app using System.out & System.in
 */

package com.example.kyrs_project1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Addition {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add;

    @FXML
    private Button back;

    @FXML
    private Label check;

    @FXML
    private TextField date;

    @FXML
    private TextField quote;

    @FXML
    private TextField subject;

    @FXML
    private TextField teacher;

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {
        Application.changeScene("Menu.fxml");
    }

    @FXML
    void initialize() {
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'addition.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'addition.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'addition.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'addition.fxml'.";
        assert quote != null : "fx:id=\"quote\" was not injected: check your FXML file 'addition.fxml'.";
        assert subject != null : "fx:id=\"subject\" was not injected: check your FXML file 'addition.fxml'.";
        assert teacher != null : "fx:id=\"teacher\" was not injected: check your FXML file 'addition.fxml'.";

    }

}

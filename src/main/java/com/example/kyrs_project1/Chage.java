package com.example.kyrs_project1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Chage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button chage;

    @FXML
    private Label check;

    @FXML
    private Button delete;

    @FXML
    private TextField newQuote;

    @FXML
    private TextField oldQuote;

    @FXML
    void back(ActionEvent event) {
        Application.changeScene("myQuotes.fxml");
    }

    @FXML
    void chage(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'change.fxml'.";
        assert chage != null : "fx:id=\"chage\" was not injected: check your FXML file 'change.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'change.fxml'.";
        assert delete != null : "fx:id=\"delete\" was not injected: check your FXML file 'change.fxml'.";
        assert newQuote != null : "fx:id=\"newQuote\" was not injected: check your FXML file 'change.fxml'.";
        assert oldQuote != null : "fx:id=\"oldQuote\" was not injected: check your FXML file 'change.fxml'.";

    }

}


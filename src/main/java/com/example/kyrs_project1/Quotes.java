package com.example.kyrs_project1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Quotes {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //кнопка назад
    @FXML
    private Button back;

    //метод назад
    @FXML
    void back(ActionEvent event) {
        Application.changeScene("Menu.fxml");
    }
}
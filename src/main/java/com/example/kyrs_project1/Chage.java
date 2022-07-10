package com.example.kyrs_project1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Chage {

    //поле для высвечивания информации
    @FXML
    private Label check;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //кнопка назад
    @FXML
    private Button back;

    //кнопка изменить
    @FXML
    private Button chage;

    //поле измененная цитата
    @FXML
    private TextField chageQuote;

    //кнопка удалить
    @FXML
    private Button delete;

    //поле номер цитаты
    @FXML
    private TextField numberQuotes;

    //метод назаж
    @FXML
    void back(ActionEvent event) {
        Application.changeScene("myQuotes.fxml");
    }

    //метод изменить
    @FXML
    void chage(ActionEvent event) {

    }

    //метод удалить
    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'change.fxml'.";
        assert chage != null : "fx:id=\"chage\" was not injected: check your FXML file 'change.fxml'.";
        assert chageQuote != null : "fx:id=\"chageQuote\" was not injected: check your FXML file 'change.fxml'.";
        assert delete != null : "fx:id=\"delete\" was not injected: check your FXML file 'change.fxml'.";
        assert numberQuotes != null : "fx:id=\"numberQuotes\" was not injected: check your FXML file 'change.fxml'.";
    }
}

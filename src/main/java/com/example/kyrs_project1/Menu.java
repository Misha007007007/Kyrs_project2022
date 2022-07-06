package com.example.kyrs_project1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Menu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //кнопка добавить/удалить
    @FXML
    private Button add;

    //кнопка все цитаты
    @FXML
    private Button allQuotes;

    //кнопка изменения данных аккаунта
    @FXML
    private Button chageData;

    //выхода
    @FXML
    private Button exit;

    //кнопка мои цитаты
    @FXML
    private Button myQuotes;


    @FXML
    void add(ActionEvent event) {
        Application.changeScene("change.fxml");
    }

    //кнопка все цитаты
    @FXML
    void allQuotes(ActionEvent event) {
        Application.changeScene("Quotes.fxml");
    }

    //кнопка изменения данных аккаунта
    @FXML
    void chageData(ActionEvent event) {
        Application.changeScene("recovery.fxml");
    }

    //кнопка мои цитаты
    @FXML
    void myQuotes(ActionEvent event) {
        Application.changeScene("myQuotes.fxml");
    }

    //выход при нажатии
    @FXML
    void exit(ActionEvent event) {
        Application.changeScene("hello-view.fxml");
    }

    @FXML
    void initialize() {

    }

}



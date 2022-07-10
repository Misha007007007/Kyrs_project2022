package com.example.kyrs_project1.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.kyrs_project1.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Menu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //кнопка все цитаты
    @FXML
    private Button allQuotes;

    //кнопка изменения логина
    @FXML
    private Button chageData;

    //выхода
    @FXML
    private Button exit;

    //кнопка мои цитаты
    @FXML
    private Button myQuotes;

    //кнопка все цитаты
    @FXML
    void allQuotes(ActionEvent event) {
        Application.changeScene("Quotes.fxml");
    }

    //кнопка изменения пароля
    @FXML
    private Button chagePassword;

    //кнопка изменения логина
    @FXML
    void chageData(ActionEvent event) {
        Application.changeScene("recoveryLogin.fxml");
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

    //кнопка изменения пароля
    @FXML
    void chagePassword(ActionEvent event) {
        Application.changeScene("recoveryPassword.fxml");
    }

    @FXML
    void initialize() {

    }

}



package com.example.kyrs_project1;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Avtorization {

    //кнопка войти как гость
    @FXML
    private Button inputGuest;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //кнопка "регистрация" на окне аторизации
    @FXML
    private Button RegistrationInAuthorization;

    //кнопка "войти" на окне аторизации
    @FXML
    private Button input;

    //поле "логин" на окне аторизации
    @FXML
    private TextField login;

    //поле "пароль" на окне авторизации
    @FXML
    private TextField password;

    //сообщение об ошибке
    @FXML
    private Label ckeckPerson;

    //вход при нажатии
    @FXML
    void loginGuest(ActionEvent event) {
        Application.changeScene("MainWindow.fxml");
    }

    //вход при нажатии
    @FXML
    void loginUser(ActionEvent event) {
        Application.changeScene("Menu.fxml");
    }

    //переход на регистрацию
    @FXML
    void registrationUser(ActionEvent event) {
        Application.changeScene("Registration.fxml");
    }

    //проверка авторизации
    @FXML
    void checkAvtor(ActionEvent event) {

    }
}


















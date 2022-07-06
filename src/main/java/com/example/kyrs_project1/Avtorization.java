package com.example.kyrs_project1;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class Avtorization {

    private Users users;

    //кнопка войти как гость
    @FXML
    private Button inputGuest;

    @FXML
    private ResourceBundle resources;

    //сообщение об ошибке
    @FXML
    private Label check;

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

    //вход при нажатии
    @FXML
    void loginGuest(ActionEvent event) {
        Application.changeScene("Quotes.fxml");
    }

    //вход пользоваетеля
    @FXML
    void loginUser(ActionEvent event) {
        Connection connect = Application.connection();
        try {
            Statement statement = connect.createStatement();
            users = new Users();

            String query = String.format("SELECT * FROM users WHERE login = '%s' AND password_hash = '%s';", login.getText(), users.hashing(password.getText()));

            if (login.getText() == "" || users.hashing(password.getText()) == "") {
                check.setTextFill(Paint.valueOf("RED"));
                check.setText("Запоните все поля для успешной авторизации!");
            } else {
                try {
                    statement.execute(query);
                    Application.changeScene("Menu.fxml");

                } catch (SQLIntegrityConstraintViolationException e) {
                    check.setTextFill(Paint.valueOf("RED"));
                    check.setText("Данные введены неверно!");
                }
            }
            connect.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Искл при регистрации");
        }
    }

    //переход на регистрацию
    @FXML
    void registrationUser(ActionEvent event) {
        Application.changeScene("Registration.fxml");
    }
}


















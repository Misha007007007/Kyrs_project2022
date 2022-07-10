package com.example.kyrs_project1.Controllers;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.example.kyrs_project1.Application;
import com.example.kyrs_project1.QuotesContainer;
import com.example.kyrs_project1.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class Avtorization {

    Users user;

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
            user = new Users();
            String query = "SELECT * FROM users WHERE login = ? AND password_hash = ?;";

            PreparedStatement statement = connect.prepareStatement(query);
            statement.setString(1, login.getText());
            statement.setString(2, user.hashing(password.getText()));


            if (login.getText() == "" || password.getText() == "") {
                check.setTextFill(Paint.valueOf("RED"));
                check.setText("Заполните все поля для успешной авторизации!");
            } else {
                try {
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        int role = resultSet.getInt("role");
                        String band = resultSet.getString("band");
                        QuotesContainer quotesContainer = new QuotesContainer();
                        quotesContainer.fillUser(login.getText());
                        user = new Users(login.getText(), user.hashing(password.getText()), role, band, quotesContainer);

                        Application.user = user;
                        System.out.println(user);
                        Application.changeScene("Menu.fxml");
                    }
                    else{
                        check.setTextFill(Paint.valueOf("RED"));
                        check.setText("Введены неверные данные!");
                    }

                } catch (SQLIntegrityConstraintViolationException e) {
                    check.setTextFill(Paint.valueOf("RED"));
                    check.setText("Данные введены неверно!");
                }
            }
            connect.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Искл при авторизации");
        }
    }

    //переход на регистрацию
    @FXML
    void registrationUser(ActionEvent event) {
        Application.changeScene("Registration.fxml");
    }
}


















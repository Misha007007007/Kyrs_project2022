package com.example.kyrs_project1.Controllers;

import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.kyrs_project1.Application;
import com.example.kyrs_project1.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class RecoveryPassword {

    Users user;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //поле для вывода ошибок
    @FXML
    private Label check;

    //кнопка назад
    @FXML
    private Button Back;

    //кнопка изменить
    @FXML
    private Button chage;

    //поле логин
    @FXML
    private TextField oldPassword;

    //поле новый пароль
    @FXML
    private TextField newPassword;

    //метод назад
    @FXML
    void Back(ActionEvent event) {
        Application.changeScene("Menu.fxml");
    }

    //изменение пароля
    @FXML
    void chage(ActionEvent event) {
        Connection connect = Application.connection();
        try {
            user = new Users();
            String query = "UPDATE users SET password_hash = ? WHERE login = ?";
            PreparedStatement statement = connect.prepareStatement(query);

            statement.setString(1, Users.MakeHashing(newPassword.getText()));
            statement.setString(2, Application.user.getLogin());

            //String query = String.format("UPDATE users SET password_hash = '%s' WHERE login = '%s'", Users.MakeHashing(newPassword.getText()), Application.user.getLogin());

            if (Objects.equals(Users.MakeHashing(oldPassword.getText()), Users.MakeHashing(newPassword.getText()))){
                check.setTextFill(Paint.valueOf("RED"));
                check.setText("Введены одинаковые пароли!");
            }
            else if (oldPassword.getText() == "" || newPassword.getText() == "") {
                check.setTextFill(Paint.valueOf("RED"));
                check.setText("Заполните все поля для успешного изменения!");
            } else {
                try {
                    if (Objects.equals(Users.MakeHashing(oldPassword.getText()), Application.user.getHash_password())) {
                        statement.execute();
                        check.setTextFill(Paint.valueOf("GREEN"));
                        check.setText("Ваш пароль изменен!");
                        Application.user.setHash_password(Users.MakeHashing(oldPassword.getText()));
                    } else {
                        check.setTextFill(Paint.valueOf("RED"));
                        check.setText("Старый пароль введен неверно!");
                    }
                } catch (SQLIntegrityConstraintViolationException e) {
                    check.setTextFill(Paint.valueOf("RED"));
                    check.setText("искл смены пароля!");
                }
            }
            connect.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Искл при изменении логина");
        }
    }

}

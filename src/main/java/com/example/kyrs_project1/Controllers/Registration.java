package com.example.kyrs_project1.Controllers;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.example.kyrs_project1.Application;
import com.example.kyrs_project1.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class Registration {

    private Users users;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //поле для высвечивания ошибок
    @FXML
    private Label check;

    @FXML
    private Label check2;

    //кнопка назад
    @FXML
    private Button back;

    //поле логин
    @FXML
    private TextField loginReg;

    //поле пароль
    @FXML
    private TextField passwordReg;

    //поле группа
    @FXML
    private TextField group;

    //кнопка регистрации
    @FXML
    private Button regInRegistration;

    //переход на авторизацию
    @FXML
    void backAvtorization(ActionEvent event) {
        Application.changeScene("hello-view.fxml");
    }

    //регистрация пользователя
    @FXML
    void registration(ActionEvent event) {
        Connection connect = Application.connection();
        try {
            users = new Users();
            String query = "INSERT INTO users(login, password_hash, band, role) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = connect.prepareStatement(query);
            //String query = String.format("INSERT INTO users(login, password_hash, band, role) VALUES ('%s', '%s', '%s', %d);", loginReg.getText(), users.hashing(passwordReg.getText()), group.getText(), 3);
            statement.setString(1, loginReg.getText());
            statement.setString(2, users.hashing(passwordReg.getText()));
            statement.setString(3, group.getText());
            statement.setInt(4, 7);
            if (loginReg.getText() == "" || users.hashing(passwordReg.getText()) == "" || group.getText() == "") {
                check.setTextFill(Paint.valueOf("RED"));
                check.setText("Запоните все поля для успешной регистрации!");
            } else {
                try {
                    statement.execute();
                    check.setTextFill(Paint.valueOf("GREEN"));
                    check.setText("Вы зарегистрированы, авторизуйтесь на предыдышей странице!");
                } catch (SQLIntegrityConstraintViolationException e) {
                    check.setTextFill(Paint.valueOf("RED"));
                    check.setText("Такой логин уже существует!");
                }
            }
            connect.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Искл при регистрации");
        }
    }
}

package com.example.kyrs_project1.Controllers;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
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
            Statement statement = connect.createStatement();
            //users = new Users();

            String query = String.format("INSERT INTO users(login, password_hash, band, role) VALUES ('%s', '%s', '%s', %d);", loginReg.getText(), users.hashing(passwordReg.getText()), group.getText(), 3);

            if (loginReg.getText() == "" || users.hashing(passwordReg.getText()) == "" || group.getText() == "") {
                check.setTextFill(Paint.valueOf("RED"));
                check.setText("Запоните все поля для успешной регистрации!");
            } else {
                try {
                    statement.execute(query);
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

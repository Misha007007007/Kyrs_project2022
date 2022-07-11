package com.example.kyrs_project1.Controllers;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.example.kyrs_project1.Application;
import com.example.kyrs_project1.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

public class Menu {

    private Users user;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //поле количестов цитат
    @FXML
    private Label countQuotes;

    //кнопка все цитаты
    @FXML
    private Button allQuotes;

    //кнопка изменения логина
    @FXML
    private Button chageData;

    //нопка количество цитат
    @FXML
    private Button count;

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
        Application.user = null;
    }

    //кнопка изменения пароля
    @FXML
    void chagePassword(ActionEvent event) {
        Application.changeScene("recoveryPassword.fxml");
    }

    //мнтод количество цитат
    @FXML
    void count(ActionEvent event) {
        Connection connect = Application.connection();
        try {
            user = new Users();

            String query = "SELECT COUNT(*) as count FROM teacher_quotes WHERE login_user = ?";
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setString(1, Application.user.getLogin());
            countQuotes.setTextFill(Paint.valueOf("WHITE"));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                countQuotes.setText("Количество цитат: " + resultSet.getString("count"));
            }
            connect.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Искл при подсчете");
        }
    }

    @FXML
    void initialize() {

    }

}



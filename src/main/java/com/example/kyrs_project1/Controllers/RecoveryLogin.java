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

public class RecoveryLogin {

    Users user;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //кнопка назад
    @FXML
    private Button back;

    //кнопка изменить логин
    @FXML
    private Button chageLogin;

    //кнопка изменить пароль
    @FXML
    private Button chagePassword;

    //поле для высвечивания ошибок
    @FXML
    private Label check;

    //поле новый логин
    @FXML
    private TextField newLogin;

    //поле старый логин
    @FXML
    private TextField oldLogin;

    //кнопка назад
    @FXML
    void back(ActionEvent event) {
        Application.changeScene("Menu.fxml");
    }


    //изменение логина
    @FXML
    void chageLogin(ActionEvent event) {
        Connection connect = Application.connection();
        try {
            user = new Users();
            String query = "UPDATE users SET login = ? WHERE login = ?";
            PreparedStatement statement = connect.prepareStatement(query);

            statement.setString(1, newLogin.getText());
            statement.setString(2, Application.user.getLogin());


            //String query = String.format("UPDATE users SET login = '%s' WHERE login = '%s'", newLogin.getText(), Application.user.getLogin());

            if (newLogin.getText() == "" || oldLogin.getText() == "") {
                check.setTextFill(Paint.valueOf("RED"));
                check.setText("Заполните все поля для успешного изменения!");
            } else {
                try {
                    if(Objects.equals(oldLogin.getText(), Application.user.getLogin())){
                        statement.execute();
                        //System.out.println(Application.user.getLogin());
                        check.setTextFill(Paint.valueOf("GREEN"));
                        check.setText("Ваш логин изменен!");
                        Application.user.setLogin(newLogin.getText());
                    } else {
                        //System.out.println(oldLogin.getText());
                        //System.out.println(Application.user.getLogin());
                        //System.out.println(Objects.equals(oldLogin.getText(), Application.user.getLogin()));
                        check.setTextFill(Paint.valueOf("RED"));
                        check.setText("Старый логин введен неверно!");
                    }
                } catch (SQLIntegrityConstraintViolationException e) {
                    check.setTextFill(Paint.valueOf("RED"));
                    check.setText("Такой логин уже существует!");
                }
            }
            connect.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Искл при изменении логина");
        }
    }

    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'recoveryLogin.fxml'.";
        assert chageLogin != null : "fx:id=\"chageLogin\" was not injected: check your FXML file 'recoveryLogin.fxml'.";
        assert chagePassword != null : "fx:id=\"chagePassword\" was not injected: check your FXML file 'recoveryLogin.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'recoveryLogin.fxml'.";
        assert newLogin != null : "fx:id=\"newLogin\" was not injected: check your FXML file 'recoveryLogin.fxml'.";
        assert oldLogin != null : "fx:id=\"oldLogin\" was not injected: check your FXML file 'recoveryLogin.fxml'.";
    }
}
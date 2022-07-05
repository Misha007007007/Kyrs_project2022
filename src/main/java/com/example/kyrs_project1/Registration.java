package com.example.kyrs_project1;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Registration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

    //регистрация при нажатии
    @FXML
    void initialize() {

    }

    //переход на авторизацию
    @FXML
    void backAvtorization(ActionEvent event) {
        back.setOnAction(actionEvent -> {
            Application.changeScene("hello-view.fxml");
        });
    }

}

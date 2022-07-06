package com.example.kyrs_project1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class recovery {

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

    //поле новый пароль
    @FXML
    private TextField newPassword;

    //поле старый логин
    @FXML
    private TextField oldLogin;

    //поле старый пароль
    @FXML
    private TextField oldPassword;

    //кнопка назад
    @FXML
    void back(ActionEvent event) {
        Application.changeScene("Menu.fxml");
    }

    @FXML
    void chageLogin(ActionEvent event) {

    }

    @FXML
    void chagePassword(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'recovery.fxml'.";
        assert chageLogin != null : "fx:id=\"chageLogin\" was not injected: check your FXML file 'recovery.fxml'.";
        assert chagePassword != null : "fx:id=\"chagePassword\" was not injected: check your FXML file 'recovery.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'recovery.fxml'.";
        assert newLogin != null : "fx:id=\"newLogin\" was not injected: check your FXML file 'recovery.fxml'.";
        assert newPassword != null : "fx:id=\"newPassword\" was not injected: check your FXML file 'recovery.fxml'.";
        assert oldLogin != null : "fx:id=\"oldLogin\" was not injected: check your FXML file 'recovery.fxml'.";
        assert oldPassword != null : "fx:id=\"oldPassword\" was not injected: check your FXML file 'recovery.fxml'.";

    }

}
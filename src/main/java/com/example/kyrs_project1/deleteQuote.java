package com.example.kyrs_project1;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class deleteQuote {

    private Users user;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //кнопка назад
    @FXML
    private Button back;

    //кнопка изменить
    @FXML
    private Button chage;

    //поле для отображения ошибок
    @FXML
    private Label check;

    //старая цитата
    @FXML
    private TextField oldQuote;

    //метод назад
    @FXML
    void back(ActionEvent event) {
        Application.changeScene("myQuotes.fxml");
    }

    //метод удалить
    @FXML
    void delete(ActionEvent event) {
        Connection connect = Application.connection();
        try {
            user = new Users();

            String query = "DELETE FROM `teacher_quotes` WHERE `teacher_quotes`.`quote` = ? AND `teacher_quotes`.`login_user` = ?";
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setString(1, oldQuote.getText());
            statement.setString(2, Application.user.getLogin());

            if (oldQuote.getText() == "") {
                check.setTextFill(Paint.valueOf("RED"));
                check.setText("Запоните все поля для успешного удаления!");
            } else {
                try {
                    int executeUpdate = statement.executeUpdate();
                    if (executeUpdate > 0) {
                        check.setTextFill(Paint.valueOf("GREEN"));
                        check.setText("Цитата удалена!");
                    }else{
                        check.setTextFill(Paint.valueOf("RED"));
                        check.setText("Такой цитаты нет или вы не можете ее удалить!");
                    }
                } catch (SQLIntegrityConstraintViolationException e) {
                    System.out.println(e);
                    check.setTextFill(Paint.valueOf("RED"));
                    check.setText("Такой цитаты нет!");
                }
            }
            connect.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Искл при регистрации");
        }
    }

    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'deleteQuote.fxml'.";
        assert chage != null : "fx:id=\"chage\" was not injected: check your FXML file 'deleteQuote.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'deleteQuote.fxml'.";
        assert oldQuote != null : "fx:id=\"oldQuote\" was not injected: check your FXML file 'deleteQuote.fxml'.";
    }
}


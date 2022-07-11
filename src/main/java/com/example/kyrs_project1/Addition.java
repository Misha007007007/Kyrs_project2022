package com.example.kyrs_project1;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class Addition {

    private Users user;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //кнопка добавить
    @FXML
    private Button add;

    //кнопка изменить
    @FXML
    private Button back;

    //поле для отображения ошибок
    @FXML
    private Label check;

    //поле дата
    @FXML
    private DatePicker date;

    //поле цитата
    @FXML
    private TextField quote;

    //поле предмет
    @FXML
    private TextField subject;

    //поле учитель
    @FXML
    private TextField teacher;

    //добавление цитаты
    @FXML
    void add(ActionEvent event) {
        Connection connect = Application.connection();
        try {
            user = new Users();

            String query = "INSERT INTO teacher_quotes (login_user, band, quote, subject, date, teacher) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = connect.prepareStatement(query);

            statement.setString(1, Application.user.getLogin());
            statement.setString(2, Application.user.getBand());
            statement.setString(3, quote.getText());
            statement.setString(4, subject.getText());
            statement.setString(5, String.valueOf(date.getValue()));
            statement.setString(6, teacher.getText());

            //String query = String.format("INSERT INTO teacher_quotes (login_user, quote, subject, date, teacher) VALUES ('%s', '%s', '%s', %d, '%s');", user.getLogin(), quote.getText(), subject.getText(), date.getValue(), teacher.getText());

            if (quote.getText() == "" || subject.getText() == "" || teacher.getText() == "") {
                check.setTextFill(Paint.valueOf("RED"));
                check.setText("Запоните все поля для успешной регистрации!");
            } else {
                try {
                    statement.execute();
                    check.setTextFill(Paint.valueOf("GREEN"));
                    check.setText("Ваша цитата добавлена!");
                } catch (SQLIntegrityConstraintViolationException e) {
                    System.out.println(e);
                    check.setTextFill(Paint.valueOf("RED"));
                    check.setText("Такая цитата уже существует!");
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
    void back(ActionEvent event) {
        Application.changeScene("myQuotes.fxml");
    }

    @FXML
    void initialize() {
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'addition.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'addition.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'addition.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'addition.fxml'.";
        assert quote != null : "fx:id=\"quote\" was not injected: check your FXML file 'addition.fxml'.";
        assert subject != null : "fx:id=\"subject\" was not injected: check your FXML file 'addition.fxml'.";
        assert teacher != null : "fx:id=\"teacher\" was not injected: check your FXML file 'addition.fxml'.";
    }
}

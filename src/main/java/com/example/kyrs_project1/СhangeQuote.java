package com.example.kyrs_project1;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class СhangeQuote {

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
    private Button change;

    //поле для отображения ошибок
    @FXML
    private Label check;

    //поле дата
    @FXML
    private DatePicker date;

    //поле повая цитата
    @FXML
    private TextField newQuote;

    //поле старая цитата
    @FXML
    private TextField oldQuote;

    //поле предмет
    @FXML
    private TextField subject;

    //поле преподаватель
    @FXML
    private TextField teacher;

    //метод назад
    @FXML
    void back(ActionEvent event) {
        Application.changeScene("myQuotes.fxml");
    }

    //метод изменить
    @FXML
    void change(ActionEvent event) {
        Connection connect = Application.connection();
        PreparedStatement statement = null;
        try {
            user = new Users();
            //обычный пользователь
            if (Objects.equals(Application.user.getRole(), 7)) {
                String query = "UPDATE `teacher_quotes` SET quote = ?, subject = ?, date = ?, teacher = ? WHERE login_user = ? AND quote = ?";
                statement = connect.prepareStatement(query);

                statement.setString(5, Application.user.getLogin());
                statement.setString(6, oldQuote.getText());
            } //админ (суперпользователь)
            else if(Objects.equals(Application.user.getRole(), 0)){
                String query = "UPDATE `teacher_quotes` SET quote = ?, subject = ?, date = ?, teacher = ? WHERE quote = ?";
                statement = connect.prepareStatement(query);

            } //верификатор 1
            else if(Objects.equals(Application.user.getRole(), 1)){
                String query = "UPDATE `teacher_quotes` SET quote = ?, subject = ?, date = ?, teacher = ? WHERE quote = ? AND band = 1";
                statement = connect.prepareStatement(query);

            } //верификатор 2
            else if(Objects.equals(Application.user.getRole(), 2)){
                String query = "UPDATE `teacher_quotes` SET quote = ?, subject = ?, date = ?, teacher = ? WHERE quote = ? AND band = 2";
                statement = connect.prepareStatement(query);

            } //верификатор 3
            else if(Objects.equals(Application.user.getRole(), 3)){
                String query = "UPDATE `teacher_quotes` SET quote = ?, subject = ?, date = ?, teacher = ? WHERE quote = ? AND band = 3";
                statement = connect.prepareStatement(query);

            }
            statement.setString(1, newQuote.getText());
            statement.setString(2, subject.getText());
            statement.setString(3, String.valueOf(date.getValue()));
            statement.setString(4, teacher.getText());
            statement.setString(5, oldQuote.getText());
            /*
            statement.setString(1, newQuote.getText());
            statement.setString(2, subject.getText());
            statement.setString(3, String.valueOf(date.getValue()));
            statement.setString(4, teacher.getText());
            statement.setString(5, Application.user.getLogin());
            statement.setString(6, oldQuote.getText());

             */

            if (oldQuote.getText() == "" || newQuote.getText() == "" || subject.getText() == "" || teacher.getText() == "") {
                check.setTextFill(Paint.valueOf("RED"));
                check.setText("Запоните все поля для успешного изменения");
            } else {
                try {
                    int executeUpdate = statement.executeUpdate();
                    if (executeUpdate > 0){
                        check.setTextFill(Paint.valueOf("GREEN"));
                        check.setText("Цитата изменена!");
                    }else{
                        check.setTextFill(Paint.valueOf("RED"));
                        check.setText("Такой цитаты нет или вы не имеете право ее редактировать!");
                    }
                    System.out.println(executeUpdate);
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
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'changeQuote.fxml'.";
        assert change != null : "fx:id=\"change\" was not injected: check your FXML file 'changeQuote.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'changeQuote.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'changeQuote.fxml'.";
        assert newQuote != null : "fx:id=\"newQuote\" was not injected: check your FXML file 'changeQuote.fxml'.";
        assert oldQuote != null : "fx:id=\"oldQuote\" was not injected: check your FXML file 'changeQuote.fxml'.";
        assert subject != null : "fx:id=\"subject\" was not injected: check your FXML file 'changeQuote.fxml'.";
        assert teacher != null : "fx:id=\"teacher\" was not injected: check your FXML file 'changeQuote.fxml'.";

    }

}


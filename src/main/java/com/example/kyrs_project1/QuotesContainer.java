package com.example.kyrs_project1;
//контейнер с циататми
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Date;

public class QuotesContainer {
    private Connection connection;

    private ObservableList<QuoteEntry> quoteEntries = FXCollections.observableArrayList();

    //public void add(QuoteEntry quoteEntry){
        //quoteEntries
   // }

    public void update(QuoteEntry quoteEntry){

    }

    //заполнение таблицы
    public void fill(){
        int tempId;
        String tempLogin;
        String tempQuote;
        String tempSubject;
        Date tempDate;
        String tempTeacher;

        Connection connect = Application.connection();
        try {
            Statement statement = connect.createStatement();

            String query = String.format("SELECT * FROM teacher_quotes");
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                tempId = resultSet.getInt("id");
                tempLogin = resultSet.getString("login_user");
                tempQuote = resultSet.getString("quote");
                tempSubject = resultSet.getString("subject");
                tempDate = resultSet.getDate("date");
                tempTeacher = resultSet.getString("teacher");

                quoteEntries.addAll(new QuoteEntry(tempId, tempLogin, tempQuote, tempSubject, tempDate, tempTeacher));

            }
            connect.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Искл аполнения");
        }
    }

    //заполнение таблицы одного пользователя
    public void fillUser(String userLogin){
        int tempId;
        String tempLogin;
        String tempQuote;
        String tempSubject;
        Date tempDate;
        String tempTeacher;

        Connection connect = Application.connection();
        try {
            Statement statement = connect.createStatement();
            //"SELECT * FROM users WHERE login = '%s' AND password_hash = '%s';", login.getText(), users.hashing(password.getText())
            String query = String.format("SELECT * FROM teacher_quotes WHERE login_user = '%s';", userLogin);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                tempId = resultSet.getInt("id");
                tempLogin = resultSet.getString("login_user");
                tempQuote = resultSet.getString("quote");
                tempSubject = resultSet.getString("subject");
                tempDate = resultSet.getDate("date");
                tempTeacher = resultSet.getString("teacher");

                quoteEntries.addAll(new QuoteEntry(tempId, tempLogin, tempQuote, tempSubject, tempDate, tempTeacher));

            }
            connect.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Искл аполнения таблицы пользователя");
        }
    }



    public ObservableList<QuoteEntry> getQuoteEntries() {
        return quoteEntries;
    }
}

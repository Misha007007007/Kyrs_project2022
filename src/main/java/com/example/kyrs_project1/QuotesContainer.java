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
        String tempQuote;
        String tempTeacher;
        String tempSubject;
        Date tempDate;
        String tempLogin;
        Connection connect = Application.connection();
        try {
            Statement statement = connect.createStatement();

            String query = String.format("SELECT * FROM teacher_quotes");
            ResultSet resultSet = null;
            while (resultSet.next()){
                tempQuote = resultSet.getString("quote");
                tempTeacher = resultSet.getString("teacher");
                tempSubject = resultSet.getString("subject");
                tempDate = resultSet.getDate("date");
                tempLogin = resultSet.getString("login_user");
                tempId = resultSet.getInt("id");
                quoteEntries.addAll(new QuoteEntry(tempId, tempLogin, tempQuote, tempSubject, tempDate, tempTeacher));

            }
            connect.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Искл аполнения");
        }
    }

    public ObservableList<QuoteEntry> getQuoteEntries() {
        return quoteEntries;
    }
}

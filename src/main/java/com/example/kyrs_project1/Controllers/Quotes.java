package com.example.kyrs_project1.Controllers;
//класс со всеми ццитататми
import java.net.URL;
import java.util.*;

import com.example.kyrs_project1.Application;
import com.example.kyrs_project1.QuoteEntry;
import com.example.kyrs_project1.QuotesContainer;
import com.example.kyrs_project1.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Quotes {
    private QuotesContainer quotesContainer = new QuotesContainer();

    private Users user;

    //нопка назад
    @FXML
    private Button back;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //поле дата
    @FXML
    private TableColumn<QuoteEntry, Date> date;

    //поле логин
    @FXML
    private TableColumn<QuoteEntry, String> lognUser;

    //поле цитата
    @FXML
    private TableColumn<QuoteEntry, String> quotes;

    //поле предмет
    @FXML
    private TableColumn<QuoteEntry, String> subject;

    //поле преподаватель
    @FXML
    private TableColumn<QuoteEntry, String> teacher;

    //таблица
    @FXML
    private TableView tabelQuotes;

    //метод назад для пользователя и гостя
    @FXML
    void back(ActionEvent event) {
        if (Application.user == null){
            Application.changeScene("hello-view.fxml");
        }else {
            Application.changeScene("Menu.fxml");
        }
    }

    @FXML
    void initialize() {
        lognUser.setCellValueFactory(new PropertyValueFactory<QuoteEntry, String>("login"));

        subject.setCellValueFactory(new PropertyValueFactory<QuoteEntry, String>("subject"));
        date.setCellValueFactory(new PropertyValueFactory<QuoteEntry, Date>("date"));
        teacher.setCellValueFactory(new PropertyValueFactory<QuoteEntry, String>("teacher"));
        quotes.setCellValueFactory(new PropertyValueFactory<QuoteEntry, String>("content"));

        quotesContainer.fill();
        tabelQuotes.setItems(quotesContainer.getQuoteEntries());
    }
}
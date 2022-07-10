package com.example.kyrs_project1.Controllers;
//класс со всеми ццитататми
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

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

    private Users users;

    //нопка назад
    @FXML
    private Button back;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<QuoteEntry, Date> date;

    @FXML
    private TableColumn<QuoteEntry, String> lognUser;

    @FXML
    private TableColumn<QuoteEntry, String> quotes;

    @FXML
    private TableColumn<QuoteEntry, String> subject;

    @FXML
    private TableColumn<QuoteEntry, String> teacher;
    //таблица
    @FXML
    private TableView tabelQuotes;


    //метод назад
    @FXML
    void back(ActionEvent event) {
        Application.changeScene("Menu.fxml");
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
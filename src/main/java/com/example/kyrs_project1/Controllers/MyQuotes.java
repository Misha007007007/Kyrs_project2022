package com.example.kyrs_project1.Controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.kyrs_project1.Application;
import com.example.kyrs_project1.QuoteEntry;
import com.example.kyrs_project1.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MyQuotes {
    Users user;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Back;

    @FXML
    private Button add;

    @FXML
    private Button change;

    @FXML
    private TableColumn<QuoteEntry, Date> data;

    @FXML
    private Button delete;

    @FXML
    private TableColumn<QuoteEntry, String> login;

    @FXML
    private TableView<QuoteEntry> myQotesTabel;

    @FXML
    private TableColumn<QuoteEntry, String> quote;

    @FXML
    private TableColumn<QuoteEntry, String> subject;

    @FXML
    private TableColumn<QuoteEntry, String> teacher;

    @FXML
    void add(ActionEvent event) {
        Application.changeScene("addition.fxml");
    }

    @FXML
    void change(ActionEvent event) {
        Application.changeScene("changeQuote.fxml");
    }

    @FXML
    void delete(ActionEvent event) {
        Application.changeScene("deleteQuote.fxml");
    }


    @FXML
    void back(ActionEvent event) {
        Application.changeScene("Menu.fxml");
    }



    @FXML
    void initialize() {
        user = Application.user;

        login.setCellValueFactory(new PropertyValueFactory<QuoteEntry, String>("login"));
        subject.setCellValueFactory(new PropertyValueFactory<QuoteEntry, String>("subject"));
        data.setCellValueFactory(new PropertyValueFactory<QuoteEntry, Date>("date"));
        teacher.setCellValueFactory(new PropertyValueFactory<QuoteEntry, String>("teacher"));
        quote.setCellValueFactory(new PropertyValueFactory<QuoteEntry, String>("content"));

        myQotesTabel.setItems(user.getQuotesContainer().getQuoteEntries());
    }
}
package com.example.kyrs_project1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

public class Application extends javafx.application.Application {

    private static Stage thisStage;

    @Override
    public void start(Stage stage) throws IOException {
        thisStage = stage;
        stage.setResizable(false);

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Великие цитаты великих людей");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(String fxml) {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource(fxml)));
            thisStage.getScene().setRoot(parent);
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public static Connection connection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_1959_kyrspr",
                    "std_1959_kyrspr", "1231231234");

            return connection;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }
}
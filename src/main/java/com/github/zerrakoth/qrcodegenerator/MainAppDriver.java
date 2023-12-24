package com.github.zerrakoth.qrcodegenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainAppDriver extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainAppDriver.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        URL applicationIconURL = MainAppDriver.class.getResource("/com/github/zerrakoth/qrcodegenerator/appIcon.png");
        Image applicationIcon = new Image(applicationIconURL.toString());

        stage.setTitle("QR Code Generator");
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}
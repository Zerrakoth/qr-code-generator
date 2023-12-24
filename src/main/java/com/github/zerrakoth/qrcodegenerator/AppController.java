package com.github.zerrakoth.qrcodegenerator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AppController
{
    @FXML
    private VBox vBox;

    @FXML
    private HBox topHBox;

    @FXML
    private Label errorText;

    @FXML
    private HBox middleHBox;

    @FXML
    private ImageView image;

    @FXML
    private HBox bottomHBox;

    @FXML
    private ButtonBar buttonBar;

    @FXML
    private TextField textField;

    @FXML
    private Button button;

    @FXML
    private void onButtonClick()
    {
    }

    public String getUserInput()
    {
        return textField.getText();
    }
}
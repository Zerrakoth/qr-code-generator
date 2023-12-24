package com.github.zerrakoth.qrcodegenerator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

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
        // If the error text is already visible when the button is clicked, make it invisible.
        if (errorText.isVisible())
        {
            errorText.setVisible(false);
        }

        // When the program is opened or ran, don't have focus on the TextField so the user can see the promptText.
        button.requestFocus();

        String userInput = getUserInput();
        userInput = userInput.trim().toLowerCase();

        // Check to verify the user entered a proper URL in the TextField box.
        if (userInput.startsWith("http://") || userInput.startsWith("https://"))
        {
            String apiURL = "https://api.qrserver.com/v1/create-qr-code/?data=" + userInput + "&size=250x250";

            try
            {
                // Call the API.
                URL url = new URL(apiURL);
                InputStream inputStream = url.openStream();

                // Create a temporary file that contains the .png file from the API.
                Path tempImage = Files.createTempFile("tempQRCode", ".png");
                Files.copy(inputStream, tempImage, StandardCopyOption.REPLACE_EXISTING);

                inputStream.close();

                Image newImageObj = new Image(tempImage.toUri().toString());
                image.setImage(newImageObj);

                // Delete the temporary image file.
                Files.deleteIfExists(tempImage);
            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.out.println("Possible issue with URL or API.");

                // Remove QR Code image if there is one on screen.
                image.setImage(null);

                errorText.setVisible(true);
                errorText.setText("ERROR - Please try again");
            }
        }
        else
        {
            System.out.println("Entered an invalid URL, most likely didn't start with http:// or https://");

            // Remove QR Code image if there is one on screen.
            image.setImage(null);

            errorText.setVisible(true);
            errorText.setText("ERROR - Invalid URL entered.");
        }
    }

    public String getUserInput()
    {
        return textField.getText();
    }
}
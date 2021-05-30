package presentation.window;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WindowView {

    private final WindowViewModel windowViewModel = new WindowViewModel();

    @FXML
    private TextField textField;

    @FXML
    private Button button;

    @FXML
    private Label encryptedLabel;

    @FXML
    private Label decodedLabel;

    @FXML
    void initialize() {
        initButton();
        bind();
    }

    private void initButton() {
        button.setOnAction(event -> {
            String message = textField.getText();
            if (message != null) {
                textField.setText("");
                windowViewModel.encAndDec(message);
            }
        });
    }

    private void bind() {
        encryptedLabel.textProperty().bind(windowViewModel.getEncryptedProperty());
        decodedLabel.textProperty().bind(windowViewModel.getDecodedProperty());
    }
}

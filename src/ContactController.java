import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ContactController {
    public TextField name, email;
    public TextArea message;
    public Button sendButton;
    public Label labelSend;

    public void clickSend() throws IOException {
        if (name.getText().isEmpty() || email.getText().isEmpty() || message.getText().isEmpty()){
            labelSend.setText("Fill all fields out!");
            labelSend.setTextFill(Color.RED);
            return;
        }

        labelSend.setText("Your message is successfully recorded!");
        labelSend.setTextFill(Color.GREEN);

        File file = new File("src/replies.txt");

        Main.replyCount += 1;

        String text = "";
        text += Main.replyCount + "-reply: ";
        text += "name=\"" + name.getText() + "\" ";
        text += "email=\"" + email.getText() + "\" ";
        text += "message=\"" + message.getText() + "\"\n";

        Files.write(Paths.get(file.getPath()), text.getBytes(), StandardOpenOption.APPEND);
    }

    public void initialize(){
        name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                name.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });
    }
}

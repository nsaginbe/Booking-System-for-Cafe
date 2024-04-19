import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BookingController {
    public TextField name, email, phone, time;
    public DatePicker date;
    public Slider amount;
    public Button bookButton;
    public Label labelBook;
    public TextArea requests;

    public void checkTime(ActionEvent event){
        TextField time = (TextField)event.getSource();
        if (!time.getText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")){
            time.setText("");
        }
    }

    public void bookTable() throws IOException {
        if (name.getText().isEmpty() || email.getText().isEmpty() || date.getEditor().getText().isEmpty() || time.getText().isEmpty()){
            labelBook.setText("Fill all required fields out!");
            labelBook.setTextFill(Color.RED);
            return;
        }

        labelBook.setText("Your data is successfully recorded!");
        labelBook.setTextFill(Color.GREEN);

        File file = new File("src/bookings.txt");

        Main.bookingCount += 1;

        String text = "";
        text += Main.bookingCount + "-book: ";
        text += "name=\"" + name.getText() + "\" ";
        text += "email=\"" + email.getText() + "\" ";
        text += "phone=\"" + phone.getText() + "\" ";
        text += "date=\"" + date.getEditor().getText() + "\" ";
        text += "time=\"" + time.getText() + "\" ";
        text += "amount=\"" + (int)amount.getValue() + "\" ";
        text += "requests=\"" + requests.getText() + "\"\n";

        Files.write(Paths.get(file.getPath()), text.getBytes(), StandardOpenOption.APPEND);
    }

    public void initialize(){
        name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                name.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });

        phone.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 11){
                phone.setText(phone.getText().substring(0, 11));
            }
            if (!newValue.matches("\\d*")) {
                phone.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        time.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 5){
                time.setText(time.getText().substring(0, 5));
            }
        });

        amount.valueProperty().addListener((observable, oldValue, newValue) -> amount.setValue(Math.round(newValue.doubleValue())));

        date.setStyle("-fx-font-size: 20px; -fx-font-family: Serif");
    }
}

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Orders {
    public Parent ordersPage() throws IOException {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefWidth(800.0);
        scrollPane.setPrefHeight(575.0);

        VBox vBox = new VBox(20.0);
        vBox.setPrefWidth(785.0);
        vBox.getChildren().add(new Region());

        String content = new String(Files.readAllBytes(Paths.get("src/bookings.txt")));
        System.out.println(content);
        Scanner sc = new Scanner(Paths.get("src/bookings.txt"));

        for (int i = 1; i <= Main.bookingCount; i++){
            String s = sc.nextLine();
            String name = s.substring(s.indexOf("name=\"") + 6, s.indexOf("\" email"));
            String email = s.substring(s.indexOf("email=\"") + 7, s.indexOf("\" phone"));
            String date = s.substring(s.indexOf("date=\"") + 6, s.indexOf("\" time"));

            // Booking i
            HBox headBox = new HBox();
            headBox.setAlignment(Pos.CENTER);
            Label headLabel = new Label("Booking " + i + ":");
            headLabel.setStyle("-fx-font-size: 25px; -fx-font-family: Serif; -fx-font-weight: bold;");
            headBox.getChildren().addAll(headLabel);

            // Name
            HBox nameBox1 = new HBox(25.0);
            HBox nameBox2 = new HBox(25.0);

            Label nameLabel = new Label("Name");
            TextField nameField = new TextField();
            nameField.setPromptText(name);
            nameField.setPrefWidth(300.0);
            nameField.setFocusTraversable(false);
            nameLabel.setStyle("-fx-font-size: 20px; -fx-font-family: Serif; -fx-font-weight: bold;");
            nameField.setStyle("-fx-font-size: 20px; -fx-font-family: Serif;");

            nameBox1.getChildren().addAll(new Region(), nameLabel);
            nameBox2.getChildren().addAll(new Region(), nameField);

            // Email
            HBox emailBox1 = new HBox(25.0);
            HBox emailBox2 = new HBox(25.0);

            Label emailLabel = new Label("Email");
            TextField emailField = new TextField();
            emailField.setPromptText(email);
            emailField.setPrefWidth(300.0);
            emailField.setFocusTraversable(false);
            emailLabel.setStyle("-fx-font-size: 20px; -fx-font-family: Serif; -fx-font-weight: bold;");
            emailField.setStyle("-fx-font-size: 20px; -fx-font-family: Serif;");

            emailBox1.getChildren().addAll(new Region(), emailLabel);
            emailBox2.getChildren().addAll(new Region(), emailField);

            // Date
            HBox dateBox1 = new HBox(25.0);
            HBox dateBox2 = new HBox(25.0);

            Label dateLabel = new Label("Date");
            DatePicker dateField = new DatePicker();
            dateField.setPromptText(date);
            dateField.setPrefWidth(300.0);
            dateField.setFocusTraversable(false);
            dateLabel.setStyle("-fx-font-size: 20px; -fx-font-family: Serif; -fx-font-weight: bold;");
            dateField.setStyle("-fx-font-size: 20px; -fx-font-family: Serif;");

            dateBox1.getChildren().addAll(new Region(), dateLabel);
            dateBox2.getChildren().addAll(new Region(), dateField);

            vBox.getChildren().addAll(headBox, nameBox1, nameBox2, emailBox1, emailBox2, dateBox1, dateBox2, new Region());

            int finalI = i;
            nameField.setOnAction(e -> {
                String newText = nameField.getText();
                nameField.setPromptText(newText);
            });

            emailField.setOnAction(e -> {
                String newText = emailField.getText();
                emailField.setPromptText(newText);
            });

            dateField.setOnAction(e -> {
                String newText = dateField.getEditor().getText();
                dateField.setPromptText(newText);
            });
        }

        if (Main.bookingCount == 0){
            Label empty = new Label("No bookings have been ordered!");
            ImageView pic = new ImageView("pics/x.png");
            pic.setFitWidth(50.0);
            pic.setFitHeight(50.0);
            empty.setContentDisplay(ContentDisplay.TOP);
            empty.setGraphic(pic);
            empty.setStyle("-fx-font-size: 20px; -fx-font-family: Serif; -fx-font-weight: bold;");

            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().add(empty);

            vBox.getChildren().addAll(hBox);
        }

        scrollPane.setContent(vBox);
        return scrollPane;
    }
}

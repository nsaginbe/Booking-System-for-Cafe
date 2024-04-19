import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends Application {
    private BorderPane borderPane;
    public static int bookingCount = 0;
    public static int replyCount = 0;

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) throws IOException {
        borderPane = new BorderPane();

        MenuBar leftBar = new MenuBar();
        ClickableMenu homeRef = new ClickableMenu("Home");
        ClickableMenu ordersRef = new ClickableMenu("Orders");

        leftBar.getMenus().addAll(homeRef, ordersRef);

        MenuBar rightBar = new MenuBar();
        ClickableMenu bookingRef = new ClickableMenu("Booking");
        ClickableMenu galleryRef = new ClickableMenu("Gallery");
        ClickableMenu menuRef = new ClickableMenu("Menu");
        ClickableMenu contactRef = new ClickableMenu("Contact");

        rightBar.getMenus().addAll(bookingRef, galleryRef, menuRef, contactRef);

        Region spacer = new Region();
        spacer.getStyleClass().add("menu-bar");
        HBox.setHgrow(spacer, Priority.SOMETIMES);
        HBox menuBars = new HBox(leftBar, spacer, rightBar);

        borderPane.setTop(menuBars);
        homePage(borderPane);

        Scene scene = new Scene(borderPane, 800, 600);

        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene.getStylesheets().add("style.css");

        stage.setTitle("Cafe");
        stage.setScene(scene);
        stage.show();

        homeRef.setOnAction(event -> {
            try {
                homePage(borderPane);
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        });

        bookingRef.setOnAction(event -> {
            try {
                bookingPage(borderPane);
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        });

        menuRef.setOnAction(event -> {
            try {
                menuPage(borderPane);
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        });

        galleryRef.setOnAction(event -> {
            try {
                galleryPage(borderPane);
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        });

        contactRef.setOnAction(event -> {
            try {
                contactPage(borderPane);
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        });

        ordersRef.setOnAction(event -> {
            try {
                ordersPage(borderPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        File file1 = new File("src/bookings.txt");
        try (PrintWriter pw = new PrintWriter(file1)){
            pw.print("");
        }

        File file2 = new File("src/replies.txt");
        try (PrintWriter pw = new PrintWriter(file2)){
            pw.print("");
        }
    }

    public void homePage(BorderPane borderPane) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomeFXML.fxml"));
        Parent root = fxmlLoader.load();
        borderPane.setCenter(root);
    }

    public void bookingPage(BorderPane borderPane) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BookingFXML.fxml"));
        Parent root = fxmlLoader.load();
        borderPane.setCenter(root);
    }

    public void menuPage(BorderPane borderPane) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuFXML.fxml"));
        Parent root = fxmlLoader.load();
        borderPane.setCenter(root);
    }

    public void galleryPage(BorderPane borderPane) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GalleryFXML.fxml"));
        Parent root = fxmlLoader.load();
        borderPane.setCenter(root);
    }

    public void contactPage(BorderPane borderPane) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContactFXML.fxml"));
        Parent root = fxmlLoader.load();
        borderPane.setCenter(root);
    }

    public void ordersPage(BorderPane borderPane) throws IOException {
        borderPane.setCenter(new Orders().ordersPage());
    }
}
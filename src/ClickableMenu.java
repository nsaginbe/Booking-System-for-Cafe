import javafx.css.StyleClass;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class ClickableMenu extends Menu {
    private final Label label;

    public ClickableMenu() {
        this("");
    }

    public ClickableMenu(String title) {

        MenuItem dummyItem = new MenuItem();
        dummyItem.setVisible(false);
        getItems().add(dummyItem);

        this.label = new Label();
        label.setText(title);
        label.setOnMouseClicked(event -> dummyItem.fire());

        label.setStyle("-fx-text-fill: black");

        setGraphic(label);
    }

    public String getTitle() {
        return label.getText();
    }

    public void setTitle(String text) {
        label.setText(text);
    }
}
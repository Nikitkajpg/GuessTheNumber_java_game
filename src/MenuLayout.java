import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuLayout {
    Label nameLabel;
    Button newGameButton, settingsButton, exitButton;
    VBox mainVBox, addVBox;

    public MenuLayout(Stage stage) {
        nameLabel = new Label("Угадай число");
        newGameButton = new Button("Новая игра");
        settingsButton = new Button("Настройки");
        exitButton = new Button("Выход");

        addVBox = new VBox(newGameButton, settingsButton, exitButton);
        addVBox.setId("addVBox");
        mainVBox = new VBox(nameLabel, addVBox);
        mainVBox.setId("mainVBox");

        mainVBox.getStylesheets().add(getClass().getResource("css/menu.css").toString());

        newGameButton.setOnAction(event -> stage.getScene().setRoot(Main.gameLayout.getLayout()));
        settingsButton.setOnAction(event -> stage.getScene().setRoot(Main.settingsLayout.getLayout()));
        exitButton.setOnAction(event -> System.exit(0));
    }

    public VBox getLayout() {
        return mainVBox;
    }
}

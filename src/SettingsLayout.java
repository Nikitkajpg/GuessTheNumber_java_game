import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SettingsLayout {
    Button fullScreenButton, backButton;
    VBox vBox;

    public SettingsLayout(Stage stage) {
        fullScreenButton = new Button("Оконный режим");
        backButton = new Button("Назад");

        fullScreenButton.setOnAction(event -> {
            if (fullScreenButton.getText().equals("На весь экран")) {
                stage.setFullScreen(true);
                fullScreenButton.setText("Оконный режим");
            } else if (fullScreenButton.getText().equals("Оконный режим")) {
                stage.setFullScreen(false);
                fullScreenButton.setText("На весь экран");
            }
        });
        backButton.setOnAction(event -> stage.getScene().setRoot(Main.menuLayout.getLayout()));

        vBox = new VBox(fullScreenButton, backButton);
        vBox.getStylesheets().add(getClass().getResource("css/settings.css").toString());
    }

    public VBox getLayout() {
        return vBox;
    }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Main extends Application {
    Scene scene;
    static MenuLayout menuLayout;
    static GameLayout gameLayout;
    static SettingsLayout settingsLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        menuLayout = new MenuLayout(primaryStage);
        gameLayout = new GameLayout(primaryStage);
        settingsLayout = new SettingsLayout(primaryStage);
        scene = new Scene(menuLayout.getLayout());

        scene.getStylesheets().add(getClass().getResource("css/all.css").toString());
        primaryStage.setTitle("Угадай число!");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("img/four.jpg"));
        primaryStage.setResizable(true);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.show();
    }
}

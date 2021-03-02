import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Main extends Application {
    Scene scene;
    static MenuLayout menuLayout;
    static GameLayout gameLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        menuLayout = new MenuLayout(primaryStage);
        gameLayout = new GameLayout(primaryStage);
        scene = new Scene(menuLayout.getLayout());

        scene.getStylesheets().add(getClass().getResource("all.css").toString());
        primaryStage.setTitle("Угадай число!");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("four.jpg"));
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.show();
    }
}

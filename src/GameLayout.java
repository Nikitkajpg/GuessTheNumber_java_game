import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameLayout {
    String correctNumber, moreNumber, lessNumber;

    Label fromLabel, toLabel, enterNumberLabel, label;
    TextField fromTF, toTF, enterTF;
    Button guessButton, backButton, goButton, backgroundButton;
    VBox vBox;
    FlowPane topFlowPane, centerFlowPane;
    StackPane stackPane;

    public GameLayout(Stage stage) {
        correctNumber = "Правильно!";
        moreNumber = "Неправильно! Ведите большее число";
        lessNumber = "Неправильно! Ведите меньшее число";

        fromLabel = new Label("Введите интервал: от");
        toLabel = new Label("до");
        enterNumberLabel = new Label("Загаданное число:");
        label = new Label("");

        fromTF = new TextField();
        toTF = new TextField();
        enterTF = new TextField();

        backgroundButton = new Button();
        backgroundButton.setId("bButton");
        guessButton = new Button("Угадать!");
        backButton = new Button("Выйти в меню");
        goButton = new Button("Начать");

        topFlowPane = new FlowPane(fromLabel, fromTF, toLabel, toTF);
        centerFlowPane = new FlowPane(enterNumberLabel, enterTF, guessButton);

        vBox = new VBox(topFlowPane, goButton, centerFlowPane, label, backButton);

        stackPane = new StackPane(backgroundButton, vBox);
        stackPane.getStylesheets().add(getClass().getResource("css/game.css").toString());

        disSecondPart(true);

        goButton.setOnAction(event -> {
            if (isInt(fromTF.getText()) && isInt(toTF.getText()) && fromTF.getText().length() < 11 && toTF.getText().length() < 11) {
                logic();
                disSecondPart(false);
                disFirstPart(true);
                enterTF.clear();
                label.setText("");
            } else {
                showDialog();
            }
        });
        backButton.setOnAction(event -> {
            stage.getScene().setRoot(Main.menuLayout.getLayout());
            enterTF.clear();
            toTF.clear();
            fromTF.clear();
            label.setText("");
            disFirstPart(false);
            disSecondPart(true);
        });
    }

    private void showDialog() {
        label.setText("Введите число меньше миллиарда");
    }

    private void logic() {
        int key, fromNum, toNum;

        fromNum = Integer.parseInt(fromTF.getText());
        toNum = Integer.parseInt(toTF.getText());

        if (fromNum < toNum) {
            key = fromNum + (int)(Math.random() * (toNum - fromNum));
        } else if (fromNum > toNum) {
            key = toNum + (int) (Math.random() * (fromNum - toNum));
        } else {
            key = fromNum;
        }

        guessButton.setOnAction(event -> {
            if (isInt(enterTF.getText()) && enterTF.getText().length() < 11) {
                int guessKey = Integer.parseInt(enterTF.getText());

                if (guessKey > key) {
                    label.setText("Попробуйте меньшее число");
                } else if (guessKey < key) {
                    label.setText("Попробуйте большее число");
                } else {
                    label.setText("Вы угадали");
                    disFirstPart(false);
                    disSecondPart(true);
                }
            } else {
                showDialog();
            }
        });
    }

    private void disFirstPart(boolean dis) {
        topFlowPane.setDisable(dis);
        goButton.setDisable(dis);
    }

    private void disSecondPart(boolean dis) {
        centerFlowPane.setDisable(dis);
    }

    private boolean isInt(String strNum) {
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public StackPane getLayout() {
        return stackPane;
    }
}

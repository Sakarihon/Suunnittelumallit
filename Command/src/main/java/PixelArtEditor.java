import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelArtEditor extends Application {

    private static final int GRID_SIZE = 8;
    private static final int CELL_SIZE = 50;

    private final boolean[][] pixels = new boolean[GRID_SIZE][GRID_SIZE];
    private final Rectangle[][] cells = new Rectangle[GRID_SIZE][GRID_SIZE];

    private int cursorRow = 0;
    private int cursorCol = 0;

    @Override
    public void start(Stage stage) {

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {

                Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.GRAY);

                cells[row][col] = rect;

                StackPane cell = new StackPane(rect);
                gridPane.add(cell, col, row);
            }
        }

        updateGrid();

        Button generateButton = new Button("Create Code");

        Command generateCodeCommand = new GenerateCodeCommand(pixels);

        generateButton.setOnAction(e -> generateCodeCommand.execute());

        BorderPane root = new BorderPane();
        root.setCenter(gridPane);
        root.setBottom(generateButton);

        BorderPane.setAlignment(generateButton, Pos.CENTER);

        Scene scene = new Scene(root, 500, 500);

        scene.setOnKeyPressed(event -> {

            Command command = null;

            switch (event.getCode()) {

                case UP:
                    command = new MoveCursorUpCommand(this);
                    break;

                case DOWN:
                    command = new MoveCursorDownCommand(this);
                    break;

                case LEFT:
                    command = new MoveCursorLeftCommand(this);
                    break;

                case RIGHT:
                    command = new MoveCursorRightCommand(this);
                    break;

                case SPACE:
                    command = new TogglePixelCommand(this);
                    break;
            }

            if (command != null) {
                command.execute();
                updateGrid();
            }
        });

        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.show();

        root.setFocusTraversable(true);
        root.requestFocus();
    }

    public void updateGrid() {

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {

                Rectangle rect = cells[row][col];

                if (pixels[row][col]) {
                    rect.setFill(Color.BLACK);
                } else {
                    rect.setFill(Color.WHITE);
                }

                if (row == cursorRow && col == cursorCol) {
                    rect.setStroke(Color.RED);
                    rect.setStrokeWidth(3);
                } else {
                    rect.setStroke(Color.GRAY);
                    rect.setStrokeWidth(1);
                }
            }
        }
    }

    public void moveUp() {
        if (cursorRow > 0) {
            cursorRow--;
        }
    }

    public void moveDown() {
        if (cursorRow < GRID_SIZE - 1) {
            cursorRow++;
        }
    }

    public void moveLeft() {
        if (cursorCol > 0) {
            cursorCol--;
        }
    }

    public void moveRight() {
        if (cursorCol < GRID_SIZE - 1) {
            cursorCol++;
        }
    }

    public void togglePixel() {
        pixels[cursorRow][cursorCol] =
                !pixels[cursorRow][cursorCol];
    }

    public static void main(String[] args) {
        launch();
    }
}
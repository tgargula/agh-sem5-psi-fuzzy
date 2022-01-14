package pl.edu.student.tgargula.fuzzify;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/index.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets()
                .add(Objects
                        .requireNonNull(this.getClass().getResource("/styles.css"))
                        .toExternalForm()
                );
        scene.getRoot().getStyleClass().add("scene");
        stage.setScene(scene);

        stage.setTitle("Fuzzy tank demo");

        stage.show();
    }

}

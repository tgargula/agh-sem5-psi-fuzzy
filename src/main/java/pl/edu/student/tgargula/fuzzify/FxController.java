package pl.edu.student.tgargula.fuzzify;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FxController {
    private final Queue<Bullet> leftBullets = new ConcurrentLinkedQueue<>(List.of(new Bullet()));
    private final Queue<Bullet> rightBullets = new ConcurrentLinkedQueue<>();

    @FXML
    public AnchorPane anchorPane;
    @FXML
    public Button addLeftBulletButton;
    @FXML
    public Button addRightBulletButton;

    @FXML
    public void initialize() {
        addLeftBulletButton.setLayoutX(550);
        addLeftBulletButton.setLayoutY(20);
        addRightBulletButton.setLayoutX(550);
        addRightBulletButton.setLayoutY(80);
        new Engine(anchorPane, leftBullets, rightBullets).run();
    }

    @FXML
    public void addLeftBullet() {
        leftBullets.add(new Bullet());
    }

    @FXML
    public void addRightBullet() {
        rightBullets.add(new Bullet());
    }
}

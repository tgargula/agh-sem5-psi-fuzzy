package pl.edu.student.tgargula.fuzzify;

import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class Engine implements Runnable {
    private final Fuzzy fuzzy = new Fuzzy("src/main/resources/driver.fcl");
    private final AnchorPane pane;
    private final Tank tank = new Tank();
    private final Queue<Bullet> leftBullets;
    private final Queue<Bullet> rightBullets;

    public Engine(AnchorPane pane, Queue<Bullet> leftBullets, Queue<Bullet> rightBullets) {
        this.pane = pane;
        this.fuzzy.showFuzzyCharts();
        this.leftBullets = leftBullets;
        this.rightBullets = rightBullets;
    }

    @Override
    public void run() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new AnimationFrame(fuzzy, pane, tank, leftBullets, rightBullets));
            }
        }, 0, 33); // ~30 fps
    }
}

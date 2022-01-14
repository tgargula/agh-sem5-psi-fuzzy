package pl.edu.student.tgargula.fuzzify;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Queue;

public class AnimationFrame implements Runnable {
    private final Fuzzy fuzzy;
    private final AnchorPane pane;
    private final Tank tank;
    private final Queue<Bullet> leftBullets;
    private final Queue<Bullet> rightBullets;

    public AnimationFrame(Fuzzy fuzzy, AnchorPane pane, Tank tank, Queue<Bullet> leftBullets, Queue<Bullet> rightBullets) {
        this.fuzzy = fuzzy;
        this.pane = pane;
        this.tank = tank;
        this.leftBullets = leftBullets;
        this.rightBullets = rightBullets;
    }

    private double getLeftDistance() {
        if (leftBullets.size() == 0) return 100;
        return leftBullets.peek().getDistance();
    }

    private double getRightDistance() {
        if (rightBullets.size() == 0) return 100;
        return rightBullets.peek().getDistance();
    }

    @Override
    public void run() {
        fuzzy.setVariables(getLeftDistance(), getRightDistance(), tank.getPosition());
        ImageView tankImageView = tank.getImageView();
        tankImageView.setX(10);
        tankImageView.setY(tank.getPosition());
        pane.getChildren().clear();
        pane.getChildren().add(tankImageView);
        leftBullets.forEach(bullet -> {
            ImageView bulletImageView = bullet.getImageView();
            bulletImageView.setX(5 * bullet.getDistance());
            bulletImageView.setY(20);
            pane.getChildren().add(bulletImageView);
        });
        rightBullets.forEach(bullet -> {
            ImageView bulletImageView = bullet.getImageView();
            bulletImageView.setX(5 * bullet.getDistance());
            bulletImageView.setY(80);
            pane.getChildren().add(bulletImageView);
        });
        tank.move(fuzzy.getSpeed());
        leftBullets.forEach(Bullet::step);
        rightBullets.forEach(Bullet::step);
        leftBullets.stream().filter(Bullet::shouldUnregister).forEach(leftBullets::remove);
        rightBullets.stream().filter(Bullet::shouldUnregister).forEach(rightBullets::remove);
//        fuzzy.showDefuzzyChart();
    }
}

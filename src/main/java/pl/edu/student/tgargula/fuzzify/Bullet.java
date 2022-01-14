package pl.edu.student.tgargula.fuzzify;

import javafx.scene.image.ImageView;

public class Bullet implements Displayable {
    private final ImageView imageView = new ImageView("/bullet.png");
    private int distance = 100;

    public void step() {
        this.distance -= 1;
    }

    public boolean shouldUnregister() {
        return this.distance <= 0;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }
}

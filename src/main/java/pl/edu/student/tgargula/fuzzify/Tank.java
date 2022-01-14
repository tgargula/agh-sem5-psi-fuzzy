package pl.edu.student.tgargula.fuzzify;

import javafx.scene.image.ImageView;

public class Tank implements Displayable {
    private final ImageView imageView = new ImageView("/tank.png");
    private int position = 50;

    @Override
    public ImageView getImageView() {
        return imageView;
    }

    public int getPosition() {
        return position;
    }

    public void move(int speed) {
        if (position + speed > 100) {
            position = 100;
            return;
        }
        if (position + speed < 0) {
            position = 0;
            return;
        }
        position += speed;
    }
}

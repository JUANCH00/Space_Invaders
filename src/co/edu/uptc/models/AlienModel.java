package co.edu.uptc.models;

import java.awt.Image;
import java.util.Random;

import co.edu.uptc.pojos.ElementPojo;
import co.edu.uptc.utils.Utils;
import co.edu.uptc.views.DashBoard.DirectionEnum;

public class AlienModel {
    private int speed;
    private ElementPojo alienPojo = new ElementPojo();
    private DirectionEnum direction;
    private boolean running = false;
    private boolean isVisible;

    public void setSpeedDirection() {
        Random random = new Random();
        setSpeed(random.nextInt(5) + 90);
        setDirection(random.nextInt(2));
    }

    public void stop() {
        this.running = false;
    }

    public ElementPojo getAlienPojo() {
        return alienPojo;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(int direction) {
        switch (getX()) {
            case 1:
                this.direction = DirectionEnum.RIGHT;
                break;

            case 550:
                if (direction == 1) {
                    this.direction = DirectionEnum.RIGHT;
                } else {
                    this.direction = DirectionEnum.LEFT;
                }
                break;
            case 950:
                this.direction = DirectionEnum.LEFT;
                break;
        }

    }

    public void setImage(Image image) {
        alienPojo.setImage(image);
    }

    public int getX() {
        return alienPojo.getX();
    }

    public int getY() {
        return alienPojo.getY();

    }

    public int getWidth() {
        return alienPojo.getWidth();
    }

    public int getHeight() {
        return alienPojo.getHeight();
    }

    public boolean getVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public void startElement() {
        this.running = true;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    Utils.sleep(speed);
                    move();
                }
            }
        });
        thread.start();
    }

    public void move() {
        if (direction == DirectionEnum.LEFT) {
            left();
        }
        if (direction == DirectionEnum.RIGHT) {
            right();
        }
    }

    public void left() {
        alienPojo.setX(alienPojo.getX() - 10);
        if (alienPojo.getX() <= 1) {
            setVisible(false);
        }
    }

    public void right() {
        alienPojo.setX(alienPojo.getX() + 10);
        if (alienPojo.getX() >= 950) {
            setVisible(false);
        }
    }
}

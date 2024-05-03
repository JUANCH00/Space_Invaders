package co.edu.uptc.models;

import java.awt.Image;

import co.edu.uptc.pojos.ElementPojo;
import co.edu.uptc.utils.Utils;

public class LaserModel {
    private int speed = 100;
    private ElementPojo laserPojo = new ElementPojo();
    private boolean running = false;

    public LaserModel(ShipModel shipModel) {
        laserPojo.setX(shipModel.getX() - 20);
        laserPojo.setY(shipModel.getY() - 50);
        laserPojo.setPadding(10);
        laserPojo.setHeight(180);
        laserPojo.setWidth(80);
    }

    public void stop() {
        this.running = false;
    }

    public ElementPojo getLaserPojo() {
        return laserPojo;
    }

    public void setImage(Image image) {
        laserPojo.setImage(image);
    }

    public int getX() {
        return laserPojo.getX();
    }

    public int getY() {
        return laserPojo.getY();

    }

    public int getWidth() {
        return laserPojo.getWidth();
    }

    public int getHeight() {
        return laserPojo.getHeight();
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
        up();
    }

    public void up() {
        laserPojo.setY(laserPojo.getY() - 10);
    }
}

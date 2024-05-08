package co.edu.uptc.models;

import java.awt.Image;

import co.edu.uptc.pojos.ElementPojo;
import co.edu.uptc.utils.Utils;
import co.edu.uptc.utils.UtilsProperties;

public class LaserModel {
    private UtilsProperties properties;
    private int speed;
    private ElementPojo laserPojo = new ElementPojo();
    private boolean running = false;
    private boolean isVisible = false;

    public LaserModel(ShipModel shipModel) {
        properties = new UtilsProperties();
        speed = properties.getSleepGame() - 80;
        laserPojo.setX(shipModel.getX() - 18);
        laserPojo.setY(shipModel.getY() - 25);
        laserPojo.setPadding(properties.getPadding());
        laserPojo.setHeight(properties.getLaserHeigth());
        laserPojo.setWidth(properties.getLaserWidth());
        isVisible = true;
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
        up();
    }

    public void up() {
        laserPojo.setY(laserPojo.getY() - 10);
        if (laserPojo.getY() <= 1) {
            setVisible(false);
        }
    }
}

package co.edu.uptc.models;

import java.util.ArrayList;
import java.util.Random;

import co.edu.uptc.utils.Utils;
import co.edu.uptc.utils.UtilsProperties;

public class ManagerAlien {
    private AlienModel alien;
    private ArrayList<AlienModel> aliens;
    private boolean running = false;
    private int speed;
    private UtilsProperties properties;

    public ManagerAlien() {
        aliens = new ArrayList<>();
        properties = new UtilsProperties();
    }

    public synchronized void addAliens() {
        running = true;
        Random random = new Random();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    aliens.add(generateAlien());
                    speed = random.nextInt(2) == 0 ? 1000 : 2000;
                    Utils.sleep(speed);
                }
            }
        });
        thread.start();
    }

    public AlienModel generateAlien() {
        Random random = new Random();
        alien = new AlienModel();
        alien.setSpeed(random.nextInt(51) + 10);
        alien.setDirection(random.nextInt(2));
        alien.getAlienPojo().setX(getPosition(random.nextInt(3)));
        alien.getAlienPojo().setY(random.nextInt(2) == 0 ? 50 : 150);
        alien.getAlienPojo().setPadding(10);
        alien.getAlienPojo().setHeight(random.nextInt(21) + 70);
        alien.getAlienPojo().setWidth(random.nextInt(31) + 170);
        alien.setVisible(true);
        alien.setSpeedDirection();
        alien.startElement();
        return alien;
    }

    public int getPosition(int num) {
        int pos = 0;
        switch (num) {
            case 0:
                pos = properties.getLeftPos();
                break;
            case 1:
                pos = properties.getCenterPos();
                break;

            case 2:
                pos = properties.getRightPos();
                break;
        }
        return pos;
    }

    public void stop() {
        this.running = false;
    }

    public boolean getRunning() {
        return running;
    }

    public synchronized ArrayList<AlienModel> getAliens() {
        return aliens;
    }

    public boolean getRunnig() {
        return this.running;
    }
}

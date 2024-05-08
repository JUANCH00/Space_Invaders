package co.edu.uptc.models;

import java.util.ArrayList;

import co.edu.uptc.pojos.ElementPojo;
import co.edu.uptc.presenters.ContractPlay;
import co.edu.uptc.utils.Utils;
import co.edu.uptc.utils.UtilsProperties;

public class ManagerModel implements ContractPlay.Model {

    private int martiansEliminated;
    private ShipModel shipModel;
    private LaserModel laserModel;
    private ManagerAlien managerAlien;
    private ManagerLaser managerLaser;
    private ArrayList<AlienModel> aliens;
    private ContractPlay.Presenter presenter;
    private UtilsProperties properties;

    @Override
    public void setPresenter(ContractPlay.Presenter presenter) {
        this.presenter = presenter;
    }

    public ManagerModel() {
        properties = new UtilsProperties();
        managerAlien = new ManagerAlien();
        managerLaser = new ManagerLaser();
        aliens = new ArrayList<>();
        createElement();
    }

    public void eliminateMarcian() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (getManagerAlien().getRunning()) {
                    for (AlienModel alien : managerAlien.getAliens()) {
                        for (LaserModel laser : managerLaser.getLasers()) {
                            if (verifyX(alien, laser) && verifyY(alien, laser) && verifyVisible(alien,
                                    laser)) {
                                alien.setVisible(false);
                                laser.setVisible(false);
                                martiansEliminated++;
                            }

                        }
                    }
                    Utils.sleep(properties.getSleepGame());
                }
            }
        });
        thread.start();
    }

    public boolean verifyX(AlienModel alien, LaserModel laser) {
        return (laser.getX() >= alien.getX() && laser.getX() <= alien.getX() + alien.getWidth()) ||
                (laser.getX() + laser.getWidth() >= alien.getX()
                        && laser.getX() + laser.getWidth() <= alien.getX() + alien.getWidth());
    }

    public boolean verifyY(AlienModel alien, LaserModel laser) {
        return (laser.getY() >= alien.getY() && laser.getY() <= alien.getY() + alien.getHeight()) ||
                (laser.getY() + laser.getHeight() >= alien.getY()
                        && laser.getY() + laser.getHeight() <= alien.getY() + alien.getHeight());
    }

    public boolean verifyVisible(AlienModel alien, LaserModel laser) {
        boolean flag = false;
        if (alien.getVisible() && laser.getVisible()) {
            flag = true;
        }
        return flag;
    }

    public void createElement() {
        shipModel = new ShipModel();
        laserModel = new LaserModel(shipModel);
    }

    public int getMartiansEliminated() {
        return martiansEliminated;
    }

    @Override
    public void reboot() {
        martiansEliminated = 0;
        managerAlien.getAliens().clear();
        managerLaser.getLasers().clear();
    }

    @Override
    public void addLaser() {
        eliminateMarcian();
        managerLaser.addLaser(shipModel);
    }

    @Override
    public void start() {
        managerAlien.addAliens();
    }

    @Override
    public void stop() {
        managerAlien.stop();
    }

    @Override
    public ElementPojo getShipPojo() {
        ElementPojo shipPojo = shipModel.getShipPojo();
        return shipPojo;
    }

    @Override
    public ShipModel getShipModel() {
        return shipModel;
    }

    @Override
    public LaserModel getLaserModel() {
        return laserModel;
    }

    @Override
    public ArrayList<AlienModel> getAlienPojos() {
        if (!managerAlien.getAliens().isEmpty()) {
            aliens = managerAlien.getAliens();
        }
        return aliens;
    }

    public ManagerAlien getManagerAlien() {
        return managerAlien;
    }

    @Override
    public ArrayList<LaserModel> getLasersPojos() {
        ArrayList<LaserModel> lasers = new ArrayList<>();
        if (!managerLaser.getLasers().isEmpty()) {
            lasers = managerLaser.getLasers();
        }
        return lasers;
    }

}
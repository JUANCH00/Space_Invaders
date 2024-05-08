package co.edu.uptc.models;

import java.util.ArrayList;

public class ManagerLaser {
    private ArrayList<LaserModel> lasers;
    private LaserModel laser;

    public ManagerLaser() {
        lasers = new ArrayList<>();
    }

    public synchronized void addLaser(ShipModel shipmodel) {
        laser = new LaserModel(shipmodel);
        laser.startElement();
        lasers.add(laser);
    }

    public synchronized ArrayList<LaserModel> getLasers() {
        return lasers;
    }

}

package co.edu.uptc.models;

import java.util.ArrayList;

import co.edu.uptc.pojos.ElementPojo;
import co.edu.uptc.presenters.ContractPlay;

public class ManagerModel implements ContractPlay.Model {

    private ArrayList<ElementPojo> elements = new ArrayList<>();
    private ArrayList<LaserModel> lasers = new ArrayList<>();
    private ShipModel shipModel;
    private LaserModel laserModel;
    private ContractPlay.Presenter presenter;

    @Override
    public void setPresenter(ContractPlay.Presenter presenter) {
        this.presenter = presenter;
    }

    public ManagerModel() {
        createElement();
    }

    public void createElement() {
        shipModel = new ShipModel();
        laserModel = new LaserModel(shipModel);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stop'");
    }

    @Override
    public ArrayList<ElementPojo> getElementsPojo() {
        ElementPojo shipPojo = shipModel.getShipPojo();
        ElementPojo laserPojo = laserModel.getLaserPojo();
        elements.add(shipPojo);
        elements.add(laserPojo);
        return elements;
    }

    public void addLaser() {
        laserModel = new LaserModel(shipModel);
    }

    @Override
    public ShipModel getShipModel() {
        return shipModel;
    }

    @Override
    public LaserModel getLaserModel() {
        return laserModel;
    }

}
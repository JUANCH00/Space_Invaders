package co.edu.uptc.presenters;

import java.util.ArrayList;

import co.edu.uptc.models.AlienModel;
import co.edu.uptc.models.LaserModel;
import co.edu.uptc.models.ManagerModel;
import co.edu.uptc.pojos.ElementPojo;
import co.edu.uptc.presenters.ContractPlay.Model;
import co.edu.uptc.presenters.ContractPlay.View;
import co.edu.uptc.views.DashBoard.DashBoard;

public class Presenter implements ContractPlay.Presenter {

    private ContractPlay.View view;
    private ContractPlay.Model model;

    public void makeMVP() {
        ManagerModel managerModel = new ManagerModel();
        managerModel.setPresenter(this);

        DashBoard dashBoard = new DashBoard();
        dashBoard.setPresenter(this);

        setModel(managerModel);
        setView(dashBoard);
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void reboot() {
        model.reboot();
    }

    @Override
    public void begin() {
        makeMVP();
        view.begin();
    }

    @Override
    public ElementPojo getShipPojo() {
        return model.getShipPojo();
    }

    @Override
    public ArrayList<LaserModel> getLasersPojos() {
        return model.getLasersPojos();
    }

    @Override
    public void start() {
        model.start();
    }

    @Override
    public void stop() {
        model.stop();
    }

    @Override
    public void shoot() {
        model.addLaser();
    }

    @Override
    public ArrayList<AlienModel> getAlienPojos() {
        return model.getAlienPojos();
    }

}

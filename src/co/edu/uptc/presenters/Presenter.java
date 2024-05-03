package co.edu.uptc.presenters;

import java.util.ArrayList;

import co.edu.uptc.models.ManagerModel;
import co.edu.uptc.pojos.ElementPojo;
import co.edu.uptc.presenters.ContractPlay.Model;
import co.edu.uptc.presenters.ContractPlay.View;
import co.edu.uptc.views.DashBoard.DashBoard;

public class Presenter implements ContractPlay.Presenter {

    private ContractPlay.View view;
    private ContractPlay.Model model;

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

    public void makeMVP() {
        ManagerModel managerModel = new ManagerModel();
        managerModel.setPresenter(this);

        DashBoard dashBoard = new DashBoard();
        dashBoard.setPresenter(this);

        setModel(managerModel);
        setView(dashBoard);
    }

    @Override
    public void begin() {
        makeMVP();
        view.begin();
    }

    @Override
    public ArrayList<ElementPojo> getElementsPojo() {
        return model.getElementsPojo();
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stop'");
    }

}

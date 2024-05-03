package co.edu.uptc.presenters;

import java.util.ArrayList;

import co.edu.uptc.models.LaserModel;
import co.edu.uptc.models.ShipModel;
import co.edu.uptc.pojos.ElementPojo;

public class ContractPlay {
    public interface Model {
        public void setPresenter(Presenter presenter);

        public ShipModel getShipModel();

        public LaserModel getLaserModel();

        public void start();

        public void stop();

        public ArrayList<ElementPojo> getElementsPojo();
    }

    public interface View {
        public void setPresenter(Presenter presenter);

        public void begin();

    }

    public interface Presenter {
        public void setModel(Model model);

        public Model getModel();

        public void setView(View view);

        public void begin();

        public ArrayList<ElementPojo> getElementsPojo();

        public void start();

        public void stop();
    }
}
package co.edu.uptc.presenters;

import java.util.ArrayList;

import co.edu.uptc.models.AlienModel;
import co.edu.uptc.models.LaserModel;
import co.edu.uptc.models.ManagerAlien;
import co.edu.uptc.models.ShipModel;
import co.edu.uptc.pojos.ElementPojo;

public class ContractPlay {
    public interface Model {
        public void setPresenter(Presenter presenter);

        public void start();

        public void stop();

        public void reboot();

        public void addLaser();

        public int getMartiansEliminated();

        public ShipModel getShipModel();

        public LaserModel getLaserModel();

        public ManagerAlien getManagerAlien();

        public ElementPojo getShipPojo();

        public ArrayList<AlienModel> getAlienPojos();

        public ArrayList<LaserModel> getLasersPojos();

    }

    public interface View {
        public void setPresenter(Presenter presenter);

        public void begin();

    }

    public interface Presenter {
        public void setModel(Model model);

        public void setView(View view);

        public void begin();

        public void start();

        public void stop();

        public void shoot();

        public void reboot();

        public Model getModel();

        public ElementPojo getShipPojo();

        public ArrayList<AlienModel> getAlienPojos();

        public ArrayList<LaserModel> getLasersPojos();
    }
}
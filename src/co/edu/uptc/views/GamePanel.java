package co.edu.uptc.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import co.edu.uptc.models.AlienModel;
import co.edu.uptc.models.LaserModel;
import co.edu.uptc.pojos.ElementPojo;
import co.edu.uptc.utils.Utils;
import co.edu.uptc.views.DashBoard.DashBoard;

public class GamePanel extends JPanel implements KeyListener {
    private Image imgShip;
    private Image imgLaser;
    private Image imgAlien;

    private ElementPojo shipPojo;
    private DashBoard dashBoard;

    public GamePanel(DashBoard dashBoard) {
        this.dashBoard = dashBoard;
        initComponents();
    }

    public void initComponents() {
        imgShip = new ImageIcon(getClass().getResource(dashBoard.getProperties().getShipImage())).getImage();
        imgLaser = new ImageIcon(getClass().getResource(dashBoard.getProperties().getImgLaser())).getImage();
        imgAlien = new ImageIcon(getClass().getResource(dashBoard.getProperties().getImgAlien())).getImage();
        setBackground(Color.BLACK);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(imgShip, shipPojo.getX(), shipPojo.getY(), shipPojo.getWidth(), shipPojo.getHeight(), this);
        paintAliens(g);
        paintLasers(g);

    }

    public void paintLasers(Graphics g) {
        for (LaserModel laser : dashBoard.presenter.getLasersPojos()) {
            if (laser.getVisible()) {
                g.drawImage(imgLaser, laser.getX(), laser.getY(), laser.getWidth(), laser.getHeight(), this);
            }

        }
    }

    public void paintAliens(Graphics g) {
        for (AlienModel alien : dashBoard.presenter.getAlienPojos()) {
            if (alien.getVisible()) {
                g.drawImage(imgAlien, alien.getX(), alien.getY(), alien.getWidth(), alien.getHeight(), this);
            }

        }
    }

    public void threadPaint() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Utils.sleep(dashBoard.getProperties().getSleepGame());
                    shipPojo = dashBoard.presenter.getShipPojo();
                    repaint();
                }
            }
        });
        thread.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int shootKeyValue = dashBoard.getMenuPanel().getKeyPressed();
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dashBoard.presenter.getModel().getShipModel().right();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dashBoard.presenter.getModel().getShipModel().left();
        }
        if (e.getKeyCode() == shootKeyValue) {
            dashBoard.presenter.shoot();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

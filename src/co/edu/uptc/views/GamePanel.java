package co.edu.uptc.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import co.edu.uptc.pojos.ElementPojo;
import co.edu.uptc.utils.Utils;
import co.edu.uptc.views.DashBoard.DashBoard;

public class GamePanel extends JPanel implements KeyListener {
    private int speed = 80;
    private Image imgShip;
    private Image imgLaser;

    private ElementPojo shipPojo;
    private ElementPojo laserPojo;
    private DashBoard dashBoard;

    private boolean flag = false;

    public GamePanel(DashBoard dashBoard) {
        this.dashBoard = dashBoard;
        initComponents();
    }

    public void initComponents() {
        imgShip = new ImageIcon(getClass().getResource("/co/edu/uptc/img/ship2.png")).getImage();
        imgLaser = new ImageIcon(getClass().getResource("/co/edu/uptc/img/Laser.png")).getImage();
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(imgShip, shipPojo.getX(), shipPojo.getY(), shipPojo.getHeight(), shipPojo.getWidth(), this);
        if (flag == true) {
            g.drawImage(imgLaser, laserPojo.getX(), laserPojo.getY(), laserPojo.getHeight(), laserPojo.getWidth(),
                    this);
        }

    }

    public void threadPaint() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Utils.sleep(speed);
                    shipPojo = dashBoard.presenter.getElementsPojo().get(0);
                    laserPojo = dashBoard.presenter.getElementsPojo().get(1);
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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D:
                dashBoard.presenter.getModel().getShipModel().right();
                break;

            case KeyEvent.VK_A:
                dashBoard.presenter.getModel().getShipModel().left();
                break;

            case KeyEvent.VK_SPACE:
                dashBoard.presenter.getModel().getLaserModel().startElement();
                flag = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

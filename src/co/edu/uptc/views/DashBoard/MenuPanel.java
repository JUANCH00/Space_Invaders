package co.edu.uptc.views.DashBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import co.edu.uptc.utils.Utils;

public class MenuPanel extends javax.swing.JPanel {
    private JButton btnStart;
    private JButton btnStop;
    private JLabel timeLabel;
    private JLabel marciansNumber;
    private JLabel marciansEliminated;
    private Timer timer;
    private KeyPressDialog dialog;
    int hours = 0;
    int minutes = 0;
    int seconds = 0;
    private DashBoard dashBoard;

    public MenuPanel(DashBoard dashBoard) {
        this.dashBoard = dashBoard;
        initComponents();
        dialog = new KeyPressDialog(dashBoard);
    }

    private void initComponents() {
        setBounds(1, 1, dashBoard.getProperties().getWidhtMenuPanel(), dashBoard.getProperties().getHeightMenuPanel());
        createBtns();
    }

    private void createBtns() {
        createBtnStart();
        createBtnStop();
        createTimer();
        createMarcianNum();
        createMarcianEliminated();
    }

    private void createMarcianEliminated() {
        marciansEliminated = new JLabel("Marcians Eliminated: 0");
        this.add(marciansEliminated);
    }

    public void actualizeMarciansEliminated() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (!dashBoard.presenter.getAlienPojos().isEmpty()) {
                    while (dashBoard.presenter.getModel().getManagerAlien().getRunnig()) {
                        marciansEliminated.setText(
                                "Marcians Eliminated:" + dashBoard.presenter.getModel().getMartiansEliminated());
                    }
                }
                Utils.sleep(dashBoard.getProperties().getSleepGame() * 1000);
            }
        });
        thread.start();
    }

    public void createMarcianNum() {
        marciansNumber = new JLabel("0 marcians");
        this.add(marciansNumber);
    }

    public void actualizeMarciansNum() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (!dashBoard.presenter.getAlienPojos().isEmpty()) {
                    while (dashBoard.presenter.getModel().getManagerAlien().getRunnig()) {
                        marciansNumber.setText(dashBoard.presenter.getAlienPojos().size() + " Marcians");
                    }
                }
                Utils.sleep(dashBoard.getProperties().getSleepGame());
            }
        });
        thread.start();
    }

    public void createTimer() {
        timeLabel = new JLabel("00:00;00");
        this.add(timeLabel);
    }

    public void starTimer() {
        rebootTimer();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizeTimer();
            }
        });
        timer.start();
    }

    public void actualizeTimer() {
        seconds++;
        if (seconds >= 60) {
            minutes++;
            seconds = 0;
        }
        if (minutes >= 60) {
            hours++;
            minutes = 0;
        }
        timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    public void rebootTimer() {
        hours = 0;
        minutes = 0;
        seconds = 0;
        timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    public void stopTimer() {
        timer.stop();
    }

    public void reboot() {
        dashBoard.presenter.reboot();
    }

    public void createBtnStart() {
        btnStart = new JButton();
        btnStart.setText("Start");
        btnStart.setFocusable(false);
        this.add(btnStart);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashBoard.presenter.start();
                starTimer();
                actualizeMarciansNum();
                actualizeMarciansEliminated();
                initiazeKeyPressedDialog();
            }
        });
    }

    public void initiazeKeyPressedDialog() {
        dialog.setVisible(true);
    }

    public int getKeyPressed() {
        return dialog.getKeyPressed();
    }

    public void createBtnStop() {
        btnStop = new JButton();
        btnStop.setText("Stop");
        btnStop.setFocusable(false);
        this.add(btnStop);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashBoard.presenter.stop();
                stopTimer();
                reboot();
            }
        });
    }
}

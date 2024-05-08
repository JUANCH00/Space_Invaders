package co.edu.uptc.views.DashBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyPressDialog extends JDialog {
    private int keyPressed;
    private DashBoard dashBoard;

    public KeyPressDialog(DashBoard dashBoard) {
        this.dashBoard = dashBoard;
        setModal(true);
        setSize(dashBoard.getProperties().getWidhtKeyDialog(), dashBoard.getProperties().getHeightKeyDialog());
        setTitle("Press a Key");
        setLayout(new GridLayout(1, 1));
        this.setLocationRelativeTo(null);

        JLabel label = new JLabel("Press a key to shoot...");
        add(label);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keyPressed = e.getKeyCode();
                dispose();
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    public int getKeyPressed() {
        return keyPressed;
    }
}

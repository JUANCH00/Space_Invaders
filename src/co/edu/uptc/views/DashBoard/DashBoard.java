package co.edu.uptc.views.DashBoard;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import co.edu.uptc.presenters.ContractPlay;
import co.edu.uptc.utils.UtilsProperties;
import co.edu.uptc.views.GamePanel;

public class DashBoard extends JFrame implements ContractPlay.View {
    private MenuPanel menuPanel;
    protected GamePanel gamePanel;
    private UtilsProperties properties;

    public ContractPlay.Presenter presenter;

    @Override
    public void setPresenter(ContractPlay.Presenter presenter) {
        this.presenter = presenter;
    }

    public ContractPlay.Presenter getPresenter() {
        return presenter;
    }

    public DashBoard() {
        properties = new UtilsProperties();
        setLayout(new BorderLayout());
        initComponents();
    }

    private DashBoard getInstance() {
        return this;
    }

    public void initComponents() {
        setBounds(1, 1, properties.getWidhtDashBoard(), properties.getHeightDashBoard());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuPanel = new MenuPanel(getInstance());
        add(menuPanel, BorderLayout.NORTH);
        gamePanel = new GamePanel(getInstance());
        add(gamePanel, BorderLayout.CENTER);
        this.addKeyListener(gamePanel);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void begin() {
        gamePanel.threadPaint();
        setVisible(true);
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public UtilsProperties getProperties() {
        return properties;
    }

}

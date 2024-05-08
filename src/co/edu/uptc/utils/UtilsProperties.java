package co.edu.uptc.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilsProperties {
    private Properties props;

    private String shipImage;
    private String imgLaser;
    private String imgAlien;

    private int sleepGame;

    private int widhtMenuPanel;
    private int heightMenuPanel;

    private int widthKeyDialog;
    private int heightKeyDialog;

    private int heightDashBoard;
    private int widthDashBoard;

    private int shipX;

    private int shipY;
    private int padding;
    private int shipHeigth;
    private int shipWidth;

    private int leftPos;
    private int rightPos;
    private int centerPos;

    private int laserWidth;
    private int laserHeight;

    public UtilsProperties() {
        props = new Properties();
        generateProperties();
    }

    public void generateProperties() {
        try {
            props.load(new FileInputStream(
                    "C:\\Users\\jues3\\OneDrive\\Documentos\\Uptc\\IV Semestre\\Programacion III\\2ndoCorte\\ProjectThread\\src\\co\\edu\\uptc\\config\\config.properties"));
            setImages();
            setSleepGame();
            setMenuPanelSize();
            setKeyDialogSize();
            setDashBoardSize();
            setShipSize();
            setPositions();
            setLaserSize();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setImages() {
        shipImage = props.getProperty("imgShip");
        imgLaser = props.getProperty("imgLaser");
        imgAlien = props.getProperty("imgAlien");
    }

    public void setSleepGame() {
        sleepGame = Integer.parseInt(props.getProperty("sleepGame"));
    }

    public void setMenuPanelSize() {
        widhtMenuPanel = Integer.parseInt(props.getProperty("widthMenuPanel"));
        heightMenuPanel = Integer.parseInt(props.getProperty("heightMenuPanel"));
    }

    public void setKeyDialogSize() {
        widthKeyDialog = Integer.parseInt(props.getProperty("widthKeyDialog"));
        heightKeyDialog = Integer.parseInt(props.getProperty("heightKeyDialog"));
    }

    public void setDashBoardSize() {
        heightDashBoard = Integer.parseInt(props.getProperty("heightDashBoard"));
        widthDashBoard = Integer.parseInt(props.getProperty("widthDashBoard"));
    }

    public void setShipSize() {
        shipX = Integer.parseInt(props.getProperty("shipX"));
        shipY = Integer.parseInt(props.getProperty("shipY"));
        padding = Integer.parseInt(props.getProperty("shipPadding"));
        shipHeigth = Integer.parseInt(props.getProperty("shipHeight"));
        shipWidth = Integer.parseInt(props.getProperty("shipWidth"));
    }

    public void setPositions() {
        leftPos = Integer.parseInt(props.getProperty("leftPos"));
        rightPos = Integer.parseInt(props.getProperty("rightPos"));
        centerPos = Integer.parseInt(props.getProperty("centerPos"));
    }

    public void setLaserSize() {
        laserHeight = Integer.parseInt(props.getProperty("laserHeight"));
        laserWidth = Integer.parseInt(props.getProperty("laserWidth"));
    }

    public String getShipImage() {
        return shipImage;
    }

    public String getImgLaser() {
        return imgLaser;
    }

    public String getImgAlien() {
        return imgAlien;
    }

    public int getSleepGame() {
        return sleepGame;
    }

    public int getWidhtMenuPanel() {
        return widhtMenuPanel;
    }

    public int getHeightMenuPanel() {
        return heightMenuPanel;
    }

    public int getWidhtKeyDialog() {
        return widthKeyDialog;
    }

    public int getHeightKeyDialog() {
        return heightKeyDialog;
    }

    public int getHeightDashBoard() {
        return heightDashBoard;
    }

    public int getWidhtDashBoard() {
        return widthDashBoard;
    }

    public int getShipX() {
        return shipX;
    }

    public int getShipY() {
        return shipY;
    }

    public int getShipHeigth() {
        return shipHeigth;
    }

    public int getShipWidth() {
        return shipWidth;
    }

    public int getPadding() {
        return padding;
    }

    public int getLeftPos() {
        return leftPos;
    }

    public int getRightPos() {
        return rightPos;
    }

    public int getCenterPos() {
        return centerPos;
    }

    public int getLaserHeigth() {
        return laserHeight;
    }

    public int getLaserWidth() {
        return laserWidth;
    }
}

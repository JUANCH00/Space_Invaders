package co.edu.uptc.models;

import co.edu.uptc.pojos.ElementPojo;
import co.edu.uptc.utils.UtilsProperties;

import java.awt.Image;

public class ShipModel {
    private ElementPojo shipPojo = new ElementPojo();
    private UtilsProperties properties;

    public ShipModel() {
        properties = new UtilsProperties();
        shipPojo.setX(properties.getShipX());
        shipPojo.setY(properties.getShipY());
        shipPojo.setPadding(properties.getPadding());
        shipPojo.setHeight(properties.getShipHeigth());
        shipPojo.setWidth(properties.getShipWidth());
    }

    public ElementPojo getShipPojo() {
        return shipPojo;
    }

    public void setImage(Image image) {
        shipPojo.setImage(image);
    }

    public int getX() {
        return shipPojo.getX();
    }

    public int getY() {
        return shipPojo.getY();
    }

    public int getWidth() {
        return shipPojo.getWidth();
    }

    public int getHeight() {
        return shipPojo.getHeight();
    }

    public void left() {
        shipPojo.setX(shipPojo.getX() - 10);
        if (shipPojo.getX() <= 5) {
            shipPojo.setX(properties.getLeftPos());
        }
    }

    public void right() {
        shipPojo.setX(shipPojo.getX() + 10);
        if (shipPojo.getX() >= 950) {
            shipPojo.setX(properties.getRightPos());
        }
    }
}

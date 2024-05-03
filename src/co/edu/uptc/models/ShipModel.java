package co.edu.uptc.models;

import co.edu.uptc.pojos.ElementPojo;

import java.awt.Image;

public class ShipModel {
    private ElementPojo shipPojo = new ElementPojo();

    public ShipModel() {
        shipPojo.setX(485);
        shipPojo.setY(550);
        shipPojo.setPadding(10);
        shipPojo.setHeight(150);
        shipPojo.setWidth(150);
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
            shipPojo.setX(1);
        }
    }

    public void right() {
        shipPojo.setX(shipPojo.getX() + 10);
        if (shipPojo.getX() >= 950) {
            shipPojo.setX(950);
        }
    }
}

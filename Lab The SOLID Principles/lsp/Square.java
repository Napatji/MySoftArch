package com.solid.lsp;

public class Square extends Rectangle {

    Square(int side) {
        this.setSide(side);
    }

    @Override
    public void setWidth(int width) {this.setSide(width);
    }

    @Override
    public void setHeight(int height) {this.setSide(height);
    }

    @Override
    public int getArea() {
        return getSide() * getSide();
    }

    public int getSide(){
        return getHeight();
    }

    public void setSide(int side) {
        super.setWidth(side);
        super.setHeight(side);
    }
}

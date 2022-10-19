package com.solid.lsp;


public class Main {

    private static final int width = 4;
    private static final int height = 5;

    public static void main(String[] args) {
        Rectangle reg1 = new Rectangle(width, height);
        System.out.println("==== Rectangle ====");
        System.out.println("Width = " + width);
        System.out.println("Height = " + height);
        System.out.println("Area = " + reg1.getArea());

        Square reg2 = new Square(5);
        reg2.setSide(6);
        System.out.println("====   Square  ====");
        System.out.println("Width = " + reg2.getSide());
        System.out.println("Height = " + reg2.getSide());
        System.out.println("Area = " + reg2.getArea());
    }
}

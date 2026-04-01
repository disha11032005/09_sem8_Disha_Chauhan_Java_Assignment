/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_prac1;

/**
 *
 * @author root
 */
public class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(String color, int length, int width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle [Color=" + color +
               ", Length=" + length +
               ", Width=" + width +
               ", Area=" + getArea() + "]";
    }
}


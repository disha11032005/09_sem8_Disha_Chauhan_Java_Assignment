/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_prac1;

/**
 *
 * @author root
 */
public class Main1 {
    public static void main(String[] args) {

        Shape s1 = new Rectangle("Red", 10, 5);   // Upcasting
        Shape s2 = new Triangle("Blue", 8, 6);    // Upcasting

        System.out.println(s1);  // Polymorphism
        System.out.println(s2);

        if (s1 instanceof Rectangle) {
            Rectangle r = (Rectangle) s1; // Downcasting
            System.out.println("Rectangle Area (Downcasting): " + r.getArea());
        }

        if (s2 instanceof Triangle) {
            Triangle t = (Triangle) s2; // Downcasting
            System.out.println("Triangle Area (Downcasting): " + t.getArea());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Shapes;

/**
 *
 * @author alanpo
 */
public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height, Point topLeft) {
        super("Rectangle", topLeft);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return super.toString() + ", Width=" + width + ", height=" + height + ", Area = "+getArea();
    }
    
    
}

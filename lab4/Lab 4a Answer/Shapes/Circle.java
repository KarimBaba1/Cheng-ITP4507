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
public class Circle extends Shape{
    private int radius;

    public Circle(int radius, Point topLeft) {
        super("Circle", topLeft);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Radius=" + radius + ", Area = "+getArea();
    }    
}

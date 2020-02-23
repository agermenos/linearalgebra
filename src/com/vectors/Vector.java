package com.vectors;

import java.util.Arrays;

public class Vector {
    private double[] coordinates;
    private String name;

    public Vector(String name, double[] coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public double getMagnitude(){
        try {
            return Math.sqrt(Arrays.stream(coordinates).map(val -> Double.valueOf(val * val).doubleValue()).sum());
        }
        catch (Error e){
            return 0;
        }
    }

    public Vector getNormal(){
        double magnitude = getMagnitude();
        double[] coordinates = Arrays.stream(getCoordinates()).map(value -> 1/magnitude*value).toArray();
        return new Vector("Normalized", coordinates);
    }

    public void print(){
        System.out.print(name + " : [");
        int k=0;
        for (double element:coordinates){
            System.out.printf("%.3f", element);
            if (k<coordinates.length-1) System.out.print(", ");
            k++;
        }
        System.out.println("]");
    }

    public static void main(String args[]){
        Vector one = new Vector("V", new double[]{-7.579, -7.88});
        Vector two = new Vector("W", new double[]{22.737, 23.64});
        VectorMath.getProduct(one, two);
        one = new Vector("V", new double[]{-2.029, 9.97, 4.172});
        two = new Vector("W", new double[]{-9.231, -6.639, -7.245});
        VectorMath.getProduct(one, two);
        one = new Vector("V", new double[]{-2.328, -7.284, -1.214});
        two = new Vector("W", new double[]{-1.821, 1.072, -2.94});
        VectorMath.getProduct(one, two);
        one = new Vector("V", new double[]{2.118, 4.827});
        two = new Vector("W", new double[]{0,0});
        VectorMath.getProduct(one, two);
    }
}

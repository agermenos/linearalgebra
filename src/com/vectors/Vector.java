package com.vectors;

public class Vector {
    private Double[] coordinates;
    private String name;

    public Vector(String name, Double[] coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public Double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Double[] coordinates) {
        this.coordinates = coordinates;
    }

    public void print(){
        System.out.print(name + " : [");
        int k=0;
        for (Double element:coordinates){
            System.out.printf("%.3f", element);
            if (k<coordinates.length-1) System.out.print(", ");
            k++;
        }
        System.out.println("]");
    }
    public static void main(String args[]){
        Vector one = new Vector("X", new Double[]{8.218, -9.341});
        Vector two = new Vector("Y", new Double[]{-1.129, 2.111});
        VectorMath.add(one, two).print();
        one = new Vector("X", new Double[]{7.119, 8.215});
        two = new Vector("Y", new Double[]{-8.223, 0.878});
        VectorMath.substract(one,two).print();
        one = new Vector("A", new Double[]{1.671, -1.012, -0.318});
        VectorMath.byScalar(one, 7.41).print();
    }
}

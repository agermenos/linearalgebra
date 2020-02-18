package com.vectors;

public class VectorMath {
    public static Vector add(Vector vOne, Vector vTwo){
        assert vOne.getCoordinates().length == vTwo.getCoordinates().length;
        Double resultCoordinates[] = new Double[vOne.getCoordinates().length];
        for (int k=0; k<vOne.getCoordinates().length; k++) {
            resultCoordinates[k] = vOne.getCoordinates()[k] + vTwo.getCoordinates()[k];
        }
        return new Vector("Result", resultCoordinates);
    }

    public static Vector substract(Vector vOne, Vector vTwo){
        assert vOne.getCoordinates().length == vTwo.getCoordinates().length;
        Double resultCoordinates[] = new Double[vOne.getCoordinates().length];
        for (int k=0; k<vOne.getCoordinates().length; k++) {
            resultCoordinates[k] = vOne.getCoordinates()[k] - vTwo.getCoordinates()[k];
        }
        return new Vector("Result", resultCoordinates);
    }
    
    public static Vector byScalar(Vector vOne, Double scalar){
        Double resultCoordinates[] = new Double[vOne.getCoordinates().length];
        for (int k=0; k<vOne.getCoordinates().length; k++) {
            resultCoordinates[k] = vOne.getCoordinates()[k] * scalar;
        }
        return new Vector("Result", resultCoordinates);
    }
}

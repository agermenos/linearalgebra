package com.vectors;

public class VectorMath {
    public static Vector add(Vector vOne, Vector vTwo){
        assert vOne.getCoordinates().length == vTwo.getCoordinates().length;
        double resultCoordinates[] = new double[vOne.getCoordinates().length];
        for (int k=0; k<vOne.getCoordinates().length; k++) {
            resultCoordinates[k] = vOne.getCoordinates()[k] + vTwo.getCoordinates()[k];
        }
        return new Vector("Result", resultCoordinates);
    }

    public static Vector substract(Vector vOne, Vector vTwo){
        assert vOne.getCoordinates().length == vTwo.getCoordinates().length;
        double resultCoordinates[] = new double[vOne.getCoordinates().length];
        for (int k=0; k<vOne.getCoordinates().length; k++) {
            resultCoordinates[k] = vOne.getCoordinates()[k] - vTwo.getCoordinates()[k];
        }
        return new Vector("Result", resultCoordinates);
    }
    
    public static Vector byScalar(Vector vOne, double scalar){
        double resultCoordinates[] = new double[vOne.getCoordinates().length];
        for (int k=0; k<vOne.getCoordinates().length; k++) {
            resultCoordinates[k] = vOne.getCoordinates()[k] * scalar;
        }
        return new Vector("Result", resultCoordinates);
    }

    public static double innerProduct(Vector v, Vector w) throws VectorException {
        if (v.getCoordinates().length!=w.getCoordinates().length) throw new VectorException("Vector Mismatch");
        double result=0;
        for (int k=0;k<v.getCoordinates().length;k++){
            result = result+ (v.getCoordinates()[k] * w.getCoordinates()[k]);
        }
        return result;
    }

    public static double innerProductTheta(Vector v, Vector w) throws VectorException {
        double innerProduct = innerProduct(v, w);
        double magnitudes = v.getMagnitude()*w.getMagnitude();
        return Math.acos(innerProduct/magnitudes);
    }

    public static void getProduct(Vector v, Vector w){
        v.print();
        w.print();
        try {
            System.out.printf("Inner Product: %.3f", innerProduct(v, w));
            Double rads = VectorMath.innerProductTheta(v, w);
            System.out.printf("\nTheta: %.3f rad\n", rads);
            System.out.printf("Theta: %.3f deg\n----------------------\n", Math.toDegrees(rads));
        }
        catch (VectorException ve){
            System.out.println(ve.getMessage());
        }
    }
}

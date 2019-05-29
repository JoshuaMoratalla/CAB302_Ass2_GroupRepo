package NewShapes;

import DrawnShapes.drawableObject;
import DrawnShapes.fillableObject;

import java.awt.*;
import java.awt.geom.Point2D;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PolygonPack implements drawableObject, fillableObject {
    private Polygon polygonShape;
    private Color fillColor = transparent;
    private Color lineColor = Color.black;

    //fixed polygon
    public PolygonPack(Point2D startPoint, Point2D endPoint, int amountOfSides, boolean isRegular){
        if(isRegular){
            makePolygon(startPoint,endPoint,amountOfSides);
        }else{
            makeStar(startPoint,endPoint,amountOfSides);
        }
    }

    public PolygonPack(ArrayList<Point2D> listOfPoints){
        int numberofPoints = listOfPoints.size();
        int[] xPoints = new int[numberofPoints];
        int[] yPoints = new int[numberofPoints];

        for(int n = 0; n < numberofPoints ; n++ ){
            Point2D point = listOfPoints.get(n);
            xPoints[n] =(int) point.getX();
            yPoints[n] =(int) point.getY();
        }

        this.polygonShape = new Polygon(xPoints,yPoints,numberofPoints);
    }

    private void makePolygon(Point2D startPoint, Point2D endPoint, int amountOfSides){

        double radius = startPoint.distance(endPoint);
        double deltaX = endPoint.getX() - startPoint.getX();
        double deltaY = endPoint.getY() - startPoint.getY();
        double radianShift = Math.atan2(deltaY,deltaX);
        int[] xPoints = new int[amountOfSides];
        int[] yPoints = new int[amountOfSides];

        for(int n = 0; n < amountOfSides; n ++){
            xPoints[n] = (int) (startPoint.getX() + radius * Math.cos(((n * 2 * Math.PI )/ amountOfSides) + radianShift));
            yPoints[n] = (int) (startPoint.getY() + radius * Math.sin(((n * 2 * Math.PI )/ amountOfSides) + radianShift));
        }

        this.polygonShape = new Polygon(xPoints,yPoints,amountOfSides);
    }
    private void makeStar(Point2D startPoint, Point2D endPoint, int amountOfSides){

        ArrayList<Point> bufferOuterList = new ArrayList<>(amountOfSides);
        ArrayList<Point> bufferInnerList = new ArrayList<>(amountOfSides);
        double outerRadius = startPoint.distance(endPoint);
        double innerRadius = outerRadius/ 2;

        double deltaX = endPoint.getX() - startPoint.getX();
        double deltaY = endPoint.getY() - startPoint.getY();
        double radShift_Outer = Math.atan2(deltaX,deltaY);

        double anglePerCorner = 360.0 / amountOfSides;
        double radShift_Inner = Math.toRadians(anglePerCorner/2) + radShift_Outer;

        for(int iterationCount = 0; iterationCount < amountOfSides; iterationCount ++){
            int xCoordinate = (int) (startPoint.getX() + outerRadius * Math.cos(((iterationCount * 2 * Math.PI )/ amountOfSides) + radShift_Outer));
            int yCoordinate = (int) (startPoint.getY() + outerRadius * Math.sin(((iterationCount * 2 * Math.PI )/ amountOfSides) + radShift_Outer));
            bufferOuterList.add( new Point(xCoordinate,yCoordinate));
        }

        for(int iterationCount = 0; iterationCount < amountOfSides; iterationCount ++){
            int xCoordinate = (int) (startPoint.getX() + innerRadius * Math.cos(((iterationCount * 2 * Math.PI )/ amountOfSides) + radShift_Inner));
            int yCoordinate = (int) (startPoint.getY() + innerRadius * Math.sin(((iterationCount * 2 * Math.PI )/ amountOfSides) + radShift_Inner));
            bufferInnerList.add( new Point(xCoordinate,yCoordinate));
        }

        int[] xPoint = new int[amountOfSides *2];
        int[] yPoint = new int[amountOfSides *2];

        for(int n = 0; n < amountOfSides *2 ; n ++){
            xPoint[n] =(int) bufferOuterList.get(n).getX();
            yPoint[n] =(int) bufferOuterList.get(n).getY();
           // addPoint((int) bufferOuterList.get(x).getX(),(int) bufferOuterList.get(x).getY());
           // addPoint((int) bufferInnerList.get(x).getX(),(int) bufferInnerList.get(x).getY());
        }

        this.polygonShape = new Polygon();
    }


    public Polygon getPolygonShape() {
        return this.polygonShape;
    }

    @Override
    public Shape getShape() {
        return this.polygonShape;
    }

    @Override
    public void rotateObject(double angleShift) {

    }

    @Override
    public void scaleObject(double scaleSize) {

    }

    @Override
    public Color getLineColor() {
        return this.lineColor;
    }

    @Override
    public void changeLineColor(Color newColor) {
        this.lineColor = newColor;
    }

    @Override
    public String toVectorString() {
        int[] xVal = polygonShape.xpoints;
        int[] yVal = polygonShape.ypoints;

        StringBuilder str = new StringBuilder("POLYGON");

        for(int n = 0 ; n < getPolygonShape().npoints; n ++){
            str.append(" ").append(xVal[n]).append(" ").append(yVal[n]);
        }
        return str.toString();
    }

    @Override
    public String toLineColorString(Color currentPenColor) {
        if(currentPenColor != getLineColor()){
            return String.format("PEN %s", Integer.toHexString(getLineColor().getRGB()));
        }else{
            return null;
        }
    }

    @Override
    public Color getFillColor() {
        return this.getFillColor();
    }

    @Override
    public void changeFillColor(Color newColor) {
        this.fillColor = newColor;
    }

    @Override
    public void removeFillColor() {
        this.fillColor = transparent;
    }

    @Override
    public String toFillColorString(Color currentFillColor) {
        if(currentFillColor != getFillColor()){
            return String.format("FILL %s", Integer.toHexString(getFillColor().getRGB()));
        }else{
            return null;
        }
    }
}
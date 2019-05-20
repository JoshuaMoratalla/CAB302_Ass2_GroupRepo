import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class FixedPolygon extends Polygon implements fillableObject,shapeObject  {

    private Point2D centrePoint;

    Color transparent = new Color(0,0,0,0);
    Color fillColor = transparent;
    Color lineColor = Color.black;



    public FixedPolygon(int amountOfSides, Point2D centrePoint, Point2D endPoint) {
        super();

        ArrayList<Point> bufferList = new ArrayList<>(amountOfSides);
        double radius = centrePoint.distance(endPoint);

        double deltaX = endPoint.getX() - centrePoint.getX();
        double deltaY = endPoint.getY() - centrePoint.getY();
        double radianShift = Math.atan2(deltaY,deltaX);

        for(int iterationCount = 0; iterationCount < amountOfSides; iterationCount ++){
            int xCoordinate = (int) (centrePoint.getX() + radius * Math.cos(((iterationCount * 2 * Math.PI )/ amountOfSides) + radianShift));
            int yCoordinate = (int) (centrePoint.getY() + radius * Math.sin(((iterationCount * 2 * Math.PI )/ amountOfSides) + radianShift));
            addPoint(xCoordinate,yCoordinate);
            bufferList.add( new Point(xCoordinate,yCoordinate));
        }

        this.centrePoint = centrePoint;
    }




    public Color getFillColor(){
        return this.fillColor;
    }

    @Override
    public void changeColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public void removeColor() {
        this.fillColor = transparent;
    }

    @Override
    public void snapToEqualRadius(double newRadius) {
        int pointAmount =super.npoints;
        int[] xCoords = new int[pointAmount];
        int[] yCoords = new int[pointAmount];

        double radianShift =  Math.atan2(super.ypoints[0] - centrePoint.getY(),super.xpoints[0] - centrePoint.getX());

        for(int pointCount = 0; pointCount < pointAmount; pointCount++ ){
            int xCoordinate = (int) (centrePoint.getX() + newRadius * Math.cos(((pointCount * 2 * Math.PI )/ pointAmount) + radianShift));
            int yCoordinate = (int) (centrePoint.getY() + newRadius * Math.sin(((pointCount * 2 * Math.PI )/ pointAmount) + radianShift));
            xCoords[pointAmount] = xCoordinate;
            yCoords[pointAmount] = yCoordinate;
        }
        super.xpoints = xCoords;
        super.ypoints = yCoords;
    }

    @Override
    public void rotateObject(double angle) {

    }

    @Override
    public void scaleObject(double scaleSize) {

    }



}

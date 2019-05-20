import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class StarPolygon extends Polygon implements  fillableObject, shapeObject {
    private ArrayList<Point> outerPoints;
    private ArrayList<Point> innerPoints;

    private Point2D centrePoint;

    Color transparent = new Color(0,0,0,0);
    private Color fillColor = transparent;
    private Color lineColor = Color.black;


    public StarPolygon(int amountOfSides, Point2D centrePoint, Point2D outerPoint, Point2D innerPoint){
        super();


        this.centrePoint = centrePoint;

        ArrayList<Point> bufferOuterList = new ArrayList<>(amountOfSides);
        ArrayList<Point> bufferInnerList = new ArrayList<>(amountOfSides);

        //Getting Parameters
        double outerRadius = centrePoint.distance(outerPoint);
        double innerRadius = centrePoint.distance(innerPoint);

        double deltaX = outerPoint.getX() - centrePoint.getX();
        double deltaY = outerPoint.getY() - centrePoint.getY();
        double radShift_Outer = Math.atan2(deltaX,deltaY);

        double anglePerCorner = 360.0 / amountOfSides;
        double radShift_Inner = Math.toRadians(anglePerCorner/2) + radShift_Outer;

        //finding outer points

        for(int iterationCount = 0; iterationCount < amountOfSides; iterationCount ++){
            int xCoordinate = (int) (centrePoint.getX() + outerRadius * Math.cos(((iterationCount * 2 * Math.PI )/ amountOfSides) + radShift_Outer));
            int yCoordinate = (int) (centrePoint.getY() + outerRadius * Math.sin(((iterationCount * 2 * Math.PI )/ amountOfSides) + radShift_Outer));
            bufferOuterList.add( new Point(xCoordinate,yCoordinate));
        }
        this.outerPoints = bufferOuterList;


        //finding inner points
        for(int iterationCount = 0; iterationCount < amountOfSides; iterationCount ++){
            int xCoordinate = (int) (centrePoint.getX() + innerRadius * Math.cos(((iterationCount * 2 * Math.PI )/ amountOfSides) + radShift_Inner));
            int yCoordinate = (int) (centrePoint.getY() + innerRadius * Math.sin(((iterationCount * 2 * Math.PI )/ amountOfSides) + radShift_Inner));
            bufferInnerList.add( new Point(xCoordinate,yCoordinate));
        }
        this.innerPoints = bufferInnerList;

        //adding the coordinates through a dot to dot process
         //   5 sides    10 points
        for(int x = 0; x < amountOfSides ; x ++){
            addPoint((int) bufferOuterList.get(x).getX(),(int) bufferOuterList.get(x).getY());
            addPoint((int) bufferInnerList.get(x).getX(),(int) bufferInnerList.get(x).getY());
        }

    }

    @Override
    public void changeColor(Color color) {
        super.
    }

    @Override
    public void removeColor() {

    }

    @Override
    public void snapToEqualRadius(double radius) {

    }

    @Override
    public void rotateObject(double angle) {

    }

    @Override
    public void scaleObject(double scaleSize) {

    }
}

import java.awt.*;

public interface fillableObject {
    //public void addFillColor(Color color); //add fill color is somewhat the same as change color
    public void changeColor(Color color); //you can change from to default to new color the same as adding a new color to replace the old one
    public void removeColor();
    public void snapToEqualRadius(double radius);
}

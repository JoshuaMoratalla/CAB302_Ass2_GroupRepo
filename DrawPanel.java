package GUI;


import Shapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;

/**
 *
 *
 *
 * This will build the GUI content each time the main will be run. Different components were used for the project.
 *
 *
 *
 *
 * @author Abdulrahman Albaqami n10382241
 * */


public class DrawPanel extends JPanel  {

    private List<ShapeInterface> shapes =new ArrayList<ShapeInterface>();
    ShapeInterface currentShape = null;
    private ShapeType shapeType = null;
    Color lineColor = Color.black;
    Color fillColor = new Color(0, 0, 0, 0);


    // This method is to set line colors for all shapes.
    public void setLineColor(Color color)
    {
        lineColor = color;
    }

    // This method is to set fill colors for all shapes.
    public void setFillColor(Color color)
    {
        fillColor = color;
    }

    /**
     *
     * This will points for Xs, Ys for the shape that is being drawn "CurrentShape"
     *
     * */
    private void addPoint(Point p)
    {
        //if (currentShape==null) return;

        if(currentShape != null) {
            currentShape.addPoint(p);

            // We have clicked and are already drawing a shape
            if (currentShape.maxPointsReached()) {
                // Stop drawing this shape
                currentShape = null;
            }
        }
    }

    /**
     *
     * This will initialize all the mouse events while drawing shapes.
     *
     * */
    public void init()
    {
        setBackground(Color.white);
        setPreferredSize(new Dimension());

        // Set up the mouse adapter
        MouseAdapter adapter = new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e)
            {
                addPoint(e.getPoint());
                repaint();

            }
            // In mousePressed all current shapes were called to by their classes to be drawn in this event.
            @Override
            public void mousePressed(MouseEvent e)
            {

                super.mousePressed(e);

                if(e.getButton() == MouseEvent.BUTTON1)
                {
                    if(currentShape == null)
                    {
                        if(shapeType == ShapeType.POLYGON)
                        {
                            currentShape = new CustomPolygon();
                        }
                        else if (shapeType == ShapeType.LINE)
                        {
                            currentShape = new CustomLine();
                        }
                        else if (shapeType == ShapeType.RECT)
                        {
                            currentShape = new CustomRectangle();
                        }
                        else if (shapeType == ShapeType.ELLIPSE)
                        {
                            currentShape = new CustomEllipse();
                        }
                        else if (shapeType == ShapeType.PLOT)
                        {
                            currentShape = new CustomPlot();
                        }

                        // A shape has been created.

                        // Add it to the list of all shapes
                        shapes.add(currentShape);

                        // Set its fill and line color to be equal to the ones that are currently selected
                        currentShape.setFillColor(fillColor);
                        currentShape.setLineColor(lineColor);
                    }

                    addPoint(e.getPoint());
                }
                else
                {
                    currentShape = null;
                }
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e)
            {
                repaint();
            }

        };

        addMouseMotionListener(adapter);
        addMouseListener(adapter);
    }
    //What is it........
    void setShapeType(ShapeType shapeType)
    {
        this.shapeType = shapeType;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // Draw all of the shapes here

        {
            if (shapes!=null) {

                Graphics2D g2g = (Graphics2D) g;
                for (int i = 0; i < shapes.size(); i++) {
                    shapes.get(i).draw(g2g);
                }
            }

        }
    }
}

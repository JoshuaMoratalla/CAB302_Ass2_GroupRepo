package GUI;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawPanel extends JPanel {

    private ShapeType shapeType = null;

    int sx, sy, ex, ey;

    public void DrawPanel()
    {
        ex = -1;
    }

    void init()
    {
        setBackground(Color.white);
        setPreferredSize(new Dimension());

        // Set up the mouse adapter
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e)
            {
                System.out.println("Mouse RELEASED at: " + e.getPoint());
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                System.out.println("Mouse PRESSED at: " + e.getPoint());
                sx = e.getX();
                sy = e.getY();
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e)
            {
                System.out.println("Mouse DRAGGED to: " + e.getPoint());
                ex = e.getX();
                ey = e.getY();
                repaint();
            }
        };

        addMouseMotionListener(adapter);
        addMouseListener(adapter);
        System.out.println("Hello world from the DrawPanel constructor");
    }

    void setShapeType(ShapeType shapeType)
    {
        this.shapeType = shapeType;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // Draw all of the shapes here

        // TODO: Add and maintain a List<Shape> which contains all shapes that have been drawn
        {
            Graphics2D g2g = (Graphics2D)g;
            if(ex != -1)
            {
                g2g.setColor(Color.black);
                g2g.drawLine(sx, sy, ex, ey);
            }
        }
    }
}

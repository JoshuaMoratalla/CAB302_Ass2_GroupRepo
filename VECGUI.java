package GUI;

import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ContentHandler;
import java.nio.file.spi.FileTypeDetector;

/**
 *
 *
 *
 *
 *
 * This class is to set up GUI components and outlines.
 *
 *
 *
 *
 * @author Abdulrahman Albaqami n10382241
 *
 * **/

public class VECGUI extends JFrame implements ActionListener, Runnable{

    private static final long serialVersionUID = 1L;

    DrawPanel drawPanel = new DrawPanel();

    JMenuBar MenuBar = new JMenuBar();
    JMenu Menu1 = new JMenu("File");
    JMenu Menu2 = new JMenu("Edit");
    private  JFileChooser OpenFileChoser;

    Box buttonsBox = Box.createVerticalBox();
    ButtonGroup rdioBtnGroup = new ButtonGroup();
    JRadioButton PlotButton = new JRadioButton("Plot");
    JRadioButton RectangleButton = new JRadioButton("Rectangle");
    JRadioButton EllipseButton = new JRadioButton("Ellipse");
    JRadioButton LineButton = new JRadioButton("Line");
    JRadioButton PolygonButton = new JRadioButton("Polygon");
    JMenuItem OpenFile = new JMenuItem("Open");
    JMenuItem SaveFile = new JMenuItem("Save");
    JMenuItem SaveAs = new JMenuItem("Save as ..");
    JButton FillColor = new JButton("Fill Color");
    JButton LineColor = new JButton("Line Color");
    ImageIcon icon = new ImageIcon("Icons/icons8-line-16.png");
    File saveFile = null;

    // Told what kind of shape to draw when the user clicks/drags, etc. Over the draw area
    /**
     *
     *
     * **/
    public VECGUI() {

        super("VEC Application");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                init();
            }
        });
    }

    /**
     *
     *
     *
     *
     *
     *
     *
     *
     *
     **/
    void init()
    {

        setLayout(new BorderLayout());
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Draw Area
        add(drawPanel, BorderLayout.CENTER);
        drawPanel.init();

        //// Choose a file when press open
        OpenFileChoser = new JFileChooser();
        OpenFileChoser.setCurrentDirectory(new File("/Users/Abdul/Desktop"));
        OpenFileChoser.setFileFilter(new FileNameExtensionFilter("VEC File",".vec"));

        /////////////////////////////////////////////////////////////////////////////////////////////////////////


        // Is to add color fill chooser
        FillColor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            JColorChooser Fill = new JColorChooser();
            Color color = Fill.showDialog(null, "Please choose color", Color.RED);
            drawPanel.setFillColor(color);
            }
        });

        //Is to add color line chooser
        LineColor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser Fill = new JColorChooser();
                Color color = Fill.showDialog(null, "Please choose color", Color.RED);
                drawPanel.setLineColor(color);
            }
        });

        PlotButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setShapeType(ShapeType.PLOT);
            }
        });

        //Explain........
        LineButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setShapeType(ShapeType.LINE);
            }
        });

        //Explain........
        EllipseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setShapeType(ShapeType.ELLIPSE);
            }
        });

        //Explain........
        RectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setShapeType(ShapeType.RECT);
            }
        });

        //Explain........
        PolygonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setShapeType(ShapeType.POLYGON);
            }
        });

     //////////////////////////////////////////////////////////////////////////////////////////////////////////

        add(MenuBar, BorderLayout.NORTH);
        MenuBar.add(Menu1);
        MenuBar.add(Menu2);
        Menu1.add(OpenFile);
        Menu1.add(SaveFile);
        Menu1.add(SaveAs);

        // I'm not really sure if we need those
        Menu2.add("select");
        Menu2.add("Rotate left");
        Menu2.add("Rotate right");

        //add action
        OpenFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                onOpenFile();
            }
        });

        // add action
        SaveFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                onSaveFile();
            }
        });

        // add action
        SaveAs.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                onSaveAs();
            }
        });

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        add(buttonsBox, BorderLayout.WEST);

        buttonsBox.add(Box.createVerticalStrut(4));
        buttonsBox.add(PlotButton);
        buttonsBox.add(LineButton);
        buttonsBox.add(EllipseButton);
        buttonsBox.add(RectangleButton);
        buttonsBox.add(PolygonButton);
        buttonsBox.add(FillColor);
        buttonsBox.add(LineColor);

        rdioBtnGroup.add(PlotButton);
        rdioBtnGroup.add(LineButton);
        rdioBtnGroup.add(EllipseButton);
        rdioBtnGroup.add(RectangleButton);
        rdioBtnGroup.add(PolygonButton);

     /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }


    /**
     *
     *
     *
     * **/

    public void onOpenFile()
    {
        int returVal = OpenFileChoser.showOpenDialog(VECGUI.this);
        // TODO Open a file input stream for reading this file
    }

    public void onSaveFile()
    {
        if(saveFile == null)
        {
            onSaveAs();
        }
        else
        {
            // TODO Do not open the dialog, simply save the file to the last saved file directory
            // TODO: Open a output file stream using the saveFile
        }
    }

    public void onSaveAs()
    {
        int returVal = OpenFileChoser.showSaveDialog(VECGUI.this);

        OpenFileChoser.setDialogTitle("Save a File");
        if(returVal == JFileChooser.APPROVE_OPTION)
        {
            saveFile = OpenFileChoser.getSelectedFile();
            saveFile.getAbsolutePath();

        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }

}

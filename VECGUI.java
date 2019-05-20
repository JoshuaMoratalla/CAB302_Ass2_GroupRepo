package GUI;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class VECGUI extends JFrame implements ActionListener, Runnable{

    private static final long serialVersionUID = 1L;

    //JPanel MainPanel = new JPanel();
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

    public VECGUI() {

        super("VEC Application");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                init();
            }
        });
    }

    void init()
    {

        //MainPanel.setLayout(new BorderLayout());
        setLayout(new BorderLayout());
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setLocation(new Point(100, 100));
        setVisible(true);

        // Draw Area
        add(drawPanel, BorderLayout.CENTER);
        drawPanel.init();

        //// Choose a file when press open
        OpenFileChoser = new JFileChooser();
        OpenFileChoser.setCurrentDirectory(new File("/Users/Abdul/Desktop"));
        OpenFileChoser.setFileFilter(new FileNameExtensionFilter("VEC File",".vec"));

        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        // add colore chooser
        FillColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JColorChooser Fill = new JColorChooser();
            Color color = Fill.showDialog(null, "Please choose color", Color.RED);
            //here could be any shape
            }
        });

        LineColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser Fill = new JColorChooser();
                Color color = Fill.showDialog(null, "Please choose color", Color.RED);
                //here could be any shape
            }
        });

        // Actions for Buttons
        PlotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setShapeType(ShapeType.PLOT);
            }
        });
        LineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setShapeType(ShapeType.LINE);
            }
        });
        EllipseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setShapeType(ShapeType.ELLIPSE);
            }
        });
        RectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setShapeType(ShapeType.RECT);
            }
        });
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
        // add action
        OpenFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOpenFile();
            }
        });

        Menu1.add(SaveFile);
        // add action
        SaveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSaveFile();
            }
        });

        Menu1.add(SaveAs);
        // add action
        SaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSaveAs();
            }
        });

        Menu2.add("select");
        Menu2.add("Rotate left");
        Menu2.add("Rotate right");
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

     ///////////////////////////////////////////////////////////////////////



    }

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
        // TODO
        if(returVal == JFileChooser.APPROVE_OPTION)
        {
            saveFile = OpenFileChoser.getSelectedFile();
            onSaveFile();
        }
    }

// add action


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }

}

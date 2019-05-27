package testingArea.vectorReading;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read extends JFrame implements ActionListener, Runnable {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    private JPanel pnlOne;
    private JPanel pnlTwo;
    private JPanel pnlThree;
    private JPanel pnlBtn;
    private JPanel pnlFive;

    private JButton btnLoad;

    public Read(String title) throws HeadlessException {
        super(title);
    }

    private void createGUI() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        pnlOne = createPanel(Color.WHITE);
        pnlTwo = createPanel(Color.LIGHT_GRAY);
        pnlThree = createPanel(Color.LIGHT_GRAY);
        pnlBtn = createPanel(Color.LIGHT_GRAY);
        pnlFive = createPanel(Color.LIGHT_GRAY);

        btnLoad = createButton("Load");

        getContentPane().add(pnlOne,BorderLayout.CENTER);
        getContentPane().add(pnlTwo,BorderLayout.EAST);
        getContentPane().add(pnlThree,BorderLayout.WEST);
        getContentPane().add(pnlBtn,BorderLayout.SOUTH);
        getContentPane().add(pnlFive,BorderLayout.NORTH);

        layoutButtonPanel();
        repaint();
        setVisible(true);
    }

    private JPanel createPanel(Color c) {
        JPanel nPanel = new JPanel();
        nPanel.setBackground(c);

        return nPanel;
    }

    private void layoutButtonPanel() {
        GridBagLayout layout = new GridBagLayout();
        pnlBtn.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 100;
        constraints.weighty = 100;

        addToPanel(pnlBtn, btnLoad,constraints,0,0,2,1);
    }

    private JButton createButton(String str) {
        JButton nButton = new JButton();
        nButton.setText(str);
        nButton.addActionListener(this);

        return nButton;
    }

    private void addToPanel(JPanel jp,Component c, GridBagConstraints constraints,int x, int y, int w, int h) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        jp.add(c, constraints);
    }

    /**
     *
     *The following method is used to open the file chooser window.
     *It also contains a filter which only allows .vec files being executed.
     *
     */

    //public static void InputCommands(){
        ArrayList<String> commands = new ArrayList<String>();
    //}

    /*public static void fileChooser() {

        JFileChooser chooseFile = new JFileChooser();
        FileNameExtensionFilter vecFilter = new FileNameExtensionFilter(
                ".vec", "vec");
        chooseFile.setFileFilter(vecFilter);

        int file = chooseFile.showOpenDialog(null);
        if (file == JFileChooser.APPROVE_OPTION) {
            File input = new File(String.valueOf(chooseFile.getSelectedFile()));
            try {
                Scanner scan = new Scanner(input);
                while (scan.hasNext()) {
                    String vector = scan.next();

                    System.out.println(vector);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }*/

    public static void fileChooser1() {

        JFileChooser chooseFile = new JFileChooser();
        FileNameExtensionFilter vecFilter = new FileNameExtensionFilter(
                ".vec", "vec");
        chooseFile.setFileFilter(vecFilter);

        int file = chooseFile.showOpenDialog(null);
        ArrayList<String> commands = new ArrayList<String>();

        if (file == JFileChooser.APPROVE_OPTION) {
            File input = new File(String.valueOf(chooseFile.getSelectedFile()));
            try {
                Scanner scan = new Scanner(input);
                while (scan.hasNext()) {
                    String[] line = scan.nextLine().split(" ");

                    String paintAction = line[0];

                    if(paintAction == "LINE"){
                        int x = Integer.parseInt(line[1]);
                        int y = Integer.parseInt(line[2]);
                        int x1 = Integer.parseInt(line[3]);
                        int y2 = Integer.parseInt(line[4]);
                    }

                    else if(paintAction == "PLOT"){
                        int x = Integer.parseInt(line[1]);
                        int y = Integer.parseInt(line[2]);
                    }

                    else if(paintAction == "RECTANGLE"){
                        int x = Integer.parseInt(line[1]);
                        int y = Integer.parseInt(line[2]);
                        int x1 = Integer.parseInt(line[3]);
                        int y2 = Integer.parseInt(line[4]);
                    }

                    else if(paintAction == "ELLIPSE"){
                        int x = Integer.parseInt(line[1]);
                        int y = Integer.parseInt(line[2]);
                        int x1 = Integer.parseInt(line[3]);
                        int y2 = Integer.parseInt(line[4]);
                    }

                    else if(paintAction == "PEN"){
                        String code = line[1];
                    }

                    else if(paintAction == "FILL"){
                        String command = line[1];
                    }

                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String Colour = "#000000";
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        Color.decode(Colour);
        g.setColor(Color.decode(Colour));
        Shape l = new Line2D.Double((0.0 * WIDTH), (0.0 * HEIGHT), (1.0 * WIDTH), (1.0 * HEIGHT));
        g2.draw(l);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();

        if(src == btnLoad){
            JButton button = ((JButton) src);
            fileChooser1();
        }
    }

    @Override
    public void run(){
        createGUI();
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Read("BorderLayout"));
    }
}

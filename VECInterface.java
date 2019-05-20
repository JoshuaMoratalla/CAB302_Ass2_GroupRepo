package GUI;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;


public class VECInterface extends JFrame implements ActionListener, Runnable{

    private JPanel MainPanel;
    private JFormattedTextField formattedTextField1;
    private JButton fileButton;
    private JButton editButton;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JMenuBar menuBar1;


    public VECInterface() {
        menuBar1.addComponentListener(new ComponentAdapter() {
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }

    public static void main(String [] args){

    }
}
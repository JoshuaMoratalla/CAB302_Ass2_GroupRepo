package testingArea.vectorReading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Scrap {

    public void nothing(){

        //File location path
        /*public static void main(String []args) {
        System.out.println(new File(".").getAbsoluteFile());
        smallShapes();*/


        //Stringbuilder Method
            /*public static void String() {
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            for (String : sb) {
                sb =
            }

        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }*/
            //File reader

                /*public static void smallShapes() {

        File input = new File(filePath);
        try {
            Scanner scan = new Scanner(input);

            while (scan.hasNext()) {
                String vector = scan.next();

                if (vector.equals("LINE")) {
                    while (scan.hasNext()) {
                        double x1 = scan.nextDouble();
                        double y1 = scan.nextDouble();
                        double x2 = scan.nextDouble();
                        double y2 = scan.nextDouble();

                        Line();
                    }
                }

                System.out.println(vector);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }*/

                /*if (vector.equals("LINE")) {
                        while (scan.hasNext()) {
                            double x1 = scan.nextDouble();
                            double y1 = scan.nextDouble();
                            double x2 = scan.nextDouble();
                            double y2 = scan.nextDouble();
                        }
                    }

                    else if(vector.equals("PLOT")){
                        while (scan.hasNext()){
                            double x1 = scan.nextDouble();
                            double y1 = scan.nextDouble();
                        }
                    }

                    else if(vector.equals("RECTANGLE")){
                        while (scan.hasNext()){
                            double x1 = scan.nextDouble();
                            double y1 = scan.nextDouble();
                            double x2 = scan.nextDouble();
                            double y2 = scan.nextDouble();
                        }
                    }*/


        //public static void InputCommands(){
        //<String> commands = new ArrayList<String>();
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

    }
}

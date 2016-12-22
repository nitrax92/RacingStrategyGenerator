package RaceEntry;

import com.opencsv.CSVReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;


// OpenCSV


/**
 * Created by Mello on 20.12.2016.
 */
public class Controller {

    @FXML TextField session_name = new TextField();
    @FXML ChoiceBox TyreChoice = new ChoiceBox();
    @FXML
    public void nextButton(ActionEvent event) throws IOException{
        System.out.println("*******************************");
        System.out.println("Information Posted.");

        Writer writer = null;
        File file = new File("saved_data\\" + session_name.getText() +".csv");
        writer = new BufferedWriter(new FileWriter(file));

        writer.write(session_name.getText()+ "\n" +
                "Soft:, 0,1,2,3,4");

        writer.flush();
        writer.close();
    }


    @FXML
    public void readButton(ActionEvent event) throws IOException{
        System.out.println("************************ READ ****************************");
        String filename = "saved_data\\01.csv";
        File file = new File(filename);
        try{
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNext()){
                String data = inputStream.next();
                System.out.println(data);
            }
            inputStream.close();


        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }


    @FXML
    public void searchButton(ActionEvent event) throws IOException, InvocationTargetException{
        System.out.println("**************************** Line Search ************************");

        String filename = "saved_data\\01.csv";
        File file = new File(filename);
        CSVReader reader = new CSVReader(new FileReader(file));
        String [] nextLine;




        while ((nextLine = reader.readNext()) != null) {
            if(nextLine != null){
                String s = Arrays.toString(nextLine);
                if(nextLine[0].equals("S")){
                    System.out.println("Hit!");
                    System.out.println(Arrays.toString(nextLine));
                }
            }

        }
    }


}

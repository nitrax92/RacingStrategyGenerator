package RaceEntry;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Mello on 20.12.2016.
 */
public class Controller {

    @FXML TextField session_name = new TextField();

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


}

package kdTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadDataFromTextFile {

    private String filePath;
    private int dimension, numberOfPoint;
    private int[][] arrayOfPoint;

    public ReadDataFromTextFile(String filePath){
        this.filePath = filePath;
    }

    public boolean checkRepetition(ArrayList<String> listOfPoint, String line){
        for(int i=0; i<listOfPoint.size(); i++){
            if(listOfPoint.get(i).equals(line)){
                return true;
            }
        }
        return false;
    }

    public int[][] stringTOIntegerConversion(ArrayList<String> listOfPoint){
        arrayOfPoint = new int[numberOfPoint][dimension];

        for(int i=0; i<numberOfPoint; i++){
            String[] dimensionInString = listOfPoint.get(i).split(",");
            for(int j=0; j<dimensionInString.length; j++){
                arrayOfPoint[i][j] = Integer.parseInt(dimensionInString[j]);
            }
        }

        return arrayOfPoint;
    }

    public void getInfo(ArrayList<String> listOfPoint){

        numberOfPoint = listOfPoint.size();
        String[] values = listOfPoint.get(0).split(",");
        dimension = values.length;

        arrayOfPoint = stringTOIntegerConversion(listOfPoint);

    }

    public void read(){
        BufferedReader bufferedReader;
        ArrayList<String> listOfPoint = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = bufferedReader.readLine();

            while(line!=null){

                if(checkRepetition(listOfPoint, line) == false){
                    listOfPoint.add(line);
                }
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getInfo(listOfPoint);

    }

    public int getDimension() {
        return dimension;
    }

    public int getNumberOfPoint() {
        return numberOfPoint;
    }

    public int[][] getArrayOfPoint() {
        return arrayOfPoint;
    }
}

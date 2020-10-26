package kdTree;

public class Main {
    public static void main(String[] args){

        ReadDataFromTextFile readData = new ReadDataFromTextFile("points.txt");
        readData.read();
        int [][] arrayOfPoint = readData.getArrayOfPoint();
        int dimension = readData.getDimension();
        int numberOfPoint = readData.getNumberOfPoint();

        System.out.println("dimension : " + dimension);
        System.out.println("number of point : " + numberOfPoint + "\n");

        Operation operation = new Operation(arrayOfPoint, dimension, numberOfPoint);
        operation.insert();
        System.out.println("Pre-order print : \n");
        operation.printTreeInPreOrder(operation.getRoot());
        System.out.println();

        int[] point = {4,3,0};
        operation.search(point);


    }
}

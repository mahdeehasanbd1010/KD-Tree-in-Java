package kdTree;

class Node{
    int[] point;
    int depth;
    Node leftNode, rightNode;
}

public class Operation {

    int[][] arrayOfPoint;
    int dimension, numberOfPoint;
    private Node root = null;

    public Operation(int[][] arrayOfPoint, int dimension, int numberOfPoint){
        this.arrayOfPoint = arrayOfPoint;
        this.dimension = dimension;
        this.numberOfPoint = numberOfPoint;
    }

    public Node createNewNode(int[] point, int depth){
        Node newNode = new Node();
        newNode.point = point;
        newNode.leftNode = null;
        newNode.rightNode = null;
        newNode.depth = depth;

        return newNode;
    }

    public void loopForInsertion(int[] point, int depth){

        Node tempNode;
        tempNode = root;

        while(true){

            int currentDepth = depth % dimension;
            depth++;
            if(point[currentDepth] < tempNode.point[currentDepth]){
                if(tempNode.leftNode==null) {
                    tempNode.leftNode = createNewNode(point, depth);
                    break;
                }
                else {
                     tempNode =tempNode.leftNode;
                }
            }
            else{
                if(tempNode.rightNode==null) {
                    tempNode.rightNode = createNewNode(point, depth);
                    break;
                }
                else {
                    tempNode = tempNode.rightNode;
                }
            }
        }


    }

    public void insert(){

        root = createNewNode(arrayOfPoint[0],0);

        for(int i=1; i<numberOfPoint; i++){
            loopForInsertion(arrayOfPoint[i], 0);
        }
    }

    public boolean checkPoint(Node node, int[] point){

        for(int i=0; i<dimension; i++){
            if(node.point[i]!=point[i]){
                return false;
            }
        }
        return true;
    }

    public void printTreeInPreOrder(Node node){
        if(node==null){
            return;
        }

        System.out.print("(depth : " + node.depth + ") point : ");
        for(int i=0; i<dimension; i++){
            if(i == dimension-1){
                System.out.print(node.point[i] + " ");
            }
            else{
                System.out.print(node.point[i] + ", ");
            }
        }
        System.out.println();

        if(node.leftNode!=null){
            System.out.println("go to left node from depth : " + node.depth);
            printTreeInPreOrder(node.leftNode);
        }

        if(node.rightNode!=null){
            System.out.println("go to right node from depth : "+ node.depth);
            printTreeInPreOrder(node.rightNode);
        }

    }

    public boolean loopForSearch(int[] point, int depth){

        Node tempNode = root;

        if(point.length!=dimension){
            return false;
        }

        while(true){
            if(tempNode==null){
                return false;
            }

            if(checkPoint(tempNode, point)){
                System.out.println("depth : " + tempNode.depth );
                return true;
            }
            int currentDepth = depth % dimension;
            depth++;

            if(point[currentDepth] < tempNode.point[currentDepth]){
                tempNode = tempNode.leftNode;
            }

            else{
                tempNode = tempNode.rightNode;
            }

        }

    }

    public void search(int[] point){

        if(loopForSearch(point, 0)){
            System.out.println("found!");
        }
        else{
            System.out.println("not found!");
        }
    }

    public Node getRoot() {
        return root;
    }


}

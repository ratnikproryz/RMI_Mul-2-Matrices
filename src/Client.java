import java.rmi.Naming;

public class Client {
    public static void show2dArr(int arr[][]){
        int rows= arr.length;
        int cols= arr[0].length;
        String rowElements="";
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                rowElements+=arr[i][j]+" ";
            }
            System.out.println(rowElements);
            rowElements="";
        }
    }

    public static void main(String args[]) {
        try {
            Multipler stub = (Multipler) Naming.lookup("rmi://localhost:5000/mul-matrix");
            int[][] firstMatrix={{1,2,3},{4,5,6},{7,8,9}};
            int[][] secondMatrix={{1,3},{4,6},{7,9}};
            if(firstMatrix[0].length != secondMatrix.length){
                System.out.println("The Matrices don't match [m,n]x[n,p]");
                return ;
            }
            int [][] result = stub.mul(firstMatrix, secondMatrix);
            System.out.println("The result:");
            show2dArr(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

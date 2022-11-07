import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MultiplerRemote extends UnicastRemoteObject implements Multipler {
    public MultiplerRemote() throws RemoteException {
        super();
    }

    @Override
    public int[][] mul(int[][] firstMatrix, int[][] secondMatrix) throws RemoteException {
        int firstRows = firstMatrix.length;
        int firstCols = firstMatrix[0].length;
        int secondRows = secondMatrix.length;
        int secondCols = secondMatrix[0].length;
        int result[][] = new int[firstRows][secondCols];

        for (int i = 0; i < firstRows; i++) {
            for (int j = 0; j < secondCols; j++) {
                for (int k = 0; k < firstCols; k++) {
                    result[i][j] = result[i][j] + (firstMatrix[i][k] * secondMatrix[k][j]);
                }
            }
        }
        return result;
    }
}

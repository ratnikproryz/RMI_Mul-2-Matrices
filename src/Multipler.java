import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Multipler extends Remote {
    public int[][] mul(int [][] firstMatrix, int [][] secondMatrix) throws RemoteException;
}

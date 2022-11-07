import java.rmi.Naming;

public class Server {
    public static void main(String[] args) {
        try {
            Multipler stub = new MultiplerRemote();
            Naming.rebind("rmi://localhost:5000/mul-matrix", stub);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

package mexer1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            MidInterface1 remote = (MidInterface1) registry.lookup("midExercise1");

            String test = "sa1nt & louis";
            System.out.println(remote.profileString(test));
        } catch (RemoteException |NotBoundException e) {
            e.printStackTrace();
        }
    }
}

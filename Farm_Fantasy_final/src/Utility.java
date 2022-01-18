

import java.io.*;
import java.util.*;
import java.lang.*;

public class Utility{

    public void addRecords(PlayerManager manager) throws FileNotFoundException, IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("userdata.txt"));
        out.writeObject(manager);
        out.close();
    }

    public PlayerManager readFile() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("userdata.txt"));
        PlayerManager players = (PlayerManager) in.readObject();
        in.close();
        return players;
    }

}
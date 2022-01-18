
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FinalistList {

    private static ArrayList<Finalist> finalists = new ArrayList();
    private File finalistsData = new File("./data", "finalists.txt");
    private String nameList[] = new String[5];

    public FinalistList() {
        initFinalists();
    }

    public void initFinalists() {
        int i = 0;
        Scanner sFile;
        String name, password, pic, flag;
        try {
            sFile = new Scanner(finalistsData);
            while (sFile.hasNextLine()) {
                String aLine = sFile.nextLine();
                Scanner sLine = new Scanner(aLine);
                sLine.useDelimiter(",");
                while (sLine.hasNext()) {
                    name = sLine.next();
                    password = sLine.next();
                    pic = sLine.next();
                    flag = sLine.next();
                    finalists.add(new Finalist(name, password, pic, flag));
                    nameList[i] = name;
                    i++;
                }
                sLine.close();
            }
            sFile.close();
        } catch (FileNotFoundException e) {
            System.out.print(finalistsData + " not found!");
        }

    }

    public String[] getNames() {
        return nameList;
    }

    public ArrayList<Finalist> getFinalists() {
        return finalists;
    }
}

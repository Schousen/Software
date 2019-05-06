package dtu;

import java.io.File;

public class System {

    private static boolean checkIfUserExists(String userName)
    {
        File tmpDir = new File(userDataPath+"\\"+userName+".txt");
        boolean exists = tmpDir.isFile();
        return exists;
    }

}

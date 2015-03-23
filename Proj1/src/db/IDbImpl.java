
package db;

import dao.IDao;
import dao.IDaoImplement;
import model.IProduct;
import model.Product;
import service.IService;

import java.io.*;
import java.util.*;

public class IDbImpl implements IDB {
UserDb userDb;
    public String setNewPath() {


        try {
            final String currentPath = getCurrentPath();
            String additionalPath = "/DB/Db.txt";
            String PATH_TO_FILE = currentPath.concat(additionalPath);
            return PATH_TO_FILE;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    @Override
    public Object loadFromFile() {
        String path = setNewPath();

        try (
                FileInputStream file = new FileInputStream(path);
                ObjectInputStream obj = new ObjectInputStream(file)) {
            try {
                return obj.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getCurrentPath() throws IOException {
        String current = "";
        return current = new java.io.File(".").getCanonicalPath();
    }

    @Override
    //Method writes HashSet of products to file with address setNewPath();
    public void saveToFile(File file) {
        Collection list = userDb.userSet;
     //   String path = setNewPath();

        FileOutputStream fos = null;
        ObjectOutputStream obj = null;

        try {


            fos = new FileOutputStream(file.getCanonicalPath());
            obj = new ObjectOutputStream(fos);
            obj.writeObject(list);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (obj != null) {
                try {
                    obj.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}


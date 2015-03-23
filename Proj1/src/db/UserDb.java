package db;

import model.IUser;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UserDb implements Serializable {

    private String path = "User.txt";


    Set<IUser> userSet = new HashSet<IUser>();

    public UserDb() {
    }

    public void addUser(IUser iUser){
        userSet.add(iUser);
    }

    //Method writes HashSet of users to file;
    public void saveUserSet(){
        FileOutputStream file = null;
        ObjectOutputStream obj = null;
        try {
            file = new FileOutputStream(path);
            obj = new ObjectOutputStream(file);
            obj.writeObject(this.userSet);
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

    public String toStringSet(){
        String res="";
        for (IUser tempSet : userSet) res+=tempSet.toString();
        return res;
    }


    public void loadUserSet() {
        try (
                FileInputStream file = new FileInputStream(path);
                ObjectInputStream obj = new ObjectInputStream(file)) {
                setUserSet(obj.readObject());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void setUserSet (Object tempSet){
        Set<IUser> set = (Set<IUser>) tempSet;
        this.userSet.clear();
        for (Iterator<IUser> i = set.iterator(); i.hasNext(); )
            this.userSet.add(i.next());
    }

    public class NoSuchUserException extends Exception {
    }


    public IUser getUserByLogin(String login) throws NoSuchUserException {
        //  loadUserSet();
        for (Iterator<IUser> it = userSet.iterator(); it.hasNext(); ) {
            IUser f = it.next();
            if (login.equals(f.getLogin())) {
                return f;
            }
        }
        throw new NoSuchUserException();
    }



}
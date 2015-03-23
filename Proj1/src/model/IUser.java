package model;

import java.util.Collection;

public interface IUser {
    String getLogin();
    String getPassword();
    void setOnline();
    void setPassword(String password);
}

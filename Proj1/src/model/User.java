package model;

import db.UserDb;

import java.io.*;
import java.util.Iterator;
import java.util.Set;


public class User implements IUser, Serializable {
    private String login;
    private String password;
    private boolean online = false;

    public String getPassword() {
        return password;
    }

    public void setOnline() {
        if (!this.online){
            this.online = true;
        }
    }

    public User(String login) {
        this.login = login;

    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getLogin() {
        return login;
    }




@Override
  public String toString() {
      return "User[" +
              "login='" + login + '\'' +
              ", password=" + password +
              ", online=" + online +
              ']';
  }


    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return (this.login == user.login);
    }


}






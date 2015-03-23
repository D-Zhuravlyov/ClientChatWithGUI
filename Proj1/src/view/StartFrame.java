package view;

import dao.IDaoImplement;
import db.IDbImpl;
import db.UserDb;
import model.IUser;
import model.User;
import service.IService;
import service.ServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nofuruct on 13.12.14.
 */
public class StartFrame {

    public static void main(String[] args) {
        IService iService = new ServiceImpl(new IDaoImplement());
        View view = new View(iService);
        LoginFrame loginFrame = new LoginFrame();

    }

}
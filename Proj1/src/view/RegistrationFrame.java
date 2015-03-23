//frame for registration new user RegistrationFrame
package view;

import db.UserDb;
import model.IUser;
import model.User;
import view.PopUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class RegistrationFrame extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    UserDb user=new UserDb();


    public RegistrationFrame() {
        super("Регистрация");

        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        // user.addUser(this.user);
        // user.saveUserSet();
        user.loadUserSet();
        setVisible(true);
        //setResizable(false);
        init();

    }

    private void init() {
        JPanel north = new JPanel(new GridLayout(2, 1));
        getContentPane().add(north, BorderLayout.NORTH);

        JPanel south = new JPanel(new GridLayout(2, 1));
        getContentPane().add(south, BorderLayout.SOUTH);


        textField1 = new JTextField("login");
        north.add(textField1);
        textField2 = new JTextField("password");
        north.add(textField2);


        JPanel loginButtons = new JPanel(new GridLayout(1, 2));
        south.add(loginButtons);
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Exit");
        loginButtons.add(ok);
        loginButtons.add(cancel);

        JPanel registerButton = new JPanel(new GridLayout(1, 1));
        south.add(registerButton);

        JButton registration = new JButton("Registration");
        registerButton.add(registration);

        ok.addActionListener(new okButtonListener());
        cancel.addActionListener(new cancelButtonListener());
        registration.addActionListener(new registrationButtonListener());
    }

    // If user with such login exists,
    //the method checks login/password and if it matches
    //field 'online' of logged on user is changed to 'true'.

    private class okButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (textField1.getText().equals("")) {
                PopUp warn = new PopUp("<html> Please input Login</html>");
            } else {
                try {
                    IUser userByLogin = user.getUserByLogin(textField1.getText());
                    if (userByLogin.getPassword().equals(textField2.getText())) {
                        userByLogin.setOnline();
                        user.saveUserSet();
                        setVisible(false);
                        System.out.println(user.toStringSet());
                    }
                } catch (UserDb.NoSuchUserException e1) {
                    PopUp warn = new PopUp("<html> No such user in system or the password is wrong</html>");
                }
            }
        }
    }

    private class cancelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(1);
        }
    }

    private class registrationButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            IUser tempUser= new User(textField1.getText()) ;
            tempUser.setPassword(textField2.getText());
            user.addUser(tempUser);
            user.saveUserSet();
        }
    }


}

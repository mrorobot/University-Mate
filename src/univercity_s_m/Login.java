package univercity_s_m;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel, AddStudent, AddFaculty;
    JTextField tfrnum, tfpname;

    Login() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblrnum = new JLabel("Rollnumber");
        lblrnum.setBounds(40, 20, 100, 20);
        add(lblrnum);

        tfrnum = new JTextField();
        tfrnum.setBounds(150, 20, 150, 20);
        add(tfrnum);

        JLabel lblpname = new JLabel("Psuedo Name");
        lblpname.setBounds(40, 70, 100, 20);
        add(lblpname);

        tfpname = new JTextField();
        tfpname.setBounds(150, 70, 150, 20);
        add(tfpname);

        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);

        AddStudent = new JButton("NewStudent");
        AddStudent.setBounds(180, 190, 90, 23);
        AddStudent.setBackground(Color.BLACK);
        AddStudent.setForeground(Color.WHITE);
        AddStudent.addActionListener(this);
        AddStudent.setFont(new Font("Tahoma", Font.PLAIN, 9));
        add(AddStudent);

        AddFaculty = new JButton("New Faculty");
        AddFaculty.setBounds(40, 190, 90, 23);
        AddFaculty.setBackground(Color.BLACK);
        AddFaculty.setForeground(Color.WHITE);
        AddFaculty.addActionListener(this);
        AddFaculty.setFont(new Font("Tahoma", Font.PLAIN, 9));
        add(AddFaculty);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String rollNumber = tfrnum.getText();
            String pname = tfpname.getText();

            // Query for student table
            String studentQuery = "SELECT rollnumber, pname FROM student WHERE rollnumber = ? AND pname = ?";
            // Query for teacher table
            String teacherQuery = "SELECT Empid, pname FROM teacher WHERE Empid = ? AND pname = ? ";

            try {
                Conn conn = new Conn();
                PreparedStatement studentStmt = conn.c.prepareStatement(studentQuery);
                studentStmt.setString(1, rollNumber);
                studentStmt.setString(2, pname);

                PreparedStatement teacherStmt = conn.c.prepareStatement(teacherQuery);
                teacherStmt.setString(1, rollNumber);
                teacherStmt.setString(2, pname);

                ResultSet studentRs = studentStmt.executeQuery();
                ResultSet teacherRs = teacherStmt.executeQuery();

                if (studentRs.next() || teacherRs.next()) {
                    setVisible(false);
                    new Project(pname); // or whatever your access code is
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
                }

                studentStmt.close();
                teacherStmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
        
        else if (ae.getSource() == AddStudent){
            new Addstudent();
        }
        else if (ae.getSource() == AddFaculty){
            new Addteacher();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}



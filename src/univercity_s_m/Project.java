/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univercity_s_m;
import java.net.URI;


/**
 *
 * @author Inzayn
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Project extends JFrame implements ActionListener {
    public String userName;
    String gloname;
    Project( String name){
        gloname=name;
        this.userName = name;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bbauc.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);
        JMenu newInfo=new JMenu("New Information");
        newInfo.setForeground(Color.blue);
        mb.add(newInfo);
        JMenuItem addstudent=new JMenuItem("Add Student");
        addstudent.setBackground(Color.WHITE);
        addstudent.addActionListener(this);
        newInfo.add(addstudent);
        JMenuItem addteacher=new JMenuItem("Add Teacher");
        addteacher.setBackground(Color.WHITE);
        addteacher.addActionListener(this);
        newInfo.add(addteacher);
        
        
                      
        JMenu event=new JMenu("Events");
        event.setForeground(Color.blue);
        mb.add(event);
        JMenuItem ev=new JMenuItem("Events");
        ev.setBackground(Color.WHITE);
        ev.addActionListener(this);
        event.add(ev);
        
//        JMenu bbausocial=new JMenu("BBAU Social");
//        bbausocial.setForeground(Color.blue);
//        mb.add(bbausocial);
//        JMenuItem moreInfo=new JMenuItem("Add more info for better result");
//        moreInfo.setBackground(Color.WHITE);
//        bbausocial.add(moreInfo);
//        JMenuItem sbn=new JMenuItem("Search By Name");
//        sbn.setBackground(Color.WHITE);
//        bbausocial.add(sbn);
//        JMenuItem sbh=new JMenuItem("Search By Hobby");
//        sbh.setBackground(Color.WHITE);
//        bbausocial.add(sbh);
        
        JMenu details=new JMenu("Details");
        details.setForeground(Color.blue);
        mb.add(details);
        JMenuItem sdetails=new JMenuItem("Student Details");
        sdetails.setBackground(Color.WHITE);
        sdetails.addActionListener(this);
        details.add(sdetails);
         JMenuItem fdetails=new JMenuItem("Faculty Details");
        fdetails.setBackground(Color.WHITE);
        fdetails.addActionListener(this);
        details.add(fdetails);
        
        JMenu helpdesk=new JMenu("Helpdesk");
        helpdesk.setForeground(Color.blue);
        mb.add(helpdesk);
        JMenuItem hd=new JMenuItem("Open Helpdesks");
        hd.setBackground(Color.WHITE);
        hd.addActionListener(this);
        helpdesk.add(hd);
        
        
        JMenu confession=new JMenu("Confessions");
        confession.setForeground(Color.blue);
        mb.add(confession);
        JMenuItem conf=new JMenuItem("Confessions");
        conf.setBackground(Color.WHITE);
        conf.addActionListener(this);
        confession.add(conf);
        
        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.blue);
        mb.add(utility);
        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        JMenuItem calculator=new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);
        JMenuItem map=new JMenuItem("Map");
        map.addActionListener(this);
        map.setBackground(Color.WHITE);
        
        utility.add(map);
        
        
        JMenu register=new JMenu("Login/Register");
        register.setForeground(Color.blue);
        mb.add(register);
        JMenuItem reg=new JMenuItem("Login/Register");
        reg.setBackground(Color.WHITE);
        reg.addActionListener(this);
        register.add(reg);
       
        utility.add(calculator);
        
        JMenu ex=new JMenu("Exit");
        ex.setForeground(Color.blue);
        mb.add(ex);
        JMenuItem exi=new JMenuItem("Exit");
        exi.setBackground(Color.WHITE);
        exi.addActionListener(this);
        ex.add(exi);
        
        
        mb.add(Box.createHorizontalGlue());
        JMenu nameMenu = new JMenu("Welcome " + this.userName);
        Font menuFont = new Font("Arial", Font.BOLD, 14);// Using the stored username
                // Change the font family, style, and size as needed
          nameMenu.setFont(menuFont);
        nameMenu.setForeground(Color.black);
        mb.add(nameMenu);
       
        
    setVisible(true);
    setSize(1540,900);
    setLocation(0, 0);
    
    }
    public void actionPerformed(ActionEvent ae){
        
        
         String msg = ae.getActionCommand();
          System.out.println("Action performed: " + msg);
    if(msg.equals("Exit")){
        System.out.println("Exit clicked");
        setVisible(false); // Close the application
    }
        else if(msg.equals("Calculator")){
            try{
            Runtime.getRuntime().exec("calc.exe");
        }catch(Exception e){}
        
    }
            else if(msg.equals("Notepad")){
            try{
            Runtime.getRuntime().exec("notepad.exe");
        }catch(Exception e){}
        
    }
                else if(msg.equals("Events")){
                try{
                    new Event();
                }catch(Exception e){
            }   
    }
                    else if(msg.equals("Open Helpdesks")){
                try{
                    System.out.println("enter hd");
                     SwingUtilities.invokeLater(() -> {
            new HelpDesk().setVisible(true);
        });
                }catch(Exception e){
            }   
    }
                        else if(msg.equals("Confessions")){
                try{
                    new Confession(gloname);
                    System.out.println("enter confession");
                }catch(Exception e){System.out.println("enter confession");
            }   
    }
                            else if(msg.equals("Add Teacher")){
                try{
                    
                    new Addteacher();
                }catch(Exception e){System.out.println("Add Teacher");
            }   
    }
      
            else if(msg.equals("Add Student")){
                try{
                    new Addstudent();
                }catch(Exception e){
            }}
     else if(msg.equals("Student Details")){
                try{
                    new StudentDetails();
                }catch(Exception e){
            }}
     else if(msg.equals("Faculty Details")){
                try{
                    new FacultyDetails();
                }catch(Exception e){
            }}
    else if(msg.equals("Login/Register")){
                try{
                    new Login();
                }catch(Exception e){
            }}
     else if(msg.equals("Map")){
                try{
                   // Replace the coordinates with the latitude and longitude of BBAU College
        String latitude = "26.7683644";
        String longitude = "80.9244167";
        String url = "https://www.google.com/maps?q=" + latitude + "," + longitude;

        // Open the default web browser with the Google Maps URL
        Desktop.getDesktop().browse(new URI(url));
                }catch(Exception e){
            }}
    }
    
    public static void main(String[] args) {
        String name= ("InZayn");
        new Project(name);
        
    }
    
}


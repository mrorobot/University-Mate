package univercity_s_m;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    
    Thread t;
    
    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/artwork.png"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
        
        int x = 1;
        for (int i = 2; i <= 600; i += 4, x += 1) {
            setLocation(600 - ((i + x) / 2), 350 - (i / 2));
            setSize(i + 3 * x, i + x / 2);
            
            try {
                Thread.sleep(3);
            } catch (Exception e) {}
        }        
    }
    
    public void run() {
        try {
            Thread.sleep(4000);
            setVisible(false);
            
            // Next Frame
            new SelectionFrame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Splash();
    }
}

class SelectionFrame extends JFrame {
    SelectionFrame() {
        setTitle("Select User Type");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        JButton teacherButton = new JButton("Teacher");
        teacherButton.addActionListener(e -> {
            
            new Login();
            JOptionPane.showMessageDialog(null, "Teacher Button Clicked");
        });
        add(teacherButton);

        JButton studentButton = new JButton("Student");
        studentButton.addActionListener(e -> {
           new Login();
            JOptionPane.showMessageDialog(null, "Student Button Clicked");
        });
        add(studentButton);

        setVisible(true);
    }
}

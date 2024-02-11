package univercity_s_m;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.*;
import java.util.Random;

public class Confession extends JFrame {
JLabel pname, Confession,  imageLabel;
    JButton addConfession, nextConfession;

    ResultSet rs; // Declare ResultSet as a class member

    Confession(String unname) {
         //... (other initialization code)       
         setSize(800, 600);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("Your Untold Secrets");
        heading.setBounds(350, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        pname = new JLabel();
        pname.setFont(new Font("Courier New",Font.CENTER_BASELINE,25));
        Confession = new JLabel();
        Confession.setFont(new Font("Courier New",Font.CENTER_BASELINE,14));
        imageLabel = new JLabel();
       

        pname.setBounds(50, 100, 300, 30);
        Confession.setBounds(50, 150, 300, 100);
        
        imageLabel.setBounds(400, 150, 300, 300);

        add(pname);
        add(Confession);
      
        add(imageLabel);

        addConfession = new JButton("Add Confession");
        addConfession.setBounds(50, 500, 200, 30);
        add(addConfession);

        nextConfession = new JButton("Next Confession");
        nextConfession.setBounds(400, 500, 200, 30);
        add(nextConfession);
        
        
        addConfession.addActionListener(e -> {
    new AddConfession(unname);
    

            System.out.println("into the button");
   // add.setVisibel(true);
    
});


        // Inside your constructor, initialize the ResultSet
        try {
            Conn c = new Conn();
            rs = c.s.executeQuery("SELECT * FROM CONFESSIONS");

            // ... (other initialization code)
                 Random random = new Random();

            while (rs.next()) {
                pname.setText("pname: " + rs.getString("pname"));
               // Confession.setText("Context: " + rs.getString("eventContext"));
                Confession.setText("<html>Confession: " + rs.getString("confession").replace("\n", "<br>") + "</html>");
                

                // Get all image files from the 'icons.event' folder
                File folder = new File(getClass().getClassLoader().getResource("icons/conf").getFile());

                System.out.println(folder);
                File[] listOfFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png")
                        || name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg"));
                System.out.println(listOfFiles);

                if (listOfFiles != null && listOfFiles.length > 0) {
                    // Get a random image file
                    File randomImageFile = listOfFiles[random.nextInt(listOfFiles.length)];
                    String imagePath = randomImageFile.getPath();

                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    Image img = imageIcon.getImage();
                    Image newImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImageIcon = new ImageIcon(newImg);

                    imageLabel.setIcon(newImageIcon);
                    break; // Display only one event and image
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("    pahle me");
        }

            nextConfession.addActionListener(e -> {
                try {
                    if (rs.next()) {
                        pname.setText("Pname: " + rs.getString("pname"));
                        
                       Confession.setText("<html>Context: " + rs.getString("Confession").replace("\n", "<br>") + "</html>");
                        

                        // Get all image files from the 'icons.event' folder
                        File folder = new File(getClass().getClassLoader().getResource("icons/event").getFile());

                        File[] listOfFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png")
                                || name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg"));

                        if (listOfFiles != null && listOfFiles.length > 0) {
                            // Get a random image file
                            Random random = new Random();
                            File randomImageFile = listOfFiles[random.nextInt(listOfFiles.length)];
                            String imagePath = randomImageFile.getPath();

                            ImageIcon imageIcon = new ImageIcon(imagePath);
                            Image img = imageIcon.getImage();
                            Image newImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon newImageIcon = new ImageIcon(newImg);

                            imageLabel.setIcon(newImageIcon);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No more events");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("doosre me dikkat");
                    JOptionPane.showMessageDialog(null, "Error fetching next event");
                }
            });
        

        setVisible(true);
    }

    public static void main(String[] args) {
        new Confession("name");
    }
}

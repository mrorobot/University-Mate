

package univercity_s_m;

import javax.swing.*;
import java.awt.*;

import java.sql.*;
import java.io.*;
import java.util.Random;


    public class Event extends JFrame {
    JLabel eventLabel, contextLabel, dateLabel, imageLabel;
    JButton createEventButton, nextEventButton;

    ResultSet rs; // Declare ResultSet as a class member

    Event() {
         //... (other initialization code)       
         setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("Events");
        heading.setBounds(350, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        eventLabel = new JLabel();
        eventLabel.setFont(new Font("Courier New",Font.CENTER_BASELINE,25));
        contextLabel = new JLabel();
        contextLabel.setFont(new Font("Courier New",Font.CENTER_BASELINE,18));
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Courier New",Font.CENTER_BASELINE,18));
        imageLabel = new JLabel();

        eventLabel.setBounds(50, 100, 300, 30);
        contextLabel.setBounds(50, 150, 300, 200);
        dateLabel.setBounds(400, 100, 300, 30);
        imageLabel.setBounds(400, 150, 300, 300);

        add(eventLabel);
        add(contextLabel);
        add(dateLabel);
        add(imageLabel);

        createEventButton = new JButton("Create New Event");
        createEventButton.setBounds(50, 500, 200, 30);
        add(createEventButton);

        nextEventButton = new JButton("Next Event");
        nextEventButton.setBounds(400, 500, 200, 30);
        add(nextEventButton);
        
        
        createEventButton.addActionListener(e -> {
    AddEvent addEvent = new AddEvent();
    addEvent.setVisible(true);
});


        // Inside your constructor, initialize the ResultSet
        try {
            Conn c = new Conn();
            rs = c.s.executeQuery("SELECT * FROM events");

            // ... (other initialization code)
                 Random random = new Random();

            while (rs.next()) {
                eventLabel.setText("Event: " + rs.getString("eventName"));
               // contextLabel.setText("Context: " + rs.getString("eventContext"));
                contextLabel.setText("<html>Context: " + rs.getString("eventContext").replace("\n", "<br>") + "</html>");
                dateLabel.setText("Date: " + rs.getString("eventDate"));

                // Get all image files from the 'icons.event' folder
                File folder = new File(getClass().getClassLoader().getResource("icons/event").getFile());

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
        }

            nextEventButton.addActionListener(e -> {
                try {
                    if (rs.next()) {
                        eventLabel.setText("Event: " + rs.getString("eventName"));
                        
                       contextLabel.setText("<html>Context: " + rs.getString("eventContext").replace("\n", "<br>") + "</html>");
                        dateLabel.setText("Date: " + rs.getString("eventDate"));

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
                    JOptionPane.showMessageDialog(null, "Error fetching next event");
                }
            });
        

        setVisible(true);
    }

    public static void main(String[] args) {
        new Event();
    }
}

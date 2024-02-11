package univercity_s_m;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEvent extends JFrame implements ActionListener {

    JTextField eventNameField, eventDateField;
    JTextArea eventContextField; // Changed to JTextArea for multiline input
    JButton addButton, cancelButton;
    JLabel background;

    AddEvent() {
        setTitle("Add Event");
        setSize(500, 400);
        setLocation(300, 200);
        setLayout(new BorderLayout());

        // Load the background image
        ImageIcon imageIcon = new ImageIcon("icons/fee.jpeg");
        Image image = imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);

        // Set the image as a label background
        background = new JLabel("", imageIcon, JLabel.CENTER);
        add(background);

        // Create components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel eventNameLabel = new JLabel("Event Name:");
        panel.add(eventNameLabel);
        eventNameField = new JTextField();
        panel.add(eventNameField);


        JLabel eventContextLabel = new JLabel("Event Context:");
        panel.add(eventContextLabel);
        eventContextField = new JTextArea(); // Changed to JTextAreapackage univercity_s_m;package univercity_s_m;
      eventContextField.setLineWrap(true); // Enable word wrap
        JScrollPane contextScrollPane = new JScrollPane(eventContextField);
        contextScrollPane.setBounds(180, 80, 300, 200);
        panel.add(contextScrollPane);

        JLabel eventDateLabel = new JLabel("Event Date:");
        panel.add(eventDateLabel);
        eventDateField = new JTextField();
        panel.add(eventDateField);

        addButton = new JButton("Add Event");
        addButton.addActionListener(this);
        panel.add(addButton);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        background.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        background.add(panel, gbc);

        setVisible(true);
    }

    // Existing code ...

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addButton) {
            String eventName = eventNameField.getText();
            String eventContext = eventContextField.getText(); // Get text from JTextArea
            String eventDate = eventDateField.getText();

            // Limit the context to 100 words
            eventContext = limitTo100Words(eventContext);

            try {
                Conn con = new Conn();
                Statement stmt = con.s;

                // Insert event details without the image path
                String query = "INSERT INTO events (eventName, eventContext, eventDate) " +
                        "VALUES ('" + eventName + "', '" + eventContext + "', '" + eventDate + "')";
                stmt.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Event added successfully!");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to add event.");
            }
        } else if (ae.getSource() == cancelButton) {
            setVisible(false);
        }
    }

    // Function to limit the context to 100 words
    private String limitTo100Words(String text) {
        String[] words = text.split("\\s+");
        if (words.length > 100) {
            StringBuilder limitedText = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                limitedText.append(words[i]).append(" ");
            }
            return limitedText.toString().trim();
        }
        return text;
    }

    public static void main(String[] args) {
        new AddEvent();
    }
}

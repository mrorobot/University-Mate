package univercity_s_m;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class HelpDesk extends JFrame {

    JPanel helpdeskPanel;

    HelpDesk() {
        setTitle("Helpdesk");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        helpdeskPanel = new JPanel();
        helpdeskPanel.setLayout(new GridLayout(0, 1));

        JScrollPane scrollPane = new JScrollPane(helpdeskPanel);
        add(scrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("Add Helpdesk");
        addButton.addActionListener(e -> {
           new Add_helpdesk();
        });
        add(addButton, BorderLayout.NORTH);

        fetchHelpdesksFromDatabase(); // Fetch helpdesk information from the database
    }

    private void fetchHelpdesksFromDatabase() {
        try {
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("SELECT * FROM helpdesks");

            while (rs.next()) {
                JLabel nameLabel = createLabelWithFontSize("Helpdesk Name: " + rs.getString("helpdeskName"));
                JLabel purposeLabel = createLabelWithFontSize("Purpose: " + rs.getString("purpose"));
                JLabel contactLabel = createLabelWithFontSize("Contact Info: " + rs.getString("contactInfo"));

                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(new GridLayout(3, 1));
                infoPanel.add(nameLabel);
                infoPanel.add(purposeLabel);
                infoPanel.add(contactLabel);

                infoPanel.setBackground(getLightRandomColor());
                helpdeskPanel.add(infoPanel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JLabel createLabelWithFontSize(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjust font size here
        return label;
    }

    private Color getLightRandomColor() {
        return new Color(128 + (int) (Math.random() * 128),
                128 + (int) (Math.random() * 128),
                128 + (int) (Math.random() * 128));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HelpDesk().setVisible(true);
        });

    }
}

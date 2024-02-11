package univercity_s_m;

import javax.swing.*;

public class Add_helpdesk extends JFrame {

    Add_helpdesk() {
        setSize(400, 300);
        setLocation(300, 100);

        JLabel heading = new JLabel("Add Helpdesk");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        JLabel nameLabel = new JLabel("Helpdesk Name:");
        nameLabel.setBounds(20, 50, 150, 20);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(180, 50, 150, 20);
        add(nameField);

        JLabel purposeLabel = new JLabel("Purpose:");
        purposeLabel.setBounds(20, 80, 150, 20);
        add(purposeLabel);

        JTextArea purposeArea = new JTextArea();
        JScrollPane purposeScrollPane = new JScrollPane(purposeArea);
        purposeScrollPane.setBounds(180, 80, 150, 100);
        add(purposeScrollPane);

        JLabel contactLabel = new JLabel("Contact Info:");
        contactLabel.setBounds(20, 200, 150, 20);
        add(contactLabel);

        JTextField contactField = new JTextField();
        contactField.setBounds(180, 200, 150, 20);
        add(contactField);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(20, 240, 100, 30);
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(130, 240, 100, 30);
        submitButton.addActionListener(e -> {
            String helpdeskName = nameField.getText();
            String purpose = purposeArea.getText();
            String contactInfo = contactField.getText();

            try {
                Conn con = new Conn();
                String query = "INSERT INTO helpdesk (helpdeskName, purpose, contactInfo) VALUES ('" +
                        helpdeskName + "', '" + purpose + "', '" + contactInfo + "')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Helpdesk added successfully!");
                dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to add helpdesk.");
            }
        });
        add(submitButton);

        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Add_helpdesk().setVisible(true);
        });
    }
}

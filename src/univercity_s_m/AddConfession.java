package univercity_s_m;

import javax.swing.*;

public class AddConfession extends JFrame {

    AddConfession(String pname) {
        setSize(400, 300);
        setLocation(300, 100);

        JLabel heading = new JLabel("Add Confession");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(20, 50, 150, 20);
        add(nameLabel);

        JTextField nameField = new JTextField(pname);
        nameField.setBounds(180, 50, 150, 20);
        nameField.setEditable(false);
        add(nameField);

        JLabel purposeLabel = new JLabel("Confession:");
        purposeLabel.setBounds(20, 80, 150, 20);
        add(purposeLabel);

        JTextArea purposeArea = new JTextArea();
        JScrollPane purposeScrollPane = new JScrollPane(purposeArea);
        purposeScrollPane.setBounds(180, 80, 150, 100);
        add(purposeScrollPane);

       

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(20, 240, 100, 30);
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(130, 240, 100, 30);
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String confession = purposeArea.getText();
          

            try {
                Conn con = new Conn();
                String query = "INSERT INTO confessions (pname, confession) VALUES ('" +
                        name + "', '" + confession + "')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "confession added successfully!");
                dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to add confession.");
            }
        });
        add(submitButton);

        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
new AddConfession("name");
    }
}

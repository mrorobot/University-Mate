/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univercity_s_m;

/**
 *
 * @author Inzayn
 */
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.nio.file.*;

public class ImageUploader extends JFrame implements ActionListener {
    JButton uploadButton;

    ImageUploader() {
        setTitle("Image Uploader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        uploadButton = new JButton("Upload Image");
        uploadButton.addActionListener(this);

        add(uploadButton);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String selectedFilePath = selectedFile.getAbsolutePath();

            // Choose where to save the file on your computer
            JFileChooser saveFileChooser = new JFileChooser();
            int saveReturnValue = saveFileChooser.showSaveDialog(null);
            if (saveReturnValue == JFileChooser.APPROVE_OPTION) {
                File destinationFile = saveFileChooser.getSelectedFile();
                String destinationPath = destinationFile.getAbsolutePath();

                try {
                    // Copy the selected file to the destination path
                    Files.copy(Paths.get(selectedFilePath), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(null, "File saved successfully!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to save the file.");
                }
            }
        }
    }

    public static void main(String[] args) {
        new ImageUploader();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univercity_s_m;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Inzayn
 */
public class BbauSocial extends JFrame {
    BbauSocial(){
        setLocation(300,250);
        setSize(300,320);
        JLabel textLabel = new JLabel("sdsd");
        textLabel.setFont(new Font("Courier New",Font.CENTER_BASELINE,8));
        textLabel.setText("this feature will be available in future update");
        add(textLabel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BbauSocial();
    }
}


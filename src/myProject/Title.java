package myProject;

import javax.swing.*;
import java.awt.*;
public class Title extends JLabel {
    public  Title(String title,Color backgroundColor){
        this.setText(title);
        this.setBackground(backgroundColor);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Magneto",Font.BOLD,50));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(false);
    }
}

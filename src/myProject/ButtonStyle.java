package myProject;

import javax.swing.*;
import java.awt.*;
public class ButtonStyle extends JButton{
    public ButtonStyle(String nameButton, Color backgroundColor) {
        this.setText(nameButton);
        this.setBackground(backgroundColor);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Magneto",Font.PLAIN,18));
        this.setHorizontalTextPosition(SwingConstants.CENTER);
    }

}

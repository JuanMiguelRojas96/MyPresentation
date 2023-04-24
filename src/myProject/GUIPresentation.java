package myProject;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * @author Juan Miguel Rojas email: juan.noriega@correounivalle.edu.co COD:2227517
 * @version v.1.0.0 23/04/2023
 */

public class GUIPresentation extends JFrame {
    //atributos
    //metodo
    private JButton myPhoto, myHobby, myExpectation;
    private Title title;
    private JPanel containerButtons;

    private JPanelBackground containerImage, containterTitle;
    private Listener Listener;
    private JLabel imageLabel;
    private JTextArea expectativesText;

    public GUIPresentation() {
        initGUI();
        this.setTitle("My Presentation");
        this.setSize(1080, 680);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        title = new Title("This is My Project", null);
        myPhoto = new ButtonStyle("This Is Me",Color.BLACK);
        myHobby = new ButtonStyle("This Is My Hobby",Color.BLACK);
        myExpectation = new ButtonStyle("Expectation",Color.BLACK);
        containterTitle = new JPanelBackground();
        containerButtons = new JPanel();
        containerImage = new JPanelBackground();
        Listener = new Listener();
        imageLabel = new JLabel();

        expectativesText = new JTextArea(8,2);
        expectativesText.setEditable(false);
        expectativesText.setOpaque(false);
        expectativesText.setForeground(Color.WHITE);
        expectativesText.setFont(new Font("Harlow Solid Italic",Font.PLAIN,23));

        containterTitle.add(title);
        ClassLoader classLoader = getClass().getClassLoader();
        containterTitle.setBackground(classLoader.getResource("recourses/Header.jpg").getPath());


        containerImage.setBorder(BorderFactory.createTitledBorder(null, "About me", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION,
                new Font("Magneto", Font.PLAIN, 24), Color.WHITE));

        containerImage.setBackground(classLoader.getResource("recourses/Fondo.jpg").getPath());
        containerImage.add(imageLabel);
        containerImage.addMouseListener(Listener);
        containerImage.addKeyListener(Listener);
        containerImage.setFocusable(true);


        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);
        containerButtons.add(myExpectation);
        containerButtons.setBackground(new Color(74,7,21));


        myPhoto.addActionListener(Listener);
        myHobby.addActionListener(Listener);
        myExpectation.addActionListener(Listener);


        this.add(containterTitle,BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerImage, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIPresentation myGui = new GUIPresentation();
            }
        });
    }



    private class Listener implements ActionListener , MouseListener , KeyListener {

        public void cleanLabel(){
            try{
                imageLabel.setIcon(null);
                containerImage.remove(expectativesText);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        public void setImage(String urlImage) {
            try {
                BufferedImage img = ImageIO.read(getClass().getResource(urlImage));
                Image resizeImage = img.getScaledInstance(containerImage.getWidth(), containerImage.getHeight(),
                    Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(resizeImage);
                imageLabel.setIcon(icon);

            } catch (IOException e) {
                e.printStackTrace();
            }
            revalidate();
            repaint();
        }




        @Override
        public void actionPerformed(ActionEvent e) {
            cleanLabel();
            if (e.getSource() == myPhoto) {
                setImage("/recourses/itsme.jpg");
            }
            else if (e.getSource() == myHobby) {
                setImage("/recourses/CollageHobby.png");
            }

            else if (e.getSource() == myExpectation){
                expectativesText.setText("\n" +
                        "I hope to learn a lot from this course and in the future " +
                    "master the JAVA programming language,"+"\n"+
                    " my expectations are high, so I will try to absorb as much knowledge as possible.");
                containerImage.add(expectativesText,BorderLayout.CENTER);
            }
            containerImage.requestFocusInWindow();
            revalidate();
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            cleanLabel();
            if (e.getKeyCode() == KeyEvent.VK_M){
                expectativesText.setText("\n" +
                    "I hope to learn a lot from this course and in the future " +
                    "master the JAVA programming language,"+"\n"+" my expectations are high, so I will try to absorb as much knowledge as possible.");
                containerImage.add(expectativesText,BorderLayout.CENTER);
            }


        }
        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            cleanLabel();
            if (e.getClickCount() == 2){
                setImage("/recourses/CollageHobby.png");
            }
            if (e.getClickCount() == 1){
                setImage("/recourses/itsme.jpg");
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }
}



package javaapplication13;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.Graphics;

/**
 * @author User
 */
public class HelpPanel extends JPanel {

	JButton back = new JButton("Back");

	Image helpbkg = new ImageIcon("./images/4.png").getImage();

	public HelpPanel() {

	}

	public void paintComponent(Graphics g) {

	}

}

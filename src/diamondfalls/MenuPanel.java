package javaapplication13;

import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author User
 */
public class MenuPanel extends JPanel {

	Image menubkg = new ImageIcon("./images/1.png").getImage();

	ImageIcon leaderboardbtn = new ImageIcon("buttons\\6.png");

	JButton play = new JButton("");

	JButton leaderboard = new JButton("");

	JButton help = new JButton("");

	ImageIcon playbtn = new ImageIcon("buttons\\1.png");

	JPanel center = new JPanel();

	JButton exit = new JButton("");

	ImageIcon helpbtn = new ImageIcon("buttons\\5.png");

	ImageIcon exitbtn = new ImageIcon("buttons\\7.png");

	MenuPanel() {

	}

	public void paintComponent(Graphics g) {

	}

	/**
	 * adding mouseListeners on buttons
	 */
	class Click extends MouseAdapter {

		public void mouseClicked(MouseEvent me) {

		}

	}

}

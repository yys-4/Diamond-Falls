package javaapplication13;

import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author DELL
 */
class LevelPanel extends JPanel {

	Image levelbkg = new ImageIcon("images\\2.png").getImage();

	JPanel center = new JPanel();

	ImageIcon easybtn = new ImageIcon("buttons\\2.png");

	ImageIcon hardbtn = new ImageIcon("buttons\\4.png");

	ImageIcon backbtn = new ImageIcon("buttons\\8.png");

	JButton medium = new JButton("");

	JButton easy = new JButton("");

	JButton hard = new JButton("");

	JButton back = new JButton("");

	ImageIcon mediumbtn = new ImageIcon("buttons\\3.png");

	LevelPanel() {

	}

	@Override
	public void paintComponent(Graphics g) {

	}

	class Click extends MouseAdapter {

		public void mouseClicked(MouseEvent me) {

		}

	}

}

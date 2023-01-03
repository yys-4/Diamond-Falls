package javaapplication13;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Image;
import java.util.Random;
import java.awt.Graphics;

/**
 * @author User
 */
public class GamePanel extends JPanel {

	int x_basket;

	int y_basket;

	int x_diamond;

	int y_diamond;

	int pointsCount = 0;

	int timecur = 0;

	int counter = 0;

	int lifeleft = 3;

	static String level = "";

	int speedfall = 0;

	boolean gameOver = false;

	String curtanggal;

	String tanggalmysql;

	JLabel points;

	Image gamebkg = new ImageIcon("images\\2.png").getImage();

	Image diamond = new ImageIcon("images\\diamond.png").getImage();

	Image gameOverbkg = new ImageIcon("images\\3.png").getImage();

	Random rand = new Random();

	Image basket = new ImageIcon("images\\trolli.png").getImage();

	Image tempbkg;

	JLabel life;

	JLabel tanggal;

	JLabel time;

	GamePanel() {

	}

	void levelcheck() {

	}

	void fallDiamond() {

	}

	void updateTime() {

	}

	void detectCollision() {

	}

	void detectUnCollision() {

	}

	void checkGameOver() {

	}

	void date() {

	}

	protected void paintComponent(Graphics g) {

	}

}

package javaapplication13;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

/**
 * @author User
 */
public class CteGame extends JFrame {

	static JPanel cards = new JPanel();

	static LevelPanel lp = new LevelPanel();

	static GamePanel gp = new GamePanel();

	static LeaderBoardPanel lbp = new LeaderBoardPanel();

	static MenuPanel mp = new MenuPanel();

	static HelpPanel hp = new HelpPanel();

	static CardLayout cl = new CardLayout();

	CteGame() {

	}

	void setdownVisible() {

	}

}

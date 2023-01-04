/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diamondfalls;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
/**
 *
 * @author User
 */
public class MenuPanel extends JPanel {
    JButton play = new JButton("");
    JButton help = new JButton("");
    JButton leaderboard = new JButton("");
    JButton exit = new JButton("");
    
    Image menubkg = new ImageIcon("./images/1.png").getImage();  //menu background
	
	/* Setting icons on buttons */
	ImageIcon playbtn = new ImageIcon("buttons\\1.png"); 
	ImageIcon helpbtn = new ImageIcon("buttons\\5.png");
        ImageIcon leaderboardbtn = new ImageIcon("buttons\\6.png");
	ImageIcon exitbtn = new ImageIcon("buttons\\7.png");

	JPanel center = new JPanel(); //adding another jpanel in a panel for boxLayout
        
        MenuPanel(){
		
		center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS)); //setting box layout 
		add(center); //adding the panel to anothe JPanel
		
		/* setting icons on buttons */
		play.setIcon(playbtn); 
		help.setIcon(helpbtn);
                leaderboard.setIcon(leaderboardbtn);
		exit.setIcon(exitbtn);
		
		/* adding the buttons in the panel */
		center.add(play);
		center.add(help);
                center.add(leaderboard);
		center.add(exit);
				
		/* adding mouseListeners on buttons */
		play.addMouseListener(new Click());
		help.addMouseListener(new Click());
                leaderboard.addMouseListener(new Click());
		exit.addMouseListener(new Click());
		
	}
        class Click extends MouseAdapter{
        public void mouseClicked(MouseEvent me){
			if(me.getSource()== play){
				CteGame.cl.show(CteGame.cards, "LevelPanel"); //show gamePanel when play is clicked
			}
			if(me.getSource()== help){
				CteGame.cl.show(CteGame.cards, "HelpPanel"); //show helpPanel when help is clicked
			}
                        if(me.getSource()== leaderboard){
                                LeaderBoardPanel lbp = new LeaderBoardPanel();
                                CteGame.cards.add(lbp, "LeaderBoardPanel");
				CteGame.cl.show(CteGame.cards, "LeaderBoardPanel"); //show leaderboard when help is clicked
			}	
			if(me.getSource()== exit){
				System.exit(0);  //exit application when exit is clicked
			}
            }
        }
        public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		setFocusable(true); //game background
		
		g2d.drawImage(menubkg, 0, 0, null);
                repaint();
	}//end paintComponent
}

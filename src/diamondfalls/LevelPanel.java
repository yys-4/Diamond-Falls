/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diamondfalls;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author DELL
 */
class LevelPanel extends JPanel{
    Image levelbkg = new ImageIcon("images\\2.png").getImage();
        
        JButton back = new JButton(""); //back button
        JButton easy = new JButton("");
        JButton medium = new JButton("");
        JButton hard = new JButton("");
               
        ImageIcon backbtn = new ImageIcon("buttons\\8.png");
        ImageIcon easybtn = new ImageIcon("buttons\\2.png");
        ImageIcon mediumbtn = new ImageIcon("buttons\\3.png");
	ImageIcon hardbtn = new ImageIcon("buttons\\4.png");
        
        JPanel center = new JPanel();
	
	LevelPanel(){
            
		setFocusable(true); //setting the focus
                center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS)); //setting box layout 
		add(center); //adding the panel to anothe JPanel
                
                back.setIcon(backbtn);
                easy.setIcon(easybtn);
                medium.setIcon(mediumbtn);
                hard.setIcon(hardbtn);
					
                center.add(easy);
                center.add(medium);
                center.add(hard);
                center.add(back);
               
		
		easy.addMouseListener(new LevelPanel.Click());
		medium.addMouseListener(new LevelPanel.Click());
                hard.addMouseListener(new LevelPanel.Click());
		back.addMouseListener(new LevelPanel.Click());
	}
        class Click extends MouseAdapter{
        public void mouseClicked(MouseEvent me){
			if(me.getSource()== easy){
                                GamePanel gp = new GamePanel();
                                CteGame.cards.add(gp, "GamePanel");
                                GamePanel.level = "mudah";
				CteGame.cl.show(CteGame.cards, "GamePanel"); //show gamePanel when play is clicked
			}
			if(me.getSource()== medium){
                                GamePanel gp = new GamePanel();
                                CteGame.cards.add(gp, "GamePanel");
                                GamePanel.level = "sedang";
				CteGame.cl.show(CteGame.cards, "GamePanel"); //show helpPanel when help is clicked
			}
                        if(me.getSource()== hard){
                                GamePanel gp = new GamePanel();
                                CteGame.cards.add(gp, "GamePanel");
                                GamePanel.level = "sulit";
				CteGame.cl.show(CteGame.cards, "GamePanel"); //show leaderboard when help is clicked
			}	
			if(me.getSource()== back){
				CteGame.cl.show(CteGame.cards, "MenuPanel");  //exit application when exit is clicked
			}
            }
        }
        
        @Override
        public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		setFocusable(true); //game background
		
		g2d.drawImage(levelbkg, 0, 0, null);
                repaint();
	}//end paintComponent
}

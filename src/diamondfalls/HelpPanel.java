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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class HelpPanel extends JPanel{
    Image helpbkg = new ImageIcon("./images/4.png").getImage(); //help image background
	JButton back = new JButton("Back"); //back button
	
	public HelpPanel(){
		setFocusable(true); //setting the focus
		add(back);			//adding back button in the panel
		
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
			CteGame.cl.show(CteGame.cards, "MenuPanel"); // show menuPanel when back button is clicked
			}	
		  });
	}
        
        public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		setFocusable(true); //game background
		
		g2d.drawImage(helpbkg, 0, 0, null);
                repaint();
	}//end paintComponent
}

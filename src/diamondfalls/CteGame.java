/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 *
 * @author User
 */
public class CteGame extends JFrame{
    static MenuPanel mp = new MenuPanel();
	static HelpPanel hp = new HelpPanel();
	static GamePanel gp = new GamePanel();
        static LevelPanel lp = new LevelPanel();
        static LeaderBoardPanel lbp = new LeaderBoardPanel();
	
	static CardLayout cl = new CardLayout();
	static JPanel cards = new JPanel(); // to contain the panels as cards
	
	CteGame(){
		
		cards.setLayout(cl);// setting the layout to cardlayout
		cards.add(mp, "MenuPanel");
		cards.add(hp, "HelpPanel");
		cards.add(gp, "GamePanel");
                cards.add(lp, "LevelPanel");
                cards.add(lbp, "LeaderBoardPanel");
		cl.show(cards, "MenuPanel");
		add(cards); //adding the panel with cardlayout in JFrame
		
		setTitle("Catch The Diamond Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 700); //frame size
		setVisible(true);   //frame visibility	
	}
        
        void setdownVisible(){
      
        }
}

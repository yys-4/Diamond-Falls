/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diamondfalls;

import com.sun.source.tree.IfTree;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import static javaapplication13.CteGame.cards;
import static javaapplication13.CteGame.gp;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class GamePanel extends JPanel{
   Image gamebkg = new ImageIcon("images\\2.png").getImage();
	Image basket  = new ImageIcon("images\\trolli.png").getImage();
	Image diamond     = new ImageIcon("images\\diamond.png").getImage();
	Image gameOverbkg= new ImageIcon("images\\3.png").getImage();
	Image tempbkg; //temporary background
	
	int x_basket,y_basket; //basket x and y  coordinates
	int x_diamond,y_diamond; // x and y coord of diamond
	Random rand = new Random(); // for randomizing xcoord of diamond
	
	JLabel time;
	JLabel points;
        JLabel life;
        JLabel tanggal;
	
	int pointsCount = 0;
	int timecur = 0;
	int counter  = 0;
        int lifeleft = 3;
        
        static String level = "";
        int speedfall = 0;
	
	boolean gameOver = false;
	String curtanggal;// buat tanggal yg dimunculin
        String tanggalmysql; //format mysql
        
	GamePanel(){
                
		setLayout(null);
		setFocusable(true);
		tempbkg = gamebkg;
		
		x_basket = 450; y_basket = 600;
		x_diamond = (int)rand.nextInt(880);
		y_diamond = 0;
		
	    time = new JLabel("Time: ");
		time.setBounds(20, 10, 100, 20); //setting the time label on screen
                time.setForeground(Color.white);
	    
	    points = new JLabel("Points: ");
		points.setBounds(100,10,100,20);
                points.setForeground(Color.white);
                
	    life = new JLabel("Life: ");
		life.setBounds(180,10,150,20);
                life.setForeground(Color.white);
                
            tanggal = new JLabel("Tanggal: ");
		tanggal.setBounds(260,10,200,20);
                tanggal.setForeground(Color.white);
		
		/adding both components in jpanel/
		add(time);
		add(points);
                add(life);
                add(tanggal);
		
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				
				if(ke.getKeyCode() == ke.VK_LEFT & x_basket>10){
					x_basket-=50;
					repaint(); // redraw at new position
				}
				if(ke.getKeyCode() == ke.VK_RIGHT & x_basket<880){
					x_basket+=50; // redraw at new position
					repaint();
				}
			}//end keypressed
		});
	}//end constructor
        
        void levelcheck(){
                if(level.equalsIgnoreCase("mudah")){
                    speedfall = 1;
                }
                if(level.equalsIgnoreCase("sedang")){
                    speedfall = 2;
                }
                if(level.equalsIgnoreCase("sulit")){
                    speedfall = 3;
                }
        }
	
	void fallDiamond(){
		if(y_diamond >=650){
			y_diamond = 0;
			x_diamond = rand.nextInt(880);
		}
		else
			y_diamond+=speedfall;
	}
	
	void updateTime(){
		counter++;
		if(counter == 350) //we count to 60 and then dec timeleft by 1 for slowing speed
		{
		   timecur+=1;  //dec time left after 60 counts
		   counter = 0; //reset counter
		}
		time.setText("Time: "+timecur);
                life.setText("Life: "+lifeleft);
                tanggal.setText("Tanggal : "+curtanggal);
	}
        
	
	void detectCollision(){
		Rectangle basketRect  = new Rectangle(x_basket,y_basket,100,65); //making a rectangle on the basket
		Rectangle diamondRect = new Rectangle(x_diamond,y_diamond,45,67); //making a rectangle on diamond
		
                
		if(diamondRect.intersects(basketRect)){
			pointsCount+=5; // give 5 points on each catch
			points.setText("Points: "+pointsCount); // set the count
			y_diamond = 0; 
			x_diamond = rand.nextInt(880); 
		}
                
	}//end collision detection
        
        void detectUnCollision(){
		Rectangle kotakbawah = new Rectangle(0,670,1000,100); //making a rectangle on the basket
		Rectangle diamondRect    = new Rectangle(x_diamond,y_diamond,45,67); //making a rectangle on diamond
		
                
		if(diamondRect.intersects(kotakbawah)){
			lifeleft-=1; // 
			life.setText("Life: "+lifeleft); // set the count
			y_diamond = 0; 
			x_diamond = rand.nextInt(880); 
		}
                
	}//end collision detection
        
	
	void checkGameOver(){
		if(lifeleft <=0)
		{
                        JButton playagain = new JButton("Main lagi");
                        JButton kembali = new JButton("Halaman Utama");
                        tempbkg = gameOverbkg;
                        gameOver = true;
                        playagain.setBounds(350, 420, 140, 60);
                        kembali.setBounds(540, 420, 140, 60);
			JLabel yourScore = new JLabel("Your SCORE : " + pointsCount);
                        add(playagain);
                        add(kembali);
			yourScore.setBounds(425, 340, 300, 100);
			yourScore.setForeground(Color.white);
                        yourScore.setFont(new Font("Arial", Font.PLAIN, 24));
			add(yourScore);
                        
                        playagain.addMouseListener(new MouseAdapter(){
                            public void mouseClicked(MouseEvent me){
                                    GamePanel gp = new GamePanel();
                                    CteGame.cards.add(gp, "GamePanel");
                                    CteGame.cl.show(CteGame.cards, "GamePanel");
                                    try {
                                        String sql = "INSERT INTO datascore2 (`tingkat`, `tanggal`, `score`) VALUES ('" +level+"','"+tanggalmysql+"','"+pointsCount+"')";
                                        Connection con = (Connection) Koneksi.getConnection();
                                        PreparedStatement pst = con.prepareStatement(sql);
                                        pst.execute();
            
//                                        JOptionPane.showMessageDialog(null, "Behasil Menyimpan");
                                        } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, "Gagal Menyimpan "+e.getMessage());
                                    }
                                }	
                        });
                        
                        kembali.addMouseListener(new MouseAdapter(){
                            public void mouseClicked(MouseEvent me){
                                    CteGame.cl.show(CteGame.cards, "MenuPanel"); // show menuPanel when back button is clicked
                                    try {
                                        String sql = "INSERT INTO datascore2 (`tingkat`, `tanggal`, `score`) VALUES ('" +level+"','"+tanggalmysql+"','"+pointsCount+"')";
                                        Connection con = (Connection) Koneksi.getConnection();
                                        PreparedStatement pst = con.prepareStatement(sql);
                                        pst.execute();
            
//                                        JOptionPane.showMessageDialog(null, "Behasil Menyimpan");
                                        } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, "Gagal Menyimpan "+e.getMessage());
                                    }
                                }	
                        });
		}
	}
        
        void date(){
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat formattermysql = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                curtanggal = formatter.format(date);
                tanggalmysql = formattermysql.format(date);
        }
        
        
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(tempbkg,0,0,null); //game background
		
                levelcheck();
                date();
		checkGameOver();
		
		if(gameOver == false){
			setFocusable(true);
			grabFocus();
			updateTime();
			
			fallDiamond();
			detectCollision();
                        detectUnCollision();
		
			g2d.drawImage(diamond, x_diamond, y_diamond,null); //drawing diamond at new position
			g2d.drawImage(basket, x_basket, y_basket, null); //drawing basket
		}
		
		repaint();	
	}//end paintComponent
}

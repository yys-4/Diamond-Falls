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
import java.sql.ResultSet;
import java.sql.Statement;
import static javaapplication13.CteGame.lbp;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class LeaderBoardPanel extends JPanel{
    Image helpbkg = new ImageIcon("./images/2.png").getImage(); //help image background
	JButton back = new JButton("Back"); //back button
        JTable table;
        
	public LeaderBoardPanel(){
		setFocusable(true); //setting the focus
		add(back);
                TableLb();//adding back button in the panel
                
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
			CteGame.cl.show(CteGame.cards, "MenuPanel"); // show menuPanel when back button is clicked
			}	
		  });
	}
        
        void TableLb(){
        setSize(600, 400);
        setVisible(true);
        Object[][] data ={{null,null,null},{null,null,null},{null,null,null}};
        String[] columnname ={"Tingkat","Tanggal","Score"};
        
        DefaultTableModel model= new DefaultTableModel(data, columnname);
        
        table = new JTable(model);
        add(new JScrollPane(table));
        validate();

        
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Tingkat");
        tbl.addColumn("Tanggal");
        tbl.addColumn("Score");
        
        try {
            Statement st = (Statement) Koneksi.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM datascore2 ORDER BY tingkat ASC, score DESC");
            
            while (rs.next()) {
                tbl.addRow(new Object[]{
                    rs.getString("tingkat"),
                    rs.getString("tanggal"),
                    rs.getString("score"),
                });
                table.setModel(tbl);
            }
            JOptionPane.showMessageDialog(null, "Mendeteksi Database Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal"+e.getMessage());
        }
    }
        
        public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		setFocusable(true); //game background
		
		g2d.drawImage(helpbkg, 0, 0, null);
                repaint();
	}//end paintComponent
}

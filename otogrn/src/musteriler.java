import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tolga
 */
public class musteriler {
    
    public JPanel pnr = new JPanel();
    private String istenen="";
    
    public musteriler(String ad) throws ClassNotFoundException{
        this.pnr.removeAll();
        this.pnr.repaint();
        this.istenen = ad ;
        
        JLabel lbad = new JLabel(ad);
        lbad.setText(ad);
        lbad.setForeground(Color.WHITE);
        lbad.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnr.add(lbad);
        lbad.setBounds(15, 0, 150, 30);
        pnr.setBackground(Color.GRAY);
        
        JTable tablo = new JTable();
        tablo.setDefaultEditor(Object.class, null);
        JScrollPane pan = new JScrollPane(tablo);
        
        tablo.setRowHeight(20);        
        tablo.setFont(new Font("Arial", Font.PLAIN,18));
        //Bağlantı oluşturma..
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/otokira","root","");
            Statement stat =  conn.createStatement();
            String sorgu1="select * from tblmusteri";
            
            ResultSet res = stat.executeQuery(sorgu1);
            tablo.setModel(DbUtils.resultSetToTableModel(res));
              TableColumnModel tcm = tablo.getColumnModel();
              tcm.removeColumn(tcm.getColumn(0)); //id alanını siler
            
        } catch (SQLException e) {
            System.out.println("Db Bğlantı hatası");
            e.printStackTrace();
        }
         //İstenilen tablolr çalıştı. Bağlantı tamamdır..                   
        this.pnr.add(pan);                      
        pan.setBounds(30, 30, 700, 500);
        //Tablo eklendi..
        
        tablo.addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        JTable table =(JTable) mouseEvent.getSource();
        Point point = mouseEvent.getPoint();
        int row = table.rowAtPoint(point);
        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
            //JOptionPane.showMessageDialog(pnr, tablo.getModel().getValueAt(row, 1).toString()); //0=id 1=tc
             
            try { 
                vt_sorgu vt=new vt_sorgu("jdbc:mysql://localhost:3306/otokira","root","");
                vt.vt_baglan();
                long tc=Long.parseLong(tablo.getModel().getValueAt(row, 1).toString());
               vt.MusteriKiraGecmisi(pnr,tc);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(pnr, ex.toString());
            }
            
        }
    }
});
        
        
    }
    
    
}

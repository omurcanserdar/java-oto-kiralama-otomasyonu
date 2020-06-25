import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
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
public class araclar {
   
    public JPanel pnl = new JPanel();
    private String istenen="";
    public araclar(String ad) throws ClassNotFoundException{
        
        this.pnl.removeAll();
        this.pnl.repaint();
        // Araclar labeli ekrana basılıyor..
        JLabel lbad = new JLabel(ad);
        lbad.setText(ad);
        lbad.setForeground(Color.WHITE);
        lbad.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnl.add(lbad);
        lbad.setBounds(15, 0, 150, 30);
        pnl.setBackground(Color.GRAY);
        //
        //Yapıcı fonksiyondan gelen değer alınıyor.
        this.istenen = ad;
        // Araclar için oluşacak table basılıyor..       
     
//        DefaultTableModel dtm = new DefaultTableModel(tblHead,0){
//            public boolean isCellEditable(int row, int column)
//                {
//                    return false;
//                }
//        };
//      

       //Tablo oluşturma..
      
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
            String sorgu1="select * from tblarac";
            
              ResultSet res = stat.executeQuery(sorgu1);
              tablo.setModel(DbUtils.resultSetToTableModel(res));
              TableColumnModel tcm = tablo.getColumnModel();
              tcm.removeColumn(tcm.getColumn(0)); //id alanını siler
        } catch (SQLException e) {
            System.out.println("Db Bğlantı hatası");
            e.printStackTrace();
        }
         //İstenilen tablolr çalıştı. Bağlantı tamamdır..                   
        this.pnl.add(pan);                      
//        pan.setBounds(30, 30, 700, 200);
        pan.setBounds(30, 30, 700, 350);
        //Tablo eklendi..
         
        
//        JButton btnsec = new JButton(this.istenen+" "+"tablosunu yazdır");
//        pnl.add(btnsec);
//        btnsec.setBounds(30, 390, 250,60);
    
        JButton arackira = new JButton("Kirada OLAN araçları göster");
            pnl.add(arackira);
            arackira.setBounds(30, 390, 700, 60);
          
        JButton aracelde = new JButton("Kirada OLMAYAN araçları göster");
            pnl.add(aracelde);
            aracelde.setBounds(30, 460, 700, 60);           
        
            
             arackira.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
               //  JOptionPane.showMessageDialog(pnz, "Aracınız Eklendi.");
                  // JOptionPane.showConfirmDialog(pns, "ok", "okk", 0, 0);
                
                 try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/otokira","root","");
            Statement stat =  conn.createStatement();
            String sorgu1="select * from tblarac";
            
              ResultSet res = stat.executeQuery(sorgu1);
              tablo.setModel(DbUtils.resultSetToTableModel(res));
              TableColumnModel tcm = tablo.getColumnModel();
              tcm.removeColumn(tcm.getColumn(0)); //id alanını siler
        }
                 catch (ClassNotFoundException ex) {
                    Logger.getLogger(araclar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(araclar.class.getName()).log(Level.SEVERE, null, ex);
                }

    };
        });
             
             
             
             aracelde.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
               //  JOptionPane.showMessageDialog(pnz, "Aracınız Eklendi.");
                  // JOptionPane.showConfirmDialog(pns, "ok", "okk", 0, 0);
                
                 try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/otokira","root","");
            Statement stat =  conn.createStatement();
            String sorgu1="select * from tblarac where kiradaMi=false";
            
              ResultSet res = stat.executeQuery(sorgu1);
              tablo.setModel(DbUtils.resultSetToTableModel(res));
              TableColumnModel tcm = tablo.getColumnModel();
              tcm.removeColumn(tcm.getColumn(0)); //id alanını siler
        }
                 catch (ClassNotFoundException ex) {
                    Logger.getLogger(araclar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(araclar.class.getName()).log(Level.SEVERE, null, ex);
                }

    };
        });
        
        
    }
    
    
    
    
    
}
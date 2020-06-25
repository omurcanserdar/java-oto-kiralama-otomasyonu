
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
public class araceklesil {
    
    public JPanel pnx = new JPanel();
    
    
    
    public araceklesil() {
        
        //Gerekli veritabanı işlemlerini sen halledersin.
        
        
        pnx.setLayout(null);
        
        
        // Ana başlık labeli ekrana basılıyor..
         
        JLabel lbad = new JLabel();
        lbad.setText("Araç Ekle-Sil");
        lbad.setForeground(Color.WHITE);
        lbad.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnx.add(lbad);
        lbad.setBounds(15, 0, 150, 30);
        pnx.setBackground(Color.GRAY);
        
        //Form Oluşturuluyor.
        
        JLabel lblaracmarka = new JLabel("Eklenecek Arabanın Markası :");
        lblaracmarka.setForeground(Color.WHITE);
        lblaracmarka.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnx.add(lblaracmarka);
        lblaracmarka.setBounds(30, 30, 290, 30);
        
        JTextField earacmarka = new JTextField();
        this.pnx.add(earacmarka);
        earacmarka.setBounds(295, 30, 100, 30);
        
        JLabel lblaracmodel = new JLabel("Eklenecek Arabanın Modeli :");
        lblaracmodel.setForeground(Color.WHITE);
        lblaracmodel.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnx.add(lblaracmodel);
        lblaracmodel.setBounds(30, 80, 290, 30);
        
        JTextField earacmodel = new JTextField();
        this.pnx.add(earacmodel);
        earacmodel.setBounds(295, 80, 100, 30);
        
        JLabel lblaracplaka = new JLabel("Eklenecek Arabanın Plakası :");
        lblaracplaka.setForeground(Color.WHITE);
        lblaracplaka.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnx.add(lblaracplaka);
        lblaracplaka.setBounds(30, 130, 290, 30);
        
        JTextField earacplaka = new JTextField();
        this.pnx.add(earacplaka);
        earacplaka.setBounds(295, 130, 100, 30);
        
        JLabel lblaracyil = new JLabel("Eklenecek Arabanın Üretim Yılı :");
        lblaracyil.setForeground(Color.WHITE);
        lblaracyil.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnx.add(lblaracyil);
        lblaracyil.setBounds(30, 180, 290, 30);
        
        JTextField earacyil = new JTextField();
        this.pnx.add(earacyil);
        earacyil.setBounds(295, 180, 100, 30);
        
        JLabel lblarackm = new JLabel("Eklenecek Arabanın Km değeri :");
        lblarackm.setForeground(Color.WHITE);
        lblarackm.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnx.add(lblarackm);
        lblarackm.setBounds(30, 230, 290, 30);
        
        JTextField earackm = new JTextField();
        this.pnx.add(earackm);
        earackm.setBounds(295, 230, 100, 30);
        
        JLabel lblaracucret = new JLabel("Eklenecek Arabanın Saatlik Ücreti :");
        lblaracucret.setForeground(Color.WHITE);
        lblaracucret.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnx.add(lblaracucret);
        lblaracucret.setBounds(30, 280, 290, 30);
        
        JTextField earacucret = new JTextField();
        this.pnx.add(earacucret);
        earacucret.setBounds(295, 280, 100, 30);
        
        JButton ekle = new JButton("Aracı ekle");
        this.pnx.add(ekle);
        ekle.setBounds(295, 330, 100, 40);
        ekle.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                 try{
                 vt_sorgu vt=new vt_sorgu("jdbc:mysql://localhost:3306/otokira","root","");
                 vt.vt_baglan(); 
                    vt.AracEkle(
                         earacmarka.getText(),
                         earacmodel.getText(),
                         earacplaka.getText(),
                         Integer.parseInt(earacyil.getText()),
                         earackm.getText(), 
                         Double.parseDouble(earacucret.getText()));
                    JOptionPane.showMessageDialog(pnx, "Yeni araç ekleme başarılı","Yeni Araç",1);
                  }
                  catch(Exception ex){
                      System.out.println(ex.toString());
                  }
            }});
        
        
        //Çizgiden sonrası araç silme
        
        JLabel cizgi = new JLabel("--------------------------------------------------------------------------------------");
        cizgi.setForeground(Color.white);
        cizgi.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnx.add(cizgi);
        cizgi.setBounds(10, 390, 700, 30);
        
        JLabel aracsil = new JLabel("Araç Sil");
        aracsil.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        aracsil.setForeground(Color.white);
        this.pnx.add(aracsil);
        aracsil.setBounds(30,440,150,30);
        
        JLabel aracsil2 = new JLabel("Silmek istediğiniz Aracın Plaka Bilgilerini Giriniz :");
        aracsil2.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        aracsil2.setForeground(Color.white);
        this.pnx.add(aracsil2);
        aracsil2.setBounds(30,490,450,30);
        
        JTextField aracplakasil = new JTextField();
        this.pnx.add(aracplakasil);
        aracplakasil.setBounds(450, 490, 100, 30);
        
        JButton aracsilbtn = new JButton("Aracı sil");
        this.pnx.add(aracsilbtn);
        aracsilbtn.setBounds(550, 490, 100, 30);
        
        aracsilbtn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
               try{
                 vt_sorgu vt=new vt_sorgu("jdbc:mysql://localhost:3306/otokira","root","");
                 vt.vt_baglan(); 
                   int s=vt.AracSil(aracplakasil.getText());
                   if(s==1){
                      JOptionPane.showMessageDialog(pnx, "Araç kayıtlardan silindi ","Araç Silme",0); 
                   }    
                   else{
                      JOptionPane.showMessageDialog(pnx, "Araç kayıtlardan silinemedi ","Araç Silme",0); 
                   }
               }
               catch(Exception ex){
                 JOptionPane.showMessageDialog(pnx,ex.toString());

               }
            }});
        
        // Bu kısımda plaka ile araç seçip siliyoruz.
        // Ancak bir if ile yazılan plakaya ait bir araç var mı yokmu kontrolünü sağlarsın
        
        
        
       
              
     

        
       
      
       
         
        
       
        
        
    }
    
    
}

//import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import org.netbeans.lib.awtextra.AbsoluteLayout;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tolga
 */
public class kiralama {
    
    public JPanel pns = new JPanel();
    //private String istenen="";
    
    public kiralama(String ad){
        // Burda kontrol amaçlı paneli temizliyoruz.
        this.pns.removeAll();
        this.pns.repaint();
       
        // Componentleri istediğimiz gibi yerleştirmek için layoutunu null yapıyoruz.
       pns.setLayout(null);
        
        //Bu kısım ilk müşterinin TCNO'su ile sorgulanıp bulunduğu kısım
        JLabel lbad = new JLabel(ad);
        lbad.setText(ad);
        lbad.setForeground(Color.WHITE);
        lbad.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pns.add(lbad);
        lbad.setBounds(15, 0, 150, 30);
        pns.setBackground(Color.GRAY);
        
        JLabel lbmusteriad = new JLabel("Kiralama Yapacak Müşterinin TCNO'su :");
        lbad.setForeground(Color.WHITE);
        lbmusteriad.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pns.add(lbmusteriad);
        lbmusteriad.setBounds(25, 30, 340, 30);
        
        JTextField tcno = new JTextField();
        this.pns.add(tcno);
        tcno.setBounds(360, 30, 150, 30);
        tcno.setText("41294004688");
        
        JButton bul = new JButton("Bul");
        this.pns.add(bul);
        bul.setBounds(520, 30, 100, 30);
        
     bul.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    bulActionPerformed(evt);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(kiralama.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(kiralama.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            private void bulActionPerformed(ActionEvent evt) throws ClassNotFoundException, SQLException {
                   try {
           vt_sorgu vt=new vt_sorgu("jdbc:mysql://localhost:3306/otokira","root","");
           vt.vt_baglan(); 
           long tcv=Long.parseLong(tcno.getText());
                 Musteri mbul=vt.musteriBul(tcv);
                 if(tcv==mbul.getmTC()){
                     /*
                     == ile nesnelerin hafızada aynı yeri tutup tutmaması karşılaştırılır.
                .equals ile nesnelerin içindeki değerlerin birbirine eşit olup olmaması karşılaştırılır
                     */
                     // JOptionPane.showMessageDialog(pns, "OK");
                      JLabel mismi = new JLabel("Müşteri Ad:");
        mismi.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN , 18));
        mismi.setForeground(Color.white);
        pns.add(mismi);
        mismi.setBounds(25, 60, 110, 30);
        
        JLabel mismidb = new JLabel(mbul.getmAd());
        mismidb.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN , 18));
        mismidb.setForeground(Color.BLACK);
        pns.add(mismidb);
        mismidb.setBounds(120, 60, 140, 30);
        
        JLabel msoy = new JLabel("Müşteri Soyad:");
        msoy.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN , 18));
        msoy.setForeground(Color.white);
        pns.add(msoy);
        msoy.setBounds(330, 60, 150, 30);
        
        JLabel msoydb = new JLabel(mbul.getmSoyad());
        msoydb.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN , 18));
        msoydb.setForeground(Color.BLACK);
        pns.add(msoydb);
        msoydb.setBounds(450, 60, 100, 30);
        
        JLabel mtcno = new JLabel("Müşteri TC:");
        mtcno.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN , 18));
        mtcno.setForeground(Color.white);
        pns.add(mtcno);
        mtcno.setBounds(25, 80, 150, 30);
        
                JLabel mtcnodb = new JLabel(String.valueOf(mbul.getmTC()));
        mtcnodb.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN , 18));
        mtcnodb.setForeground(Color.BLACK);
        pns.add(mtcnodb);
        mtcnodb.setBounds(120, 80, 150, 30);
        
        JLabel mmail = new JLabel("Müşteri Email:");
        mmail.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN , 18));
        mmail.setForeground(Color.white);
        pns.add(mmail);
        mmail.setBounds(330, 80, 180, 30);
        
        JLabel mmaildb = new JLabel(mbul.getmEmail());
        mmaildb.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN , 18));
        mmaildb.setForeground(Color.BLACK);
        pns.add(mmaildb);
        mmaildb.setBounds(450, 80, 200, 30);
        
        JLabel secme = new JLabel("Kiralanacak Aracı Tablodan seçiniz");
        secme.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        secme.setForeground(Color.white);
        pns.add(secme);
        secme.setBounds(25, 100, 300, 30);
        
        bul.setEnabled(false);
        JButton btnkayitsec = new JButton("Araç Seçimini Tamamla");
        pns.add(btnkayitsec);
        btnkayitsec.setBounds(350, 105, 300, 30);
       
        
        //arac getirme
          JTable tablo = new JTable(); 
        tablo.setDefaultEditor(Object.class, null);
        JScrollPane pan = new JScrollPane(tablo);
        tablo.setRowHeight(20);
        tablo.setFont(new Font("Arial", Font.PLAIN,18));
        //Bağlantı oluşturma..
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/otokira","root","");
            Statement stat =  conn.createStatement();
            String sorgu1="select * from tblarac where kiradaMi=false";
            ResultSet res = stat.executeQuery(sorgu1);
            tablo.setModel(DbUtils.resultSetToTableModel(res));
            if(tablo.getRowCount()>0){
                TableColumnModel tcm = tablo.getColumnModel();
              tcm.removeColumn(tcm.getColumn(7)); //id alanını siler
                //İstenilen tablolr çalıştı. Bağlantı tamamdır.. 
         pns.add(pan);                   
        pan.setBounds(20, 135, 700, 350); //x,y,width,height
        //Tablo eklendi..
        //arac getirme son   
            }
            else{
              JOptionPane.showMessageDialog(pns,"Kiralamaya müsait araç yoktur");
            }
              
         //İstenilen tablolr çalıştı. Bağlantı tamamdır.. 
         pns.add(pan);                   
        pan.setBounds(20, 135, 700, 350); //x,y,width,height
        //Tablo eklendi..
        //arac getirme son   
        
        //datachooser
        JLabel malimtarih= new JLabel("Alım Tarih: ");
        malimtarih.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN , 18));
        malimtarih.setForeground(Color.white);
        pns.add(malimtarih);
        malimtarih.setBounds(20, 485, 130, 30);
        
         JDateChooser tarih1 =new JDateChooser();
        pns.add(tarih1);
        tarih1.setBounds(115, 485, 130, 33);
        pns.revalidate();
        pns.repaint();
        
         JLabel mteslimtarih= new JLabel("Teslim Tarih: ");
        mteslimtarih.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN , 18));
        mteslimtarih.setForeground(Color.white);
        pns.add(mteslimtarih);
        mteslimtarih.setBounds(20, 520, 130, 30);
        
         JDateChooser tarih2 = new JDateChooser();
        pns.add(tarih2);
        tarih2.setBounds(115, 520, 130, 33);
        
        pns.revalidate();
        pns.repaint();
        //datachooserson
        
        //arac secme
        btnkayitsec.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnkayitsecActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(kiralama.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

                          private void btnkayitsecActionPerformed(ActionEvent evt) throws SQLException {
        int tablo1satir=tablo.getSelectedRow();//Hangi satır olduğunu alıyor. 0dan başlıyor satırlar
        
        if(tablo1satir!=-1){
            String karac=tablo.getModel().getValueAt(tablo1satir, 4).toString();
            String kmusteri=mtcnodb.getText();
           Date alimtarih=tarih1.getDate();
           
           Date teslimtarih=tarih2.getDate();
           long fark=(teslimtarih.getTime()-alimtarih.getTime())/3600000;
           String saatlikucret=tablo.getModel().getValueAt(tablo1satir, 6).toString();
           double toplamucret=Double.parseDouble(saatlikucret)*fark;
        //   double toplamucret=fark*tablo.getModel().getValueAt(tablo1satir, 6);
            JOptionPane.showMessageDialog(pns, "Araç Plaka: "+karac+
                                               "\n Müşteri TC: "+kmusteri+
                                               "\n Alım Tarih: "+alimtarih+
                                               "\n Teslim Tarih: "+teslimtarih+
                                               "\n Kiralama Süresi(saat): "+fark+
                                               "\n Saatlik Üzerinden Toplam Ücret: "+toplamucret,
                                               "Kiralama Bilgileri...",
                                               JOptionPane.INFORMATION_MESSAGE);
            
              java.util.Date utilDate = new java.util.Date();
              java.sql.Date sqlDatealim = new java.sql.Date(alimtarih.getTime());
             java.sql.Date sqlDateteslim = new java.sql.Date(teslimtarih.getTime());
             
             int mid=mbul.getmID();
             int paracid=Integer.parseInt(tablo.getModel().getValueAt(tablo1satir,0).toString());
           // JOptionPane.showMessageDialog(pns,mid.getText()+" "+paracid);
           int snc=vt.KiraEkle(paracid,mid,sqlDatealim, sqlDateteslim, toplamucret);
           if(snc==1){
                 JOptionPane.showMessageDialog(pns,"Araç Kiralama Başarılı","Kiralama Bilgileri...",
                                               JOptionPane.INFORMATION_MESSAGE);
           }
        }
        else{
             JOptionPane.showMessageDialog(pns, "Lütfen Araç seçimi Yapınız !");
        }
        }
        });
        //arac secme son
                 }
                 else if(tcv==0){
                     JOptionPane.showMessageDialog(pns,
                "Kullanıcı Sistemde Kayıtlı Değil !! ",
                "Uyarı...",
                JOptionPane.WARNING_MESSAGE);
                    }
                 else if(mbul.getmTC()==0){
            {
                JOptionPane.showMessageDialog(pns,
                "Kullanıcı Sistemde Kayıtlı Değil !! ",
                "Uyarı...",
                JOptionPane.WARNING_MESSAGE);
            }
                 }
                 else{
                     JOptionPane.showMessageDialog(pns,"Bilinmeyen Hata");
                 }
           }
           catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(pns, ex.toString());
                     }
                 }
     });
             }
        }      
        // Tarih seçimi için JCalender kütüphanesinden eklediğim 
        // JDateChooser kullanıdım.
        // JDateChooserın döndürdüğü tarih değeri içinde saat ve bölgede içeriyor.
        // JDateChooserın gönderdiği içeriği gün-ay-yıl şeklinde düzenlemen gerekicez :)
        /*
        JDateChooser tarih1 = new JDateChooser();
        pns.add(tarih1);
        tarih1.setBounds(20, 420, 130, 33);
        //Burdaki kod actiolistener içine yazılan kütüphane componentlerini yerleştiriyor.
        //Bu kodu kaldırırsan JDateChooser sadece gri bir arka plan olarak gözüküyor.
        pns.revalidate();
        pns.repaint();
        JLabel tariharasi = new JLabel("'tarihinden");
        tariharasi.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        tariharasi.setForeground(Color.white);
        pns.add(tariharasi);
        tariharasi.setBounds(160, 423, 100, 30);
        JDateChooser tarih2 = new JDateChooser();
        pns.add(tarih2);
        tarih2.setBounds(270, 420, 130, 33);

        JButton tamamla = new JButton("Kiralama işlemini tamamla");
        tamamla.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
              int islem =  JOptionPane.showConfirmDialog(null,"Kiralama Tutarı toplam = tutar","İşlem Onayı",JOptionPane.YES_NO_OPTION );
                System.out.println(islem);
                // Burda İşlem Onayı mesajı çıkıyor yes'e basılırsa 0 dönüyor. İf ile kontrolünü sağlayıp 
                  //  Arabanın kira durumunu true yaparsın.
                    //Müşterininde yaptığı işlemlere kiralamayı eklersin 
                    //Bunun içinde bir müşteri log tablosu lazım oda senin maharetin :)
                
            }
        });
        pns.add(tamamla);
        tamamla.setBounds(525, 420, 200, 100);
                   */

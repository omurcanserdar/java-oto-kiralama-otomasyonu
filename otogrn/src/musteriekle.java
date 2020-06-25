import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tolga
 */
public class musteriekle {
    
    public JPanel pnz = new JPanel();
    
    
    public musteriekle()
    {
        pnz.setLayout(null);
        
         // Ana başlık labeli ekrana basılıyor..
         
        JLabel lbad = new JLabel();
        lbad.setText("Müşteri ekle");
        lbad.setForeground(Color.WHITE);
        lbad.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnz.add(lbad);
        lbad.setBounds(15, 0, 150, 30);
        pnz.setBackground(Color.GRAY);
        
        // Form oluşturuluyor.
        
        JLabel lblmusteritc = new JLabel("Eklenecek Müşterinin TCNO'su :");
        lblmusteritc.setForeground(Color.WHITE);
        lblmusteritc.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnz.add(lblmusteritc);
        lblmusteritc.setBounds(30, 30, 290, 30);
        
        JTextField emusteritc = new JTextField();
        this.pnz.add(emusteritc);
        emusteritc.setBounds(295, 30, 100, 30);
        
        JLabel lblmusteriad = new JLabel("Eklenecek Müşterinin adı :");
        lblmusteriad.setForeground(Color.WHITE);
        lblmusteriad.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnz.add(lblmusteriad);
        lblmusteriad.setBounds(30, 80, 290, 30);
        
        JTextField emusteriad = new JTextField();
        this.pnz.add(emusteriad);
        emusteriad.setBounds(295, 80, 100, 30);
        
        JLabel lblmusterisoyad = new JLabel("Eklenecek Müşterinin Soyadı :");
        lblmusterisoyad.setForeground(Color.WHITE);
        lblmusterisoyad.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnz.add(lblmusterisoyad);
        lblmusterisoyad.setBounds(30, 130, 290, 30);
        
        JTextField emusterisoyad = new JTextField();
        this.pnz.add(emusterisoyad);
        emusterisoyad.setBounds(295, 130, 100, 30);
        
        JLabel lblmusteritel = new JLabel("Eklenecek Müşterinin tel. no. :");
        lblmusteritel.setForeground(Color.WHITE);
        lblmusteritel.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnz.add(lblmusteritel);
        lblmusteritel.setBounds(30, 180, 290, 30);
        
        JTextField emusteritel = new JTextField();
        this.pnz.add(emusteritel);
        emusteritel.setBounds(295, 180, 100, 30);
        
        JLabel lblmusteriadres = new JLabel("Eklenecek Müşterinin adresi :");
        lblmusteriadres.setForeground(Color.WHITE);
        lblmusteriadres.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnz.add(lblmusteriadres);
        lblmusteriadres.setBounds(30, 230, 290, 30);
        
        JTextField emusteriadres = new JTextField();
        this.pnz.add(emusteriadres);
        emusteriadres.setBounds(295, 230, 100, 30);
        
        JLabel lblmusterimail = new JLabel("Eklenecek Müşterinin mail adresi :");
        lblmusterimail.setForeground(Color.WHITE);
        lblmusterimail.setFont(new Font("Kozuka Gothic Pr6n B", Font.PLAIN, 18));
        this.pnz.add(lblmusterimail);
        lblmusterimail.setBounds(30, 280, 290, 30);
        
        JTextField emusterimail = new JTextField();
        this.pnz.add(emusterimail);
        emusterimail.setBounds(295, 280, 100, 30);
        
        JButton mekle = new JButton("Müşteriyi ekle");
        this.pnz.add(mekle);
        mekle.setBounds(300, 330, 150, 40);
        mekle.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
               //  JOptionPane.showMessageDialog(pnz, "Aracınız Eklendi.");
                  // JOptionPane.showConfirmDialog(pns, "ok", "okk", 0, 0);
                
                  try{
                 vt_sorgu vt=new vt_sorgu("jdbc:mysql://localhost:3306/otokira","root","");
                 vt.vt_baglan(); 
                    vt.MusteriEkle(Long.parseLong(emusteritc.getText()),
                         emusteriad.getText(),
                         emusterisoyad.getText(),
                         Long.parseLong(emusteritel.getText()),
                         emusteriadres.getText(), 
                         emusterimail.getText());
                    JOptionPane.showMessageDialog(pnz, "Yeni müşteri ekleme başarılı","Yeni Müşteri",1);
                  }
                  catch(Exception ex){
                      System.out.println(ex.toString());
                  }

    };
        });
                }
}
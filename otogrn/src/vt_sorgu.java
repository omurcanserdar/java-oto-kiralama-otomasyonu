import java.awt.Component;
import java.sql.Connection; 
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ömür
 */

public class vt_sorgu {
    private Connection baglanti;
    private String vtyol,kullanici_ad,kullanici_sifre;

 public vt_sorgu(){
        this.baglanti=null;
        this.vtyol="";
        this.kullanici_ad="";
        this.kullanici_sifre="";
    }
 public vt_sorgu(String yyol,String yad,String ysifre){
        this.baglanti=null;
        this.vtyol=yyol;
        this.kullanici_ad=yad;
        this.kullanici_sifre=ysifre;
    }
 public void vt_baglan() throws SQLException{
            if(this.baglanti!=null){//bağlantı var ise
                if(this.baglanti.isClosed()==false){//kapatılmamış ise 
                    return; //çık
                }
            }
        this.baglanti=DriverManager.getConnection(this.vtyol, this.kullanici_ad, this.kullanici_sifre);
    }
  public void vt_baglantiKes()throws SQLException{
        if(this.baglanti!=null) //baglantı bos degilse
        {
            if(this.baglanti.isClosed()==false) //baglantı kapatılmamıssa
            {
                this.baglanti.close(); //baglantıyı kapat
            }
        }
    }
  
   public Kullanici kullaniciBul(String ad) throws SQLException{
       String sorgu="select * from tblkullanici where kullaniciAd=?"; 
       PreparedStatement p=this.baglanti.prepareStatement(sorgu);
       p.setString(1,ad);
       ResultSet sonuc= p.executeQuery();
       Kullanici k=null;
       
       if (sonuc.next()){
        k=new Kullanici();
        k.setkID(sonuc.getInt(1));
        k.setkAd(sonuc.getString(2));
        k.setkSifre(sonuc.getString(3));
       }
       return k; 
    }
   
   public Musteri musteriBul(long mp_tc) throws SQLException{
       String sorgu="select * from tblmusteri where TC=?"; 
       PreparedStatement p=this.baglanti.prepareStatement(sorgu);
       p.setLong(1,mp_tc);
       ResultSet sonuc= p.executeQuery();
       
       if (sonuc.next()){
      Musteri m=new Musteri();
        m.setmID(sonuc.getInt(1));
        m.setmTC(sonuc.getLong(2));
        m.setmAd(sonuc.getString(3));
        m.setSoyad(sonuc.getString(4));
        m.setTel(sonuc.getLong(5));
        m.setAdres(sonuc.getString(6));
        m.setEMail(sonuc.getString(7));
       return m;
       } 
       else{
           Musteri m=new Musteri();
           m.setmTC(0);
        return m;
       }
       
    }
   
   public int MusteriEkle (long TC,String ad,String soyad,long Tel,String adres,String Email) throws SQLException{
   String query = "insert into tblmusteri (TC,ad,soyad,telefon,adres,email) values (?, ?, ?, ?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt=this.baglanti.prepareStatement(query);
      preparedStmt.setLong(1, TC);
      preparedStmt.setString(2, ad);
      preparedStmt.setString(3, soyad);
      preparedStmt.setLong(4, Tel);
      preparedStmt.setString(5, adres);
      preparedStmt.setString(6, Email);
      return preparedStmt.executeUpdate();
   }
   
    public int AracEkle (String marka,String model,String plaka,int yil,String km,double ucret) throws SQLException{
   String query = "insert into tblarac(marka,model,plaka,yil,km,ucret) values (?, ?, ?, ?, ?, ?)";
      PreparedStatement preparedStmt=this.baglanti.prepareStatement(query);
      preparedStmt.setString(1, marka);
      preparedStmt.setString(2, model);
      preparedStmt.setString(3, plaka);
      preparedStmt.setInt(4, yil);
      preparedStmt.setString(5, km);
      preparedStmt.setDouble(6, ucret);
      return preparedStmt.executeUpdate();
}
    
    public int AracSil(String plaka) throws SQLException{
         String sil = "delete from tblarac where plaka = ?";
         PreparedStatement preparedStmt = this.baglanti.prepareStatement(sil);
         preparedStmt.setString(1, plaka);
            return preparedStmt.executeUpdate();
    }
    
    public int KiraEkle(int aracid,int musteri_id,Date alimtarih,Date teslimtarih,double ucret) throws SQLException{
      String query = "insert into tblkira(arac_id,musteri_id,alimTarih,teslimTarih,ucret) values (?, ?, ?, ?, ?)";
      PreparedStatement preparedStmt=this.baglanti.prepareStatement(query);
      preparedStmt.setInt(1, aracid);
      preparedStmt.setInt(2, musteri_id);
      preparedStmt.setDate(3, alimtarih);
      preparedStmt.setDate(4, teslimtarih);
      preparedStmt.setDouble(5, ucret);
      
      String sorgu2="update tblarac set kiradaMi=1 where id=?";
      PreparedStatement preparedStmt2=this.baglanti.prepareStatement(sorgu2);
      preparedStmt2.setInt(1, aracid);
      preparedStmt2.executeUpdate();
      
      return preparedStmt.executeUpdate();
    }
    
    public void MusteriKiraGecmisi(Component c,long tc) throws SQLException{
         String sorgum = "select tblmusteri.ad,tblarac.plaka,tblarac.marka,tblarac.model from tblkira,tblmusteri,tblarac where tblkira.musteri_id=tblmusteri.id and tblarac.id=tblkira.arac_id and tblmusteri.TC="+tc;
         PreparedStatement preparedStmt = this.baglanti.prepareStatement(sorgum);
       //  preparedStmt.setLong(1, tc);
        // preparedStmt.execute();   //select sorgusu icin executeUpdate() calısmaz 
         ResultSet rs = preparedStmt.executeQuery(sorgum);
            // Veriler ayıklanır.
            ArrayList<String> list = new ArrayList<String>();
                while(rs.next()){
                // Sutunlara göre degerlerı alıyoruz
               //6 String ad = rs.getString("ad");
                String plaka = rs.getString("plaka");
                String marka=rs.getString("marka");
                String model=rs.getString("model");
                list.add(plaka+" plakalı araç; marka => "+marka
                        + " model=> "+model+" \n");
            }
                if(list.size()>0)
        JOptionPane.showMessageDialog(c,list.subList(0, list.size()),"Kiralama Geçmişi",1);
 else
        JOptionPane.showMessageDialog(c,"Kiralama Geçmişi YOKTUR","Kiralama Geçmişi",1);                      
    }
}
   

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omurserdarr
 */
public class Musteri {
    private int mId;
    private long mTel;
    private long mTC;
    private String mAd,mSoyad,mAdres,mEmail;
    
        public Musteri(){
    this.mId=0; this.mTC=0; this.mTel=0;
    this.mAd="";this.mSoyad="";this.mAdres="";this.mEmail="";
    }
    
    public Musteri(int mID,long mTC,long mTel,String mAd,String mSoyad,String mAdres,String mEmail){
    this.mId=mID;this.mTC=mTC;this.mTel=mTel;
    this.mAd=mAd;this.mSoyad=mSoyad;this.mAdres=mAdres;this.mEmail=mEmail;
    }
    public int getmID(){return this.mId;}
    public long getmTC(){return this.mTC;}
    public String getmAd(){return this.mAd;}
    public String getmSoyad(){return this.mSoyad;}
    public long getmTel(){return this.mTel;}
    public String getmAdres(){return this.mAdres;}
    public String getmEmail(){return this.mEmail;}
    
    
    public void setmID(int mID){this.mId=mID;}
    public void setmTC(long mtc){this.mTC=mtc;}
    public void setmAd(String mAd){this.mAd=mAd;}
    public void setSoyad(String mSoyad){this.mSoyad=mSoyad;}
    public void setTel(long mTel){this.mTel=mTel;}
    public void setAdres(String mAdres){this.mAdres=mAdres;}
    public void setEMail(String mEmail){this.mEmail=mEmail;}
     
}

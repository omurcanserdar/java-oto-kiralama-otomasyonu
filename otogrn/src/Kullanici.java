/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author omurserdarr
 */
public class Kullanici {
    private int kId;
    private String kAd,kSifre;
    
        public Kullanici(){
    this.kId=0;
    this.kAd="";
    this.kSifre="";
    }
    
    public Kullanici(int kID,String kAd,String kSifre){
    this.kId=kID;
    this.kAd=kAd;
    this.kSifre=kSifre;
    }
    public int getkID(){return this.kId;}
    public String getkAd(){return this.kAd;}
    public String getkSifre(){return this.kSifre;}
    
    public void setkID(int kID){this.kId=kID;}
    public void setkAd(String kAd){this.kAd=kAd;}
    public void setkSifre(String kSifre){this.kSifre=kSifre;}
}

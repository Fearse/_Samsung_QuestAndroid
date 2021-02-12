package com.example.myapplication;

public class Situation {
    public Situation[] direction;
    public String subject;
    public String text;
    public String Var1;
    public String Var2;
    public String Var3;
    public int dRep;
    public int dMon;
    public int dHp;
    public Situation(String subject,String text, String Var1,String Var2,String Var3,int variants,int drep,int dmon,int dhp){
        this.subject=subject;
        this.text=text;
        this.Var1=Var1;
        this.Var2=Var2;
        this.Var3=Var3;
        dMon=dmon;
        dHp=dhp;
        dRep=drep;
        direction=new Situation[variants];
    }
}

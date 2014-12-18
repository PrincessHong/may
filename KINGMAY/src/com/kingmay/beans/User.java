package com.kingmay.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private String uid;
	private String ulname;
	private String ulpwd;
	private String uname;
	private String uque;
	private String uans;
	private int ucanuse = 0;
	private int uused = 0;
	private int ucanuse4 = 0;
	private int uused4 = 0;
	private String uemail;
	private String utel;
	private String ucom;
	private String ucomadd;
	private String upei;
	private String usex;
	private String uqq;
	private String uiden;
	private String uquan;
	private String ubir;
	private String umsn;
	private String uip;
	private String uicq;
	private String ustm;
	private String ulast;
	private String ubei;
	private String uren;
	public User(){}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUlname() {
		return ulname;
	}

	public void setUlname(String ulname) {
		this.ulname = ulname;
	}

	public String getUlpwd() {
		return ulpwd;
	}

	public void setUlpwd(String ulpwd) {
		this.ulpwd = ulpwd;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUque() {
		return uque;
	}

	public void setUque(String uque) {
		this.uque = uque;
	}

	public String getUans() {
		return uans;
	}

	public void setUans(String uans) {
		this.uans = uans;
	}

	public int getUcanuse() {
		return ucanuse;
	}

	public void setUcanuse(int ucanuse) {
		this.ucanuse = ucanuse;
	}

	public int getUused() {
		return uused;
	}

	public void setUused(int uused) {
		this.uused = uused;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUtel() {
		return utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	public String getUcom() {
		return ucom;
	}

	public void setUcom(String ucom) {
		this.ucom = ucom;
	}

	public String getUcomadd() {
		return ucomadd;
	}

	public void setUcomadd(String ucomadd) {
		this.ucomadd = ucomadd;
	}

	public String getUpei() {
		return upei;
	}

	public void setUpei(String upei) {
		this.upei = upei;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public String getUqq() {
		return uqq;
	}

	public void setUqq(String uqq) {
		this.uqq = uqq;
	}

	public String getUiden() {
		return uiden;
	}

	public void setUiden(String uiden) {
		this.uiden = uiden;
	}

	public String getUquan() {
		return uquan;
	}

	public void setUquan(String uquan) {
		this.uquan = uquan;
	}

	public String getUbir() {
		return ubir;
	}

	public void setUbir(String ubir) {
		this.ubir = ubir;
	}

	public String getUmsn() {
		return umsn;
	}

	public void setUmsn(String umsn) {
		this.umsn = umsn;
	}

	public String getUip() {
		return uip;
	}

	public void setUip(String uip) {
		this.uip = uip;
	}

	public String getUicq() {
		return uicq;
	}

	public void setUicq(String uicq) {
		this.uicq = uicq;
	}

	public String getUstm() {
		return ustm;
	}

	public void setUstm(String ustm) {
		this.ustm = ustm;
	}

	public String getUlast() {
		return ulast;
	}

	public String setlast(Date time) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String last = df.format(time);
		return last;
	}

	public String getUbei() {
		return ubei;
	}

	public void setUbei(String ubei) {
		this.ubei = ubei;
	}

	public void setUlast(String ulast) {
		this.ulast = ulast;
	}

	public String getUren() {
		return uren;
	}

	public void setUren(String uren) {
		this.uren = uren;
	}

	public int getUcanuse4() {
		return ucanuse4;
	}

	public void setUcanuse4(int ucanuse4) {
		this.ucanuse4 = ucanuse4;
	}

	public int getUused4() {
		return uused4;
	}

	public void setUused4(int uused4) {
		this.uused4 = uused4;
	}
	
	
	
}

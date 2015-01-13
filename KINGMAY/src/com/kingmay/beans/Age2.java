package com.kingmay.beans;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.table.A1226_311;
import com.kingmay.table.A2;
import com.kingmay.table.A26_28;
import com.kingmay.table.A29_211;
import com.kingmay.table.A3;
import com.kingmay.table.A33_35;
import com.kingmay.table.A36_38;
import com.kingmay.table.A39_311;
import com.kingmay.table.A3_32;
import com.kingmay.table.A4;
import com.kingmay.table.A5;
import com.kingmay.table.B1;
import com.kingmay.table.B10;
import com.kingmay.table.B11;
import com.kingmay.table.B2;
import com.kingmay.table.B3;
import com.kingmay.table.B4;
import com.kingmay.table.B5;
import com.kingmay.table.B6;
import com.kingmay.table.B7;
import com.kingmay.table.B8;
import com.kingmay.table.C1;
import com.kingmay.table.C2;
import com.kingmay.table.C3;
import com.kingmay.table.C4;

public class Age2 {
	private String aid;
	private String cid;
	private int rv = -1;
	private int bd = -1;
	private int pm = -1;
	private int inf = -1;
	private int oa = -1;
	private int zl = -1;
	private int pn = -1;
	private int rvl = 0;
	private int bdl = 0;
	private int pml = 0;
	private int infl = 0;
	private int oal = 0;
	private int zll = 0;
	private int pnl = 0;
	/*
	 * @para sp
	 * 置信区间 0-0.9 1-0.95 */
	private int sp = 0;
	/*
	 * @para ssp
	 * 比较基础 0-0.01 1-0.05 2-0.10 3-0.15*/
	private int ssp = 0;
	/*
	 * @para bjjc
	 * 比较基础 0-全样本 1-估计*/
	private int bjjc = 0;
	/*
	 * @para 0-替分 1-估计*/
	private int jsff = 0;
	private int vci = -1;
	private int vsi = -1;
	private int wmi = -1;
	private int fsiq = -1;
	private int vcii = 0;
	private int vsii = 0;
	private int wmii = 0;
	private int fsiqi = 0;
	private String vcib = "";
	private String vsib = "";
	private String wmib = "";
	private String fsiqb = "";
	private String vciz = "";
	private String vsiz = "";
	private String wmiz = "";
	private String fsiqz = "";
	private int zszf3 = 0;
	private float zsfs3jz = -1f;
	private float vcizsfscy = 0.0f;
	private float vsizsfscy = 0.0f;
	private float wmizsfscy = 0.0f;
	private float vcizsfsljz = 0.0f;
	private float vsizsfsljz = 0.0f;
	private float wmizsfsljz = 0.0f;
	private int vcizsfsqrx = 0;
	private int vsizsfsqrx = 0;
	private int wmizsfsqrx = 0;
	private String vcizsfsjcl = "";
	private String vsizsfsjcl = "";
	private String wmizsfsjcl = "";
	private int vcizzsfscy = 0;
	private int vsizzsfscy = 0;
	private int wmizzsfscy = 0;
	private float vcizzsljz = 0.0f;
	private float vsizzsljz = 0.0f;
	private float wmizzsljz = 0.0f;
	private int vcizzsqrx = 0;
	private int vsizzsqrx = 0;
	private int wmizzsqrx = 0;
	private String vcizzsjcl = "";
	private String vsizzsjcl = "";
	private String wmizzsjcl = "";
	private int zsfs6 = -1;
	private float zsfs6jz = -1f;
	private int zsfs6fsd = 0;
	private float zsfs6rvfscy = 0.0f;
	private float zsfs6infscy = 0.0f;
	private float zsfs6bdfscy = 0.0f;
	private float zsfs6oafscy = 0.0f;
	private float zsfs6pmfscy = 0.0f;
	private float zsfs6zlfscy = 0.0f;
	private float zsfs6rvljz = 0.0f;
	private float zsfs6inljz = 0.0f;
	private float zsfs6bdljz = 0.0f;
	private float zsfs6oaljz = 0.0f;
	private float zsfs6pmljz = 0.0f;
	private float zsfs6zlljz = 0.0f;
	private int zsfs6rvqrx = 0;
	private int zsfs6inqrx = 0;
	private int zsfs6bdqrx = 0;
	private int zsfs6oaqrx = 0;
	private int zsfs6pmqrx = 0;
	private int zsfs6zlqrx = 0;
	private String zsfs6rvjcl = "";
	private String zsfs6injcl = "";
	private String zsfs6bdjcl = "";
	private String zsfs6oajcl = "";
	private String zsfs6pmjcl = "";
	private String zsfs6zljcl = "";
	private int zsfs5 = 0;
	private float zsfs5jz = 0.0f;
	private int zsfs5fsd = 0;
	private float zsfs5rvfscy = 0.0f;
	private float zsfs5infscy = 0.0f;
	private float zsfs5bdfscy = 0.0f;
	private float zsfs5oafscy = 0.0f;
	private float zsfs5pmfscy = 0.0f;
	private float zsfs5zlfscy = 0.0f;
	private float zsfs5rvljz = 0.0f;
	private float zsfs5inljz = 0.0f;
	private float zsfs5bdljz = 0.0f;
	private float zsfs5oaljz = 0.0f;
	private float zsfs5pmljz = 0.0f;
	private float zsfs5zlljz = 0.0f;
	private int zsfs5rvqrx = 0;
	private int zsfs5inqrx = 0;
	private int zsfs5bdqrx = 0;
	private int zsfs5oaqrx = 0;
	private int zsfs5pmqrx = 0;
	private int zsfs5zlqrx = 0;
	private String zsfs5rvjcl = "";
	private String zsfs5injcl = "";
	private String zsfs5bdjcl = "";
	private String zsfs5oajcl = "";
	private String zsfs5pmjcl = "";
	private String zsfs5zljcl = "";
	private int vci_vsi = 0;
	private int vci_wmi = 0;
	private int vsi_wmi = 0;
	private int rv_in = 0;
	private int bd_oa = 0;
	private int pm_zl = 0;
	private float vci_vsiljz = 0.0f;
	private float vci_wmiljz = 0.0f;
	private float vsi_wmiljz = 0.0f;
	private float rv_inljz = 0.0f;
	private float bd_oaljz = 0.0f;
	private float pm_zlljz = 0.0f;
	private int vci_vsiqrx = 0;
	private int vci_wmiqrx = 0;
	private int vsi_wmiqrx = 0;
	private int rv_inqrx = 0;
	private int bd_oaqrx = 0;
	private int pm_zlqrx = 0;
	private String vci_vsijcl = "";
	private String vci_wmijcl = "";
	private String vsi_wmijcl = "";
	private String rv_injcl = "";
	private String bd_oajcl = "";
	private String pm_zljcl = "";
	private int vai = 0;
	private int nvi = 0;
	private int gai = 0;
	private int vaii = 0;
	private int nvii = 0;
	private int gaii = 0;
	private int vaizsfs = 0;
	private int nvizsfs = 0;
	private int gaizsfs = 0;
	private String vaib = "";
	private String nvib = "";
	private String gaib = "";
	private String vaizxqj = "";
	private String nvizxqj = "";
	private String gaizxqj = "";
	private int gai_fsiq;
	private float gai_fsiqljz;
	private int gai_fsiqcy;
	private String gai_fsiqjcl = "";
	private int rv_pn = 0;
	private float rv_pnljz = 0.0f;
	private int rv_pncy = 0;
	private String rv_pnjcl = "";
	
	public Age2(){}
	
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public int getRv() {
		return rv;
	}
	public void setRv(int rv) {
		this.rv = rv;
	}
	public int getBd() {
		return bd;
	}
	public void setBd(int bd) {
		this.bd = bd;
	}
	public int getPm() {
		return pm;
	}
	public void setPm(int pm) {
		this.pm = pm;
	}
	public int getInf() {
		return inf;
	}
	public void setInf(int inf) {
		this.inf = inf;
	}
	public int getOa() {
		return oa;
	}
	public void setOa(int oa) {
		this.oa = oa;
	}
	public int getZl() {
		return zl;
	}
	public void setZl(int zl) {
		this.zl = zl;
	}
	public int getPn() {
		return pn;
	}
	public void setPn(int pn) {
		this.pn = pn;
	}
	public int getSp() {
		return sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	public int getSsp() {
		return ssp;
	}
	public void setSsp(int ssp) {
		this.ssp = ssp;
	}
	public int getBjjc() {
		return bjjc;
	}
	public void setBjjc(int bjjc) {
		this.bjjc = bjjc;
	}
	public int getJsff() {
		return jsff;
	}
	public void setJsff(int jsff) {
		this.jsff = jsff;
	}
	public int getVci() {
		return vci;
	}
	public void setVci(int vci) {
		this.vci = vci;
	}
	public int getVsi() {
		return vsi;
	}
	public void setVsi(int vsi) {
		this.vsi = vsi;
	}
	public int getWmi() {
		return wmi;
	}
	public void setWmi(int wmi) {
		this.wmi = wmi;
	}
	public int getFsiq() {
		return fsiq;
	}
	public void setFsiq(int fsiq) {
		this.fsiq = fsiq;
	}
	public String getVcib() {
		return vcib;
	}
	public void setVcib(String vcib) {
		this.vcib = vcib;
	}
	public String getVsib() {
		return vsib;
	}
	public void setVsib(String vsib) {
		this.vsib = vsib;
	}
	public String getWmib() {
		return wmib;
	}
	public void setWmib(String wmib) {
		this.wmib = wmib;
	}
	public String getFsiqb() {
		return fsiqb;
	}
	public void setFsiqb(String fsiqb) {
		this.fsiqb = fsiqb;
	}
	public String getVciz() {
		return vciz;
	}
	public void setVciz(String vciz) {
		this.vciz = vciz;
	}
	public String getVsiz() {
		return vsiz;
	}
	public void setVsiz(String vsiz) {
		this.vsiz = vsiz;
	}
	public String getWmiz() {
		return wmiz;
	}
	public void setWmiz(String wmiz) {
		this.wmiz = wmiz;
	}
	public int getZszf3() {
		return zszf3;
	}
	public void setZszf3(int zszf3) {
		this.zszf3 = zszf3;
	}
	public float getZsfs3jz() {
		return zsfs3jz;
	}
	public void setZsfs3jz(float zsfs3jz) {
		this.zsfs3jz = zsfs3jz;
	}
	public float getVcizsfscy() {
		return vcizsfscy;
	}
	public void setVcizsfscy(float vcizsfscy) {
		this.vcizsfscy = vcizsfscy;
	}
	public float getVsizsfscy() {
		return vsizsfscy;
	}
	public void setVsizsfscy(float vsizsfscy) {
		this.vsizsfscy = vsizsfscy;
	}
	public float getWmizsfscy() {
		return wmizsfscy;
	}
	public void setWmizsfscy(float wmizsfscy) {
		this.wmizsfscy = wmizsfscy;
	}
	public float getVcizsfsljz() {
		return vcizsfsljz;
	}
	public void setVcizsfsljz(float vcizsfsljz) {
		this.vcizsfsljz = vcizsfsljz;
	}
	public float getVsizsfsljz() {
		return vsizsfsljz;
	}
	public void setVsizsfsljz(float vsizsfsljz) {
		this.vsizsfsljz = vsizsfsljz;
	}
	public float getWmizsfsljz() {
		return wmizsfsljz;
	}
	public void setWmizsfsljz(float wmizsfsljz) {
		this.wmizsfsljz = wmizsfsljz;
	}
	public int getVcizsfsqrx() {
		return vcizsfsqrx;
	}
	public void setVcizsfsqrx(int vcizsfsqrx) {
		this.vcizsfsqrx = vcizsfsqrx;
	}
	public int getVsizsfsqrx() {
		return vsizsfsqrx;
	}
	public void setVsizsfsqrx(int vsizsfsqrx) {
		this.vsizsfsqrx = vsizsfsqrx;
	}
	public int getWmizsfsqrx() {
		return wmizsfsqrx;
	}
	public void setWmizsfsqrx(int wmizsfsqrx) {
		this.wmizsfsqrx = wmizsfsqrx;
	}
	public String getVcizsfsjcl() {
		return vcizsfsjcl;
	}
	public void setVcizsfsjcl(String vcizsfsjcl) {
		this.vcizsfsjcl = vcizsfsjcl;
	}
	public String getVsizsfsjcl() {
		return vsizsfsjcl;
	}
	public void setVsizsfsjcl(String vsizsfsjcl) {
		this.vsizsfsjcl = vsizsfsjcl;
	}
	public String getWmizsfsjcl() {
		return wmizsfsjcl;
	}
	public void setWmizsfsjcl(String wmizsfsjcl) {
		this.wmizsfsjcl = wmizsfsjcl;
	}
	public int getVcizzsfscy() {
		return vcizzsfscy;
	}
	public void setVcizzsfscy(int vcizzsfscy) {
		this.vcizzsfscy = vcizzsfscy;
	}
	public int getVsizzsfscy() {
		return vsizzsfscy;
	}
	public void setVsizzsfscy(int vsizzsfscy) {
		this.vsizzsfscy = vsizzsfscy;
	}
	public int getWmizzsfscy() {
		return wmizzsfscy;
	}
	public void setWmizzsfscy(int wmizzsfscy) {
		this.wmizzsfscy = wmizzsfscy;
	}
	public float getVcizzsljz() {
		return vcizzsljz;
	}
	public void setVcizzsljz(float vcizzsljz) {
		this.vcizzsljz = vcizzsljz;
	}
	public float getVsizzsljz() {
		return vsizzsljz;
	}
	public void setVsizzsljz(float vsizzsljz) {
		this.vsizzsljz = vsizzsljz;
	}
	public float getWmizzsljz() {
		return wmizzsljz;
	}
	public void setWmizzsljz(float wmizzsljz) {
		this.wmizzsljz = wmizzsljz;
	}
	public int getVcizzsqrx() {
		return vcizzsqrx;
	}
	public void setVcizzsqrx(int vcizzsqrx) {
		this.vcizzsqrx = vcizzsqrx;
	}
	public int getVsizzsqrx() {
		return vsizzsqrx;
	}
	public void setVsizzsqrx(int vsizzsqrx) {
		this.vsizzsqrx = vsizzsqrx;
	}
	public int getWmizzsqrx() {
		return wmizzsqrx;
	}
	public void setWmizzsqrx(int wmizzsqrx) {
		this.wmizzsqrx = wmizzsqrx;
	}
	public String getVcizzsjcl() {
		return vcizzsjcl;
	}
	public void setVcizzsjcl(String vcizzsjcl) {
		this.vcizzsjcl = vcizzsjcl;
	}
	public String getVsizzsjcl() {
		return vsizzsjcl;
	}
	public void setVsizzsjcl(String vsizzsjcl) {
		this.vsizzsjcl = vsizzsjcl;
	}
	public String getWmizzsjcl() {
		return wmizzsjcl;
	}
	public void setWmizzsjcl(String wmizzsjcl) {
		this.wmizzsjcl = wmizzsjcl;
	}
	public int getZsfs6() {
		return zsfs6;
	}
	public void setZsfs6(int zsfs6) {
		this.zsfs6 = zsfs6;
	}
	public float getZsfs6jz() {
		return zsfs6jz;
	}
	public void setZsfs6jz(float zsfs6jz) {
		this.zsfs6jz = zsfs6jz;
	}
	public int getZsfs6fsd() {
		return zsfs6fsd;
	}
	public void setZsfs6fsd(int zsfs6fsd) {
		this.zsfs6fsd = zsfs6fsd;
	}
	public float getZsfs6rvfscy() {
		return zsfs6rvfscy;
	}
	public void setZsfs6rvfscy(float zsfs6rvfscy) {
		this.zsfs6rvfscy = zsfs6rvfscy;
	}
	public float getZsfs6infscy() {
		return zsfs6infscy;
	}
	public void setZsfs6infscy(float zsfs6infscy) {
		this.zsfs6infscy = zsfs6infscy;
	}
	public float getZsfs6bdfscy() {
		return zsfs6bdfscy;
	}
	public void setZsfs6bdfscy(float zsfs6bdfscy) {
		this.zsfs6bdfscy = zsfs6bdfscy;
	}
	public float getZsfs6oafscy() {
		return zsfs6oafscy;
	}
	public void setZsfs6oafscy(float zsfs6oafscy) {
		this.zsfs6oafscy = zsfs6oafscy;
	}
	public float getZsfs6pmfscy() {
		return zsfs6pmfscy;
	}
	public void setZsfs6pmfscy(float zsfs6pmfscy) {
		this.zsfs6pmfscy = zsfs6pmfscy;
	}
	public float getZsfs6zlfscy() {
		return zsfs6zlfscy;
	}
	public void setZsfs6zlfscy(float zsfs6zlfscy) {
		this.zsfs6zlfscy = zsfs6zlfscy;
	}
	public float getZsfs6rvljz() {
		return zsfs6rvljz;
	}
	public void setZsfs6rvljz(float zsfs6rvljz) {
		this.zsfs6rvljz = zsfs6rvljz;
	}
	public float getZsfs6inljz() {
		return zsfs6inljz;
	}
	public void setZsfs6inljz(float zsfs6inljz) {
		this.zsfs6inljz = zsfs6inljz;
	}
	public float getZsfs6bdljz() {
		return zsfs6bdljz;
	}
	public void setZsfs6bdljz(float zsfs6bdljz) {
		this.zsfs6bdljz = zsfs6bdljz;
	}
	public float getZsfs6oaljz() {
		return zsfs6oaljz;
	}
	public void setZsfs6oaljz(float zsfs6oaljz) {
		this.zsfs6oaljz = zsfs6oaljz;
	}
	public float getZsfs6pmljz() {
		return zsfs6pmljz;
	}
	public void setZsfs6pmljz(float zsfs6pmljz) {
		this.zsfs6pmljz = zsfs6pmljz;
	}
	public float getZsfs6zlljz() {
		return zsfs6zlljz;
	}
	public void setZsfs6zlljz(float zsfs6zlljz) {
		this.zsfs6zlljz = zsfs6zlljz;
	}
	public int getZsfs6rvqrx() {
		return zsfs6rvqrx;
	}
	public void setZsfs6rvqrx(int zsfs6rvqrx) {
		this.zsfs6rvqrx = zsfs6rvqrx;
	}
	public int getZsfs6inqrx() {
		return zsfs6inqrx;
	}
	public void setZsfs6inqrx(int zsfs6inqrx) {
		this.zsfs6inqrx = zsfs6inqrx;
	}
	public int getZsfs6bdqrx() {
		return zsfs6bdqrx;
	}
	public void setZsfs6bdqrx(int zsfs6bdqrx) {
		this.zsfs6bdqrx = zsfs6bdqrx;
	}
	public int getZsfs6oaqrx() {
		return zsfs6oaqrx;
	}
	public void setZsfs6oaqrx(int zsfs6oaqrx) {
		this.zsfs6oaqrx = zsfs6oaqrx;
	}
	public int getZsfs6pmqrx() {
		return zsfs6pmqrx;
	}
	public void setZsfs6pmqrx(int zsfs6pmqrx) {
		this.zsfs6pmqrx = zsfs6pmqrx;
	}
	public int getZsfs6zlqrx() {
		return zsfs6zlqrx;
	}
	public void setZsfs6zlqrx(int zsfs6zlqrx) {
		this.zsfs6zlqrx = zsfs6zlqrx;
	}
	public String getZsfs6rvjcl() {
		return zsfs6rvjcl;
	}
	public void setZsfs6rvjcl(String zsfs6rvjcl) {
		this.zsfs6rvjcl = zsfs6rvjcl;
	}
	public String getZsfs6injcl() {
		return zsfs6injcl;
	}
	public void setZsfs6injcl(String zsfs6injcl) {
		this.zsfs6injcl = zsfs6injcl;
	}
	public String getZsfs6bdjcl() {
		return zsfs6bdjcl;
	}
	public void setZsfs6bdjcl(String zsfs6bdjcl) {
		this.zsfs6bdjcl = zsfs6bdjcl;
	}
	public String getZsfs6oajcl() {
		return zsfs6oajcl;
	}
	public void setZsfs6oajcl(String zsfs6oajcl) {
		this.zsfs6oajcl = zsfs6oajcl;
	}
	public String getZsfs6pmjcl() {
		return zsfs6pmjcl;
	}
	public void setZsfs6pmjcl(String zsfs6pmjcl) {
		this.zsfs6pmjcl = zsfs6pmjcl;
	}
	public String getZsfs6zljcl() {
		return zsfs6zljcl;
	}
	public void setZsfs6zljcl(String zsfs6zljcl) {
		this.zsfs6zljcl = zsfs6zljcl;
	}
	public int getZsfs5() {
		return zsfs5;
	}
	public void setZsfs5(int zsfs5) {
		this.zsfs5 = zsfs5;
	}
	public float getZsfs5jz() {
		return zsfs5jz;
	}
	public void setZsfs5jz(float zsfs5jz) {
		this.zsfs5jz = zsfs5jz;
	}
	public int getZsfs5fsd() {
		return zsfs5fsd;
	}
	public void setZsfs5fsd(int zsfs5fsd) {
		this.zsfs5fsd = zsfs5fsd;
	}
	public float getZsfs5rvfscy() {
		return zsfs5rvfscy;
	}
	public void setZsfs5rvfscy(float zsfs5rvfscy) {
		this.zsfs5rvfscy = zsfs5rvfscy;
	}
	public float getZsfs5infscy() {
		return zsfs5infscy;
	}
	public void setZsfs5infscy(float zsfs5infscy) {
		this.zsfs5infscy = zsfs5infscy;
	}
	public float getZsfs5bdfscy() {
		return zsfs5bdfscy;
	}
	public void setZsfs5bdfscy(float zsfs5bdfscy) {
		this.zsfs5bdfscy = zsfs5bdfscy;
	}
	public float getZsfs5oafscy() {
		return zsfs5oafscy;
	}
	public void setZsfs5oafscy(float zsfs5oafscy) {
		this.zsfs5oafscy = zsfs5oafscy;
	}
	public float getZsfs5pmfscy() {
		return zsfs5pmfscy;
	}
	public void setZsfs5pmfscy(float zsfs5pmfscy) {
		this.zsfs5pmfscy = zsfs5pmfscy;
	}
	public float getZsfs5zlfscy() {
		return zsfs5zlfscy;
	}
	public void setZsfs5zlfscy(float zsfs5zlfscy) {
		this.zsfs5zlfscy = zsfs5zlfscy;
	}
	public float getZsfs5rvljz() {
		return zsfs5rvljz;
	}
	public void setZsfs5rvljz(float zsfs5rvljz) {
		this.zsfs5rvljz = zsfs5rvljz;
	}
	public float getZsfs5inljz() {
		return zsfs5inljz;
	}
	public void setZsfs5inljz(float zsfs5inljz) {
		this.zsfs5inljz = zsfs5inljz;
	}
	public float getZsfs5bdljz() {
		return zsfs5bdljz;
	}
	public void setZsfs5bdljz(float zsfs5bdljz) {
		this.zsfs5bdljz = zsfs5bdljz;
	}
	public float getZsfs5oaljz() {
		return zsfs5oaljz;
	}
	public void setZsfs5oaljz(float zsfs5oaljz) {
		this.zsfs5oaljz = zsfs5oaljz;
	}
	public float getZsfs5pmljz() {
		return zsfs5pmljz;
	}
	public void setZsfs5pmljz(float zsfs5pmljz) {
		this.zsfs5pmljz = zsfs5pmljz;
	}
	public float getZsfs5zlljz() {
		return zsfs5zlljz;
	}
	public void setZsfs5zlljz(float zsfs5zlljz) {
		this.zsfs5zlljz = zsfs5zlljz;
	}
	public int getZsfs5rvqrx() {
		return zsfs5rvqrx;
	}
	public void setZsfs5rvqrx(int zsfs5rvqrx) {
		this.zsfs5rvqrx = zsfs5rvqrx;
	}
	public int getZsfs5inqrx() {
		return zsfs5inqrx;
	}
	public void setZsfs5inqrx(int zsfs5inqrx) {
		this.zsfs5inqrx = zsfs5inqrx;
	}
	public int getZsfs5bdqrx() {
		return zsfs5bdqrx;
	}
	public void setZsfs5bdqrx(int zsfs5bdqrx) {
		this.zsfs5bdqrx = zsfs5bdqrx;
	}
	public int getZsfs5oaqrx() {
		return zsfs5oaqrx;
	}
	public void setZsfs5oaqrx(int zsfs5oaqrx) {
		this.zsfs5oaqrx = zsfs5oaqrx;
	}
	public int getZsfs5pmqrx() {
		return zsfs5pmqrx;
	}
	public void setZsfs5pmqrx(int zsfs5pmqrx) {
		this.zsfs5pmqrx = zsfs5pmqrx;
	}
	public int getZsfs5zlqrx() {
		return zsfs5zlqrx;
	}
	public void setZsfs5zlqrx(int zsfs5zlqrx) {
		this.zsfs5zlqrx = zsfs5zlqrx;
	}
	public String getZsfs5rvjcl() {
		return zsfs5rvjcl;
	}
	public void setZsfs5rvjcl(String zsfs5rvjcl) {
		this.zsfs5rvjcl = zsfs5rvjcl;
	}
	public String getZsfs5injcl() {
		return zsfs5injcl;
	}
	public void setZsfs5injcl(String zsfs5injcl) {
		this.zsfs5injcl = zsfs5injcl;
	}
	public String getZsfs5bdjcl() {
		return zsfs5bdjcl;
	}
	public void setZsfs5bdjcl(String zsfs5bdjcl) {
		this.zsfs5bdjcl = zsfs5bdjcl;
	}
	public String getZsfs5oajcl() {
		return zsfs5oajcl;
	}
	public void setZsfs5oajcl(String zsfs5oajcl) {
		this.zsfs5oajcl = zsfs5oajcl;
	}
	public String getZsfs5pmjcl() {
		return zsfs5pmjcl;
	}
	public void setZsfs5pmjcl(String zsfs5pmjcl) {
		this.zsfs5pmjcl = zsfs5pmjcl;
	}
	public String getZsfs5zljcl() {
		return zsfs5zljcl;
	}
	public void setZsfs5zljcl(String zsfs5zljcl) {
		this.zsfs5zljcl = zsfs5zljcl;
	}
	public int getVci_vsi() {
		return vci_vsi;
	}
	public void setVci_vsi(int vci_vsi) {
		this.vci_vsi = vci_vsi;
	}
	public int getVci_wmi() {
		return vci_wmi;
	}
	public void setVci_wmi(int vci_wmi) {
		this.vci_wmi = vci_wmi;
	}
	public int getVsi_wmi() {
		return vsi_wmi;
	}
	public void setVsi_wmi(int vsi_wmi) {
		this.vsi_wmi = vsi_wmi;
	}
	public int getRv_in() {
		return rv_in;
	}
	public void setRv_in(int rv_in) {
		this.rv_in = rv_in;
	}
	public int getBd_oa() {
		return bd_oa;
	}
	public void setBd_oa(int bd_oa) {
		this.bd_oa = bd_oa;
	}
	public int getPm_zl() {
		return pm_zl;
	}
	public void setPm_zl(int pm_zl) {
		this.pm_zl = pm_zl;
	}
	public float getVci_vsiljz() {
		return vci_vsiljz;
	}
	public void setVci_vsiljz(float vci_vsiljz) {
		this.vci_vsiljz = vci_vsiljz;
	}
	public float getVci_wmiljz() {
		return vci_wmiljz;
	}
	public void setVci_wmiljz(float vci_wmiljz) {
		this.vci_wmiljz = vci_wmiljz;
	}
	public float getVsi_wmiljz() {
		return vsi_wmiljz;
	}
	public void setVsi_wmiljz(float vsi_wmiljz) {
		this.vsi_wmiljz = vsi_wmiljz;
	}
	public float getRv_inljz() {
		return rv_inljz;
	}
	public void setRv_inljz(float rv_inljz) {
		this.rv_inljz = rv_inljz;
	}
	public float getBd_oaljz() {
		return bd_oaljz;
	}
	public void setBd_oaljz(float bd_oaljz) {
		this.bd_oaljz = bd_oaljz;
	}
	public float getPm_zlljz() {
		return pm_zlljz;
	}
	public void setPm_zlljz(float pm_zlljz) {
		this.pm_zlljz = pm_zlljz;
	}
	public int getVci_vsiqrx() {
		return vci_vsiqrx;
	}
	public void setVci_vsiqrx(int vci_vsiqrx) {
		this.vci_vsiqrx = vci_vsiqrx;
	}
	public int getVci_wmiqrx() {
		return vci_wmiqrx;
	}
	public void setVci_wmiqrx(int vci_wmiqrx) {
		this.vci_wmiqrx = vci_wmiqrx;
	}
	public int getVsi_wmiqrx() {
		return vsi_wmiqrx;
	}
	public void setVsi_wmiqrx(int vsi_wmiqrx) {
		this.vsi_wmiqrx = vsi_wmiqrx;
	}
	public int getRv_inqrx() {
		return rv_inqrx;
	}
	public void setRv_inqrx(int rv_inqrx) {
		this.rv_inqrx = rv_inqrx;
	}
	public int getBd_oaqrx() {
		return bd_oaqrx;
	}
	public void setBd_oaqrx(int bd_oaqrx) {
		this.bd_oaqrx = bd_oaqrx;
	}
	public int getPm_zlqrx() {
		return pm_zlqrx;
	}
	public void setPm_zlqrx(int pm_zlqrx) {
		this.pm_zlqrx = pm_zlqrx;
	}
	public String getVci_vsijcl() {
		return vci_vsijcl;
	}
	public void setVci_vsijcl(String vci_vsijcl) {
		this.vci_vsijcl = vci_vsijcl;
	}
	public String getVci_wmijcl() {
		return vci_wmijcl;
	}
	public void setVci_wmijcl(String vci_wmijcl) {
		this.vci_wmijcl = vci_wmijcl;
	}
	public String getVsi_wmijcl() {
		return vsi_wmijcl;
	}
	public void setVsi_wmijcl(String vsi_wmijcl) {
		this.vsi_wmijcl = vsi_wmijcl;
	}
	public String getRv_injcl() {
		return rv_injcl;
	}
	public void setRv_injcl(String rv_injcl) {
		this.rv_injcl = rv_injcl;
	}
	public String getBd_oajcl() {
		return bd_oajcl;
	}
	public void setBd_oajcl(String bd_oajcl) {
		this.bd_oajcl = bd_oajcl;
	}
	public String getPm_zljcl() {
		return pm_zljcl;
	}
	public void setPm_zljcl(String pm_zljcl) {
		this.pm_zljcl = pm_zljcl;
	}
	public int getVai() {
		return vai;
	}
	public void setVai(int vai) {
		this.vai = vai;
	}
	public int getNvi() {
		return nvi;
	}
	public void setNvi(int nvi) {
		this.nvi = nvi;
	}
	public int getGai() {
		return gai;
	}
	public void setGai(int gai) {
		this.gai = gai;
	}
	public int getVaizsfs() {
		return vaizsfs;
	}
	public void setVaizsfs(int vaizsfs) {
		this.vaizsfs = vaizsfs;
	}
	public int getNvizsfs() {
		return nvizsfs;
	}
	public void setNvizsfs(int nvizsfs) {
		this.nvizsfs = nvizsfs;
	}
	public int getGaizsfs() {
		return gaizsfs;
	}
	public void setGaizsfs(int gaizsfs) {
		this.gaizsfs = gaizsfs;
	}
	public String getVaib() {
		return vaib;
	}
	public void setVaib(String vaib) {
		this.vaib = vaib;
	}
	public String getNvib() {
		return nvib;
	}
	public void setNvib(String nvib) {
		this.nvib = nvib;
	}
	public String getGaib() {
		return gaib;
	}
	public void setGaib(String gaib) {
		this.gaib = gaib;
	}
	public String getVaizxqj() {
		return vaizxqj;
	}
	public void setVaizxqj(String vaizxqj) {
		this.vaizxqj = vaizxqj;
	}
	public String getNvizxqj() {
		return nvizxqj;
	}
	public void setNvizxqj(String nvizxqj) {
		this.nvizxqj = nvizxqj;
	}
	public String getGaizxqj() {
		return gaizxqj;
	}
	public void setGaizxqj(String gaizxqj) {
		this.gaizxqj = gaizxqj;
	}
	public int getGai_fsiq() {
		return gai_fsiq;
	}
	public void setGai_fsiq(int gai_fsiq) {
		this.gai_fsiq = gai_fsiq;
	}
	public float getGai_fsiqljz() {
		return gai_fsiqljz;
	}
	public void setGai_fsiqljz(float gai_fsiqljz) {
		this.gai_fsiqljz = gai_fsiqljz;
	}
	public int getGai_fsiqcy() {
		return gai_fsiqcy;
	}
	public void setGai_fsiqcy(int gai_fsiqcy) {
		this.gai_fsiqcy = gai_fsiqcy;
	}
	public String getGai_fsiqjcl() {
		return gai_fsiqjcl;
	}
	public void setGai_fsiqjcl(String gai_fsiqjcl) {
		this.gai_fsiqjcl = gai_fsiqjcl;
	}
	public int getRv_pn() {
		return rv_pn;
	}
	public void setRv_pn(int rv_pn) {
		this.rv_pn = rv_pn;
	}
	public float getRv_pnljz() {
		return rv_pnljz;
	}
	public void setRv_pnljz(float rv_pnljz) {
		this.rv_pnljz = rv_pnljz;
	}
	public int getRv_pncy() {
		return rv_pncy;
	}
	public void setRv_pncy(int rv_pncy) {
		this.rv_pncy = rv_pncy;
	}
	public String getRv_pnjcl() {
		return rv_pnjcl;
	}
	public void setRv_pnjcl(String rv_pnjcl) {
		this.rv_pnjcl = rv_pnjcl;
	}

	public int getRvl() {
		return rvl;
	}

	public void setRvl(int rvl) {
		this.rvl = rvl;
	}

	public int getBdl() {
		return bdl;
	}

	public void setBdl(int bdl) {
		this.bdl = bdl;
	}

	public int getPml() {
		return pml;
	}

	public void setPml(int pml) {
		this.pml = pml;
	}

	public int getInfl() {
		return infl;
	}

	public void setInfl(int infl) {
		this.infl = infl;
	}

	public int getOal() {
		return oal;
	}

	public void setOal(int oal) {
		this.oal = oal;
	}

	public int getZll() {
		return zll;
	}

	public void setZll(int zll) {
		this.zll = zll;
	}

	public int getPnl() {
		return pnl;
	}

	public void setPnl(int pnl) {
		this.pnl = pnl;
	}

	public int getVcii() {
		return vcii;
	}

	public void setVcii(int vcii) {
		this.vcii = vcii;
	}

	public int getVsii() {
		return vsii;
	}

	public void setVsii(int vsii) {
		this.vsii = vsii;
	}

	public int getWmii() {
		return wmii;
	}

	public void setWmii(int wmii) {
		this.wmii = wmii;
	}

	public int getFsiqi() {
		return fsiqi;
	}

	public void setFsiqi(int fsiqi) {
		this.fsiqi = fsiqi;
	}

	public String getFsiqz() {
		return fsiqz;
	}

	public void setFsiqz(String fsiqz) {
		this.fsiqz = fsiqz;
	}

	public int getVaii() {
		return vaii;
	}

	public void setVaii(int vaii) {
		this.vaii = vaii;
	}

	public int getNvii() {
		return nvii;
	}

	public void setNvii(int nvii) {
		this.nvii = nvii;
	}

	public int getGaii() {
		return gaii;
	}

	public void setGaii(int gaii) {
		this.gaii = gaii;
	}
	
	
	

	/**初始化时候计算age2分数
	 * @param rv
	 * @param bd
	 * @param pm
	 * @param inf
	 * @param oa
	 * @param zl
	 * @param pn
	 * @param sp
	 * @param ssp
	 * @param bjjc
	 * @param jsff
	 * @param Child c
	 * */
	public Age2(int rv , int bd ,int pm ,int inf ,int oa,int zl , int pn, int sp, int ssp,int bjjc, int jsff , Child c){
		this.rv = rv;
		this.bd = bd;
		this.pm = pm;
		this.inf = inf;
		this.oa = oa;
		this.zl = zl;
		this.pn = pn;
		this.sp = sp;
		this.ssp = ssp;
		this.bjjc = bjjc;
		this.jsff = jsff;
		
		toscore(c);
		
		
		
		//mark
		if(this.rv == -1 || this.inf == -1){
			this.vci =-1 ;
		}else if(this.rv == 0 && this.inf == 0){
			this.vci = -1;
		}else if(this.rv != -1 && this.inf != -1 ){
			this.vci = this.rvl + this.infl;
		}
		if(this.bd == -1 || this.oa == -1){
			this.vsi = -1;
		}else if(this.bd == 0 && this.oa == 0){
			this.vsi = -1;
		}else if(this.bd != -1 && this.oa != -1 ){
			this.vsi = this.bdl + this.oal;
		}
		if(this.pm == -1 || this.zl == -1){
			this.wmi = -1;
		}else if(this.pm == 0 && this.zl == 0){
			this.wmi = -1;
		}else if(this.pm != -1 && this.zl != -1 ){
			this.wmi = this.pml + this.zll;
		}
		
//		System.out.println(""+rv +" " + inf + " " +bd + " "+oa + " " + pm + " "+zl +
//				" vci"+vci+" vsi:"+vsi+"  wmi"+wmi);
		
		int count0 = 0;
		int count1 = 0;
		int[] ct_fsiq = ct_fsiq();

		
		/*没有分数缺失时候*/
		if(ct_fsiq[1] <1 && ct_fsiq[0] < 4){
			this.fsiq = this.rvl+ this.bdl + this.pml + this.infl + this.oal;
		}
		
		/*2个分数缺失 3个0分时候*/
		if(ct_fsiq[1] >1 || ct_fsiq[0] > 3){
			this.fsiq = -1;
		}
		
		/*0~1个分数缺失  < 3个零分、计算方法为替分时候*/
		if(ct_fsiq[1] >0 && ct_fsiq[1] <=1 && ct_fsiq[0] <4 && this.jsff == 0){
			this.fsiq = 0;
			this.fsiq += this.bdl + this.infl + this.oal;
			if(this.rv == -1){
				if(this.pn != -1){
					this.fsiq += this.pnl;
				}else{
					this.fsiq = -1;
				}
			}else{
				this.fsiq += this.rvl;
			}
			if(this.pm == -1){
				if(this.zl != -1){
					this.fsiq += this.zll;
				}else{
					this.fsiq = -1;
				}
			}else{
				this.fsiq += this.pml;
			}
			if(this.bd == -1 || this.inf == -1 || this.oa == -1){
//				this.fsiq = -1;
				if(this.bd == -1){
					this.fsiq += this.infl + this.oal; 
				}else if (this.inf == -1) {
					this.fsiq += this.bdl + this.oal; 
				}else if (this.oa == -1) {
					this.fsiq += this.bdl + this.infl; 
				}
				this.fsiq = A1226_311.a[this.fsiq -4 ];
			}
//			float a =B11.cpi_b_gai[0-1];
		}
		
		/*比例估算法*/
		if((ct_fsiq[1] >= 2 || ct_fsiq[0] > 3) && this.jsff == 1){
			this.fsiq = -1;
		}else if(ct_fsiq[1] <=1 && ct_fsiq[0] < 2 && this.jsff == 1){
			this.fsiq = this.rvl + this.bdl + this.pml + this.infl +this.oal;
			this.fsiq = A1226_311.a[this.fsiq - 4];
		}
		
		if(this.vci != -1){
			this.vcii = A2.vcii[this.vci-2];
			this.vcib = A2.vcib[this.vci-2];
			if(this.sp == 0){
				this.vciz = A2.z90[this.vci-2];
			}else{
				this.vciz = A2.z95[this.vci-2];
			}
		}
		
		if(this.vsi != -1){
			this.vsii = A3.vsii[this.vsi-2];
			this.vsib = A3.vsib[this.vsi-2];
			if(this.sp == 0){
				this.vsiz = A3.z90[this.vsi-2];
			}else{
				this.vsiz = A3.z95[this.vsi-2];
			}
		}
		
		if(this.wmi != -1){
			this.wmii = A4.wmii[this.wmi-2];
			this.wmib = A4.wmib[this.wmi-2];
			if(this.sp == 0){
				this.wmiz = A4.z90[this.wmi-2];
			}else{
				this.wmiz = A4.z95[this.wmi-2];
			}
		}
		
		if(this.fsiq != -1){
			this.fsiqi = A5.fsiqi[this.fsiq-5];
			this.fsiqb = A5.fsiqb[this.fsiq-5];
			if(this.sp == 0){
				this.fsiqz = A5.z90[this.fsiq-5];
			}else{
				this.fsiqz = A5.z95[this.fsiq-5];
			}
		}
		
		zsfs3();
		cy();
		qrpd();
		//mark1 end
		cybjb();
		
		fuzu();
		
		//mark4 end;
//		putoutall(this);
	}
	
	//计算分散度
	public int com_fen(int rvl , int bdl , int pml , int zll ,int oal ,int infl){
		int max=0,min=999;
		int a[] = new int[]{rvl,bdl,pml,zll,oal,infl};
		for(int i = 0 ; i < 6 ;i++){
			if(a[i]>max){
				max = a[i];
			}
			if(a[i] < min){
				min = a[i];
			}
		}
		return max-min;
	}
	
	//计算分散度_缺失
	public int com_fen_q(){
		int max=0,min=999;
		int[] a = new int[]{0,0,0,0,0,0};
		int i = 0;
		if(this.rv != -1){
			a[i] = this.rvl;
			i= i+1;
		}else{
			a[i] = this.pnl;
			i++;
		}
		if(this.bd != -1){
			a[i] = this.bdl;
			i++;
		}
		if(this.pm != -1){
			a[i] = this.pml;
			i++;
		}
		if(this.oa != -1){
			a[i] = this.oal;
			i++;
		}
		if(this.inf != -1){
			a[i] = this.infl;
			i++;
		}
		if(this.zl != -1){
			a[i] = this.zll;
			i++;
		}
		for(int j = 0 ; j< a.length ; j++){
			if(a[j]>max && a[j]!=0){
				max = a[j];
			}
			if(a[j] < min && a[j]!=0){
				min = a[j];
			}
		}
		System.out.println("min max="+ min+" "+ max);
		return max - min;
	}
	
	//计算0分个数
	public int com_zero(int bd,int pm,int oa,int zl){
		int count = 0;
		int[] a = new int[]{bd,pm,oa,zl};
		for(int i = 0; i< a.length ; i++){
			if(a[i] == 0){
				count++;
			}
		}
		return count;
	}
	
	//计算0分个数
	public int[] com_allzero(int bd,int pm,int oa,int zl,int rv){
		int count[] = new int[]{0,0};
		int[] a = new int[]{bd,pm,oa,zl,rv};
		for(int i = 0; i< a.length ; i++){
			if(a[i] == 0){
				count[0]++;
			}
			if(a[i] == -1){
				count[1]++;
			}
		}
		return count;
	}
	
	
	public void nothing(){
		if(this.rv != -1){
		}
		if(this.bd != -1){
		}
		if(this.pm != -1){
		}
		if(this.zl != -1){
		}
		if(this.oa != -1){
		}
		if(this.inf != -1){
		}
	}
	
	private void putoutall(Age2 a){
		System.out.println("rv "+a.rv);
		System.out.println("bd "+a.bd);
		System.out.println("pm "+a.pm);
		System.out.println("inf "+a.inf);
		System.out.println("oa "+a.oa);
		System.out.println("zl "+a.zl);
		System.out.println("pn "+a.pn);
		System.out.println("rvl "+a.rvl);
		System.out.println("bdl "+a.bdl);
		System.out.println("pml "+a.pml);
		System.out.println("infl "+a.infl);
		System.out.println("oal "+a.oal);
		System.out.println("zll "+a.zll);
		System.out.println("pnl "+a.pnl);
		System.out.println("sp "+a.sp);
		System.out.println("ssp "+a.ssp);
		System.out.println("bjjc "+a.bjjc);
		System.out.println("jsff "+a.jsff);
		System.out.println("vci "+a.vci);
		System.out.println("vsi "+a.vsi);
		System.out.println("wmi "+a.wmi);
		System.out.println("fsiq "+a.fsiq);
		System.out.println("vcii "+a.vcii);
		System.out.println("vsii "+a.vsii);
		System.out.println("wmii "+a.wmii);
		System.out.println("fsiqi "+a.fsiqi);
		System.out.println("vcib "+a.vcib);
		System.out.println("vsib;"+a.vsib);
		System.out.println("wmib;"+a.wmib);
		System.out.println("fsiqb;"+a.fsiqb);
		System.out.println("vciz;"+a.vciz);
		System.out.println("vsiz;"+a.vsiz);
		System.out.println("wmiz;"+a.wmiz);
		System.out.println("fsiqz;"+a.fsiqz);
		System.out.println("zszf3 "+a.zszf3 );
		System.out.println("zsfs3jz "+a.zsfs3jz );
		System.out.println("vcizsfscy "+a.vcizsfscy );
		System.out.println("vsizsfscy "+a.vsizsfscy );
		System.out.println("wmizsfscy "+a.wmizsfscy );
		System.out.println("vcizsfsljz "+a.vcizsfsljz );
		System.out.println("vsizsfsljz "+a.vsizsfsljz );
		System.out.println("wmizsfsljz "+a.wmizsfsljz );
		System.out.println("vcizsfsqrx "+a.vcizsfsqrx );
		System.out.println("vsizsfsqrx "+a.vsizsfsqrx );
		System.out.println("wmizsfsqrx "+a.wmizsfsqrx );
		System.out.println("vcizsfsjcl;"+a.vcizsfsjcl);
		System.out.println("vsizsfsjcl;"+a.vsizsfsjcl);
		System.out.println("wmizsfsjcl;"+a.wmizsfsjcl);
		System.out.println("vcizzsfscy "+a.vcizzsfscy );
		System.out.println("vsizzsfscy "+a.vsizzsfscy );
		System.out.println("wmizzsfscy "+a.wmizzsfscy );
		System.out.println("vcizzsljz "+a.vcizzsljz );
		System.out.println("vsizzsljz "+a.vsizzsljz );
		System.out.println("wmizzsljz "+a.wmizzsljz );
		System.out.println("vcizzsqrx "+a.vcizzsqrx );
		System.out.println("vsizzsqrx "+a.vsizzsqrx );
		System.out.println("wmizzsqrx "+a.wmizzsqrx );
		System.out.println("vcizzsjcl;"+a.vcizzsjcl);
		System.out.println("vsizzsjcl;"+a.vsizzsjcl);
		System.out.println("wmizzsjcl;"+a.wmizzsjcl);
		System.out.println("zsfs6 "+a.zsfs6 );
		System.out.println("zsfs6jz "+a.zsfs6jz );
		System.out.println("zsfs6fsd "+a.zsfs6fsd );
		System.out.println("zsfs6rvfscy "+a.zsfs6rvfscy );
		System.out.println("zsfs6infscy "+a.zsfs6infscy );
		System.out.println("zsfs6bdfscy "+a.zsfs6bdfscy );
		System.out.println("zsfs6oafscy "+a.zsfs6oafscy );
		System.out.println("zsfs6pmfscy "+a.zsfs6pmfscy );
		System.out.println("zsfs6zlfscy "+a.zsfs6zlfscy );
		System.out.println("zsfs6rvljz "+a.zsfs6rvljz );
		System.out.println("zsfs6inljz "+a.zsfs6inljz );
		System.out.println("zsfs6bdljz "+a.zsfs6bdljz );
		System.out.println("zsfs6oaljz "+a.zsfs6oaljz );
		System.out.println("zsfs6pmljz "+a.zsfs6pmljz );
		System.out.println("zsfs6zlljz "+a.zsfs6zlljz );
		System.out.println("zsfs6rvqrx "+a.zsfs6rvqrx );
		System.out.println("zsfs6inqrx "+a.zsfs6inqrx );
		System.out.println("zsfs6bdqrx "+a.zsfs6bdqrx );
		System.out.println("zsfs6oaqrx "+a.zsfs6oaqrx );
		System.out.println("zsfs6pmqrx "+a.zsfs6pmqrx );
		System.out.println("zsfs6zlqrx "+a.zsfs6zlqrx );
		System.out.println("zsfs6rvjcl;"+a.zsfs6rvjcl);
		System.out.println("zsfs6injcl;"+a.zsfs6injcl);
		System.out.println("zsfs6bdjcl;"+a.zsfs6bdjcl);
		System.out.println("zsfs6oajcl;"+a.zsfs6oajcl);
		System.out.println("zsfs6pmjcl;"+a.zsfs6pmjcl);
		System.out.println("zsfs6zljcl;"+a.zsfs6zljcl);
		System.out.println("zsfs5 "+a.zsfs5 );
		System.out.println("zsfs5jz "+a.zsfs5jz );
		System.out.println("zsfs5fsd "+a.zsfs5fsd );
		System.out.println("zsfs5rvfscy "+a.zsfs5rvfscy );
		System.out.println("zsfs5infscy "+a.zsfs5infscy );
		System.out.println("zsfs5bdfscy "+a.zsfs5bdfscy );
		System.out.println("zsfs5oafscy "+a.zsfs5oafscy );
		System.out.println("zsfs5pmfscy "+a.zsfs5pmfscy );
		System.out.println("zsfs5zlfscy "+a.zsfs5zlfscy );
		System.out.println("zsfs5rvljz "+a.zsfs5rvljz );
		System.out.println("zsfs5inljz "+a.zsfs5inljz );
		System.out.println("zsfs5bdljz "+a.zsfs5bdljz );
		System.out.println("zsfs5oaljz "+a.zsfs5oaljz );
		System.out.println("zsfs5pmljz "+a.zsfs5pmljz );
		System.out.println("zsfs5zlljz "+a.zsfs5zlljz );
		System.out.println("zsfs5rvqrx "+a.zsfs5rvqrx );
		System.out.println("zsfs5inqrx "+a.zsfs5inqrx );
		System.out.println("zsfs5bdqrx "+a.zsfs5bdqrx );
		System.out.println("zsfs5oaqrx "+a.zsfs5oaqrx );
		System.out.println("zsfs5pmqrx "+a.zsfs5pmqrx );
		System.out.println("zsfs5zlqrx "+a.zsfs5zlqrx );
		System.out.println("zsfs5rvjcl;"+a.zsfs5rvjcl);
		System.out.println("zsfs5injcl;"+a.zsfs5injcl);
		System.out.println("zsfs5bdjcl;"+a.zsfs5bdjcl);
		System.out.println("zsfs5oajcl;"+a.zsfs5oajcl);
		System.out.println("zsfs5pmjcl;"+a.zsfs5pmjcl);
		System.out.println("zsfs5zljcl;"+a.zsfs5zljcl);
		System.out.println("vci_vsi "+a.vci_vsi);
		System.out.println("vci_wmi "+a.vci_wmi );
		System.out.println("vsi_wmi "+a.vsi_wmi );
		System.out.println("rv_in "+a.rv_in );
		System.out.println("bd_oa "+a.bd_oa );
		System.out.println("pm_zl "+a.pm_zl );
		System.out.println("vci_vsiljz "+a.vci_vsiljz );
		System.out.println("vci_wmiljz "+a.vci_wmiljz );
		System.out.println("vsi_wmiljz "+a.vsi_wmiljz );
		System.out.println("rv_inljz " +a.rv_inljz );
		System.out.println("bd_oaljz "+a.bd_oaljz );
		System.out.println("pm_zlljz "+a.pm_zlljz );
		System.out.println("vci_vsiqrx "+a.vci_vsiqrx );
		System.out.println("vci_wmiqrx "+a.vci_wmiqrx );
		System.out.println("vsi_wmiqrx "+a.vsi_wmiqrx );
		System.out.println("rv_inqrx "+a.rv_inqrx );
		System.out.println("bd_oaqrx "+a.bd_oaqrx );
		System.out.println("pm_zlqrx "+a.pm_zlqrx );
		System.out.println("vci_vsijcl;"+a.vci_vsijcl);
		System.out.println("vci_wmijcl;"+a.vci_wmijcl);
		System.out.println("vsi_wmijcl;"+a.vsi_wmijcl);
		System.out.println("rv_injcl;"+a.rv_injcl);
		System.out.println("bd_oajcl"+a.bd_oajcl);
		System.out.println("pm_zljcl;"+a.pm_zljcl);
		System.out.println("vai "+a.vai );
		System.out.println("nvi "+a.nvi );
		System.out.println("gai "+a.gai );
		System.out.println("vaii "+a.vaii );
		System.out.println("nvii "+a.nvii );
		System.out.println("gaii "+a.gaii );
		System.out.println("vaizsfs "+a.vaizsfs );
		System.out.println("nvizsfs "+a.nvizsfs );
		System.out.println("gaizsfs "+a.gaizsfs );
		System.out.println("vaib;"+a.vaib);
		System.out.println("nvib;"+a.nvib);
		System.out.println("gaib;"+a.gaib);
		System.out.println("vaizxqj;"+a.vaizxqj);
		System.out.println("nvizxqj;"+a.nvizxqj);
		System.out.println("gaizxqj;"+a.gaizxqj);
		System.out.println("gai_fsiq;"+a.gai_fsiq);
		System.out.println("gai_fsiqljz;"+a.gai_fsiqljz);
		System.out.println("gai_fsiqcy;"+a.gai_fsiqcy);
		System.out.println("gai_fsiqjcl;"+ a.gai_fsiqjcl);
		System.out.println("rv_pn "+a.rv_pn );
		System.out.println("rv_pnljz "+a.rv_pnljz);
		System.out.println("rv_pncy "+a.rv_pncy );
		System.out.println("rv_pnjcl;"+a.rv_pnjcl);
		
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
		
		
	}
	
	private float change2(float in){
		BigDecimal b = new BigDecimal(in); 
		float out = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue(); ;
		return out;
	}
	
	private int count_zsfs(){
		int i=0 ;
		if(this.rv == -1){
			i++;
		}
		if(this.inf == -1){
			i++;
		}
		if(this.bd == -1){
			i++;
		}
		if(this.oa == -1){
			i++;
		}
		if(this.pm == -1){
			i++;
		}
		if(this.zl == -1){
			i++;
		}
		return i;
	}
	
	private void toscore(Child c){
		int year = c.getCyear() , month = c.getCmonth();
		if(year == 2 && (month >= 6 && month <= 8)){
			if(this.rv != -1){
				this.rvl = A26_28.a1_rv[rv];
			}
			if(this.bd != -1){
				this.bdl = A26_28.a1_bd[bd];
			}
			if(this.pm != -1){
				this.pml = A26_28.a1_pm[pm];
			}
			if(this.inf != -1){
				this.infl = A26_28.a1_inf[inf];
			}
			if(this.oa != -1){
				this.oal = A26_28.a1_oa[oa];
			}
			if(this.zl != -1){
				this.zll = A26_28.a1_zl[zl];
			}
			if(this.pn != -1){
				this.pnl = A26_28.a1_pn[pn];
			}
		}
		if(year == 2 && (month >= 9 && month <= 11)){
			if(this.rv != -1){
				this.rvl = A29_211.a1_rv[rv];
			}
			if(this.bd != -1){
				this.bdl = A29_211.a1_bd[bd];
			}
			if(this.pm != -1){
				this.pml = A29_211.a1_pm[pm];
			}
			if(this.inf != -1){
				this.infl = A29_211.a1_inf[inf];
			}
			if(this.oa != -1){
				this.oal = A29_211.a1_oa[oa];
			}
			if(this.zl != -1){
				this.zll = A29_211.a1_zl[zl];
			}
			if(this.pn != -1){
				this.pnl = A29_211.a1_pn[pn];
			}
		}
		
		if(year == 3 && (month >= 0 && month <= 2)){
			if(this.rv != -1){
				this.rvl = A3_32.a1_rv[rv];
			}
			if(this.bd != -1){
				this.bdl = A3_32.a1_bd[bd];
			}
			if(this.pm != -1){
				this.pml = A3_32.a1_pm[pm];
			}
			if(this.inf != -1){
				this.infl = A3_32.a1_inf[inf];
			}
			if(this.oa != -1){
				this.oal = A3_32.a1_oa[oa];
			}
			if(this.zl != -1){
				this.zll = A3_32.a1_zl[zl];
			}
			if(this.pn != -1){
				this.pnl = A3_32.a1_pn[pn];
			}
		}
		if(year == 3 && (month >= 3 && month <= 5)){
			if(this.rv != -1){
				this.rvl = A33_35.a1_rv[rv];
			}
			if(this.bd != -1){
				this.bdl = A33_35.a1_bd[bd];
			}
			if(this.pm != -1){
				this.pml = A33_35.a1_pm[pm];
			}
			if(this.inf != -1){
				this.infl = A33_35.a1_inf[inf];
			}
			if(this.oa != -1){
				this.oal = A33_35.a1_oa[oa];
			}
			if(this.zl != -1){
				this.zll = A33_35.a1_zl[zl];
			}
			if(this.pn != -1){
				this.pnl = A33_35.a1_pn[pn];
			}
		}
		
		if(year == 3 && (month >= 6 && month <= 8)){
			if(this.rv != -1){
				this.rvl = A36_38.a1_rv[rv];
			}
			if(this.bd != -1){
				this.bdl = A36_38.a1_bd[bd];
			}
			if(this.pm != -1){
				this.pml = A36_38.a1_pm[pm];
			}
			if(this.inf != -1){
				this.infl = A36_38.a1_inf[inf];
			}
			if(this.oa != -1){
				this.oal = A36_38.a1_oa[oa];
			}
			if(this.zl != -1){
				this.zll = A36_38.a1_zl[zl];
			}
			if(this.pn != -1){
				this.pnl = A36_38.a1_pn[pn];
			}
		}
		if(year == 3 && (month >= 9 && month <= 11)){
			if(this.rv != -1){
				this.rvl = A39_311.a1_rv[rv];
			}
			if(this.bd != -1){
				this.bdl = A39_311.a1_bd[bd];
			}
			if(this.pm != -1){
				this.pml = A39_311.a1_pm[pm];
			}
			if(this.inf != -1){
				this.infl = A39_311.a1_inf[inf];
			}
			if(this.oa != -1){
				this.oal = A39_311.a1_oa[oa];
			}
			if(this.zl != -1){
				this.zll = A39_311.a1_zl[zl];
			}
			if(this.pn != -1){
				this.pnl = A39_311.a1_pn[pn];
			}
		}
	}
	
	private void zsfs3(){
		//mark
		//指数水平 强项与弱项确定表_完整
		if(this.wmi !=-1 && this.vci!= -1 && this.vsi != -1){
			this.zszf3 = this.vcii + this.vsii + this.wmii ;
			this.zsfs3jz = change2((float)this.zszf3/3);
			
			//分数差异
			this.vcizsfscy = change2((float)this.vcii - this.zsfs3jz);
			this.vsizsfscy = change2((float)this.vsii - this.zsfs3jz);
			this.wmizsfscy = change2((float)this.wmii - this.zsfs3jz);
			
			//临界值
			if(this.ssp == 0){
				this.vcizsfsljz = B1.vci_mis01;
			}else if(this.ssp == 1){
				this.vcizsfsljz = B1.vci_mis05;
			}else if(this.ssp == 2){
				this.vcizsfsljz = B1.vci_mis10;
			}else if(this.ssp == 3){
				this.vcizsfsljz = B1.vci_mis15;
			}
			
			if(this.ssp == 0){
				this.vsizsfsljz = B1.vsi_mis01;
			}else if(this.ssp == 1){
				this.vsizsfsljz = B1.vsi_mis05;
			}else if(this.ssp == 2){
				this.vsizsfsljz = B1.vsi_mis10;
			}else if(this.ssp == 3){
				this.vsizsfsljz = B1.vsi_mis15;
			}
			
			if(this.ssp == 0){
				this.wmizsfsljz = B1.wmi_mis01;
			}else if(this.ssp == 1){
				this.wmizsfsljz = B1.wmi_mis05;
			}else if(this.ssp == 2){
				this.wmizsfsljz = B1.wmi_mis10;
			}else if(this.ssp == 3){
				this.wmizsfsljz = B1.wmi_mis15;
			}
			
			if(Math.abs(this.vcizsfscy) >= this.vcizsfsljz){
				if(this.vcizsfscy>0){
					this.vcizsfsqrx = 1;
				}else{
					this.vcizsfsqrx = 2;
				}
				if(this.vcizsfscy < 0){
					if(Math.abs(this.vcizsfscy) <= B2.vci_mis25){
						this.vcizsfsjcl = ">25%";
						if(Math.abs(this.vcizsfscy) == B2.vci_mis25){
							this.vcizsfsjcl ="25%";
						}
					}else if(Math.abs(this.vcizsfscy) > B2.vci_mis25 && Math.abs(this.vcizsfscy) <= B2.vci_mis10){
						this.vcizsfsjcl = "10-25%";
						if(Math.abs(this.vcizsfscy) == B2.vci_mis10){
							this.vcizsfsjcl ="10%";
						}
					}else if(Math.abs(this.vcizsfscy) > B2.vci_mis10 && Math.abs(this.vcizsfscy) <= B2.vci_mis5){
						this.vcizsfsjcl = "5-10%";
						if(Math.abs(this.vcizsfscy) == B2.vci_mis5){
							this.vcizsfsjcl ="5%";
						}
					}else if(Math.abs(this.vcizsfscy) > B2.vci_mis5 && Math.abs(this.vcizsfscy) <= B2.vci_mis2){
						this.vcizsfsjcl = "2-5%";
						if(Math.abs(this.vcizsfscy) == B2.vci_mis2){
							this.vcizsfsjcl ="2%";
						}
					}else if(Math.abs(this.vcizsfscy) > B2.vci_mis2 && Math.abs(this.vcizsfscy) <= B2.vci_mis1){
						this.vcizsfsjcl = "1-2%";
						if(Math.abs(this.vcizsfscy) == B2.vci_mis1){
							this.vcizsfsjcl ="1%";
						}
					}else if(Math.abs(this.vcizsfscy) >= B2.vci_mis1 ){
						this.vcizsfsjcl = "<1%";
					}
					
					if(this.bjjc == 1){
						if(this.fsiqi >=40 && this.fsiqi <=79){
							if(Math.abs(this.vcizsfscy) <= B2.vci_mis40_25){
								this.vcizsfsjcl = ">25%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis40_25){
									this.vcizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis40_25 && Math.abs(this.vcizsfscy) <= B2.vci_mis40_10){
								this.vcizsfsjcl = "10-25%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis40_10){
									this.vcizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis40_10 && Math.abs(this.vcizsfscy) <= B2.vci_mis40_5){
								this.vcizsfsjcl = "5-10%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis40_5){
									this.vcizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis40_5 && Math.abs(this.vcizsfscy) <= B2.vci_mis40_2){
								this.vcizsfsjcl = "2-5%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis40_2){
									this.vcizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis40_2 && Math.abs(this.vcizsfscy) <= B2.vci_mis40_1){
								this.vcizsfsjcl = "1-2%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis40_1){
									this.vcizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vcizsfscy) >= B2.vci_mis40_1 ){
								this.vcizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=80 && this.fsiqi <=89){
							if(Math.abs(this.vcizsfscy) <= B2.vci_mis80_25){
								this.vcizsfsjcl = ">25%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis80_25){
									this.vcizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis80_25 && Math.abs(this.vcizsfscy) <= B2.vci_mis80_10){
								this.vcizsfsjcl = "10-25%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis80_10){
									this.vcizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis80_10 && Math.abs(this.vcizsfscy) <= B2.vci_mis80_5){
								this.vcizsfsjcl = "5-10%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis80_5){
									this.vcizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis80_5 && Math.abs(this.vcizsfscy) <= B2.vci_mis80_2){
								this.vcizsfsjcl = "2-5%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis80_2){
									this.vcizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis80_2 && Math.abs(this.vcizsfscy) <= B2.vci_mis80_1){
								this.vcizsfsjcl = "1-2%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis80_1){
									this.vcizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vcizsfscy) >= B2.vci_mis80_1 ){
								this.vcizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=90 && this.fsiqi <=109){
							if(Math.abs(this.vcizsfscy) <= B2.vci_mis90_25){
								this.vcizsfsjcl = ">25%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis90_25){
									this.vcizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis90_25 && Math.abs(this.vcizsfscy) <= B2.vci_mis90_10){
								this.vcizsfsjcl = "10-25%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis90_10){
									this.vcizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis90_10 && Math.abs(this.vcizsfscy) <= B2.vci_mis90_5){
								this.vcizsfsjcl = "5-10%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis90_5){
									this.vcizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis90_5 && Math.abs(this.vcizsfscy) <= B2.vci_mis90_2){
								this.vcizsfsjcl = "2-5%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis90_2){
									this.vcizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis90_2 && Math.abs(this.vcizsfscy) <= B2.vci_mis90_1){
								this.vcizsfsjcl = "1-2%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis90_1){
									this.vcizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vcizsfscy) >= B2.vci_mis90_1 ){
								this.vcizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=110 && this.fsiqi <=119){
							if(Math.abs(this.vcizsfscy) <= B2.vci_mis110_25){
								this.vcizsfsjcl = ">25%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis110_25){
									this.vcizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis110_25 && Math.abs(this.vcizsfscy) <= B2.vci_mis110_10){
								this.vcizsfsjcl = "10-25%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis110_10){
									this.vcizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis110_10 && Math.abs(this.vcizsfscy) <= B2.vci_mis110_5){
								this.vcizsfsjcl = "5-10%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis110_5){
									this.vcizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis110_5 && Math.abs(this.vcizsfscy) <= B2.vci_mis110_2){
								this.vcizsfsjcl = "2-5%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis110_2){
									this.vcizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis110_2 && Math.abs(this.vcizsfscy) <= B2.vci_mis110_1){
								this.vcizsfsjcl = "1-2%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis110_1){
									this.vcizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vcizsfscy) >= B2.vci_mis110_1 ){
								this.vcizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=120){
							if(Math.abs(this.vcizsfscy) <= B2.vci_mis120_25){
								this.vcizsfsjcl = ">25%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis120_25){
									this.vcizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis120_25 && Math.abs(this.vcizsfscy) <= B2.vci_mis120_10){
								this.vcizsfsjcl = "10-25%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis120_10){
									this.vcizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis120_10 && Math.abs(this.vcizsfscy) <= B2.vci_mis120_5){
								this.vcizsfsjcl = "5-10%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis120_5){
									this.vcizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis120_5 && Math.abs(this.vcizsfscy) <= B2.vci_mis120_2){
								this.vcizsfsjcl = "2-5%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis120_2){
									this.vcizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.vci_mis120_2 && Math.abs(this.vcizsfscy) <= B2.vci_mis120_1){
								this.vcizsfsjcl = "1-2%";
								if(Math.abs(this.vcizsfscy) == B2.vci_mis120_1){
									this.vcizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vcizsfscy) >= B2.vci_mis120_1 ){
								this.vcizsfsjcl = "<1%";
							}
						}
						
					}
				}else{
					if(Math.abs(this.vcizsfscy) <= B2.mis_vci25){
						this.vcizsfsjcl = ">25%";
						if(Math.abs(this.vcizsfscy) == B2.mis_vci25){
							this.vcizsfsjcl ="25%";
						}
					}else if(Math.abs(this.vcizsfscy) > B2.mis_vci25 && Math.abs(this.vcizsfscy) <= B2.mis_vci10){
						this.vcizsfsjcl = "10-25%";
						if(Math.abs(this.vcizsfscy) == B2.mis_vci10){
							this.vcizsfsjcl ="10%";
						}
					}else if(Math.abs(this.vcizsfscy) > B2.mis_vci10 && Math.abs(this.vcizsfscy) <= B2.mis_vci5){
						this.vcizsfsjcl = "5-10%";
						if(Math.abs(this.vcizsfscy) == B2.mis_vci5){
							this.vcizsfsjcl ="5%";
						}
					}else if(Math.abs(this.vcizsfscy) > B2.mis_vci5 && Math.abs(this.vcizsfscy) <= B2.mis_vci2){
						this.vcizsfsjcl = "2-5%";
						if(Math.abs(this.vcizsfscy) == B2.mis_vci2){
							this.vcizsfsjcl ="2%";
						}
					}else if(Math.abs(this.vcizsfscy) > B2.mis_vci2 && Math.abs(this.vcizsfscy) <= B2.mis_vci1){
						this.vcizsfsjcl = "1-2%";
						if(Math.abs(this.vcizsfscy) == B2.mis_vci1){
							this.vcizsfsjcl ="1%";
						}
					}else if(Math.abs(this.vcizsfscy) >= B2.mis_vci1 ){
						this.vcizsfsjcl = "<1%";
					}
					
					if(this.bjjc == 1){
						if(this.fsiqi >=40 && this.fsiqi <=79){
							if(Math.abs(this.vcizsfscy) <= B2.mis_vci40_25){
								this.vcizsfsjcl = ">25%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci40_25){
									this.vcizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci40_25 && Math.abs(this.vcizsfscy) <= B2.mis_vci40_10){
								this.vcizsfsjcl = "10-25%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci40_10){
									this.vcizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci40_10 && Math.abs(this.vcizsfscy) <= B2.mis_vci40_5){
								this.vcizsfsjcl = "5-10%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci40_5){
									this.vcizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci40_5 && Math.abs(this.vcizsfscy) <= B2.mis_vci40_2){
								this.vcizsfsjcl = "2-5%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci40_2){
									this.vcizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci40_2 && Math.abs(this.vcizsfscy) <= B2.mis_vci40_1){
								this.vcizsfsjcl = "1-2%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci40_1){
									this.vcizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vcizsfscy) >= B2.mis_vci40_1 ){
								this.vcizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=80 && this.fsiqi <=89){
							if(Math.abs(this.vcizsfscy) <= B2.mis_vci80_25){
								this.vcizsfsjcl = ">25%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci80_25){
									this.vcizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci80_25 && Math.abs(this.vcizsfscy) <= B2.mis_vci80_10){
								this.vcizsfsjcl = "10-25%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci80_10){
									this.vcizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci80_10 && Math.abs(this.vcizsfscy) <= B2.mis_vci80_5){
								this.vcizsfsjcl = "5-10%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci80_5){
									this.vcizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci80_5 && Math.abs(this.vcizsfscy) <= B2.mis_vci80_2){
								this.vcizsfsjcl = "2-5%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci80_2){
									this.vcizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci80_2 && Math.abs(this.vcizsfscy) <= B2.mis_vci80_1){
								this.vcizsfsjcl = "1-2%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci80_1){
									this.vcizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vcizsfscy) >= B2.mis_vci80_1 ){
								this.vcizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=90 && this.fsiqi <=109){
							if(Math.abs(this.vcizsfscy) <= B2.mis_vci90_25){
								this.vcizsfsjcl = ">25%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci90_25){
									this.vcizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci90_25 && Math.abs(this.vcizsfscy) <= B2.mis_vci90_10){
								this.vcizsfsjcl = "10-25%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci90_10){
									this.vcizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci90_10 && Math.abs(this.vcizsfscy) <= B2.mis_vci90_5){
								this.vcizsfsjcl = "5-10%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci90_5){
									this.vcizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci90_5 && Math.abs(this.vcizsfscy) <= B2.mis_vci90_2){
								this.vcizsfsjcl = "2-5%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci90_2){
									this.vcizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci90_2 && Math.abs(this.vcizsfscy) <= B2.mis_vci90_1){
								this.vcizsfsjcl = "1-2%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci90_1){
									this.vcizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vcizsfscy) >= B2.mis_vci90_1 ){
								this.vcizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=110 && this.fsiqi <=119){
							if(Math.abs(this.vcizsfscy) <= B2.mis_vci110_25){
								this.vcizsfsjcl = ">25%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci110_25){
									this.vcizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci110_25 && Math.abs(this.vcizsfscy) <= B2.mis_vci110_10){
								this.vcizsfsjcl = "10-25%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci110_10){
									this.vcizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci110_10 && Math.abs(this.vcizsfscy) <= B2.mis_vci110_5){
								this.vcizsfsjcl = "5-10%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci110_5){
									this.vcizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci110_5 && Math.abs(this.vcizsfscy) <= B2.mis_vci110_2){
								this.vcizsfsjcl = "2-5%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci110_2){
									this.vcizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci110_2 && Math.abs(this.vcizsfscy) <= B2.mis_vci110_1){
								this.vcizsfsjcl = "1-2%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci110_1){
									this.vcizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vcizsfscy) >= B2.mis_vci110_1 ){
								this.vcizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=120){
							if(Math.abs(this.vcizsfscy) <= B2.mis_vci120_25){
								this.vcizsfsjcl = ">25%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci120_25){
									this.vcizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci120_25 && Math.abs(this.vcizsfscy) <= B2.mis_vci120_10){
								this.vcizsfsjcl = "10-25%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci120_10){
									this.vcizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci120_10 && Math.abs(this.vcizsfscy) <= B2.mis_vci120_5){
								this.vcizsfsjcl = "5-10%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci120_5){
									this.vcizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci120_5 && Math.abs(this.vcizsfscy) <= B2.mis_vci120_2){
								this.vcizsfsjcl = "2-5%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci120_2){
									this.vcizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vcizsfscy) > B2.mis_vci120_2 && Math.abs(this.vcizsfscy) <= B2.mis_vci120_1){
								this.vcizsfsjcl = "1-2%";
								if(Math.abs(this.vcizsfscy) == B2.mis_vci120_1){
									this.vcizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vcizsfscy) >= B2.mis_vci120_1 ){
								this.vcizsfsjcl = "<1%";
							}
						}
						
					}
				}
				
				
				
			}
			
			if(Math.abs(this.vsizsfscy) >= this.vsizsfsljz){
				if(this.vsizsfscy>0){
					this.vsizsfsqrx = 1;
				}else{
					this.vsizsfsqrx = 2;
				}
				
				if(this.vsizsfscy < 0){
					if(Math.abs(this.vsizsfscy) <= B2.vsi_mis25){
						this.vsizsfsjcl = ">25%";
						if(Math.abs(this.vsizsfscy) == B2.vsi_mis25){
							this.vsizsfsjcl ="25%";
						}
					}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis25 && Math.abs(this.vsizsfscy) <= B2.vsi_mis10){
						this.vcizsfsjcl = "10-25%";
						if(Math.abs(this.vsizsfscy) == B2.vsi_mis10){
							this.vsizsfsjcl ="10%";
						}
					}else if(Math.abs(this.vsizsfscy) > B2.vci_mis10 && Math.abs(this.vsizsfscy) <= B2.vsi_mis5){
						this.vsizsfsjcl = "5-10%";
						if(Math.abs(this.vsizsfscy) == B2.vsi_mis5){
							this.vsizsfsjcl ="5%";
						}
					}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis5 && Math.abs(this.vsizsfscy) <= B2.vsi_mis2){
						this.vsizsfsjcl = "2-5%";
						if(Math.abs(this.vsizsfscy) == B2.vsi_mis2){
							this.vsizsfsjcl ="2%";
						}
					}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis2 && Math.abs(this.vsizsfscy) <= B2.vsi_mis1){
						this.vsizsfsjcl = "1-2%";
						if(Math.abs(this.vsizsfscy) == B2.vsi_mis1){
							this.vsizsfsjcl ="1%";
						}
					}else if(Math.abs(this.vsizsfscy) >= B2.vsi_mis1 ){
						this.vsizsfsjcl = "<1%";
					}
					if(this.bjjc == 1){
						if(this.fsiqi >=40 && this.fsiqi <=79){
							if(Math.abs(this.vsizsfscy) <= B2.vsi_mis40_25){
								this.vsizsfsjcl = ">25%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis40_25){
									this.vsizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis40_25 && Math.abs(this.vsizsfscy) <= B2.vsi_mis40_10){
								this.vsizsfsjcl = "10-25%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis40_10){
									this.vsizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis40_10 && Math.abs(this.vsizsfscy) <= B2.vsi_mis40_5){
								this.vsizsfsjcl = "5-10%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis40_5){
									this.vsizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis40_5 && Math.abs(this.vsizsfscy) <= B2.vsi_mis40_2){
								this.vsizsfsjcl = "2-5%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis40_2){
									this.vsizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis40_2 && Math.abs(this.vsizsfscy) <= B2.vsi_mis40_1){
								this.vsizsfsjcl = "1-2%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis40_1){
									this.vsizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vsizsfscy) >= B2.vsi_mis40_1 ){
								this.vsizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=80 && this.fsiqi <=89){
							if(Math.abs(this.vsizsfscy) <= B2.vsi_mis80_25){
								this.vsizsfsjcl = ">25%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis80_25){
									this.vsizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis80_25 && Math.abs(this.vsizsfscy) <= B2.vsi_mis80_10){
								this.vsizsfsjcl = "10-25%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis80_10){
									this.vsizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis80_10 && Math.abs(this.vsizsfscy) <= B2.vsi_mis80_5){
								this.vsizsfsjcl = "5-10%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis80_5){
									this.vsizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis80_5 && Math.abs(this.vsizsfscy) <= B2.vsi_mis80_2){
								this.vsizsfsjcl = "2-5%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis80_2){
									this.vsizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis80_2 && Math.abs(this.vsizsfscy) <= B2.vsi_mis80_1){
								this.vsizsfsjcl = "1-2%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis80_1){
									this.vsizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vsizsfscy) >= B2.vsi_mis80_1 ){
								this.vsizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=90 && this.fsiqi <=109){
							if(Math.abs(this.vsizsfscy) <= B2.vsi_mis90_25){
								this.vsizsfsjcl = ">25%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis90_25){
									this.vsizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis90_25 && Math.abs(this.vsizsfscy) <= B2.vsi_mis90_10){
								this.vsizsfsjcl = "10-25%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis90_10){
									this.vsizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis90_10 && Math.abs(this.vsizsfscy) <= B2.vsi_mis90_5){
								this.vsizsfsjcl = "5-10%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis90_5){
									this.vsizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis90_5 && Math.abs(this.vsizsfscy) <= B2.vsi_mis90_2){
								this.vsizsfsjcl = "2-5%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis90_2){
									this.vsizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis90_2 && Math.abs(this.vsizsfscy) <= B2.vsi_mis90_1){
								this.vsizsfsjcl = "1-2%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis90_1){
									this.vsizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vsizsfscy) >= B2.vsi_mis90_1 ){
								this.vsizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=110 && this.fsiqi <=119){
							if(Math.abs(this.vsizsfscy) <= B2.vsi_mis110_25){
								this.vsizsfsjcl = ">25%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis110_25){
									this.vsizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis110_25 && Math.abs(this.vsizsfscy) <= B2.vsi_mis110_10){
								this.vsizsfsjcl = "10-25%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis110_10){
									this.vsizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis110_10 && Math.abs(this.vsizsfscy) <= B2.vsi_mis110_5){
								this.vsizsfsjcl = "5-10%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis110_5){
									this.vsizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis110_5 && Math.abs(this.vsizsfscy) <= B2.vsi_mis110_2){
								this.vsizsfsjcl = "2-5%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis110_2){
									this.vsizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis110_2 && Math.abs(this.vsizsfscy) <= B2.vsi_mis110_1){
								this.vsizsfsjcl = "1-2%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis110_1){
									this.vsizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vsizsfscy) >= B2.vsi_mis110_1 ){
								this.vsizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=120){
							if(Math.abs(this.vsizsfscy) <= B2.vsi_mis120_25){
								this.vsizsfsjcl = ">25%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis120_25){
									this.vsizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis120_25 && Math.abs(this.vsizsfscy) <= B2.vsi_mis120_10){
								this.vsizsfsjcl = "10-25%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis120_10){
									this.vsizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis120_10 && Math.abs(this.vsizsfscy) <= B2.vsi_mis120_5){
								this.vsizsfsjcl = "5-10%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis120_5){
									this.vsizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis120_5 && Math.abs(this.vsizsfscy) <= B2.vsi_mis120_2){
								this.vsizsfsjcl = "2-5%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis120_2){
									this.vsizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.vsi_mis120_2 && Math.abs(this.vsizsfscy) <= B2.vsi_mis120_1){
								this.vsizsfsjcl = "1-2%";
								if(Math.abs(this.vsizsfscy) == B2.vsi_mis120_1){
									this.vsizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vsizsfscy) >= B2.vsi_mis120_1 ){
								this.vsizsfsjcl = "<1%";
							}
							
						}	
							
					}
					
				}else{
					if(Math.abs(this.vsizsfscy) <= B2.mis_vsi25){
						this.vsizsfsjcl = ">25%";
						if(Math.abs(this.vsizsfscy) == B2.mis_vsi25){
							this.vsizsfsjcl ="25%";
						}
					}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi25 && Math.abs(this.vsizsfscy) <= B2.mis_vsi10){
						this.vsizsfsjcl = "10-25%";
						if(Math.abs(this.vsizsfscy) == B2.mis_vsi10){
							this.vsizsfsjcl ="10%";
						}
					}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi10 && Math.abs(this.vsizsfscy) <= B2.mis_vsi5){
						this.vsizsfsjcl = "5-10%";
						if(Math.abs(this.vsizsfscy) == B2.mis_vsi5){
							this.vsizsfsjcl ="5%";
						}
					}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi5 && Math.abs(this.vsizsfscy) <= B2.mis_vsi2){
						this.vsizsfsjcl = "2-5%";
						if(Math.abs(this.vsizsfscy) == B2.mis_vsi2){
							this.vsizsfsjcl ="2%";
						}
					}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi2 && Math.abs(this.vsizsfscy) <= B2.mis_vsi1){
						this.vsizsfsjcl = "1-2%";
						if(Math.abs(this.vsizsfscy) == B2.mis_vsi1){
							this.vsizsfsjcl ="1%";
						}
					}else if(Math.abs(this.vsizsfscy) >= B2.mis_vsi1 ){
						this.vsizsfsjcl = "<1%";
					}
					
					if(this.bjjc == 1){
						if(this.fsiqi >=40 && this.fsiqi <=79){
							if(Math.abs(this.vsizsfscy) <= B2.mis_vsi40_25){
								this.vsizsfsjcl = ">25%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi40_25){
									this.vsizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi40_25 && Math.abs(this.vsizsfscy) <= B2.mis_vsi40_10){
								this.vsizsfsjcl = "10-25%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi40_10){
									this.vsizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi40_10 && Math.abs(this.vsizsfscy) <= B2.mis_vsi40_5){
								this.vsizsfsjcl = "5-10%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi40_5){
									this.vsizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi40_5 && Math.abs(this.vsizsfscy) <= B2.mis_vsi40_2){
								this.vsizsfsjcl = "2-5%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi40_2){
									this.vsizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi40_2 && Math.abs(this.vsizsfscy) <= B2.mis_vsi40_1){
								this.vsizsfsjcl = "1-2%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi40_1){
									this.vsizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vsizsfscy) >= B2.mis_vsi40_1 ){
								this.vsizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=80 && this.fsiqi <=89){
							if(Math.abs(this.vsizsfscy) <= B2.mis_vsi80_25){
								this.vsizsfsjcl = ">25%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi80_25){
									this.vsizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi80_25 && Math.abs(this.vsizsfscy) <= B2.mis_vsi80_10){
								this.vsizsfsjcl = "10-25%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi80_10){
									this.vsizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi80_10 && Math.abs(this.vsizsfscy) <= B2.mis_vsi80_5){
								this.vsizsfsjcl = "5-10%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi80_5){
									this.vsizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi80_5 && Math.abs(this.vsizsfscy) <= B2.mis_vsi80_2){
								this.vsizsfsjcl = "2-5%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi80_2){
									this.vsizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi80_2 && Math.abs(this.vsizsfscy) <= B2.mis_vsi80_1){
								this.vsizsfsjcl = "1-2%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi80_1){
									this.vsizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vsizsfscy) >= B2.mis_vsi80_1 ){
								this.vsizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=90 && this.fsiqi <=109){
							if(Math.abs(this.vsizsfscy) <= B2.mis_vsi90_25){
								this.vsizsfsjcl = ">25%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi90_25){
									this.vsizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi90_25 && Math.abs(this.vsizsfscy) <= B2.mis_vsi90_10){
								this.vsizsfsjcl = "10-25%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi90_10){
									this.vsizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi90_10 && Math.abs(this.vsizsfscy) <= B2.mis_vsi90_5){
								this.vsizsfsjcl = "5-10%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi90_5){
									this.vsizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi90_5 && Math.abs(this.vsizsfscy) <= B2.mis_vsi90_2){
								this.vsizsfsjcl = "2-5%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi90_2){
									this.vsizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi90_2 && Math.abs(this.vsizsfscy) <= B2.mis_vsi90_1){
								this.vsizsfsjcl = "1-2%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi90_1){
									this.vsizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vsizsfscy) >= B2.mis_vsi90_1 ){
								this.vsizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=110 && this.fsiqi <=119){
							if(Math.abs(this.vsizsfscy) <= B2.mis_vsi110_25){
								this.vsizsfsjcl = ">25%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi110_25){
									this.vsizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi110_25 && Math.abs(this.vsizsfscy) <= B2.mis_vsi110_10){
								this.vsizsfsjcl = "10-25%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi110_10){
									this.vsizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi110_10 && Math.abs(this.vsizsfscy) <= B2.mis_vsi110_5){
								this.vsizsfsjcl = "5-10%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi110_5){
									this.vsizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi110_5 && Math.abs(this.vsizsfscy) <= B2.mis_vsi110_2){
								this.vsizsfsjcl = "2-5%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi110_2){
									this.vsizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi110_2 && Math.abs(this.vsizsfscy) <= B2.mis_vsi110_1){
								this.vsizsfsjcl = "1-2%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi110_1){
									this.vsizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vsizsfscy) >= B2.mis_vsi110_1 ){
								this.vsizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=120){
							if(Math.abs(this.vsizsfscy) <= B2.mis_vsi120_25){
								this.vsizsfsjcl = ">25%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi120_25){
									this.vsizsfsjcl ="25%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi120_25 && Math.abs(this.vsizsfscy) <= B2.mis_vsi120_10){
								this.vsizsfsjcl = "10-25%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi120_10){
									this.vsizsfsjcl ="10%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi120_10 && Math.abs(this.vsizsfscy) <= B2.mis_vsi120_5){
								this.vsizsfsjcl = "5-10%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi120_5){
									this.vsizsfsjcl ="5%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi120_5 && Math.abs(this.vsizsfscy) <= B2.mis_vsi120_2){
								this.vsizsfsjcl = "2-5%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi120_2){
									this.vsizsfsjcl ="2%";
								}
							}else if(Math.abs(this.vsizsfscy) > B2.mis_vsi120_2 && Math.abs(this.vsizsfscy) <= B2.mis_vsi120_1){
								this.vsizsfsjcl = "1-2%";
								if(Math.abs(this.vsizsfscy) == B2.mis_vsi120_1){
									this.vsizsfsjcl ="1%";
								}
							}else if(Math.abs(this.vsizsfscy) >= B2.mis_vsi120_1 ){
								this.vsizsfsjcl = "<1%";
							}
						}
						
					}
				}
				
				
				
			}
			
			if(Math.abs(this.wmizsfscy) >= this.wmizsfsljz){
				if(this.wmizsfscy>0){
					this.wmizsfsqrx = 1;
				}else{
					this.wmizsfsqrx = 2;
				}
				
				if(this.wmizsfscy < 0){
					if(Math.abs(this.wmizsfscy) <= B2.wmi_mis25){
						this.wmizsfsjcl = ">25%";
						if(Math.abs(this.wmizsfscy) == B2.wmi_mis25){
							this.wmizsfsjcl ="25%";
						}
					}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis25 && Math.abs(this.wmizsfscy) <= B2.wmi_mis10){
						this.wmizsfsjcl = "10-25%";
						if(Math.abs(this.wmizsfscy) == B2.wmi_mis10){
							this.wmizsfsjcl ="10%";
						}
					}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis10 && Math.abs(this.wmizsfscy) <= B2.wmi_mis5){
						this.wmizsfsjcl = "5-10%";
						if(Math.abs(this.wmizsfscy) == B2.wmi_mis5){
							this.wmizsfsjcl ="5%";
						}
					}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis5 && Math.abs(this.wmizsfscy) <= B2.wmi_mis2){
						this.wmizsfsjcl = "2-5%";
						if(Math.abs(this.wmizsfscy) == B2.wmi_mis2){
							this.wmizsfsjcl ="2%";
						}
					}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis2 && Math.abs(this.wmizsfscy) <= B2.wmi_mis1){
						this.wmizsfsjcl = "1-2%";
						if(Math.abs(this.wmizsfscy) == B2.wmi_mis1){
							this.wmizsfsjcl ="1%";
						}
					}else if(Math.abs(this.wmizsfscy) >= B2.wmi_mis1 ){
						this.wmizsfsjcl = "<1%";
					}
					
					if(this.bjjc == 1){
						if(this.fsiqi >=40 && this.fsiqi <=79){
							if(Math.abs(this.wmizsfscy) <= B2.wmi_mis40_25){
								this.wmizsfsjcl = ">25%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis40_25){
									this.wmizsfsjcl ="25%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis40_25 && Math.abs(this.wmizsfscy) <= B2.wmi_mis40_10){
								this.wmizsfsjcl = "10-25%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis40_10){
									this.wmizsfsjcl ="10%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis40_10 && Math.abs(this.wmizsfscy) <= B2.wmi_mis40_5){
								this.wmizsfsjcl = "5-10%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis40_5){
									this.wmizsfsjcl ="5%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis40_5 && Math.abs(this.wmizsfscy) <= B2.wmi_mis40_2){
								this.wmizsfsjcl = "2-5%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis40_2){
									this.wmizsfsjcl ="2%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis40_2 && Math.abs(this.wmizsfscy) <= B2.wmi_mis40_1){
								this.wmizsfsjcl = "1-2%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis40_1){
									this.wmizsfsjcl ="1%";
								}
							}else if(Math.abs(this.wmizsfscy) >= B2.wmi_mis40_1 ){
								this.wmizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=80 && this.fsiqi <=89){
							if(Math.abs(this.wmizsfscy) <= B2.wmi_mis80_25){
								this.wmizsfsjcl = ">25%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis80_25){
									this.wmizsfsjcl ="25%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis80_25 && Math.abs(this.wmizsfscy) <= B2.wmi_mis80_10){
								this.wmizsfsjcl = "10-25%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis80_10){
									this.wmizsfsjcl ="10%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis80_10 && Math.abs(this.wmizsfscy) <= B2.wmi_mis80_5){
								this.wmizsfsjcl = "5-10%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis80_5){
									this.wmizsfsjcl ="5%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis80_5 && Math.abs(this.wmizsfscy) <= B2.wmi_mis80_2){
								this.wmizsfsjcl = "2-5%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis80_2){
									this.wmizsfsjcl ="2%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis80_2 && Math.abs(this.wmizsfscy) <= B2.wmi_mis80_1){
								this.wmizsfsjcl = "1-2%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis80_1){
									this.wmizsfsjcl ="1%";
								}
							}else if(Math.abs(this.wmizsfscy) >= B2.wmi_mis80_1 ){
								this.wmizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=90 && this.fsiqi <=109){
							if(Math.abs(this.wmizsfscy) <= B2.wmi_mis90_25){
								this.wmizsfsjcl = ">25%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis90_25){
									this.wmizsfsjcl ="25%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis90_25 && Math.abs(this.wmizsfscy) <= B2.wmi_mis90_10){
								this.wmizsfsjcl = "10-25%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis90_10){
									this.wmizsfsjcl ="10%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis90_10 && Math.abs(this.wmizsfscy) <= B2.wmi_mis90_5){
								this.wmizsfsjcl = "5-10%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis90_5){
									this.wmizsfsjcl ="5%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis90_5 && Math.abs(this.wmizsfscy) <= B2.wmi_mis90_2){
								this.wmizsfsjcl = "2-5%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis90_2){
									this.wmizsfsjcl ="2%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis90_2 && Math.abs(this.wmizsfscy) <= B2.wmi_mis90_1){
								this.wmizsfsjcl = "1-2%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis90_1){
									this.wmizsfsjcl ="1%";
								}
							}else if(Math.abs(this.wmizsfscy) >= B2.wmi_mis90_1 ){
								this.wmizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=110 && this.fsiqi <=119){
							if(Math.abs(this.wmizsfscy) <= B2.wmi_mis110_25){
								this.wmizsfsjcl = ">25%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis110_25){
									this.wmizsfsjcl ="25%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis110_25 && Math.abs(this.wmizsfscy) <= B2.wmi_mis110_10){
								this.wmizsfsjcl = "10-25%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis110_10){
									this.wmizsfsjcl ="10%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis110_10 && Math.abs(this.wmizsfscy) <= B2.wmi_mis110_5){
								this.wmizsfsjcl = "5-10%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis110_5){
									this.wmizsfsjcl ="5%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis110_5 && Math.abs(this.wmizsfscy) <= B2.wmi_mis110_2){
								this.wmizsfsjcl = "2-5%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis110_2){
									this.wmizsfsjcl ="2%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis110_2 && Math.abs(this.wmizsfscy) <= B2.wmi_mis110_1){
								this.wmizsfsjcl = "1-2%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis110_1){
									this.wmizsfsjcl ="1%";
								}
							}else if(Math.abs(this.wmizsfscy) >= B2.wmi_mis110_1 ){
								this.wmizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=120){
							if(Math.abs(this.wmizsfscy) <= B2.wmi_mis120_25){
								this.wmizsfsjcl = ">25%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis120_25){
									this.wmizsfsjcl ="25%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis120_25 && Math.abs(this.wmizsfscy) <= B2.wmi_mis120_10){
								this.wmizsfsjcl = "10-25%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis120_10){
									this.wmizsfsjcl ="10%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis120_10 && Math.abs(this.wmizsfscy) <= B2.wmi_mis120_5){
								this.wmizsfsjcl = "5-10%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis120_5){
									this.wmizsfsjcl ="5%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis120_5 && Math.abs(this.wmizsfscy) <= B2.wmi_mis120_2){
								this.wmizsfsjcl = "2-5%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis120_2){
									this.wmizsfsjcl ="2%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.wmi_mis120_2 && Math.abs(this.wmizsfscy) <= B2.wmi_mis120_1){
								this.wmizsfsjcl = "1-2%";
								if(Math.abs(this.wmizsfscy) == B2.wmi_mis120_1){
									this.wmizsfsjcl ="1%";
								}
							}else if(Math.abs(this.wmizsfscy) >= B2.wmi_mis120_1 ){
								this.wmizsfsjcl = "<1%";
							}
						}
					}
					
				}else{
					if(Math.abs(this.wmizsfscy) <= B2.mis_wmi25){
						this.wmizsfsjcl = ">25%";
						if(Math.abs(this.wmizsfscy) == B2.mis_wmi25){
							this.wmizsfsjcl ="25%";
						}
					}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi25 && Math.abs(this.wmizsfscy) <= B2.mis_wmi10){
						this.wmizsfsjcl = "10-25%";
						if(Math.abs(this.wmizsfscy) == B2.mis_wmi10){
							this.wmizsfsjcl ="10%";
						}
					}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi10 && Math.abs(this.wmizsfscy) <= B2.mis_wmi5){
						this.wmizsfsjcl = "5-10%";
						if(Math.abs(this.wmizsfscy) == B2.mis_wmi5){
							this.wmizsfsjcl ="5%";
						}
					}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi5 && Math.abs(this.wmizsfscy) <= B2.mis_wmi2){
						this.wmizsfsjcl = "2-5%";
						if(Math.abs(this.wmizsfscy) == B2.mis_wmi2){
							this.wmizsfsjcl ="2%";
						}
					}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi2 && Math.abs(this.wmizsfscy) <= B2.mis_wmi1){
						this.wmizsfsjcl = "1-2%";
						if(Math.abs(this.wmizsfscy) == B2.mis_wmi1){
							this.wmizsfsjcl ="1%";
						}
					}else if(Math.abs(this.wmizsfscy) >= B2.mis_wmi1 ){
						this.wmizsfsjcl = "<1%";
					}
					
					if(this.bjjc == 1){
						if(this.fsiqi >=40 && this.fsiqi <=79){
							if(Math.abs(this.wmizsfscy) <= B2.mis_wmi40_25){
								this.wmizsfsjcl = ">25%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi40_25){
									this.wmizsfsjcl ="25%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi40_25 && Math.abs(this.wmizsfscy) <= B2.mis_wmi40_10){
								this.wmizsfsjcl = "10-25%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi40_10){
									this.wmizsfsjcl ="10%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi40_10 && Math.abs(this.wmizsfscy) <= B2.mis_wmi40_5){
								this.wmizsfsjcl = "5-10%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi40_5){
									this.wmizsfsjcl ="5%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi40_5 && Math.abs(this.wmizsfscy) <= B2.mis_wmi40_2){
								this.wmizsfsjcl = "2-5%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi40_2){
									this.wmizsfsjcl ="2%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi40_2 && Math.abs(this.wmizsfscy) <= B2.mis_wmi40_1){
								this.wmizsfsjcl = "1-2%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi40_1){
									this.wmizsfsjcl ="1%";
								}
							}else if(Math.abs(this.wmizsfscy) >= B2.mis_wmi40_1 ){
								this.wmizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=80 && this.fsiqi <=89){
							if(Math.abs(this.wmizsfscy) <= B2.mis_wmi80_25){
								this.wmizsfsjcl = ">25%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi80_25){
									this.wmizsfsjcl ="25%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi80_25 && Math.abs(this.wmizsfscy) <= B2.mis_wmi80_10){
								this.wmizsfsjcl = "10-25%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi80_10){
									this.wmizsfsjcl ="10%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi80_10 && Math.abs(this.wmizsfscy) <= B2.mis_wmi80_5){
								this.wmizsfsjcl = "5-10%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi80_5){
									this.wmizsfsjcl ="5%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi80_5 && Math.abs(this.wmizsfscy) <= B2.mis_wmi80_2){
								this.wmizsfsjcl = "2-5%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi80_2){
									this.wmizsfsjcl ="2%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi80_2 && Math.abs(this.wmizsfscy) <= B2.mis_wmi80_1){
								this.wmizsfsjcl = "1-2%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi80_1){
									this.wmizsfsjcl ="1%";
								}
							}else if(Math.abs(this.wmizsfscy) >= B2.mis_wmi80_1 ){
								this.wmizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=90 && this.fsiqi <=109){
							if(Math.abs(this.wmizsfscy) <= B2.mis_wmi90_25){
								this.wmizsfsjcl = ">25%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi90_25){
									this.wmizsfsjcl ="25%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi90_25 && Math.abs(this.wmizsfscy) <= B2.mis_wmi90_10){
								this.wmizsfsjcl = "10-25%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi90_10){
									this.wmizsfsjcl ="10%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi90_10 && Math.abs(this.wmizsfscy) <= B2.mis_wmi90_5){
								this.wmizsfsjcl = "5-10%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi90_5){
									this.wmizsfsjcl ="5%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi90_5 && Math.abs(this.wmizsfscy) <= B2.mis_wmi90_2){
								this.wmizsfsjcl = "2-5%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi90_2){
									this.wmizsfsjcl ="2%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi90_2 && Math.abs(this.wmizsfscy) <= B2.mis_wmi90_1){
								this.wmizsfsjcl = "1-2%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi90_1){
									this.wmizsfsjcl ="1%";
								}
							}else if(Math.abs(this.wmizsfscy) >= B2.mis_wmi90_1 ){
								this.wmizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=110 && this.fsiqi <=119){
							if(Math.abs(this.wmizsfscy) <= B2.mis_wmi110_25){
								this.wmizsfsjcl = ">25%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi110_25){
									this.wmizsfsjcl ="25%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi110_25 && Math.abs(this.wmizsfscy) <= B2.mis_wmi110_10){
								this.wmizsfsjcl = "10-25%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi110_10){
									this.wmizsfsjcl ="10%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi110_10 && Math.abs(this.wmizsfscy) <= B2.mis_wmi110_5){
								this.wmizsfsjcl = "5-10%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi110_5){
									this.wmizsfsjcl ="5%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi110_5 && Math.abs(this.wmizsfscy) <= B2.mis_wmi110_2){
								this.wmizsfsjcl = "2-5%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi110_2){
									this.wmizsfsjcl ="2%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi110_2 && Math.abs(this.wmizsfscy) <= B2.mis_wmi110_1){
								this.wmizsfsjcl = "1-2%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi110_1){
									this.wmizsfsjcl ="1%";
								}
							}else if(Math.abs(this.wmizsfscy) >= B2.mis_wmi110_1 ){
								this.wmizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=120){
							if(Math.abs(this.wmizsfscy) <= B2.mis_wmi120_25){
								this.wmizsfsjcl = ">25%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi120_25){
									this.wmizsfsjcl ="25%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi120_25 && Math.abs(this.wmizsfscy) <= B2.mis_wmi120_10){
								this.wmizsfsjcl = "10-25%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi120_10){
									this.wmizsfsjcl ="10%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi120_10 && Math.abs(this.wmizsfscy) <= B2.mis_wmi120_5){
								this.wmizsfsjcl = "5-10%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi120_5){
									this.wmizsfsjcl ="5%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi120_5 && Math.abs(this.wmizsfscy) <= B2.mis_wmi120_2){
								this.wmizsfsjcl = "2-5%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi120_2){
									this.wmizsfsjcl ="2%";
								}
							}else if(Math.abs(this.wmizsfscy) > B2.mis_wmi120_2 && Math.abs(this.wmizsfscy) <= B2.mis_wmi120_1){
								this.wmizsfsjcl = "1-2%";
								if(Math.abs(this.wmizsfscy) == B2.mis_wmi120_1){
									this.wmizsfsjcl ="1%";
								}
							}else if(Math.abs(this.wmizsfscy) >= B2.mis_wmi120_1 ){
								this.wmizsfsjcl = "<1%";
							}
						}
						
					}
				}
			}
			System.out.println("wmi jcl :"+this.wmizsfsjcl);
		}else{
			this.zszf3 = -1;
		}
	}
	
	private void cy(){
		//与总智商比
		//分数差异
		if(this.vci != -1 && this.fsiq != -1){
			this.vcizzsfscy = this.vcii - this.fsiqi;
			//临界值
			if(this.ssp == 0){
				this.vcizzsljz = B1.vci_fsiq01;
			}else if(this.ssp == 1){
				this.vcizzsljz = B1.vci_fsiq05;
			}else if(this.ssp == 2){
				this.vcizzsljz = B1.vci_fsiq10;
			}else if(this.ssp == 3){
				this.vcizzsljz = B1.vci_fsiq15;
			}
			
			if(Math.abs(this.vcizzsfscy) >= this.vcizzsljz){
				if(this.vcizzsfscy>0){
					this.vcizzsqrx = 1;
				}else{
					this.vcizzsqrx = 2;
				}
				
				if(this.vcizzsfscy < 0){
					if(Math.abs(this.vcizzsfscy) <= B2.vci_fsiq25){
						this.vcizzsjcl = ">25%";
						if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq25){
							this.vcizzsjcl ="25%";
						}
					}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq25 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq10){
						this.vcizzsjcl = "10-25%";
						if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq10){
							this.vcizzsjcl ="10%";
						}
					}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq10 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq5){
						this.vcizzsjcl = "5-10%";
						if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq5){
							this.vcizzsjcl ="5%";
						}
					}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq5 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq2){
						this.vcizzsjcl = "2-5%";
						if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq2){
							this.vcizzsjcl ="2%";
						}
					}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq2 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq1){
						this.vcizzsjcl = "1-2%";
						if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq1){
							this.vcizzsjcl ="1%";
						}
					}else if(Math.abs(this.vcizzsfscy) >= B2.vci_fsiq1 ){
						this.vcizzsjcl = "<1%";
					}
				
					if(this.bjjc == 1){
						if(this.fsiqi >=40 && this.fsiqi <=79){
							if(Math.abs(this.vcizzsfscy) <= B2.vci_fsiq40_25){
								this.vcizzsjcl = ">25%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq40_25){
									this.vcizzsjcl ="25%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq40_25 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq40_10){
								this.vcizzsjcl = "10-25%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq40_10){
									this.vcizzsjcl ="10%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq40_10 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq40_5){
								this.vcizzsjcl = "5-10%";
								if(Math.abs(this.vcizsfscy) == B2.vci_fsiq40_5){
									this.vcizzsjcl ="5%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq40_5 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq40_2){
								this.vcizzsjcl = "2-5%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq40_2){
									this.vcizzsjcl ="2%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq40_2 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq40_1){
								this.vcizzsjcl = "1-2%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq40_1){
									this.vcizzsjcl ="1%";
								}
							}else if(Math.abs(this.vcizzsfscy) >= B2.vci_fsiq40_1 ){
								this.vcizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=80 && this.fsiqi <=89){
							if(Math.abs(this.vcizzsfscy) <= B2.vci_fsiq80_25){
								this.vcizzsjcl = ">25%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq80_25){
									this.vcizzsjcl ="25%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq80_25 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq80_10){
								this.vcizzsjcl = "10-25%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq80_10){
									this.vcizzsjcl ="10%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq80_10 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq80_5){
								this.vcizzsjcl = "5-10%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq80_5){
									this.vcizzsjcl ="5%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq80_5 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq80_2){
								this.vcizzsjcl = "2-5%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq80_2){
									this.vcizzsjcl ="2%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq80_2 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq80_1){
								this.vcizzsjcl = "1-2%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq80_1){
									this.vcizzsjcl ="1%";
								}
							}else if(Math.abs(this.vcizzsfscy) >= B2.vci_fsiq80_1 ){
								this.vcizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=90 && this.fsiqi <=109){
							if(Math.abs(this.vcizzsfscy) <= B2.vci_fsiq90_25){
								this.vcizzsjcl = ">25%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq90_25){
									this.vcizzsjcl ="25%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq90_25 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq90_10){
								this.vcizzsjcl = "10-25%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq90_10){
									this.vcizzsjcl ="10%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq90_10 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq90_5){
								this.vcizzsjcl = "5-10%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq90_5){
									this.vcizzsjcl ="5%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq90_5 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq90_2){
								this.vcizzsjcl = "2-5%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq90_2){
									this.vcizzsjcl ="2%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq90_2 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq90_1){
								this.vcizzsjcl = "1-2%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq90_1){
									this.vcizzsjcl ="1%";
								}
							}else if(Math.abs(this.vcizzsfscy) >= B2.vci_fsiq90_1 ){
								this.vcizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=110 && this.fsiqi <=119){
							if(Math.abs(this.vcizzsfscy) <= B2.vci_fsiq110_25){
								this.vcizzsjcl = ">25%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq110_25){
									this.vcizzsjcl ="25%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq110_25 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq110_10){
								this.vcizzsjcl = "10-25%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq110_10){
									this.vcizzsjcl ="10%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq110_10 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq110_5){
								this.vcizzsjcl = "5-10%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq110_5){
									this.vcizzsjcl ="5%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq110_5 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq110_2){
								this.vcizzsjcl = "2-5%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq110_2){
									this.vcizzsjcl ="2%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq110_2 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq110_1){
								this.vcizzsjcl = "1-2%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq110_1){
									this.vcizzsjcl ="1%";
								}
							}else if(Math.abs(this.vcizzsfscy) >= B2.vci_fsiq110_1 ){
								this.vcizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=120){
							if(Math.abs(this.vcizzsfscy) <= B2.vci_fsiq120_25){
								this.vcizzsjcl = ">25%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq120_25){
									this.vcizzsjcl ="25%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq120_25 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq120_10){
								this.vcizzsjcl = "10-25%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq120_10){
									this.vcizzsjcl ="10%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq120_10 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq120_5){
								this.vcizzsjcl = "5-10%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq120_5){
									this.vcizzsjcl ="5%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq120_5 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq120_2){
								this.vcizzsjcl = "2-5%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq120_2){
									this.vcizzsjcl ="2%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.vci_fsiq120_2 && Math.abs(this.vcizzsfscy) <= B2.vci_fsiq120_1){
								this.vcizzsjcl = "1-2%";
								if(Math.abs(this.vcizzsfscy) == B2.vci_fsiq120_1){
									this.vcizzsjcl ="1%";
								}
							}else if(Math.abs(this.vcizzsfscy) >= B2.vci_fsiq120_1 ){
								this.vcizzsjcl = "<1%";
							}
						}
					}
					
				}else{
					if(Math.abs(this.vcizzsfscy) <= B2.fsiq_vci25){
						this.vcizzsjcl = ">25%";
						if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci25){
							this.vcizzsjcl ="25%";
						}
					}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci25 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci10){
						this.vcizzsjcl = "10-25%";
						if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci10){
							this.vcizzsjcl ="10%";
						}
					}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci10 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci5){
						this.vcizzsjcl = "5-10%";
						if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci5){
							this.vcizzsjcl ="5%";
						}
					}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci5 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci2){
						this.vcizzsjcl = "2-5%";
						if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci2){
							this.vcizzsjcl ="2%";
						}
					}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci2 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci1){
						this.vcizzsjcl = "1-2%";
						if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci1){
							this.vcizzsjcl ="1%";
						}
					}else if(Math.abs(this.vcizzsfscy) >= B2.fsiq_vci1 ){
						this.vcizzsjcl = "<1%";
					}
				
					if(this.bjjc == 1){
						if(this.fsiqi >=40 && this.fsiqi <=79){
							if(Math.abs(this.vcizzsfscy) <= B2.fsiq_vci40_25){
								this.vcizzsjcl = ">25%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci40_25){
									this.vcizzsjcl ="25%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci40_25 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci40_10){
								this.vcizzsjcl = "10-25%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci40_10){
									this.vcizzsjcl ="10%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci40_10 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci40_5){
								this.vcizzsjcl = "5-10%";
								if(Math.abs(this.vcizsfscy) == B2.fsiq_vci40_5){
									this.vcizzsjcl ="5%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci40_5 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci40_2){
								this.vcizzsjcl = "2-5%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci40_2){
									this.vcizzsjcl ="2%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci40_2 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci40_1){
								this.vcizzsjcl = "1-2%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci40_1){
									this.vcizzsjcl ="1%";
								}
							}else if(Math.abs(this.vcizzsfscy) >= B2.fsiq_vci40_1 ){
								this.vcizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=80 && this.fsiqi <=89){
							if(Math.abs(this.vcizzsfscy) <= B2.fsiq_vci80_25){
								this.vcizzsjcl = ">25%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci80_25){
									this.vcizzsjcl ="25%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci80_25 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci80_10){
								this.vcizzsjcl = "10-25%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci80_10){
									this.vcizzsjcl ="10%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci80_10 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci80_5){
								this.vcizzsjcl = "5-10%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci80_5){
									this.vcizzsjcl ="5%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci80_5 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci80_2){
								this.vcizzsjcl = "2-5%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci80_2){
									this.vcizzsjcl ="2%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci80_2 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci80_1){
								this.vcizzsjcl = "1-2%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci80_1){
									this.vcizzsjcl ="1%";
								}
							}else if(Math.abs(this.vcizzsfscy) >= B2.fsiq_vci80_1 ){
								this.vcizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=90 && this.fsiqi <=109){
							if(Math.abs(this.vcizzsfscy) <= B2.fsiq_vci90_25){
								this.vcizzsjcl = ">25%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci90_25){
									this.vcizzsjcl ="25%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci90_25 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci90_10){
								this.vcizzsjcl = "10-25%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci90_10){
									this.vcizzsjcl ="10%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci90_10 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci90_5){
								this.vcizzsjcl = "5-10%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci90_5){
									this.vcizzsjcl ="5%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci90_5 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci90_2){
								this.vcizzsjcl = "2-5%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci90_2){
									this.vcizzsjcl ="2%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci90_2 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci90_1){
								this.vcizzsjcl = "1-2%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci90_1){
									this.vcizzsjcl ="1%";
								}
							}else if(Math.abs(this.vcizzsfscy) >= B2.fsiq_vci90_1 ){
								this.vcizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=110 && this.fsiqi <=119){
							if(Math.abs(this.vcizzsfscy) <= B2.fsiq_vci110_25){
								this.vcizzsjcl = ">25%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci110_25){
									this.vcizzsjcl ="25%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci110_25 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci110_10){
								this.vcizzsjcl = "10-25%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci110_10){
									this.vcizzsjcl ="10%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci110_10 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci110_5){
								this.vcizzsjcl = "5-10%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci110_5){
									this.vcizzsjcl ="5%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci110_5 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci110_2){
								this.vcizzsjcl = "2-5%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci110_2){
									this.vcizzsjcl ="2%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci110_2 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci110_1){
								this.vcizzsjcl = "1-2%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci110_1){
									this.vcizzsjcl ="1%";
								}
							}else if(Math.abs(this.vcizzsfscy) >= B2.fsiq_vci110_1 ){
								this.vcizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=120){
							if(Math.abs(this.vcizzsfscy) <= B2.fsiq_vci120_25){
								this.vcizzsjcl = ">25%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci120_25){
									this.vcizzsjcl ="25%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci120_25 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci120_10){
								this.vcizzsjcl = "10-25%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci120_10){
									this.vcizzsjcl ="10%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci120_10 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci120_5){
								this.vcizzsjcl = "5-10%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci120_5){
									this.vcizzsjcl ="5%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci120_5 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci120_2){
								this.vcizzsjcl = "2-5%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci120_2){
									this.vcizzsjcl ="2%";
								}
							}else if(Math.abs(this.vcizzsfscy) > B2.fsiq_vci120_2 && Math.abs(this.vcizzsfscy) <= B2.fsiq_vci120_1){
								this.vcizzsjcl = "1-2%";
								if(Math.abs(this.vcizzsfscy) == B2.fsiq_vci120_1){
									this.vcizzsjcl ="1%";
								}
							}else if(Math.abs(this.vcizzsfscy) >= B2.fsiq_vci120_1 ){
								this.vcizzsjcl = "<1%";
							}
						}
					}
				}
				
				
				
			}
		}
		
		if(this.vsi != -1 && this.fsiq != -1){
			this.vsizzsfscy = this.vsii - this.fsiqi;
			if(this.ssp == 0){
				this.vsizzsljz = B1.vsi_fsiq01;
			}else if(this.ssp == 1){
				this.vsizzsljz = B1.vsi_fsiq05;
			}else if(this.ssp == 2){
				this.vsizzsljz = B1.vsi_fsiq10;
			}else if(this.ssp == 3){
				this.vsizzsljz = B1.vsi_fsiq15;
			}
			if(Math.abs(this.vsizzsfscy) >= this.vsizzsljz){
				if(this.vsizzsfscy>0){
					this.vsizzsqrx = 1;
				}else{
					this.vsizzsqrx = 2;
				}
				
				if(this.vsizzsfscy < 0){
					if(Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq25){
						this.vsizzsjcl = ">25%";
						if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq25){
							this.vsizzsjcl ="25%";
						}
					}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq25 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq10){
						this.vsizzsjcl = "10-25%";
						if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq10){
							this.vsizzsjcl ="10%";
						}
					}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq10 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq5){
						this.vsizzsjcl = "5-10%";
						if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq5){
							this.vsizzsjcl ="5%";
						}
					}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq5 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq2){
						this.vsizzsjcl = "2-5%";
						if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq2){
							this.vsizzsjcl ="2%";
						}
					}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq2 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq1){
						this.vsizzsjcl = "1-2%";
						if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq1){
							this.vsizzsjcl ="1%";
						}
					}else if(Math.abs(this.vsizzsfscy) >= B2.vsi_fsiq1 ){
						this.vsizzsjcl = "<1%";
					}
				
					if(this.bjjc == 1){
						if(this.fsiqi >=40 && this.fsiqi <=79){
							if(Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq40_25){
								this.vsizzsjcl = ">25%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq40_25){
									this.vsizzsjcl ="25%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq40_25 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq40_10){
								this.vsizzsjcl = "10-25%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq40_10){
									this.vsizzsjcl ="10%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq40_10 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq40_5){
								this.vsizzsjcl = "5-10%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq40_5){
									this.vsizzsjcl ="5%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq40_5 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq40_2){
								this.vsizzsjcl = "2-5%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq40_2){
									this.vsizzsjcl ="2%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq40_2 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq40_1){
								this.vsizzsjcl = "1-2%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq40_1){
									this.vsizzsjcl ="1%";
								}
							}else if(Math.abs(this.vsizzsfscy) >= B2.vsi_fsiq40_1 ){
								this.vsizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=80 && this.fsiqi <=89){
							if(Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq80_25){
								this.vsizzsjcl = ">25%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq80_25){
									this.vsizzsjcl ="25%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq80_25 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq80_10){
								this.vsizzsjcl = "10-25%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq80_10){
									this.vsizzsjcl ="10%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq80_10 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq80_5){
								this.vsizzsjcl = "5-10%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq80_5){
									this.vsizzsjcl ="5%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq80_5 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq80_2){
								this.vsizzsjcl = "2-5%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq80_2){
									this.vsizzsjcl ="2%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq80_2 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq80_1){
								this.vsizzsjcl = "1-2%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq80_1){
									this.vsizzsjcl ="1%";
								}
							}else if(Math.abs(this.vsizzsfscy) >= B2.vsi_fsiq80_1 ){
								this.vsizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=90 && this.fsiqi <=109){
							if(Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq90_25){
								this.vsizzsjcl = ">25%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq90_25){
									this.vsizzsjcl ="25%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq90_25 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq90_10){
								this.vsizzsjcl = "10-25%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq90_10){
									this.vsizzsjcl ="10%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq90_10 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq90_5){
								this.vsizzsjcl = "5-10%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq90_5){
									this.vsizzsjcl ="5%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq90_5 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq90_2){
								this.vsizzsjcl = "2-5%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq90_2){
									this.vsizzsjcl ="2%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq90_2 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq90_1){
								this.vsizzsjcl = "1-2%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq90_1){
									this.vsizzsjcl ="1%";
								}
							}else if(Math.abs(this.vsizzsfscy) >= B2.vsi_fsiq90_1 ){
								this.vsizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=110 && this.fsiqi <=119){
							if(Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq110_25){
								this.vsizzsjcl = ">25%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq110_25){
									this.vsizzsjcl ="25%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq110_25 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq110_10){
								this.vsizzsjcl = "10-25%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq110_10){
									this.vsizzsjcl ="10%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq110_10 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq110_5){
								this.vsizzsjcl = "5-10%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq110_5){
									this.vsizzsjcl ="5%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq110_5 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq110_2){
								this.vsizzsjcl = "2-5%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq110_2){
									this.vsizzsjcl ="2%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq110_2 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq110_1){
								this.vsizzsjcl = "1-2%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq110_1){
									this.vsizzsjcl ="1%";
								}
							}else if(Math.abs(this.vsizzsfscy) >= B2.vsi_fsiq110_1 ){
								this.vsizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=120){
							if(Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq120_25){
								this.vsizzsjcl = ">25%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq120_25){
									this.vsizzsjcl ="25%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq120_25 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq120_10){
								this.vsizzsjcl = "10-25%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq120_10){
									this.vsizzsjcl ="10%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq120_10 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq120_5){
								this.vsizzsjcl = "5-10%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq120_5){
									this.vsizzsjcl ="5%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq120_5 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq120_2){
								this.vsizzsjcl = "2-5%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq120_2){
									this.vsizzsjcl ="2%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.vsi_fsiq120_2 && Math.abs(this.vsizzsfscy) <= B2.vsi_fsiq120_1){
								this.vsizzsjcl = "1-2%";
								if(Math.abs(this.vsizzsfscy) == B2.vsi_fsiq120_1){
									this.vsizzsjcl ="1%";
								}
							}else if(Math.abs(this.vsizzsfscy) >= B2.vsi_fsiq120_1 ){
								this.vsizzsjcl = "<1%";
							}
						}
					}
					
				}else{
					if(Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi25){
						this.vsizzsjcl = ">25%";
						if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi25){
							this.vsizzsjcl ="25%";
						}
					}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi25 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi10){
						this.vsizzsjcl = "10-25%";
						if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi10){
							this.vsizzsjcl ="10%";
						}
					}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi10 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi5){
						this.vsizzsjcl = "5-10%";
						if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi5){
							this.vsizzsjcl ="5%";
						}
					}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi5 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi2){
						this.vsizzsjcl = "2-5%";
						if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi2){
							this.vsizzsjcl ="2%";
						}
					}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi2 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi1){
						this.vsizzsjcl = "1-2%";
						if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi1){
							this.vsizzsjcl ="1%";
						}
					}else if(Math.abs(this.vsizzsfscy) >= B2.fsiq_vsi1 ){
						this.vsizzsjcl = "<1%";
					}
				
					if(this.bjjc == 1){
						if(this.fsiqi >=40 && this.fsiqi <=79){
							if(Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi40_25){
								this.vsizzsjcl = ">25%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi40_25){
									this.vsizzsjcl ="25%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi40_25 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi40_10){
								this.vsizzsjcl = "10-25%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi40_10){
									this.vsizzsjcl ="10%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi40_10 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi40_5){
								this.vsizzsjcl = "5-10%";
								if(Math.abs(this.vsizsfscy) == B2.fsiq_vsi40_5){
									this.vsizzsjcl ="5%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi40_5 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi40_2){
								this.vsizzsjcl = "2-5%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi40_2){
									this.vsizzsjcl ="2%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi40_2 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi40_1){
								this.vsizzsjcl = "1-2%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi40_1){
									this.vsizzsjcl ="1%";
								}
							}else if(Math.abs(this.vsizzsfscy) >= B2.fsiq_vsi40_1 ){
								this.vsizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=80 && this.fsiqi <=89){
							if(Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi80_25){
								this.vsizzsjcl = ">25%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi80_25){
									this.vsizzsjcl ="25%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi80_25 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi80_10){
								this.vsizzsjcl = "10-25%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi80_10){
									this.vsizzsjcl ="10%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi80_10 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi80_5){
								this.vsizzsjcl = "5-10%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi80_5){
									this.vsizzsjcl ="5%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi80_5 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi80_2){
								this.vsizzsjcl = "2-5%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi80_2){
									this.vsizzsjcl ="2%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi80_2 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi80_1){
								this.vsizzsjcl = "1-2%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi80_1){
									this.vsizzsjcl ="1%";
								}
							}else if(Math.abs(this.vsizzsfscy) >= B2.fsiq_vsi80_1 ){
								this.vsizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=90 && this.fsiqi <=109){
							if(Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi90_25){
								this.vsizzsjcl = ">25%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi90_25){
									this.vsizzsjcl ="25%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi90_25 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi90_10){
								this.vsizzsjcl = "10-25%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi90_10){
									this.vsizzsjcl ="10%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi90_10 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi90_5){
								this.vsizzsjcl = "5-10%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi90_5){
									this.vsizzsjcl ="5%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi90_5 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi90_2){
								this.vsizzsjcl = "2-5%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi90_2){
									this.vsizzsjcl ="2%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi90_2 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi90_1){
								this.vsizzsjcl = "1-2%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi90_1){
									this.vsizzsjcl ="1%";
								}
							}else if(Math.abs(this.vsizzsfscy) >= B2.fsiq_vsi90_1 ){
								this.vsizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=110 && this.fsiqi <=119){
							if(Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi110_25){
								this.vsizzsjcl = ">25%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi110_25){
									this.vsizzsjcl ="25%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi110_25 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi110_10){
								this.vsizzsjcl = "10-25%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi110_10){
									this.vsizzsjcl ="10%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi110_10 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi110_5){
								this.vsizzsjcl = "5-10%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi110_5){
									this.vsizzsjcl ="5%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi110_5 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi110_2){
								this.vsizzsjcl = "2-5%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi110_2){
									this.vsizzsjcl ="2%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi110_2 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi110_1){
								this.vsizzsjcl = "1-2%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi110_1){
									this.vsizzsjcl ="1%";
								}
							}else if(Math.abs(this.vsizzsfscy) >= B2.fsiq_vsi110_1 ){
								this.vsizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=120){
							if(Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi120_25){
								this.vsizzsjcl = ">25%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi120_25){
									this.vsizzsjcl ="25%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi120_25 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi120_10){
								this.vsizzsjcl = "10-25%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi120_10){
									this.vsizzsjcl ="10%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi120_10 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi120_5){
								this.vsizzsjcl = "5-10%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi120_5){
									this.vsizzsjcl ="5%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi120_5 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi120_2){
								this.vsizzsjcl = "2-5%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi120_2){
									this.vsizzsjcl ="2%";
								}
							}else if(Math.abs(this.vsizzsfscy) > B2.fsiq_vsi120_2 && Math.abs(this.vsizzsfscy) <= B2.fsiq_vsi120_1){
								this.vsizzsjcl = "1-2%";
								if(Math.abs(this.vsizzsfscy) == B2.fsiq_vsi120_1){
									this.vsizzsjcl ="1%";
								}
							}else if(Math.abs(this.vsizzsfscy) >= B2.fsiq_vsi120_1 ){
								this.vsizzsjcl = "<1%";
							}
						}
					}
				}
				
				
				
			}
		}
		
		if(this.wmi != -1 && this.fsiq != -1){
			this.wmizzsfscy = this.wmii - this.fsiqi;
			if(this.ssp == 0){
				this.wmizzsljz = B1.wmi_fsiq01;
			}else if(this.ssp == 1){
				this.wmizzsljz = B1.wmi_fsiq05;
			}else if(this.ssp == 2){
				this.wmizzsljz = B1.wmi_fsiq10;
			}else if(this.ssp == 3){
				this.wmizzsljz = B1.wmi_fsiq15;
			}
			
			if(Math.abs(this.wmizzsfscy) >= this.wmizzsljz){
				if(this.wmizzsfscy>0){
					this.wmizzsqrx = 1;
				}else{
					this.wmizzsqrx = 2;
				}
				
				if(this.wmizzsfscy < 0){
					if(Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq25){
						this.wmizzsjcl = ">25%";
						if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq25){
							this.wmizzsjcl ="25%";
						}
					}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq25 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq10){
						this.wmizzsjcl = "10-25%";
						if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq10){
							this.wmizzsjcl ="10%";
						}
					}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq10 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq5){
						this.wmizzsjcl = "5-10%";
						if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq5){
							this.wmizzsjcl ="5%";
						}
					}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq5 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq2){
						this.wmizzsjcl = "2-5%";
						if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq2){
							this.wmizzsjcl ="2%";
						}
					}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq2 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq1){
						this.wmizzsjcl = "1-2%";
						if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq25){
							this.wmizzsjcl ="1%";
						}
					}else if(Math.abs(this.wmizzsfscy) >= B2.wmi_fsiq1 ){
						this.wmizzsjcl = "<1%";
					}
					
					if(this.bjjc == 1){
						if(this.fsiqi >=40 && this.fsiqi <=79){
							if(Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq40_25){
								this.wmizzsjcl = ">25%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq40_25){
									this.wmizzsjcl ="25%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq40_25 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq40_10){
								this.wmizzsjcl = "10-25%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq40_10){
									this.wmizzsjcl ="10%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq40_10 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq40_5){
								this.wmizzsjcl = "5-10%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq40_5){
									this.wmizzsjcl ="5%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq40_5 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq40_2){
								this.wmizzsjcl = "2-5%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq40_2){
									this.wmizzsjcl ="2%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq40_2 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq40_1){
								this.wmizzsjcl = "1-2%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq40_1){
									this.wmizzsjcl ="1%";
								}
							}else if(Math.abs(this.wmizzsfscy) >= B2.wmi_fsiq40_1 ){
								this.wmizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=80 && this.fsiqi <=89){
							if(Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq80_25){
								this.wmizzsjcl = ">25%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq80_25){
									this.wmizzsjcl ="25%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq80_25 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq80_10){
								this.wmizzsjcl = "10-25%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq80_10){
									this.wmizzsjcl ="10%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq80_10 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq80_5){
								this.wmizzsjcl = "5-10%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq80_5){
									this.wmizzsjcl ="5%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq80_5 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq80_2){
								this.wmizzsjcl = "2-5%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq80_2){
									this.wmizzsjcl ="2%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq80_2 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq80_1){
								this.wmizzsjcl = "1-2%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq80_1){
									this.wmizzsjcl ="1%";
								}
							}else if(Math.abs(this.wmizzsfscy) >= B2.wmi_fsiq80_1 ){
								this.wmizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=90 && this.fsiqi <=109){
							if(Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq90_25){
								this.wmizzsjcl = ">25%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq90_25){
									this.wmizzsjcl ="25%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq90_25 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq90_10){
								this.wmizzsjcl = "10-25%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq90_10){
									this.wmizzsjcl ="10%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq90_10 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq90_5){
								this.wmizzsjcl = "5-10%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq90_5){
									this.wmizzsjcl ="5%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq90_5 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq90_2){
								this.wmizzsjcl = "2-5%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq90_2){
									this.wmizzsjcl ="2%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq90_2 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq90_1){
								this.wmizzsjcl = "1-2%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq90_1){
									this.wmizzsjcl ="1%";
								}
							}else if(Math.abs(this.wmizzsfscy) >= B2.wmi_fsiq90_1 ){
								this.wmizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=110 && this.fsiqi <=119){
							if(Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq110_25){
								this.wmizzsjcl = ">25%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq110_25){
									this.wmizzsjcl ="25%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq110_25 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq110_10){
								this.wmizzsjcl = "10-25%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq110_10){
									this.wmizzsjcl ="10%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq110_10 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq110_5){
								this.wmizzsjcl = "5-10%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq110_5){
									this.wmizzsjcl ="5%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq110_5 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq110_2){
								this.wmizzsjcl = "2-5%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq110_2){
									this.wmizzsjcl ="2%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq110_2 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq110_1){
								this.wmizzsjcl = "1-2%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq110_1){
									this.wmizzsjcl ="1%";
								}
							}else if(Math.abs(this.wmizzsfscy) >= B2.wmi_fsiq110_1 ){
								this.wmizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=120){
							if(Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq120_25){
								this.wmizzsjcl = ">25%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq120_25){
									this.wmizzsjcl ="25%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq120_25 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq120_10){
								this.wmizzsjcl = "10-25%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq120_10){
									this.wmizzsjcl ="10%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq120_10 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq120_5){
								this.wmizzsjcl = "5-10%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq120_5){
									this.wmizzsjcl ="5%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq120_5 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq120_2){
								this.wmizzsjcl = "2-5%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq120_2){
									this.wmizzsjcl ="2%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.wmi_fsiq120_2 && Math.abs(this.wmizzsfscy) <= B2.wmi_fsiq120_1){
								this.wmizzsjcl = "1-2%";
								if(Math.abs(this.wmizzsfscy) == B2.wmi_fsiq120_1){
									this.wmizzsjcl ="1%";
								}
							}else if(Math.abs(this.wmizzsfscy) >= B2.wmi_fsiq120_1 ){
								this.wmizzsjcl = "<1%";
							}
						}
					}
					
				}else{
					if(Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi25){
						this.wmizzsjcl = ">25%";
						if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi25){
							this.wmizzsjcl ="25%";
						}
					}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi25 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi10){
						this.wmizzsjcl = "10-25%";
						if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi10){
							this.wmizzsjcl ="10%";
						}
					}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi10 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi5){
						this.wmizzsjcl = "5-10%";
						if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi5){
							this.wmizzsjcl ="5%";
						}
					}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi5 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi2){
						this.wmizzsjcl = "2-5%";
						if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi2){
							this.wmizzsjcl ="2%";
						}
					}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi2 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi1){
						this.wmizzsjcl = "1-2%";
						if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi1){
							this.wmizzsjcl ="1%";
						}
					}else if(Math.abs(this.wmizzsfscy) >= B2.fsiq_wmi1 ){
						this.wmizzsjcl = "<1%";
					}
				
					if(this.bjjc == 1){
						if(this.fsiqi >=40 && this.fsiqi <=79){
							if(Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi40_25){
								this.wmizzsjcl = ">25%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi40_25){
									this.wmizzsjcl ="25%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi40_25 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi40_10){
								this.wmizzsjcl = "10-25%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi40_10){
									this.wmizzsjcl ="10%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi40_10 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi40_5){
								this.wmizzsjcl = "5-10%";
								if(Math.abs(this.wmizsfscy) == B2.fsiq_wmi40_5){
									this.wmizzsjcl ="5%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi40_5 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi40_2){
								this.wmizzsjcl = "2-5%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi40_2){
									this.wmizzsjcl ="2%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi40_2 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi40_1){
								this.wmizzsjcl = "1-2%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi40_1){
									this.wmizzsjcl ="1%";
								}
							}else if(Math.abs(this.wmizzsfscy) >= B2.fsiq_wmi40_1 ){
								this.wmizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=80 && this.fsiqi <=89){
							if(Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi80_25){
								this.wmizzsjcl = ">25%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi80_25){
									this.wmizzsjcl ="25%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi80_25 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi80_10){
								this.wmizzsjcl = "10-25%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi80_10){
									this.wmizzsjcl ="10%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi80_10 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi80_5){
								this.wmizzsjcl = "5-10%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi80_5){
									this.wmizzsjcl ="5%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi80_5 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi80_2){
								this.wmizzsjcl = "2-5%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi80_2){
									this.wmizzsjcl ="2%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi80_2 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi80_1){
								this.wmizzsjcl = "1-2%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi80_1){
									this.wmizzsjcl ="1%";
								}
							}else if(Math.abs(this.wmizzsfscy) >= B2.fsiq_wmi80_1 ){
								this.wmizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=90 && this.fsiqi <=109){
							if(Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi90_25){
								this.wmizzsjcl = ">25%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi90_25){
									this.wmizzsjcl ="25%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi90_25 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi90_10){
								this.wmizzsjcl = "10-25%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi90_10){
									this.wmizzsjcl ="10%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi90_10 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi90_5){
								this.wmizzsjcl = "5-10%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi90_5){
									this.wmizzsjcl ="5%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi90_5 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi90_2){
								this.wmizzsjcl = "2-5%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi90_2){
									this.wmizzsjcl ="2%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi90_2 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi90_1){
								this.wmizzsjcl = "1-2%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi90_1){
									this.wmizzsjcl ="1%";
								}
							}else if(Math.abs(this.wmizzsfscy) >= B2.fsiq_wmi90_1 ){
								this.wmizsfsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=110 && this.fsiqi <=119){
							if(Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi110_25){
								this.wmizzsjcl = ">25%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi110_25){
									this.wmizzsjcl ="25%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi110_25 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi110_10){
								this.wmizzsjcl = "10-25%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi110_10){
									this.wmizzsjcl ="10%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi110_10 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi110_5){
								this.wmizzsjcl = "5-10%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi110_5){
									this.wmizzsjcl ="5%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi110_5 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi110_2){
								this.wmizzsjcl = "2-5%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi110_2){
									this.wmizzsjcl ="2%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi110_2 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi110_1){
								this.wmizzsjcl = "1-2%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi110_1){
									this.wmizzsjcl ="1%";
								}
							}else if(Math.abs(this.wmizzsfscy) >= B2.fsiq_wmi110_1 ){
								this.wmizzsjcl = "<1%";
							}
						}
						
						if(this.fsiqi >=120){
							if(Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi120_25){
								this.wmizzsjcl = ">25%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi120_25){
									this.wmizzsjcl ="25%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi120_25 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi120_10){
								this.wmizzsjcl = "10-25%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi120_10){
									this.wmizzsjcl ="10%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi120_10 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi120_5){
								this.wmizzsjcl = "5-10%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi120_5){
									this.wmizzsjcl ="5%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi120_5 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi120_2){
								this.wmizzsjcl = "2-5%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi120_2){
									this.wmizzsjcl ="2%";
								}
							}else if(Math.abs(this.wmizzsfscy) > B2.fsiq_wmi120_2 && Math.abs(this.wmizzsfscy) <= B2.fsiq_wmi120_1){
								this.wmizzsjcl = "1-2%";
								if(Math.abs(this.wmizzsfscy) == B2.fsiq_wmi120_1){
									this.wmizzsjcl ="1%";
								}
							}else if(Math.abs(this.wmizzsfscy) >= B2.fsiq_wmi120_1 ){
								this.wmizzsjcl = "<1%";
							}
						}
					}
				}
			}
		}
	}
	
	private void qrpd(){
		//分测验水平 强项与弱项确定表
		//6个不缺失
		if(count_zsfs() <1){
			this.zsfs6 = this.rvl + this.infl + this.pml + this.oal + this.zll + this.bdl;
			this.zsfs6fsd = com_fen(rvl, bdl, pml, zll, oal, infl);
			this.zsfs6jz = change2((float)this.zsfs6/6);
			this.zsfs6rvfscy = change2((float)this.rvl - this.zsfs6jz);
			this.zsfs6bdfscy = change2((float)this.bdl - this.zsfs6jz);
			this.zsfs6pmfscy = change2((float)this.pml - this.zsfs6jz);
			this.zsfs6zlfscy = change2((float)this.zll - this.zsfs6jz);
			this.zsfs6oafscy = change2((float)this.oal - this.zsfs6jz);
			this.zsfs6infscy = change2((float)this.infl - this.zsfs6jz);
			if(this.ssp == 0){
				this.zsfs6rvljz = B3.rv_mss01;
				this.zsfs6bdljz = B3.bd_mss01;
				this.zsfs6pmljz = B3.pm_mss01;
				this.zsfs6zlljz = B3.zl_mss01;
				this.zsfs6oaljz = B3.oa_mss01;
				this.zsfs6inljz = B3.in_mss01;
			}
			if(this.ssp == 1){
				this.zsfs6rvljz = B3.rv_mss05;
				this.zsfs6bdljz = B3.bd_mss05;
				this.zsfs6pmljz = B3.pm_mss05;
				this.zsfs6zlljz = B3.zl_mss05;
				this.zsfs6oaljz = B3.oa_mss05;
				this.zsfs6inljz = B3.in_mss05;
			}
			if(this.ssp == 2){
				this.zsfs6rvljz = B3.rv_mss10;
				this.zsfs6bdljz = B3.bd_mss10;
				this.zsfs6pmljz = B3.pm_mss10;
				this.zsfs6zlljz = B3.zl_mss10;
				this.zsfs6oaljz = B3.oa_mss10;
				this.zsfs6inljz = B3.in_mss10;
			}
			if(this.ssp == 3){
				this.zsfs6rvljz = B3.rv_mss15;
				this.zsfs6bdljz = B3.bd_mss15;
				this.zsfs6pmljz = B3.pm_mss15;
				this.zsfs6zlljz = B3.zl_mss15;
				this.zsfs6oaljz = B3.oa_mss15;
				this.zsfs6inljz = B3.in_mss15;
			}
			
			//rv强弱，基础
			if(Math.abs(this.zsfs6rvfscy) >= this.zsfs6rvljz){
				if(this.zsfs6rvfscy > 0){
					this.zsfs6rvqrx = 1;
				}else{
					this.zsfs6rvqrx = 2;
				}
				
				if(this.zsfs6rvfscy < 0){
					if(Math.abs(this.zsfs6rvfscy) <= B4.rv_mss25){
						this.zsfs6rvjcl = ">25%";
						if(Math.abs(this.zsfs6rvfscy) == B4.rv_mss25){
							this.zsfs6rvjcl ="25%";
						}
					}else if(Math.abs(this.zsfs6rvfscy) > B4.rv_mss25 && Math.abs(this.zsfs6rvfscy) <= B4.rv_mss10){
						this.zsfs6rvjcl = "10-25%";
						if(Math.abs(this.zsfs6rvfscy) == B4.rv_mss10){
							this.zsfs6rvjcl ="10%";
						}
					}else if(Math.abs(this.zsfs6rvfscy) > B4.rv_mss10 && Math.abs(this.zsfs6rvfscy) <= B4.rv_mss5){
						this.zsfs6rvjcl = "5-10%";
						if(Math.abs(this.zsfs6rvfscy) == B4.rv_mss5){
							this.zsfs6rvjcl ="5%";
						}
					}else if(Math.abs(this.zsfs6rvfscy) > B4.rv_mss5 && Math.abs(this.zsfs6rvfscy) <= B4.rv_mss2){
						this.zsfs6rvjcl = "2-5%";
						if(Math.abs(this.zsfs6rvfscy) == B4.rv_mss2){
							this.zsfs6rvjcl ="2%";
						}
					}else if(Math.abs(this.zsfs6rvfscy) > B4.rv_mss2 && Math.abs(this.zsfs6rvfscy) <= B4.rv_mss1){
						this.zsfs6rvjcl = "1-2%";
						if(Math.abs(this.zsfs6rvfscy) == B4.rv_mss1){
							this.zsfs6rvjcl ="1%";
						}
					}else if(Math.abs(this.zsfs6rvfscy) >= B4.rv_mss1 ){
						this.zsfs6rvjcl = "<1%";
					}
				}else{
					if(Math.abs(this.zsfs6rvfscy) <= B4.mss_rv25){
						this.zsfs6rvjcl = ">25%";
						if(Math.abs(this.zsfs6rvfscy) == B4.mss_rv25){
							this.zsfs6rvjcl ="25%";
						}
					}else if(Math.abs(this.zsfs6rvfscy) > B4.mss_rv25 && Math.abs(this.zsfs6rvfscy) <= B4.mss_rv10){
						this.zsfs6rvjcl = "10-25%";
						if(Math.abs(this.zsfs6rvfscy) == B4.mss_rv10){
							this.zsfs6rvjcl ="10%";
						}
					}else if(Math.abs(this.zsfs6rvfscy) > B4.mss_rv10 && Math.abs(this.zsfs6rvfscy) <= B4.mss_rv5){
						this.zsfs6rvjcl = "5-10%";
						if(Math.abs(this.zsfs6rvfscy) == B4.mss_rv5){
							this.zsfs6rvjcl ="5%";
						}
					}else if(Math.abs(this.zsfs6rvfscy) > B4.mss_rv5 && Math.abs(this.zsfs6rvfscy) <= B4.mss_rv2){
						this.zsfs6rvjcl = "2-5%";
						if(Math.abs(this.zsfs6rvfscy) == B4.mss_rv2){
							this.zsfs6rvjcl ="2%";
						}
					}else if(Math.abs(this.zsfs6rvfscy) > B4.mss_rv2 && Math.abs(this.zsfs6rvfscy) <= B4.mss_rv1){
						this.zsfs6rvjcl = "1-2%";
						if(Math.abs(this.zsfs6rvfscy) == B4.mss_rv1){
							this.zsfs6rvjcl ="1%";
						}
					}else if(Math.abs(this.zsfs6rvfscy) >= B4.mss_rv1 ){
						this.zsfs6rvjcl = "<1%";
					}
				}
				
				
			}
			
			//bd强弱，基础
			if(Math.abs(this.zsfs6bdfscy) >= this.zsfs6bdljz){
				if(this.zsfs6bdfscy > 0){
					this.zsfs6bdqrx = 1;
				}else{
					this.zsfs6bdqrx = 2;
				}
//				System.out.println("zsfs6bdfscy-->" +Math.abs(this.zsfs6bdfscy));
				if(this.zsfs6bdfscy < 0){
					if(Math.abs(this.zsfs6bdfscy) <= B4.bd_mss25){
						this.zsfs6bdjcl = ">25%";
						if(Math.abs(this.zsfs6bdfscy) == B4.bd_mss25){
							this.zsfs6bdjcl ="25%";
						}
					}else if(Math.abs(this.zsfs6bdfscy) > B4.bd_mss25 && Math.abs(this.zsfs6bdfscy) <= B4.bd_mss10){
						this.zsfs6bdjcl = "10-25%";
						if(Math.abs(this.zsfs6bdfscy) == B4.bd_mss10){
							this.zsfs6bdjcl ="10%";
						}
					}else if(Math.abs(this.zsfs6bdfscy) > B4.bd_mss10 && Math.abs(this.zsfs6bdfscy) <= B4.bd_mss5){
						this.zsfs6bdjcl = "5-10%";
						if(Math.abs(this.zsfs6bdfscy) == B4.bd_mss5){
							this.zsfs6bdjcl ="5%";
						}
					}else if(Math.abs(this.zsfs6bdfscy) > B4.bd_mss5 && Math.abs(this.zsfs6bdfscy) <= B4.bd_mss2){
						this.zsfs6bdjcl = "2-5%";
						if(Math.abs(this.zsfs6bdfscy) == B4.bd_mss2){
							this.zsfs6bdjcl ="2%";
						}
					}else if(Math.abs(this.zsfs6bdfscy) > B4.bd_mss2 && Math.abs(this.zsfs6bdfscy) <= B4.bd_mss1){
						this.zsfs6bdjcl = "1-2%";
						if(Math.abs(this.zsfs6bdfscy) == B4.bd_mss25){
							this.zsfs6bdjcl ="1%";
						}
					}else if(Math.abs(this.zsfs6bdfscy) >= B4.bd_mss1 ){
						this.zsfs6bdjcl = "<1%";
					}
				}else{
					if(Math.abs(this.zsfs6bdfscy) <= B4.bd_mss25){
						this.zsfs6bdjcl = ">25%";
						if(Math.abs(this.zsfs6bdfscy) == B4.bd_mss25){
							this.zsfs6bdjcl ="25%";
						}
					}else if(Math.abs(this.zsfs6bdfscy) > B4.bd_mss25 && Math.abs(this.zsfs6bdfscy) <= B4.bd_mss10){
						this.zsfs6bdjcl = "10-25%";
						if(Math.abs(this.zsfs6bdfscy) == B4.bd_mss10){
							this.zsfs6bdjcl ="10%";
						}
					}else if(Math.abs(this.zsfs6bdfscy) > B4.bd_mss10 && Math.abs(this.zsfs6bdfscy) <= B4.bd_mss5){
						this.zsfs6bdjcl = "5-10%";
						if(Math.abs(this.zsfs6bdfscy) == B4.bd_mss5){
							this.zsfs6bdjcl ="5%";
						}
					}else if(Math.abs(this.zsfs6bdfscy) > B4.bd_mss5 && Math.abs(this.zsfs6bdfscy) <= B4.bd_mss2){
						this.zsfs6bdjcl = "2-5%";
						if(Math.abs(this.zsfs6bdfscy) == B4.bd_mss2){
							this.zsfs6bdjcl ="2%";
						}
					}else if(Math.abs(this.zsfs6bdfscy) > B4.bd_mss2 && Math.abs(this.zsfs6bdfscy) <= B4.bd_mss1){
						this.zsfs6bdjcl = "1-2%";
						if(Math.abs(this.zsfs6bdfscy) == B4.bd_mss25){
							this.zsfs6bdjcl ="1%";
						}
					}else if(Math.abs(this.zsfs6bdfscy) >= B4.bd_mss1 ){
						this.zsfs6bdjcl = "<1%";
					}
				}
			}
			
			//pm强弱，基础
			if(Math.abs(this.zsfs6pmfscy) >= this.zsfs6pmljz){
				if(this.zsfs6pmfscy > 0){
					this.zsfs6pmqrx = 1;
				}else{
					this.zsfs6pmqrx = 2;
				}
				
				if(this.zsfs6pmfscy < 0){
					if(Math.abs(this.zsfs6pmfscy) <= B4.pm_mss25){
						this.zsfs6pmjcl = ">25%";
						if(Math.abs(this.zsfs6pmfscy) == B4.pm_mss25){
							this.zsfs6pmjcl ="25%";
						}
					}else if(Math.abs(this.zsfs6pmfscy) > B4.pm_mss25 && Math.abs(this.zsfs6pmfscy) <= B4.pm_mss10){
						this.zsfs6pmjcl = "10-25%";
						if(Math.abs(this.zsfs6pmfscy) == B4.pm_mss10){
							this.zsfs6pmjcl ="10%";
						}
					}else if(Math.abs(this.zsfs6pmfscy) > B4.pm_mss10 && Math.abs(this.zsfs6pmfscy) <= B4.pm_mss5){
						this.zsfs6pmjcl = "5-10%";
						if(Math.abs(this.zsfs6pmfscy) == B4.pm_mss5){
							this.zsfs6pmjcl ="5%";
						}
					}else if(Math.abs(this.zsfs6pmfscy) > B4.pm_mss5 && Math.abs(this.zsfs6pmfscy) <= B4.pm_mss2){
						this.zsfs6pmjcl = "2-5%";
						if(Math.abs(this.zsfs6pmfscy) == B4.pm_mss2){
							this.zsfs6pmjcl ="2%";
						}
					}else if(Math.abs(this.zsfs6pmfscy) > B4.pm_mss2 && Math.abs(this.zsfs6pmfscy) <= B4.pm_mss1){
						this.zsfs6pmjcl = "1-2%";
						if(Math.abs(this.zsfs6pmfscy) == B4.pm_mss25){
							this.zsfs6pmjcl ="1%";
						}
					}else if(Math.abs(this.zsfs6pmfscy) >= B4.pm_mss1 ){
						this.zsfs6pmjcl = "<1%";
					}
				}else{
					if(Math.abs(this.zsfs6pmfscy) <= B4.mss_pm25){
						this.zsfs6pmjcl = ">25%";
						if(Math.abs(this.zsfs6pmfscy) == B4.mss_pm25){
							this.zsfs6pmjcl ="25%";
						}
					}else if(Math.abs(this.zsfs6pmfscy) > B4.mss_pm25 && Math.abs(this.zsfs6pmfscy) <= B4.mss_pm10){
						this.zsfs6pmjcl = "10-25%";
						if(Math.abs(this.zsfs6pmfscy) == B4.mss_pm10){
							this.zsfs6pmjcl ="10%";
						}
					}else if(Math.abs(this.zsfs6pmfscy) > B4.mss_pm10 && Math.abs(this.zsfs6pmfscy) <= B4.mss_pm5){
						this.zsfs6pmjcl = "5-10%";
						if(Math.abs(this.zsfs6pmfscy) == B4.mss_pm5){
							this.zsfs6pmjcl ="5%";
						}
					}else if(Math.abs(this.zsfs6pmfscy) > B4.mss_pm5 && Math.abs(this.zsfs6pmfscy) <= B4.mss_pm2){
						this.zsfs6pmjcl = "2-5%";
						if(Math.abs(this.zsfs6pmfscy) == B4.mss_pm2){
							this.zsfs6pmjcl ="2%";
						}
					}else if(Math.abs(this.zsfs6pmfscy) > B4.mss_pm2 && Math.abs(this.zsfs6pmfscy) <= B4.mss_pm1){
						this.zsfs6pmjcl = "1-2%";
						if(Math.abs(this.zsfs6pmfscy) == B4.mss_pm25){
							this.zsfs6pmjcl ="1%";
						}
					}else if(Math.abs(this.zsfs6pmfscy) >= B4.mss_pm1 ){
						this.zsfs6pmjcl = "<1%";
					}
				}
			}
			
			//zl强弱，基础
			if(Math.abs(this.zsfs6zlfscy) >= this.zsfs6zlljz){
				if(this.zsfs6zlfscy > 0){
					this.zsfs6zlqrx = 1;
				}else{
					this.zsfs6zlqrx = 2;
				}
				
				if(this.zsfs6zlfscy < 0){
					if(Math.abs(this.zsfs6zlfscy) <= B4.zl_mss25){
						this.zsfs6zljcl = ">25%";
						if(Math.abs(this.zsfs6zlfscy) == B4.zl_mss25){
							this.zsfs6zljcl ="25%";
						}
					}else if(Math.abs(this.zsfs6zlfscy) > B4.zl_mss25 && Math.abs(this.zsfs6zlfscy) <= B4.zl_mss10){
						this.zsfs6zljcl = "10-25%";
						if(Math.abs(this.zsfs6zlfscy) == B4.zl_mss10){
							this.zsfs6zljcl ="10%";
						}
					}else if(Math.abs(this.zsfs6zlfscy) > B4.zl_mss10 && Math.abs(this.zsfs6zlfscy) <= B4.zl_mss5){
						this.zsfs6zljcl = "5-10%";
						if(Math.abs(this.zsfs6zlfscy) == B4.zl_mss5){
							this.zsfs6zljcl ="5%";
						}
					}else if(Math.abs(this.zsfs6zlfscy) > B4.zl_mss5 && Math.abs(this.zsfs6zlfscy) <= B4.zl_mss2){
						this.zsfs6zljcl = "2-5%";
						if(Math.abs(this.zsfs6zlfscy) == B4.zl_mss2){
							this.zsfs6zljcl ="2%";
						}
					}else if(Math.abs(this.zsfs6zlfscy) > B4.zl_mss2 && Math.abs(this.zsfs6zlfscy) <= B4.zl_mss1){
						this.zsfs6zljcl = "1-2%";
						if(Math.abs(this.zsfs6zlfscy) == B4.zl_mss1){
							this.zsfs6zljcl ="1%";
						}
					}else if(Math.abs(this.zsfs6zlfscy) >= B4.zl_mss1 ){
						this.zsfs6zljcl = "<1%";
					}
				}else{
					if(Math.abs(this.zsfs6zlfscy) <= B4.mss_zl25){
						this.zsfs6zljcl = ">25%";
						if(Math.abs(this.zsfs6zlfscy) == B4.mss_zl25){
							this.zsfs6zljcl ="25%";
						}
					}else if(Math.abs(this.zsfs6zlfscy) > B4.mss_zl25 && Math.abs(this.zsfs6zlfscy) <= B4.mss_zl10){
						this.zsfs6zljcl = "10-25%";
						if(Math.abs(this.zsfs6zlfscy) == B4.mss_zl10){
							this.zsfs6zljcl ="10%";
						}
					}else if(Math.abs(this.zsfs6zlfscy) > B4.mss_zl10 && Math.abs(this.zsfs6zlfscy) <= B4.mss_zl5){
						this.zsfs6zljcl = "5-10%";
						if(Math.abs(this.zsfs6zlfscy) == B4.mss_zl5){
							this.zsfs6zljcl ="5%";
						}
					}else if(Math.abs(this.zsfs6zlfscy) > B4.mss_zl5 && Math.abs(this.zsfs6zlfscy) <= B4.mss_zl2){
						this.zsfs6zljcl = "2-5%";
						if(Math.abs(this.zsfs6zlfscy) == B4.mss_zl2){
							this.zsfs6zljcl ="2%";
						}
					}else if(Math.abs(this.zsfs6zlfscy) > B4.mss_zl2 && Math.abs(this.zsfs6zlfscy) <= B4.mss_zl1){
						this.zsfs6zljcl = "1-2%";
						if(Math.abs(this.zsfs6zlfscy) == B4.mss_zl1){
							this.zsfs6zljcl ="1%";
						}
					}else if(Math.abs(this.zsfs6zlfscy) >= B4.mss_zl1 ){
						this.zsfs6zljcl = "<1%";
					}
				}
			}
			
			//in强弱，基础
			if(Math.abs(this.zsfs6infscy) >= this.zsfs6inljz){
				if(this.zsfs6infscy > 0){
					this.zsfs6inqrx = 1;
				}else{
					this.zsfs6inqrx = 2;
				}
				
				if(this.zsfs6infscy < 0){
					if(Math.abs(this.zsfs6infscy) <= B4.in_mss25){
						this.zsfs6injcl = ">25%";
						if(Math.abs(this.zsfs6infscy) == B4.in_mss25){
							this.zsfs6injcl ="25%";
						}
					}else if(Math.abs(this.zsfs6infscy) > B4.in_mss25 && Math.abs(this.zsfs6infscy) <= B4.in_mss10){
						this.zsfs6injcl = "10-25%";
						if(Math.abs(this.zsfs6infscy) == B4.in_mss10){
							this.zsfs6injcl ="10%";
						}
					}else if(Math.abs(this.zsfs6infscy) > B4.in_mss10 && Math.abs(this.zsfs6infscy) <= B4.in_mss5){
						this.zsfs6injcl = "5-10%";
						if(Math.abs(this.zsfs6infscy) == B4.in_mss5){
							this.zsfs6injcl ="5%";
						}
					}else if(Math.abs(this.zsfs6infscy) > B4.in_mss5 && Math.abs(this.zsfs6infscy) <= B4.in_mss2){
						this.zsfs6injcl = "2-5%";
						if(Math.abs(this.zsfs6infscy) == B4.in_mss2){
							this.zsfs6injcl ="2%";
						}
					}else if(Math.abs(this.zsfs6infscy) > B4.in_mss2 && Math.abs(this.zsfs6infscy) <= B4.in_mss1){
						this.zsfs6injcl = "1-2%";
						if(Math.abs(this.zsfs6infscy) == B4.in_mss1){
							this.zsfs6injcl ="1%";
						}
					}else if(Math.abs(this.zsfs6infscy) >= B4.in_mss1 ){
						this.zsfs6injcl = "<1%";
					}
				}else{
					if(Math.abs(this.zsfs6infscy) <= B4.mss_in25){
						this.zsfs6injcl = ">25%";
						if(Math.abs(this.zsfs6infscy) == B4.mss_in25){
							this.zsfs6injcl ="25%";
						}
					}else if(Math.abs(this.zsfs6infscy) > B4.mss_in25 && Math.abs(this.zsfs6infscy) <= B4.mss_in10){
						this.zsfs6injcl = "10-25%";
						if(Math.abs(this.zsfs6infscy) == B4.mss_in10){
							this.zsfs6injcl ="10%";
						}
					}else if(Math.abs(this.zsfs6infscy) > B4.mss_in10 && Math.abs(this.zsfs6infscy) <= B4.mss_in5){
						this.zsfs6injcl = "5-10%";
						if(Math.abs(this.zsfs6infscy) == B4.mss_in5){
							this.zsfs6injcl ="5%";
						}
					}else if(Math.abs(this.zsfs6infscy) > B4.mss_in5 && Math.abs(this.zsfs6infscy) <= B4.mss_in2){
						this.zsfs6injcl = "2-5%";
						if(Math.abs(this.zsfs6infscy) == B4.mss_in2){
							this.zsfs6injcl ="2%";
						}
					}else if(Math.abs(this.zsfs6infscy) > B4.mss_in2 && Math.abs(this.zsfs6infscy) <= B4.mss_in1){
						this.zsfs6injcl = "1-2%";
						if(Math.abs(this.zsfs6infscy) == B4.mss_in1){
							this.zsfs6injcl ="1%";
						}
					}else if(Math.abs(this.zsfs6infscy) >= B4.mss_in1 ){
						this.zsfs6injcl = "<1%";
					}
				}
			}
			
			//oa强弱，基础
			if(Math.abs(this.zsfs6oafscy) >= this.zsfs6oaljz){
				if(this.zsfs6oafscy > 0){
					this.zsfs6oaqrx = 1;
				}else{
					this.zsfs6oaqrx = 2;
				}
				
				if(this.zsfs6oafscy < 0){
					if(Math.abs(this.zsfs6oafscy) <= B4.oa_mss25){
						this.zsfs6oajcl = ">25%";
						if(Math.abs(this.zsfs6oafscy) == B4.oa_mss25){
							this.zsfs6oajcl ="25%";
						}
					}else if(Math.abs(this.zsfs6oafscy) > B4.oa_mss25 && Math.abs(this.zsfs6oafscy) <= B4.oa_mss10){
						this.zsfs6oajcl = "10-25%";
						if(Math.abs(this.zsfs6oafscy) == B4.oa_mss10){
							this.zsfs6oajcl ="10%";
						}
					}else if(Math.abs(this.zsfs6oafscy) > B4.oa_mss10 && Math.abs(this.zsfs6oafscy) <= B4.oa_mss5){
						this.zsfs6oajcl = "5-10%";
						if(Math.abs(this.zsfs6oafscy) == B4.oa_mss5){
							this.zsfs6oajcl ="5%";
						}
					}else if(Math.abs(this.zsfs6oafscy) > B4.oa_mss5 && Math.abs(this.zsfs6oafscy) <= B4.oa_mss2){
						this.zsfs6oajcl = "2-5%";
						if(Math.abs(this.zsfs6oafscy) == B4.oa_mss2){
							this.zsfs6oajcl ="2%";
						}
					}else if(Math.abs(this.zsfs6oafscy) > B4.oa_mss2 && Math.abs(this.zsfs6oafscy) <= B4.oa_mss1){
						this.zsfs6oajcl = "1-2%";
						if(Math.abs(this.zsfs6oafscy) == B4.oa_mss1){
							this.zsfs6oajcl ="1%";
						}
					}else if(Math.abs(this.zsfs6oafscy) >= B4.oa_mss1 ){
						this.zsfs6oajcl = "<1%";
					}
				}else{
					if(Math.abs(this.zsfs6oafscy) <= B4.mss_oa25){
						this.zsfs6oajcl = ">25%";
						if(Math.abs(this.zsfs6oafscy) == B4.mss_oa25){
							this.zsfs6oajcl ="25%";
						}
					}else if(Math.abs(this.zsfs6oafscy) > B4.mss_oa25 && Math.abs(this.zsfs6oafscy) <= B4.mss_oa10){
						this.zsfs6oajcl = "10-25%";
						if(Math.abs(this.zsfs6oafscy) == B4.mss_oa10){
							this.zsfs6oajcl ="10%";
						}
					}else if(Math.abs(this.zsfs6oafscy) > B4.mss_oa10 && Math.abs(this.zsfs6oafscy) <= B4.mss_oa5){
						this.zsfs6oajcl = "5-10%";
						if(Math.abs(this.zsfs6oafscy) == B4.mss_oa5){
							this.zsfs6oajcl ="5%";
						}
					}else if(Math.abs(this.zsfs6oafscy) > B4.mss_oa5 && Math.abs(this.zsfs6oafscy) <= B4.mss_oa2){
						this.zsfs6oajcl = "2-5%";
						if(Math.abs(this.zsfs6oafscy) == B4.mss_oa2){
							this.zsfs6oajcl ="2%";
						}
					}else if(Math.abs(this.zsfs6oafscy) > B4.mss_oa2 && Math.abs(this.zsfs6oafscy) <= B4.mss_oa1){
						this.zsfs6oajcl = "1-2%";
						if(Math.abs(this.zsfs6oafscy) == B4.mss_oa1){
							this.zsfs6oajcl ="1%";
						}
					}else if(Math.abs(this.zsfs6oafscy) >= B4.mss_oa1 ){
						this.zsfs6oajcl = "<1%";
					}
				}
			}
			
			//mark2
			//分测验水平 强项与弱项确定表2
			//5个无缺失
			this.zsfs5 = this.rvl + this.infl + this.pml + this.oal + this.bdl;
			this.zsfs5jz = change2((float)zsfs5 / 5);
			this.zsfs5fsd = com_fen_q();
			
			this.zsfs5rvfscy = change2((float)this.rvl - this.zsfs5jz);
			this.zsfs5bdfscy = change2((float)this.bdl - this.zsfs5jz);
			this.zsfs5pmfscy = change2((float)this.pml - this.zsfs5jz);
			this.zsfs5zlfscy = change2((float)this.zll - this.zsfs5jz);
			this.zsfs5oafscy = change2((float)this.oal - this.zsfs5jz);
			this.zsfs5infscy = change2((float)this.infl - this.zsfs5jz);
			if(this.ssp == 0){
				this.zsfs5rvljz = B3.rv_fsiq01;
				this.zsfs5bdljz = B3.bd_fsiq01;
				this.zsfs5pmljz = B3.pm_fsiq01;
				this.zsfs5zlljz = B3.zl_fsiq01;
				this.zsfs5oaljz = B3.oa_fsiq01;
				this.zsfs5inljz = B3.in_fsiq01;
			}
			if(this.ssp == 1){
				this.zsfs5rvljz = B3.rv_fsiq05;
				this.zsfs5bdljz = B3.bd_fsiq05;
				this.zsfs5pmljz = B3.pm_fsiq05;
				this.zsfs5zlljz = B3.zl_fsiq05;
				this.zsfs5oaljz = B3.oa_fsiq05;
				this.zsfs5inljz = B3.in_fsiq05;
			}
			if(this.ssp == 2){
				this.zsfs5rvljz = B3.rv_fsiq10;
				this.zsfs5bdljz = B3.bd_fsiq10;
				this.zsfs5pmljz = B3.pm_fsiq10;
				this.zsfs5zlljz = B3.zl_fsiq10;
				this.zsfs5oaljz = B3.oa_fsiq10;
				this.zsfs5inljz = B3.in_fsiq10;
			}
			if(this.ssp == 3){
				this.zsfs5rvljz = B3.rv_fsiq15;
				this.zsfs5bdljz = B3.bd_fsiq15;
				this.zsfs5pmljz = B3.pm_fsiq15;
				this.zsfs5zlljz = B3.zl_fsiq15;
				this.zsfs5oaljz = B3.oa_fsiq15;
				this.zsfs5inljz = B3.in_fsiq15;
			}
			
			//rv强弱，基础
			if(Math.abs(this.zsfs5rvfscy) >= this.zsfs5rvljz){
				if(this.zsfs5rvfscy > 0){
					this.zsfs5rvqrx = 1;
				}else{
					this.zsfs5rvqrx = 2;
				}
				
				if(this.zsfs5rvfscy < 0){
					if(Math.abs(this.zsfs5rvfscy) <= B4.rv_fsiq25){
						this.zsfs5rvjcl = ">25%";
						if(Math.abs(this.zsfs5rvfscy) == B4.rv_fsiq25){
							this.zsfs5rvjcl ="25%";
						}
					}else if(Math.abs(this.zsfs5rvfscy) > B4.rv_fsiq25 && Math.abs(this.zsfs5rvfscy) <= B4.rv_fsiq10){
						this.zsfs5rvjcl = "10-25%";
						if(Math.abs(this.zsfs5rvfscy) == B4.rv_fsiq10){
							this.zsfs5rvjcl ="10%";
						}
					}else if(Math.abs(this.zsfs5rvfscy) > B4.rv_fsiq10 && Math.abs(this.zsfs5rvfscy) <= B4.rv_fsiq5){
						this.zsfs5rvjcl = "5-10%";
						if(Math.abs(this.zsfs5rvfscy) == B4.rv_fsiq5){
							this.zsfs5rvjcl ="5%";
						}
					}else if(Math.abs(this.zsfs5rvfscy) > B4.rv_fsiq5 && Math.abs(this.zsfs5rvfscy) <= B4.rv_fsiq2){
						this.zsfs5rvjcl = "2-5%";
						if(Math.abs(this.zsfs5rvfscy) == B4.rv_fsiq2){
							this.zsfs5rvjcl ="2%";
						}
					}else if(Math.abs(this.zsfs5rvfscy) > B4.rv_fsiq2 && Math.abs(this.zsfs5rvfscy) <= B4.rv_fsiq1){
						this.zsfs5rvjcl = "1-2%";
						if(Math.abs(this.zsfs5rvfscy) == B4.rv_fsiq1){
							this.zsfs5rvjcl ="1%";
						}
					}else if(Math.abs(this.zsfs5rvfscy) >= B4.rv_fsiq1 ){
						this.zsfs5rvjcl = "<1%";
					}
				}else{
					if(Math.abs(this.zsfs5rvfscy) <= B4.fsiq_rv25){
						this.zsfs5rvjcl = ">25%";
						if(Math.abs(this.zsfs5rvfscy) == B4.fsiq_rv25){
							this.zsfs5rvjcl ="25%";
						}
					}else if(Math.abs(this.zsfs5rvfscy) > B4.fsiq_rv25 && Math.abs(this.zsfs5rvfscy) <= B4.fsiq_rv10){
						this.zsfs5rvjcl = "10-25%";
						if(Math.abs(this.zsfs5rvfscy) == B4.fsiq_rv10){
							this.zsfs5rvjcl ="10%";
						}
					}else if(Math.abs(this.zsfs5rvfscy) > B4.fsiq_rv10 && Math.abs(this.zsfs5rvfscy) <= B4.fsiq_rv5){
						this.zsfs5rvjcl = "5-10%";
						if(Math.abs(this.zsfs5rvfscy) == B4.fsiq_rv5){
							this.zsfs5rvjcl ="5%";
						}
					}else if(Math.abs(this.zsfs5rvfscy) > B4.fsiq_rv5 && Math.abs(this.zsfs5rvfscy) <= B4.fsiq_rv2){
						this.zsfs5rvjcl = "2-5%";
						if(Math.abs(this.zsfs5rvfscy) == B4.fsiq_rv2){
							this.zsfs5rvjcl ="2%";
						}
					}else if(Math.abs(this.zsfs5rvfscy) > B4.fsiq_rv2 && Math.abs(this.zsfs5rvfscy) <= B4.fsiq_rv1){
						this.zsfs5rvjcl = "1-2%";
						if(Math.abs(this.zsfs5rvfscy) == B4.fsiq_rv1){
							this.zsfs5rvjcl ="1%";
						}
					}else if(Math.abs(this.zsfs5rvfscy) >= B4.fsiq_rv1 ){
						this.zsfs5rvjcl = "<1%";
					}
				}
			}
			
			//bd强弱，基础
			if(Math.abs(this.zsfs5bdfscy) >= this.zsfs5bdljz){
				if(this.zsfs5bdfscy > 0){
					this.zsfs5bdqrx = 1;
				}else{
					this.zsfs5bdqrx = 2;
				}
				
				if(this.zsfs5bdfscy < 0){
					if(Math.abs(this.zsfs5bdfscy) <= B4.bd_fsiq25){
						this.zsfs5bdjcl = ">25%";
						if(Math.abs(this.zsfs5bdfscy) == B4.bd_fsiq25){
							this.zsfs5bdjcl ="25%";
						}
					}else if(Math.abs(this.zsfs5bdfscy) > B4.bd_fsiq25 && Math.abs(this.zsfs5bdfscy) <= B4.bd_fsiq10){
						this.zsfs5bdjcl = "10-25%";
						if(Math.abs(this.zsfs5bdfscy) == B4.bd_fsiq10){
							this.zsfs5bdjcl ="10%";
						}
					}else if(Math.abs(this.zsfs5bdfscy) > B4.bd_fsiq10 && Math.abs(this.zsfs5bdfscy) <= B4.bd_fsiq5){
						this.zsfs5bdjcl = "5-10%";
						if(Math.abs(this.zsfs5bdfscy) == B4.bd_fsiq25){
							this.zsfs5bdjcl ="5%";
						}
					}else if(Math.abs(this.zsfs5bdfscy) > B4.bd_fsiq5 && Math.abs(this.zsfs5bdfscy) <= B4.bd_fsiq2){
						this.zsfs5bdjcl = "2-5%";
						if(Math.abs(this.zsfs5bdfscy) == B4.bd_fsiq2){
							this.zsfs5bdjcl ="2%";
						}
					}else if(Math.abs(this.zsfs5bdfscy) > B4.bd_fsiq2 && Math.abs(this.zsfs5bdfscy) <= B4.bd_fsiq1){
						this.zsfs5bdjcl = "1-2%";
						if(Math.abs(this.zsfs5bdfscy) == B4.bd_fsiq1){
							this.zsfs5bdjcl ="1%";
						}
					}else if(Math.abs(this.zsfs6bdfscy) >= B4.bd_fsiq1 ){
						this.zsfs5bdjcl = "<1%";
					}
				}else{
					if(Math.abs(this.zsfs5bdfscy) <= B4.fsiq_bd25){
						this.zsfs5bdjcl = ">25%";
						if(Math.abs(this.zsfs5bdfscy) == B4.fsiq_bd25){
							this.zsfs5bdjcl ="25%";
						}
					}else if(Math.abs(this.zsfs5bdfscy) > B4.fsiq_bd25 && Math.abs(this.zsfs5bdfscy) <= B4.fsiq_bd10){
						this.zsfs5bdjcl = "10-25%";
						if(Math.abs(this.zsfs5bdfscy) == B4.fsiq_bd10){
							this.zsfs5bdjcl ="10%";
						}
					}else if(Math.abs(this.zsfs5bdfscy) > B4.fsiq_bd10 && Math.abs(this.zsfs5bdfscy) <= B4.fsiq_bd5){
						this.zsfs5bdjcl = "5-10%";
						if(Math.abs(this.zsfs5bdfscy) == B4.fsiq_bd25){
							this.zsfs5bdjcl ="5%";
						}
					}else if(Math.abs(this.zsfs5bdfscy) > B4.fsiq_bd5 && Math.abs(this.zsfs5bdfscy) <= B4.fsiq_bd2){
						this.zsfs5bdjcl = "2-5%";
						if(Math.abs(this.zsfs5bdfscy) == B4.fsiq_bd2){
							this.zsfs5bdjcl ="2%";
						}
					}else if(Math.abs(this.zsfs5bdfscy) > B4.fsiq_bd2 && Math.abs(this.zsfs5bdfscy) <= B4.fsiq_bd1){
						this.zsfs5bdjcl = "1-2%";
						if(Math.abs(this.zsfs5bdfscy) == B4.fsiq_bd1){
							this.zsfs5bdjcl ="1%";
						}
					}else if(Math.abs(this.zsfs6bdfscy) >= B4.fsiq_bd1 ){
						this.zsfs5bdjcl = "<1%";
					}
				}
			}
			
			//pm强弱，基础
			if(Math.abs(this.zsfs5pmfscy) >= this.zsfs5pmljz){
				if(this.zsfs5pmfscy > 0){
					this.zsfs5pmqrx = 1;
				}else{
					this.zsfs5pmqrx = 2;
				}
				
				if(this.zsfs5pmfscy < 0){
					if(Math.abs(this.zsfs5pmfscy) <= B4.pm_fsiq25){
						this.zsfs5pmjcl = ">25%";
						if(Math.abs(this.zsfs5pmfscy) == B4.pm_fsiq25){
							this.zsfs5pmjcl ="25%";
						}
					}else if(Math.abs(this.zsfs5pmfscy) > B4.pm_fsiq25 && Math.abs(this.zsfs5pmfscy) <= B4.pm_fsiq10){
						this.zsfs5pmjcl = "10-25%";
						if(Math.abs(this.zsfs5pmfscy) == B4.pm_fsiq10){
							this.zsfs5pmjcl ="10%";
						}
					}else if(Math.abs(this.zsfs5pmfscy) > B4.pm_fsiq10 && Math.abs(this.zsfs5pmfscy) <= B4.pm_fsiq5){
						this.zsfs5pmjcl = "5-10%";
						if(Math.abs(this.zsfs5pmfscy) == B4.pm_fsiq5){
							this.zsfs5pmjcl ="5%";
						}
					}else if(Math.abs(this.zsfs5pmfscy) > B4.pm_fsiq5 && Math.abs(this.zsfs5pmfscy) <= B4.pm_fsiq2){
						this.zsfs5pmjcl = "2-5%";
						if(Math.abs(this.zsfs5pmfscy) == B4.pm_fsiq2){
							this.zsfs5pmjcl ="2%";
						}
					}else if(Math.abs(this.zsfs5pmfscy) > B4.pm_fsiq2 && Math.abs(this.zsfs5pmfscy) <= B4.pm_fsiq1){
						this.zsfs5pmjcl = "1-2%";
						if(Math.abs(this.zsfs5pmfscy) == B4.pm_fsiq1){
							this.zsfs5pmjcl ="1%";
						}
					}else if(Math.abs(this.zsfs5pmfscy) >= B4.pm_fsiq1 ){
						this.zsfs5pmjcl = "<1%";
					}
				}else{
					if(Math.abs(this.zsfs5pmfscy) <= B4.fsiq_pm25){
						this.zsfs5pmjcl = ">25%";
						if(Math.abs(this.zsfs5pmfscy) == B4.fsiq_pm25){
							this.zsfs5pmjcl ="25%";
						}
					}else if(Math.abs(this.zsfs5pmfscy) > B4.fsiq_pm25 && Math.abs(this.zsfs5pmfscy) <= B4.fsiq_pm10){
						this.zsfs5pmjcl = "10-25%";
						if(Math.abs(this.zsfs5pmfscy) == B4.fsiq_pm10){
							this.zsfs5pmjcl ="10%";
						}
					}else if(Math.abs(this.zsfs5pmfscy) > B4.fsiq_pm10 && Math.abs(this.zsfs5pmfscy) <= B4.fsiq_pm5){
						this.zsfs5pmjcl = "5-10%";
						if(Math.abs(this.zsfs5pmfscy) == B4.fsiq_pm5){
							this.zsfs5pmjcl ="5%";
						}
					}else if(Math.abs(this.zsfs5pmfscy) > B4.fsiq_pm5 && Math.abs(this.zsfs5pmfscy) <= B4.fsiq_pm2){
						this.zsfs5pmjcl = "2-5%";
						if(Math.abs(this.zsfs5pmfscy) == B4.fsiq_pm2){
							this.zsfs5pmjcl ="2%";
						}
					}else if(Math.abs(this.zsfs5pmfscy) > B4.fsiq_pm2 && Math.abs(this.zsfs5pmfscy) <= B4.fsiq_pm1){
						this.zsfs5pmjcl = "1-2%";
						if(Math.abs(this.zsfs5pmfscy) == B4.fsiq_pm1){
							this.zsfs5pmjcl ="1%";
						}
					}else if(Math.abs(this.zsfs5pmfscy) >= B4.fsiq_pm1 ){
						this.zsfs5pmjcl = "<1%";
					}
				}
			}
			
			//zl强弱，基础
			if(Math.abs(this.zsfs5zlfscy) >= this.zsfs5zlljz){
				if(this.zsfs5zlfscy > 0){
					this.zsfs5zlqrx = 1;
				}else{
					this.zsfs5zlqrx = 2;
				}
				
				if(this.zsfs5zlfscy < 0){
					if(Math.abs(this.zsfs5zlfscy) <= B4.zl_fsiq25){
						this.zsfs5zljcl = ">25%";
						if(Math.abs(this.zsfs5zlfscy) == B4.zl_fsiq25){
							this.zsfs5zljcl ="25%";
						}
					}else if(Math.abs(this.zsfs5zlfscy) > B4.zl_fsiq25 && Math.abs(this.zsfs5zlfscy) <= B4.zl_fsiq10){
						this.zsfs5zljcl = "10-25%";
						if(Math.abs(this.zsfs5zlfscy) == B4.zl_fsiq10){
							this.zsfs5zljcl ="10%";
						}
					}else if(Math.abs(this.zsfs5zlfscy) > B4.zl_fsiq10 && Math.abs(this.zsfs5zlfscy) <= B4.zl_fsiq5){
						this.zsfs5zljcl = "5-10%";
						if(Math.abs(this.zsfs5zlfscy) == B4.zl_fsiq5){
							this.zsfs5zljcl ="5%";
						}
					}else if(Math.abs(this.zsfs5zlfscy) > B4.zl_fsiq5 && Math.abs(this.zsfs5zlfscy) <= B4.zl_fsiq2){
						this.zsfs5zljcl = "2-5%";
						if(Math.abs(this.zsfs5zlfscy) == B4.zl_fsiq2){
							this.zsfs5zljcl ="2%";
						}
					}else if(Math.abs(this.zsfs5zlfscy) > B4.zl_fsiq2 && Math.abs(this.zsfs5zlfscy) <= B4.zl_fsiq1){
						this.zsfs5zljcl = "1-2%";
						if(Math.abs(this.zsfs5zlfscy) == B4.zl_fsiq1){
							this.zsfs5zljcl ="1%";
						}
					}else if(Math.abs(this.zsfs5zlfscy) >= B4.zl_fsiq1 ){
						this.zsfs5zljcl = "<1%";
					}
				}else{
					if(Math.abs(this.zsfs5zlfscy) <= B4.fsiq_zl25){
						this.zsfs5zljcl = ">25%";
						if(Math.abs(this.zsfs5zlfscy) == B4.fsiq_zl25){
							this.zsfs5zljcl ="25%";
						}
					}else if(Math.abs(this.zsfs5zlfscy) > B4.fsiq_zl25 && Math.abs(this.zsfs5zlfscy) <= B4.fsiq_zl10){
						this.zsfs5zljcl = "10-25%";
						if(Math.abs(this.zsfs5zlfscy) == B4.fsiq_zl10){
							this.zsfs5zljcl ="10%";
						}
					}else if(Math.abs(this.zsfs5zlfscy) > B4.fsiq_zl10 && Math.abs(this.zsfs5zlfscy) <= B4.fsiq_zl5){
						this.zsfs5zljcl = "5-10%";
						if(Math.abs(this.zsfs5zlfscy) == B4.fsiq_zl5){
							this.zsfs5zljcl ="5%";
						}
					}else if(Math.abs(this.zsfs5zlfscy) > B4.fsiq_zl5 && Math.abs(this.zsfs5zlfscy) <= B4.fsiq_zl2){
						this.zsfs5zljcl = "2-5%";
						if(Math.abs(this.zsfs5zlfscy) == B4.fsiq_zl2){
							this.zsfs5zljcl ="2%";
						}
					}else if(Math.abs(this.zsfs5zlfscy) > B4.fsiq_zl2 && Math.abs(this.zsfs5zlfscy) <= B4.fsiq_zl1){
						this.zsfs5zljcl = "1-2%";
						if(Math.abs(this.zsfs5zlfscy) == B4.fsiq_zl1){
							this.zsfs5zljcl ="1%";
						}
					}else if(Math.abs(this.zsfs5zlfscy) >= B4.fsiq_zl1 ){
						this.zsfs5zljcl = "<1%";
					}
				}
			}
			
			//in强弱，基础
			if(Math.abs(this.zsfs5infscy) >= this.zsfs6inljz){
				if(this.zsfs5infscy > 0){
					this.zsfs5inqrx = 1;
				}else{
					this.zsfs5inqrx = 2;
				}
				
				if(this.zsfs5infscy < 0){
					if(Math.abs(this.zsfs5infscy) <= B4.in_fsiq25){
						this.zsfs5injcl = ">25%";
						if(Math.abs(this.zsfs5infscy) == B4.in_fsiq25){
							this.zsfs5injcl ="25%";
						}
					}else if(Math.abs(this.zsfs5infscy) > B4.in_fsiq25 && Math.abs(this.zsfs5infscy) <= B4.in_fsiq10){
						this.zsfs5injcl = "10-25%";
						if(Math.abs(this.zsfs5infscy) == B4.in_fsiq10){
							this.zsfs5injcl ="10%";
						}
					}else if(Math.abs(this.zsfs5infscy) > B4.in_fsiq10 && Math.abs(this.zsfs5infscy) <= B4.in_fsiq5){
						this.zsfs5injcl = "5-10%";
						if(Math.abs(this.zsfs5infscy) == B4.in_fsiq5){
							this.zsfs5injcl ="5%";
						}
					}else if(Math.abs(this.zsfs5infscy) > B4.in_fsiq5 && Math.abs(this.zsfs5infscy) <= B4.in_fsiq2){
						this.zsfs5injcl = "2-5%";
						if(Math.abs(this.zsfs5infscy) == B4.in_fsiq2){
							this.zsfs5injcl ="2%";
						}
					}else if(Math.abs(this.zsfs5infscy) > B4.in_fsiq2 && Math.abs(this.zsfs5infscy) <= B4.in_fsiq1){
						this.zsfs5injcl = "1-2%";
						if(Math.abs(this.zsfs5infscy) == B4.in_fsiq1){
							this.zsfs5injcl ="1%";
						}
					}else if(Math.abs(this.zsfs5infscy) >= B4.in_fsiq1 ){
						this.zsfs5injcl = "<1%";
					}
				}else{
					if(Math.abs(this.zsfs5infscy) <= B4.fsiq_in25){
						this.zsfs5injcl = ">25%";
						if(Math.abs(this.zsfs5infscy) == B4.fsiq_in25){
							this.zsfs5injcl ="25%";
						}
					}else if(Math.abs(this.zsfs5infscy) > B4.fsiq_in25 && Math.abs(this.zsfs5infscy) <= B4.fsiq_in10){
						this.zsfs5injcl = "10-25%";
						if(Math.abs(this.zsfs5infscy) == B4.fsiq_in10){
							this.zsfs5injcl ="10%";
						}
					}else if(Math.abs(this.zsfs5infscy) > B4.fsiq_in10 && Math.abs(this.zsfs5infscy) <= B4.fsiq_in5){
						this.zsfs5injcl = "5-10%";
						if(Math.abs(this.zsfs5infscy) == B4.fsiq_in5){
							this.zsfs5injcl ="5%";
						}
					}else if(Math.abs(this.zsfs5infscy) > B4.fsiq_in5 && Math.abs(this.zsfs5infscy) <= B4.fsiq_in2){
						this.zsfs5injcl = "2-5%";
						if(Math.abs(this.zsfs5infscy) == B4.fsiq_in2){
							this.zsfs5injcl ="2%";
						}
					}else if(Math.abs(this.zsfs5infscy) > B4.fsiq_in2 && Math.abs(this.zsfs5infscy) <= B4.fsiq_in1){
						this.zsfs5injcl = "1-2%";
						if(Math.abs(this.zsfs5infscy) == B4.fsiq_in1){
							this.zsfs5injcl ="1%";
						}
					}else if(Math.abs(this.zsfs5infscy) >= B4.fsiq_in1 ){
						this.zsfs5injcl = "<1%";
					}
				}
			}
			
			//oa强弱，基础
			if(Math.abs(this.zsfs5oafscy) >= this.zsfs5oaljz){
				if(this.zsfs5oafscy > 0){
					this.zsfs5oaqrx = 1;
				}else{
					this.zsfs5oaqrx = 2;
				}
				
				if(this.zsfs5oafscy < 0){
					if(Math.abs(this.zsfs5oafscy) <= B4.oa_fsiq25){
						this.zsfs5oajcl = ">25%";
						if(Math.abs(this.zsfs5oafscy) == B4.oa_fsiq25){
							this.zsfs5oajcl ="25%";
						}
					}else if(Math.abs(this.zsfs5oafscy) > B4.oa_fsiq25 && Math.abs(this.zsfs5oafscy) <= B4.oa_fsiq10){
						this.zsfs5oajcl = "10-25%";
						if(Math.abs(this.zsfs5oafscy) == B4.oa_fsiq10){
							this.zsfs5oajcl ="10%";
						}
					}else if(Math.abs(this.zsfs5oafscy) > B4.oa_fsiq10 && Math.abs(this.zsfs5oafscy) <= B4.oa_fsiq5){
						this.zsfs5oajcl = "5-10%";
						if(Math.abs(this.zsfs5oafscy) == B4.oa_fsiq5){
							this.zsfs5oajcl ="5%";
						}
					}else if(Math.abs(this.zsfs5oafscy) > B4.oa_fsiq5 && Math.abs(this.zsfs5oafscy) <= B4.oa_fsiq2){
						this.zsfs5oajcl = "2-5%";
						if(Math.abs(this.zsfs5oafscy) == B4.oa_fsiq2){
							this.zsfs5oajcl ="2%";
						}
					}else if(Math.abs(this.zsfs5oafscy) > B4.oa_fsiq2 && Math.abs(this.zsfs5oafscy) <= B4.oa_fsiq1){
						this.zsfs5oajcl = "1-2%";
						if(Math.abs(this.zsfs5oafscy) == B4.oa_fsiq1){
							this.zsfs5oajcl ="1%";
						}
					}else if(Math.abs(this.zsfs5oafscy) >= B4.oa_fsiq1 ){
						this.zsfs5oajcl = "<1%";
					}
				}else{
					if(Math.abs(this.zsfs5oafscy) <= B4.fsiq_oa25){
						this.zsfs5oajcl = ">25%";
						if(Math.abs(this.zsfs5oafscy) == B4.fsiq_oa25){
							this.zsfs5oajcl ="25%";
						}
					}else if(Math.abs(this.zsfs5oafscy) > B4.fsiq_oa25 && Math.abs(this.zsfs5oafscy) <= B4.fsiq_oa10){
						this.zsfs5oajcl = "10-25%";
						if(Math.abs(this.zsfs5oafscy) == B4.fsiq_oa10){
							this.zsfs5oajcl ="10%";
						}
					}else if(Math.abs(this.zsfs5oafscy) > B4.fsiq_oa10 && Math.abs(this.zsfs5oafscy) <= B4.fsiq_oa5){
						this.zsfs5oajcl = "5-10%";
						if(Math.abs(this.zsfs5oafscy) == B4.fsiq_oa5){
							this.zsfs5oajcl ="5%";
						}
					}else if(Math.abs(this.zsfs5oafscy) > B4.fsiq_oa5 && Math.abs(this.zsfs5oafscy) <= B4.fsiq_oa2){
						this.zsfs5oajcl = "2-5%";
						if(Math.abs(this.zsfs5oafscy) == B4.fsiq_oa2){
							this.zsfs5oajcl ="2%";
						}
					}else if(Math.abs(this.zsfs5oafscy) > B4.fsiq_oa2 && Math.abs(this.zsfs5oafscy) <= B4.fsiq_oa1){
						this.zsfs5oajcl = "1-2%";
						if(Math.abs(this.zsfs5oafscy) == B4.fsiq_oa1){
							this.zsfs5oajcl ="1%";
						}
					}else if(Math.abs(this.zsfs5oafscy) >= B4.fsiq_oa1 ){
						this.zsfs5oajcl = "<1%";
					}
				}
			}
			//mark2 end;
		}
		//mark1
		//分测验水平 强项与弱项确定表
		//6个中1个缺失
		if(count_zsfs()>0 && count_zsfs() < 2 && this.fsiq !=-1){
			this.zsfs6 = -1;
			this.zsfs6fsd = -1;
			this.zsfs6jz = -1f;
			this.zsfs6rvfscy = -1f;
			this.zsfs6bdfscy = -1f;
			this.zsfs6pmfscy = -1f;
			this.zsfs6zlfscy = -1f;
			this.zsfs6oafscy = -1f;
			this.zsfs6infscy = -1f;
			this.zsfs6rvljz = -1f;
			this.zsfs6bdljz = -1f;
			this.zsfs6pmljz = -1f;
			this.zsfs6zlljz = -1f;
			this.zsfs6oaljz = -1f;
			this.zsfs6inljz = -1f;
			
			
			//mark2
			//分测验水平 强项与弱项确定表2
			//5个有缺失
			this.zsfs5 = this.fsiq;
			this.zsfs5jz = change2((float)zsfs5 / 5);
			this.zsfs5fsd = com_fen_q();
			
			if(this.rv != -1){
				this.zsfs5rvfscy = change2((float)this.rvl - this.zsfs5jz);
			}
			if(this.bd != -1){
				this.zsfs5bdfscy = change2((float)this.bdl - this.zsfs5jz);
			}
			if(this.pm != -1){
				this.zsfs5pmfscy = change2((float)this.pml - this.zsfs5jz);
			}
			if(this.zl != -1){
				this.zsfs5zlfscy = change2((float)this.zll - this.zsfs5jz);
			}
			if(this.oa != -1){
				this.zsfs5oafscy = change2((float)this.oal - this.zsfs5jz);
			}
			if(this.inf != -1){
				this.zsfs5infscy = change2((float)this.infl - this.zsfs5jz);
			}
			if(this.ssp == 0){
				if(this.rv != -1){
					this.zsfs5rvljz = B3.rv_fsiq01;
				}
				if(this.bd != -1){
					this.zsfs5bdljz = B3.bd_fsiq01;
				}
				if(this.pm != -1){
					this.zsfs5pmljz = B3.pm_fsiq01;
				}
				if(this.zl != -1){
					this.zsfs5zlljz = B3.zl_fsiq01;
				}
				if(this.oa != -1){
					this.zsfs5oaljz = B3.oa_fsiq01;
				}
				if(this.inf != -1){
					this.zsfs5inljz = B3.in_fsiq01;
				}
			}
			if(this.ssp == 1){
				if(this.rv != -1){
					this.zsfs5rvljz = B3.rv_fsiq05;
				}
				if(this.bd != -1){
					this.zsfs5bdljz = B3.bd_fsiq05;
				}
				if(this.pm != -1){
					this.zsfs5pmljz = B3.pm_fsiq05;
				}
				if(this.zl != -1){
					this.zsfs5zlljz = B3.zl_fsiq05;
				}
				if(this.oa != -1){
					this.zsfs5oaljz = B3.oa_fsiq05;
				}
				if(this.inf != -1){
					this.zsfs5inljz = B3.in_fsiq05;
				}
			}
			if(this.ssp == 2){
				if(this.rv != -1){
					this.zsfs5rvljz = B3.rv_fsiq10;
				}
				if(this.bd != -1){
					this.zsfs5bdljz = B3.bd_fsiq10;
				}
				if(this.pm != -1){
					this.zsfs5pmljz = B3.pm_fsiq10;
				}
				if(this.zl != -1){
					this.zsfs5zlljz = B3.zl_fsiq10;
				}
				if(this.oa != -1){
					this.zsfs5oaljz = B3.oa_fsiq10;
				}
				if(this.inf != -1){
					this.zsfs5inljz = B3.in_fsiq10;
				}
			}
			if(this.ssp == 3){
				if(this.rv != -1){
					this.zsfs5rvljz = B3.rv_fsiq15;
				}
				if(this.bd != -1){
					this.zsfs5bdljz = B3.bd_fsiq15;
				}
				if(this.pm != -1){
					this.zsfs5pmljz = B3.pm_fsiq15;
				}
				if(this.zl != -1){
					this.zsfs5zlljz = B3.zl_fsiq15;
				}
				if(this.oa != -1){
					this.zsfs5oaljz = B3.oa_fsiq15;
				}
				if(this.inf != -1){
					this.zsfs5inljz = B3.in_fsiq15;
				}
			}
			
			//rv强弱，基础
			if(this.rv != -1){
				if(Math.abs(this.zsfs5rvfscy) >= this.zsfs5rvljz){
					if(this.zsfs5rvfscy > 0){
						this.zsfs5rvqrx = 1;
					}else{
						this.zsfs5rvqrx = 2;
					}
					
					if(this.zsfs5rvfscy < 0){
						if(Math.abs(this.zsfs5rvfscy) <= B4.rv_fsiq25){
							this.zsfs5rvjcl = ">25%";
							if(Math.abs(this.zsfs5rvfscy) == B4.rv_fsiq25){
								this.zsfs5rvjcl ="25%";
							}
						}else if(Math.abs(this.zsfs5rvfscy) > B4.rv_fsiq25 && Math.abs(this.zsfs5rvfscy) <= B4.rv_fsiq10){
							this.zsfs5rvjcl = "10-25%";
							if(Math.abs(this.zsfs5rvfscy) == B4.rv_fsiq10){
								this.zsfs5rvjcl ="10%";
							}
						}else if(Math.abs(this.zsfs5rvfscy) > B4.rv_fsiq10 && Math.abs(this.zsfs5rvfscy) <= B4.rv_fsiq5){
							this.zsfs5rvjcl = "5-10%";
							if(Math.abs(this.zsfs5rvfscy) == B4.rv_fsiq5){
								this.zsfs5rvjcl ="5%";
							}
						}else if(Math.abs(this.zsfs5rvfscy) > B4.rv_fsiq5 && Math.abs(this.zsfs5rvfscy) <= B4.rv_fsiq2){
							this.zsfs5rvjcl = "2-5%";
							if(Math.abs(this.zsfs5rvfscy) == B4.rv_fsiq2){
								this.zsfs5rvjcl ="2%";
							}
						}else if(Math.abs(this.zsfs5rvfscy) > B4.rv_fsiq2 && Math.abs(this.zsfs5rvfscy) <= B4.rv_fsiq1){
							this.zsfs5rvjcl = "1-2%";
							if(Math.abs(this.zsfs5rvfscy) == B4.rv_fsiq1){
								this.zsfs5rvjcl ="1%";
							}
						}else if(Math.abs(this.zsfs5rvfscy) >= B4.rv_fsiq1 ){
							this.zsfs5rvjcl = "<1%";
						}
					}else{
						if(Math.abs(this.zsfs5rvfscy) <= B4.fsiq_rv25){
							this.zsfs5rvjcl = ">25%";
							if(Math.abs(this.zsfs5rvfscy) == B4.fsiq_rv25){
								this.zsfs5rvjcl ="25%";
							}
						}else if(Math.abs(this.zsfs5rvfscy) > B4.fsiq_rv25 && Math.abs(this.zsfs5rvfscy) <= B4.fsiq_rv10){
							this.zsfs5rvjcl = "10-25%";
							if(Math.abs(this.zsfs5rvfscy) == B4.fsiq_rv10){
								this.zsfs5rvjcl ="10%";
							}
						}else if(Math.abs(this.zsfs5rvfscy) > B4.fsiq_rv10 && Math.abs(this.zsfs5rvfscy) <= B4.fsiq_rv5){
							this.zsfs5rvjcl = "5-10%";
							if(Math.abs(this.zsfs5rvfscy) == B4.fsiq_rv5){
								this.zsfs5rvjcl ="5%";
							}
						}else if(Math.abs(this.zsfs5rvfscy) > B4.fsiq_rv5 && Math.abs(this.zsfs5rvfscy) <= B4.fsiq_rv2){
							this.zsfs5rvjcl = "2-5%";
							if(Math.abs(this.zsfs5rvfscy) == B4.fsiq_rv2){
								this.zsfs5rvjcl ="2%";
							}
						}else if(Math.abs(this.zsfs5rvfscy) > B4.fsiq_rv2 && Math.abs(this.zsfs5rvfscy) <= B4.fsiq_rv1){
							this.zsfs5rvjcl = "1-2%";
							if(Math.abs(this.zsfs5rvfscy) == B4.fsiq_rv1){
								this.zsfs5rvjcl ="1%";
							}
						}else if(Math.abs(this.zsfs5rvfscy) >= B4.fsiq_rv1 ){
							this.zsfs5rvjcl = "<1%";
						}
					}
				}
			}
			if(this.bd != -1){
				//bd强弱，基础
				if(Math.abs(this.zsfs5bdfscy) >= this.zsfs5bdljz){
					if(this.zsfs5bdfscy > 0){
						this.zsfs5bdqrx = 1;
					}else{
						this.zsfs5bdqrx = 2;
					}
					
					if(this.zsfs5bdfscy < 0){
						if(Math.abs(this.zsfs5bdfscy) <= B4.bd_fsiq25){
							this.zsfs5bdjcl = ">25%";
							if(Math.abs(this.zsfs5bdfscy) == B4.bd_fsiq25){
								this.zsfs5bdjcl ="25%";
							}
						}else if(Math.abs(this.zsfs5bdfscy) > B4.bd_fsiq25 && Math.abs(this.zsfs5bdfscy) <= B4.bd_fsiq10){
							this.zsfs5bdjcl = "10-25%";
							if(Math.abs(this.zsfs5bdfscy) == B4.bd_fsiq10){
								this.zsfs5bdjcl ="10%";
							}
						}else if(Math.abs(this.zsfs5bdfscy) > B4.bd_fsiq10 && Math.abs(this.zsfs5bdfscy) <= B4.bd_fsiq5){
							this.zsfs5bdjcl = "5-10%";
							if(Math.abs(this.zsfs5bdfscy) == B4.bd_fsiq5){
								this.zsfs5bdjcl ="5%";
							}
						}else if(Math.abs(this.zsfs5bdfscy) > B4.bd_fsiq5 && Math.abs(this.zsfs5bdfscy) <= B4.bd_fsiq2){
							this.zsfs5bdjcl = "2-5%";
							if(Math.abs(this.zsfs5bdfscy) == B4.bd_fsiq2){
								this.zsfs5bdjcl ="2%";
							}
						}else if(Math.abs(this.zsfs5bdfscy) > B4.bd_fsiq2 && Math.abs(this.zsfs5bdfscy) <= B4.bd_fsiq1){
							this.zsfs5bdjcl = "1-2%";
							if(Math.abs(this.zsfs5bdfscy) == B4.bd_fsiq1){
								this.zsfs5bdjcl ="1%";
							}
						}else if(Math.abs(this.zsfs6bdfscy) >= B4.bd_fsiq1 ){
							this.zsfs5bdjcl = "<1%";
						}
					}else{
						if(Math.abs(this.zsfs5bdfscy) <= B4.fsiq_bd25){
							this.zsfs5bdjcl = ">25%";
							if(Math.abs(this.zsfs5bdfscy) == B4.fsiq_bd25){
								this.zsfs5bdjcl ="25%";
							}
						}else if(Math.abs(this.zsfs5bdfscy) > B4.fsiq_bd25 && Math.abs(this.zsfs5bdfscy) <= B4.fsiq_bd10){
							this.zsfs5bdjcl = "10-25%";
							if(Math.abs(this.zsfs5bdfscy) == B4.fsiq_bd10){
								this.zsfs5bdjcl ="10%";
							}
						}else if(Math.abs(this.zsfs5bdfscy) > B4.fsiq_bd10 && Math.abs(this.zsfs5bdfscy) <= B4.fsiq_bd5){
							this.zsfs5bdjcl = "5-10%";
							if(Math.abs(this.zsfs5bdfscy) == B4.fsiq_bd5){
								this.zsfs5bdjcl ="5%";
							}
						}else if(Math.abs(this.zsfs5bdfscy) > B4.fsiq_bd5 && Math.abs(this.zsfs5bdfscy) <= B4.fsiq_bd2){
							this.zsfs5bdjcl = "2-5%";
							if(Math.abs(this.zsfs5bdfscy) == B4.fsiq_bd2){
								this.zsfs5bdjcl ="2%";
							}
						}else if(Math.abs(this.zsfs5bdfscy) > B4.fsiq_bd2 && Math.abs(this.zsfs5bdfscy) <= B4.fsiq_bd1){
							this.zsfs5bdjcl = "1-2%";
							if(Math.abs(this.zsfs5bdfscy) == B4.fsiq_bd1){
								this.zsfs5bdjcl ="1%";
							}
						}else if(Math.abs(this.zsfs6bdfscy) >= B4.fsiq_bd1 ){
							this.zsfs5bdjcl = "<1%";
						}
					}
				}
			}
			if(this.pm != -1){
				//pm强弱，基础
				if(Math.abs(this.zsfs5pmfscy) >= this.zsfs5pmljz){
					if(this.zsfs5pmfscy > 0){
						this.zsfs5pmqrx = 1;
					}else{
						this.zsfs5pmqrx = 2;
					}
					
					if(this.zsfs5pmfscy < 0 ){
						if(Math.abs(this.zsfs5pmfscy) <= B4.pm_fsiq25){
							this.zsfs5pmjcl = ">25%";
							if(Math.abs(this.zsfs5pmfscy) == B4.pm_fsiq25){
								this.zsfs5pmjcl ="25%";
							}
						}else if(Math.abs(this.zsfs5pmfscy) > B4.pm_fsiq25 && Math.abs(this.zsfs5pmfscy) <= B4.pm_fsiq10){
							this.zsfs5pmjcl = "10-25%";
							if(Math.abs(this.zsfs5pmfscy) == B4.pm_fsiq10){
								this.zsfs5pmjcl ="10%";
							}
						}else if(Math.abs(this.zsfs5pmfscy) > B4.pm_fsiq10 && Math.abs(this.zsfs5pmfscy) <= B4.pm_fsiq5){
							this.zsfs5pmjcl = "5-10%";
							if(Math.abs(this.zsfs5pmfscy) == B4.pm_fsiq5){
								this.zsfs5pmjcl ="5%";
							}
						}else if(Math.abs(this.zsfs5pmfscy) > B4.pm_fsiq5 && Math.abs(this.zsfs5pmfscy) <= B4.pm_fsiq2){
							this.zsfs5pmjcl = "2-5%";
							if(Math.abs(this.zsfs5pmfscy) == B4.pm_fsiq2){
								this.zsfs5pmjcl ="2%";
							}
						}else if(Math.abs(this.zsfs5pmfscy) > B4.pm_fsiq2 && Math.abs(this.zsfs5pmfscy) <= B4.pm_fsiq1){
							this.zsfs5pmjcl = "1-2%";
							if(Math.abs(this.zsfs5pmfscy) == B4.pm_fsiq1){
								this.zsfs5pmjcl ="1%";
							}
						}else if(Math.abs(this.zsfs5pmfscy) >= B4.pm_fsiq1 ){
							this.zsfs5pmjcl = "<1%";
						}
					}else{
						if(Math.abs(this.zsfs5pmfscy) <= B4.fsiq_pm25){
							this.zsfs5pmjcl = ">25%";
							if(Math.abs(this.zsfs5pmfscy) == B4.fsiq_pm25){
								this.zsfs5pmjcl ="25%";
							}
						}else if(Math.abs(this.zsfs5pmfscy) > B4.fsiq_pm25 && Math.abs(this.zsfs5pmfscy) <= B4.fsiq_pm10){
							this.zsfs5pmjcl = "10-25%";
							if(Math.abs(this.zsfs5pmfscy) == B4.fsiq_pm10){
								this.zsfs5pmjcl ="10%";
							}
						}else if(Math.abs(this.zsfs5pmfscy) > B4.fsiq_pm10 && Math.abs(this.zsfs5pmfscy) <= B4.fsiq_pm5){
							this.zsfs5pmjcl = "5-10%";
							if(Math.abs(this.zsfs5pmfscy) == B4.fsiq_pm5){
								this.zsfs5pmjcl ="5%";
							}
						}else if(Math.abs(this.zsfs5pmfscy) > B4.fsiq_pm5 && Math.abs(this.zsfs5pmfscy) <= B4.fsiq_pm2){
							this.zsfs5pmjcl = "2-5%";
							if(Math.abs(this.zsfs5pmfscy) == B4.fsiq_pm2){
								this.zsfs5pmjcl ="2%";
							}
						}else if(Math.abs(this.zsfs5pmfscy) > B4.fsiq_pm2 && Math.abs(this.zsfs5pmfscy) <= B4.fsiq_pm1){
							this.zsfs5pmjcl = "1-2%";
							if(Math.abs(this.zsfs5pmfscy) == B4.fsiq_pm1){
								this.zsfs5pmjcl ="1%";
							}
						}else if(Math.abs(this.zsfs5pmfscy) >= B4.fsiq_pm1 ){
							this.zsfs5pmjcl = "<1%";
						}
					}
				}
			}
			if(this.zl != -1){
				//zl强弱，基础
				if(Math.abs(this.zsfs5zlfscy) >= this.zsfs5zlljz){
					if(this.zsfs5zlfscy > 0){
						this.zsfs5zlqrx = 1;
					}else{
						this.zsfs5zlqrx = 2;
					}
					
					if(this.zsfs5zlfscy < 0){
						if(Math.abs(this.zsfs5zlfscy) <= B4.zl_fsiq25){
							this.zsfs5zljcl = ">25%";
							if(Math.abs(this.zsfs5zlfscy) == B4.zl_fsiq25){
								this.zsfs5zljcl ="25%";
							}
						}else if(Math.abs(this.zsfs5zlfscy) > B4.zl_fsiq25 && Math.abs(this.zsfs5zlfscy) <= B4.zl_fsiq10){
							this.zsfs5zljcl = "10-25%";
							if(Math.abs(this.zsfs5zlfscy) == B4.zl_fsiq10){
								this.zsfs5zljcl ="10%";
							}
						}else if(Math.abs(this.zsfs5zlfscy) > B4.zl_fsiq10 && Math.abs(this.zsfs5zlfscy) <= B4.zl_fsiq5){
							this.zsfs5zljcl = "5-10%";
							if(Math.abs(this.zsfs5zlfscy) == B4.zl_fsiq5){
								this.zsfs5zljcl ="5%";
							}
						}else if(Math.abs(this.zsfs5zlfscy) > B4.zl_fsiq5 && Math.abs(this.zsfs5zlfscy) <= B4.zl_fsiq2){
							this.zsfs5zljcl = "2-5%";
							if(Math.abs(this.zsfs5zlfscy) == B4.zl_fsiq2){
								this.zsfs5zljcl ="2%";
							}
						}else if(Math.abs(this.zsfs5zlfscy) > B4.zl_fsiq2 && Math.abs(this.zsfs5zlfscy) <= B4.zl_fsiq1){
							this.zsfs5zljcl = "1-2%";
							if(Math.abs(this.zsfs5zlfscy) == B4.zl_fsiq1){
								this.zsfs5zljcl ="1%";
							}
						}else if(Math.abs(this.zsfs5zlfscy) >= B4.zl_fsiq1 ){
							this.zsfs5zljcl = "<1%";
						}
					}else{
						if(Math.abs(this.zsfs5zlfscy) <= B4.fsiq_zl25){
							this.zsfs5zljcl = ">25%";
							if(Math.abs(this.zsfs5zlfscy) == B4.fsiq_zl25){
								this.zsfs5zljcl ="25%";
							}
						}else if(Math.abs(this.zsfs5zlfscy) > B4.fsiq_zl25 && Math.abs(this.zsfs5zlfscy) <= B4.fsiq_zl10){
							this.zsfs5zljcl = "10-25%";
							if(Math.abs(this.zsfs5zlfscy) == B4.fsiq_zl10){
								this.zsfs5zljcl ="10%";
							}
						}else if(Math.abs(this.zsfs5zlfscy) > B4.fsiq_zl10 && Math.abs(this.zsfs5zlfscy) <= B4.fsiq_zl5){
							this.zsfs5zljcl = "5-10%";
							if(Math.abs(this.zsfs5zlfscy) == B4.fsiq_zl5){
								this.zsfs5zljcl ="5%";
							}
						}else if(Math.abs(this.zsfs5zlfscy) > B4.fsiq_zl5 && Math.abs(this.zsfs5zlfscy) <= B4.fsiq_zl2){
							this.zsfs5zljcl = "2-5%";
							if(Math.abs(this.zsfs5zlfscy) == B4.fsiq_zl2){
								this.zsfs5zljcl ="2%";
							}
						}else if(Math.abs(this.zsfs5zlfscy) > B4.fsiq_zl2 && Math.abs(this.zsfs5zlfscy) <= B4.fsiq_zl1){
							this.zsfs5zljcl = "1-2%";
							if(Math.abs(this.zsfs5zlfscy) == B4.fsiq_zl1){
								this.zsfs5zljcl ="1%";
							}
						}else if(Math.abs(this.zsfs5zlfscy) >= B4.fsiq_zl1 ){
							this.zsfs5zljcl = "<1%";
						}
					}
				}
			}
			if(this.oa != -1){
				//in强弱，基础
				if(Math.abs(this.zsfs5infscy) >= this.zsfs6inljz){
					if(this.zsfs5infscy > 0){
						this.zsfs5inqrx = 1;
					}else{
						this.zsfs5inqrx = 2;
					}
					
					if(this.zsfs5infscy < 0){
						if(Math.abs(this.zsfs5infscy) <= B4.in_fsiq25){
							this.zsfs5injcl = ">25%";
							if(Math.abs(this.zsfs5infscy) == B4.in_fsiq25){
								this.zsfs5injcl ="25%";
							}
						}else if(Math.abs(this.zsfs5infscy) > B4.in_fsiq25 && Math.abs(this.zsfs5infscy) <= B4.in_fsiq10){
							this.zsfs5injcl = "10-25%";
							if(Math.abs(this.zsfs5infscy) == B4.in_fsiq10){
								this.zsfs5injcl ="10%";
							}
						}else if(Math.abs(this.zsfs5infscy) > B4.in_fsiq10 && Math.abs(this.zsfs5infscy) <= B4.in_fsiq5){
							this.zsfs5injcl = "5-10%";
							if(Math.abs(this.zsfs5infscy) == B4.in_fsiq5){
								this.zsfs5injcl ="5%";
							}
						}else if(Math.abs(this.zsfs5infscy) > B4.in_fsiq5 && Math.abs(this.zsfs5infscy) <= B4.in_fsiq2){
							this.zsfs5injcl = "2-5%";
							if(Math.abs(this.zsfs5infscy) == B4.in_fsiq2){
								this.zsfs5injcl ="2%";
							}
						}else if(Math.abs(this.zsfs5infscy) > B4.in_fsiq2 && Math.abs(this.zsfs5infscy) <= B4.in_fsiq1){
							this.zsfs5injcl = "1-2%";
							if(Math.abs(this.zsfs5infscy) == B4.in_fsiq1){
								this.zsfs5injcl ="1%";
							}
						}else if(Math.abs(this.zsfs5infscy) >= B4.in_fsiq1 ){
							this.zsfs5injcl = "<1%";
						}
					}else{
						if(Math.abs(this.zsfs5infscy) <= B4.fsiq_in25){
							this.zsfs5injcl = ">25%";
							if(Math.abs(this.zsfs5infscy) == B4.fsiq_in25){
								this.zsfs5injcl ="25%";
							}
						}else if(Math.abs(this.zsfs5infscy) > B4.fsiq_in25 && Math.abs(this.zsfs5infscy) <= B4.fsiq_in10){
							this.zsfs5injcl = "10-25%";
							if(Math.abs(this.zsfs5infscy) == B4.fsiq_in10){
								this.zsfs5injcl ="10%";
							}
						}else if(Math.abs(this.zsfs5infscy) > B4.fsiq_in10 && Math.abs(this.zsfs5infscy) <= B4.fsiq_in5){
							this.zsfs5injcl = "5-10%";
							if(Math.abs(this.zsfs5infscy) == B4.fsiq_in5){
								this.zsfs5injcl ="5%";
							}
						}else if(Math.abs(this.zsfs5infscy) > B4.fsiq_in5 && Math.abs(this.zsfs5infscy) <= B4.fsiq_in2){
							this.zsfs5injcl = "2-5%";
							if(Math.abs(this.zsfs5infscy) == B4.fsiq_in2){
								this.zsfs5injcl ="2%";
							}
						}else if(Math.abs(this.zsfs5infscy) > B4.fsiq_in2 && Math.abs(this.zsfs5infscy) <= B4.fsiq_in1){
							this.zsfs5injcl = "1-2%";
							if(Math.abs(this.zsfs5infscy) == B4.fsiq_in1){
								this.zsfs5injcl ="1%";
							}
						}else if(Math.abs(this.zsfs5infscy) >= B4.fsiq_in1 ){
							this.zsfs5injcl = "<1%";
						}
					}
				}
			}
			if(this.inf != -1){
				//oa强弱，基础
				if(Math.abs(this.zsfs5oafscy) >= this.zsfs5oaljz){
					if(this.zsfs5oafscy > 0){
						this.zsfs5oaqrx = 1;
					}else{
						this.zsfs5oaqrx = 2;
					}
					
					if(this.zsfs5oafscy < 0){
						if(Math.abs(this.zsfs5oafscy) <= B4.oa_fsiq25){
							this.zsfs5oajcl = ">25%";
							if(Math.abs(this.zsfs5oafscy) == B4.oa_fsiq25){
								this.zsfs5oajcl ="25%";
							}
						}else if(Math.abs(this.zsfs5oafscy) > B4.oa_fsiq25 && Math.abs(this.zsfs5oafscy) <= B4.oa_fsiq10){
							this.zsfs5oajcl = "10-25%";
							if(Math.abs(this.zsfs5oafscy) == B4.oa_fsiq10){
								this.zsfs5oajcl ="10%";
							}
						}else if(Math.abs(this.zsfs5oafscy) > B4.oa_fsiq10 && Math.abs(this.zsfs5oafscy) <= B4.oa_fsiq5){
							this.zsfs5oajcl = "5-10%";
							if(Math.abs(this.zsfs5oafscy) == B4.oa_fsiq5){
								this.zsfs5oajcl ="5%";
							}
						}else if(Math.abs(this.zsfs5oafscy) > B4.oa_fsiq5 && Math.abs(this.zsfs5oafscy) <= B4.oa_fsiq2){
							this.zsfs5oajcl = "2-5%";
							if(Math.abs(this.zsfs5oafscy) == B4.oa_fsiq2){
								this.zsfs5oajcl ="2%";
							}
						}else if(Math.abs(this.zsfs5oafscy) > B4.oa_fsiq2 && Math.abs(this.zsfs5oafscy) <= B4.oa_fsiq1){
							this.zsfs5oajcl = "1-2%";
							if(Math.abs(this.zsfs5oafscy) == B4.oa_fsiq1){
								this.zsfs5oajcl ="1%";
							}
						}else if(Math.abs(this.zsfs5oafscy) >= B4.oa_fsiq1 ){
							this.zsfs5oajcl = "<1%";
						}
					}else{
						if(Math.abs(this.zsfs5oafscy) <= B4.fsiq_oa25){
							this.zsfs5oajcl = ">25%";
							if(Math.abs(this.zsfs5oafscy) == B4.fsiq_oa25){
								this.zsfs5oajcl ="25%";
							}
						}else if(Math.abs(this.zsfs5oafscy) > B4.fsiq_oa25 && Math.abs(this.zsfs5oafscy) <= B4.fsiq_oa10){
							this.zsfs5oajcl = "10-25%";
							if(Math.abs(this.zsfs5oafscy) == B4.fsiq_oa10){
								this.zsfs5oajcl ="10%";
							}
						}else if(Math.abs(this.zsfs5oafscy) > B4.fsiq_oa10 && Math.abs(this.zsfs5oafscy) <= B4.fsiq_oa5){
							this.zsfs5oajcl = "5-10%";
							if(Math.abs(this.zsfs5oafscy) == B4.fsiq_oa5){
								this.zsfs5oajcl ="5%";
							}
						}else if(Math.abs(this.zsfs5oafscy) > B4.fsiq_oa5 && Math.abs(this.zsfs5oafscy) <= B4.fsiq_oa2){
							this.zsfs5oajcl = "2-5%";
							if(Math.abs(this.zsfs5oafscy) == B4.fsiq_oa2){
								this.zsfs5oajcl ="2%";
							}
						}else if(Math.abs(this.zsfs5oafscy) > B4.fsiq_oa2 && Math.abs(this.zsfs5oafscy) <= B4.fsiq_oa1){
							this.zsfs5oajcl = "1-2%";
							if(Math.abs(this.zsfs5oafscy) == B4.fsiq_oa1){
								this.zsfs5oajcl ="1%";
							}
						}else if(Math.abs(this.zsfs5oafscy) >= B4.fsiq_oa1 ){
							this.zsfs5oajcl = "<1%";
						}
					}
				}
			}
			//mark2 end;
		}
		if(this.fsiq == -1){
//			this.zsfs5 = -1;
//			this.zsfs5jz = -1f;
//			this.zsfs5fsd = -1;
		}
	}
	
	private void cybjb(){
		//差异比较表
		//mark3
		//无缺失
		if(this.vci != -1 && this.vsi != -1 && this.wmi != -1){
			this.vci_vsi = this.vcii - this.vsii;
			this.vci_wmi = this.vcii - this.wmii;
			this.vsi_wmi = this.vsii - this.wmii;
			
			if(this.ssp == 0 ){
				this.vci_vsiljz = B5.vci_vsi01;
				this.vci_wmiljz = B5.vci_wmi01;
				this.vsi_wmiljz = B5.vsi_wmi01;
			}
			
			if(this.ssp == 1 ){
				this.vci_vsiljz = B5.vci_vsi05;
				this.vci_wmiljz = B5.vci_wmi05;
				this.vsi_wmiljz = B5.vsi_wmi05;
			}
			
			if(this.ssp == 2 ){
				this.vci_vsiljz = B5.vci_vsi10;
				this.vci_wmiljz = B5.vci_wmi10;
				this.vsi_wmiljz = B5.vsi_wmi10;
			}
			
			if(this.ssp == 3 ){
				this.vci_vsiljz = B5.vci_vsi15;
				this.vci_wmiljz = B5.vci_wmi15;
				this.vsi_wmiljz = B5.vsi_wmi15;
			}
			if(Math.abs((this.vci_vsi)) >= this.vci_vsiljz){
				int abs = Math.abs((this.vci_vsi));
				if(abs >=40){
					abs = 40;
				}
				if(this.vci_vsi > 0){
					this.vci_vsiqrx = 1;
				}else{
					this.vci_vsiqrx = 1;
				}
				
				if(this.vcii >= this.vsii){
					if(abs != 0){
						this.vci_vsijcl = String.valueOf(B6.vci_b_vsi[abs-1]+"%");
					}
				}else{
					if(abs != 0){
						this.vci_vsijcl = String.valueOf(B6.vci_l_vsi[abs-1]+"%");
					}
					
				}
				
				if(this.bjjc == 1){
					if(this.fsiqi >= 40 && this.fsiqi <=79 ){
						
						if(this.vcii >= this.vsii){
							if(abs != 0){
								this.vci_vsijcl = String.valueOf(B6.vci_b_vsi40[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vci_vsijcl = String.valueOf(B6.vci_l_vsi40[abs-1]+"%");
							}
							
						}
					}
					
					if(this.fsiqi >= 80 && this.fsiqi <=89 ){
						
						if(this.vcii >= this.vsii){
							if(abs != 0){
								this.vci_vsijcl = String.valueOf(B6.vci_b_vsi80[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vci_vsijcl = String.valueOf(B6.vci_l_vsi80[abs-1]+"%");
							}
							
						}
					}
					
					if(this.fsiqi >= 90 && this.fsiqi <=109 ){
						
						if(this.vcii >= this.vsii){
							if(abs != 0){
								this.vci_vsijcl = String.valueOf(B6.vci_b_vsi90[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vci_vsijcl = String.valueOf(B6.vci_l_vsi90[abs-1]+"%");
							}
							
						}
					}

					if(this.fsiqi >= 110 && this.fsiqi <=119 ){
						
						if(this.vcii >= this.vsii){
							if(abs != 0){
								this.vci_vsijcl = String.valueOf(B6.vci_b_vsi110[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vci_vsijcl = String.valueOf(B6.vci_l_vsi110[abs-1]+"%");
							}
							
						}
					}
					
					if(this.fsiqi >= 120){
						
						if(this.vcii >= this.vsii){
							if(abs != 0){
								this.vci_vsijcl = String.valueOf(B6.vci_b_vsi120[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vci_vsijcl = String.valueOf(B6.vci_l_vsi120[abs-1]+"%");
							}
							
						}
					}
					
				}
					
			}
			if(Math.abs((this.vci_wmi)) >= this.vci_wmiljz){
				int abs = Math.abs((this.vci_wmi));
				if(abs >=40){
					abs = 40;
				}
				if(this.vci_wmi > 0){
					this.vci_wmiqrx = 1;
				}else{
					this.vci_wmiqrx = 1;
				}
				if(this.vcii >= this.wmii){
					if(abs != 0){
						this.vci_wmijcl = String.valueOf(B6.vci_b_wmi[abs-1]+"%");
					}
				}else{
					if(abs != 0){
						this.vci_wmijcl = String.valueOf(B6.vci_l_wmi[abs-1]+"%");
					}
				}
				
				if(this.bjjc == 1){
					if(this.fsiqi >= 40 && this.fsiqi <=79 ){
						
						if(this.vcii >= this.wmii){
							if(abs != 0){
								this.vci_wmijcl = String.valueOf(B6.vci_b_wmi40[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vci_wmijcl = String.valueOf(B6.vci_l_wmi40[abs-1]+"%");
							}
							
						}
					}
					
					if(this.fsiqi >= 80 && this.fsiqi <=89 ){
						
						if(this.vcii >= this.wmii){
							if(abs != 0){
								this.vci_wmijcl = String.valueOf(B6.vci_b_wmi80[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vci_wmijcl = String.valueOf(B6.vci_l_wmi80[abs-1]+"%");
							}
							
						}
					}
					
					if(this.fsiqi >= 90 && this.fsiqi <=109 ){
						
						if(this.vcii >= this.wmii){
							if(abs != 0){
								this.vci_wmijcl = String.valueOf(B6.vci_b_wmi90[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vci_wmijcl = String.valueOf(B6.vci_l_wmi90[abs-1]+"%");
							}
							
						}
					}

					if(this.fsiqi >= 110 && this.fsiqi <=119 ){
						
						if(this.vcii >= this.wmii){
							if(abs != 0){
								this.vci_wmijcl = String.valueOf(B6.vci_b_wmi110[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vci_wmijcl = String.valueOf(B6.vci_l_wmi110[abs-1]+"%");
							}
							
						}
					}
					
					if(this.fsiqi >= 120){
						
						if(this.vcii >= this.wmii){
							if(abs != 0){
								this.vci_wmijcl = String.valueOf(B6.vci_b_wmi120[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vci_wmijcl = String.valueOf(B6.vci_l_wmi120[abs-1]+"%");
							}
							
						}
					}
					
				}
				
			}
			if(Math.abs((this.vsi_wmi)) >= this.vsi_wmiljz){
				int abs = Math.abs((this.vsi_wmi));
				if(abs >=40){
					abs = 40;
				}
				if(this.vsi_wmi > 0){
					this.vsi_wmiqrx = 1;
				}else{
					this.vsi_wmiqrx = 1;
				}
				if(this.vsii >= this.wmii){
					if(abs != 0){
						this.vsi_wmijcl = String.valueOf(B6.vsi_b_wmi[abs-1]+"%");
					}
				}else{
					if(abs != 0){
						this.vsi_wmijcl = String.valueOf(B6.vsi_l_wmi[abs-1]+"%");
					}
				}
				
				if(this.bjjc == 1){
					if(this.fsiqi >= 40 && this.fsiqi <=79 ){
						
						if(this.vsii >= this.wmii){
							if(abs != 0){
								this.vsi_wmijcl = String.valueOf(B6.vsi_b_wmi40[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vsi_wmijcl = String.valueOf(B6.vsi_l_wmi40[abs-1]+"%");
							}
							
						}
					}
					
					if(this.fsiqi >= 80 && this.fsiqi <=89 ){
						
						if(this.vsii >= this.wmii){
							if(abs != 0){
								this.vsi_wmijcl = String.valueOf(B6.vsi_b_wmi80[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vsi_wmijcl = String.valueOf(B6.vsi_l_wmi80[abs-1]+"%");
							}
							
						}
					}
					
					if(this.fsiqi >= 90 && this.fsiqi <=109 ){
						
						if(this.vsii >= this.wmii){
							if(abs != 0){
								this.vsi_wmijcl = String.valueOf(B6.vsi_b_wmi90[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vsi_wmijcl = String.valueOf(B6.vsi_l_wmi90[abs-1]+"%");
							}
							
						}
					}

					if(this.fsiqi >= 110 && this.fsiqi <=119 ){
						
						if(this.vsii >= this.wmii){
							if(abs != 0){
								this.vsi_wmijcl = String.valueOf(B6.vsi_b_wmi110[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vsi_wmijcl = String.valueOf(B6.vsi_l_wmi110[abs-1]+"%");
							}
							
						}
					}
					
					if(this.fsiqi >= 120){
						
						if(this.vsii >= this.wmii){
							if(abs != 0){
								this.vsi_wmijcl = String.valueOf(B6.vsi_b_wmi120[abs-1]+"%");
							}
						}else{
							if(abs != 0){
								this.vsi_wmijcl = String.valueOf(B6.vsi_l_wmi120[abs-1]+"%");
							}
							
						}
					}
					
				}
				
			}
			
			//rv_in
			this.rv_in = this.rvl - this.infl;
			this.bd_oa = this.bdl - this.oal;
			this.pm_zl = this.pml - this.zll;
			
			if(this.ssp == 0 ){
				this.rv_inljz = B7.rv_in01;
				this.bd_oaljz = B7.bd_oa01;
				this.pm_zlljz = B7.pm_zl01;
			}
			
			if(this.ssp == 1 ){
				this.rv_inljz = B7.rv_in05;
				this.bd_oaljz = B7.bd_oa05;
				this.pm_zlljz = B7.pm_zl05;
			}
			
			if(this.ssp == 2 ){
				this.rv_inljz = B7.rv_in10;
				this.bd_oaljz = B7.bd_oa10;
				this.pm_zlljz = B7.pm_zl10;
			}
			
			if(this.ssp == 3 ){
				this.rv_inljz = B7.rv_in15;
				this.bd_oaljz = B7.bd_oa15;
				this.pm_zlljz = B7.pm_zl15;
			}
			if(Math.abs((this.rv_in)) >= this.rv_inljz){
				int abs = Math.abs((this.rv_in));
				if(abs >=18){
					abs = 18;
				}
				if(this.rv_in > 0){
					this.rv_inqrx = 1;
				}else{
					this.rv_inqrx = 1;
				}
				if(this.rvl >= this.infl){
					if(abs != 0){
						this.rv_injcl = String.valueOf(B8.rv_b_in[abs-1]+"%");
					}
				}else{
					if(abs != 0){
						this.rv_injcl = String.valueOf(B8.rv_l_in[abs-1]+"%");
					}
				}
			}
			if(Math.abs((this.bd_oa)) >= this.bd_oaljz){
				int abs = Math.abs((this.bd_oa));
				if(abs >=18){
					abs = 18;
				}
				if(this.bd_oa > 0){
					this.bd_oaqrx = 1;
				}else{
					this.bd_oaqrx = 1;
				}
				if(this.bdl >= this.oal){
					this.bd_oajcl = String.valueOf(B8.bd_b_oa[abs-1]+"%");
				}else{
					this.bd_oajcl = String.valueOf(B8.bd_l_oa[abs-1]+"%");
				}
			}
			if(Math.abs((this.pm_zl)) >= this.pm_zlljz){
				int abs = Math.abs((this.pm_zl));
				if(abs >=18){
					abs = 18;
				}
				if(this.pm_zl > 0){
					this.pm_zlqrx = 1;
				}else{
					this.pm_zlqrx = 1;
				}
				if(this.pml >= this.zll){
					if(abs != 0){
						this.pm_zljcl = String.valueOf(B8.pm_b_zl[abs-1]+"%");
					}
				}else{
					if(abs != 0){
						this.pm_zljcl = String.valueOf(B8.pm_l_zl[abs-1]+"%");
					}
				}
				//end
			}
		}
		
		//有缺
		if(this.wmi == -1 || this.vci == -1 || this.vsi == -1){
			if(this.vsi == -1 || this.vci == -1){
			}else{
				this.vci_vsi = this.vcii - this.vsii;
				if(this.ssp == 0 ){
					this.vci_vsiljz = B5.vci_vsi01;
				}
				
				if(this.ssp == 1 ){
					this.vci_vsiljz = B5.vci_vsi05;
				}
				
				if(this.ssp == 2 ){
					this.vci_vsiljz = B5.vci_vsi10;
				}
				
				if(this.ssp == 3 ){
					this.vci_vsiljz = B5.vci_vsi15;
				}
				
				if(Math.abs((this.vci_vsi)) >= this.vci_vsiljz){
					int abs = Math.abs((this.vci_vsi));
					if(abs >=40){
						abs = 40;
					}
//					System.out.println("abs-->"+abs);
					if(this.vci_vsi > 0){
						this.vci_vsiqrx = 1;
					}else{
						this.vci_vsiqrx = 1;
					}
					if(this.vcii >= this.vsii){
						if(abs != 0){
							this.vci_vsijcl = String.valueOf(B6.vci_b_vsi[abs-1]+"%");
						}
					}else{
						if(abs != 0){
							this.vci_vsijcl = String.valueOf(B6.vci_l_vsi[abs-1]+"%");
						}
					}
					
					if(this.bjjc == 1){
						if(this.fsiqi >= 40 && this.fsiqi <=79 ){
							
							if(this.vcii >= this.vsii){
								if(abs != 0){
									this.vci_vsijcl = String.valueOf(B6.vci_b_vsi40[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vci_vsijcl = String.valueOf(B6.vci_l_vsi40[abs-1]+"%");
								}
								
							}
						}
						
						if(this.fsiqi >= 80 && this.fsiqi <=89 ){
							
							if(this.vcii >= this.vsii){
								if(abs != 0){
									this.vci_vsijcl = String.valueOf(B6.vci_b_vsi80[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vci_vsijcl = String.valueOf(B6.vci_l_vsi80[abs-1]+"%");
								}
								
							}
						}
						
						if(this.fsiqi >= 90 && this.fsiqi <=109 ){
							
							if(this.vcii >= this.vsii){
								if(abs != 0){
									this.vci_vsijcl = String.valueOf(B6.vci_b_vsi90[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vci_vsijcl = String.valueOf(B6.vci_l_vsi90[abs-1]+"%");
								}
								
							}
						}

						if(this.fsiqi >= 110 && this.fsiqi <=119 ){
							
							if(this.vcii >= this.vsii){
								if(abs != 0){
									this.vci_vsijcl = String.valueOf(B6.vci_b_vsi110[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vci_vsijcl = String.valueOf(B6.vci_l_vsi110[abs-1]+"%");
								}
								
							}
						}
						
						if(this.fsiqi >= 120){
							
							if(this.vcii >= this.vsii){
								if(abs != 0){
									this.vci_vsijcl = String.valueOf(B6.vci_b_vsi120[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vci_vsijcl = String.valueOf(B6.vci_l_vsi120[abs-1]+"%");
								}
								
							}
						}
						
					}
					
				}
				
			}
			
			if(this.vci == -1 || this.wmi == -1){
			}else{
				this.vci_wmi = this.vcii - this.wmii;
				if(this.ssp == 0 ){
					this.vci_wmiljz = B5.vci_wmi01;
				}
				
				if(this.ssp == 1 ){
					this.vci_wmiljz = B5.vci_wmi05;
				}
				
				if(this.ssp == 2 ){
					this.vci_wmiljz = B5.vci_wmi10;
				}
				
				if(this.ssp == 3 ){
					this.vci_wmiljz = B5.vci_wmi15;
				}
				
				if(Math.abs((this.vci_wmi)) >= this.vci_wmiljz){
					int abs = Math.abs((this.vci_wmi));
					if(abs >=40){
						abs = 40;
					}
					if(this.vci_wmi > 0){
						this.vci_wmiqrx = 1;
					}else{
						this.vci_wmiqrx = 1;
					}
					if(this.vcii >= this.wmii){
						if(abs != 0){
							this.vci_wmijcl = String.valueOf(B6.vci_b_wmi[abs-1]+"%");
						}
					}else{
						if(abs != 0){
							this.vci_wmijcl = String.valueOf(B6.vci_l_wmi[abs-1]+"%");
						}
					}
					
					if(this.bjjc == 1){
						if(this.fsiqi >= 40 && this.fsiqi <=79 ){
							
							if(this.vcii >= this.wmii){
								if(abs != 0){
									this.vci_wmijcl = String.valueOf(B6.vci_b_wmi40[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vci_wmijcl = String.valueOf(B6.vci_l_wmi40[abs-1]+"%");
								}
								
							}
						}
						
						if(this.fsiqi >= 80 && this.fsiqi <=89 ){
							
							if(this.vcii >= this.wmii){
								if(abs != 0){
									this.vci_wmijcl = String.valueOf(B6.vci_b_wmi80[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vci_wmijcl = String.valueOf(B6.vci_l_wmi80[abs-1]+"%");
								}
								
							}
						}
						
						if(this.fsiqi >= 90 && this.fsiqi <=109 ){
							
							if(this.vcii >= this.wmii){
								if(abs != 0){
									this.vci_wmijcl = String.valueOf(B6.vci_b_wmi90[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vci_wmijcl = String.valueOf(B6.vci_l_wmi90[abs-1]+"%");
								}
								
							}
						}

						if(this.fsiqi >= 110 && this.fsiqi <=119 ){
							
							if(this.vcii >= this.wmii){
								if(abs != 0){
									this.vci_wmijcl = String.valueOf(B6.vci_b_wmi110[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vci_wmijcl = String.valueOf(B6.vci_l_wmi110[abs-1]+"%");
								}
								
							}
						}
						
						if(this.fsiqi >= 120){
							
							if(this.vcii >= this.wmii){
								if(abs != 0){
									this.vci_wmijcl = String.valueOf(B6.vci_b_wmi120[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vci_wmijcl = String.valueOf(B6.vci_l_wmi120[abs-1]+"%");
								}
								
							}
						}
						
					}
					
					
				}
			}
			
			if(this.vsi == -1 || this.wmi == -1){
			}else{
				this.vsi_wmi = this.vsii - this.wmii;
				if(this.ssp == 0 ){
					this.vsi_wmiljz = B5.vsi_wmi01;
				}
				
				if(this.ssp == 1 ){
					this.vsi_wmiljz = B5.vsi_wmi05;
				}
				
				if(this.ssp == 2 ){
					this.vsi_wmiljz = B5.vsi_wmi10;
				}
				
				if(this.ssp == 3 ){
					this.vsi_wmiljz = B5.vsi_wmi15;
				}
				
				if(Math.abs((this.vsi_wmi)) >= this.vsi_wmiljz){
					int abs = Math.abs((this.vsi_wmi));
					if(abs >=40){
						abs = 40;
					}
					if(this.vsi_wmi > 0){
						this.vsi_wmiqrx = 1;
					}else{
						this.vsi_wmiqrx = 1;
					}
					if(this.vsii >= this.wmii){
						if(abs != 0){
							this.vsi_wmijcl = String.valueOf(B6.vsi_b_wmi[abs-1]+"%");
						}
					}else{
						if(abs != 0){
							this.vsi_wmijcl = String.valueOf(B6.vsi_l_wmi[abs-1]+"%");
						}
					}
					
					if(this.bjjc == 1){
						if(this.fsiqi >= 40 && this.fsiqi <=79 ){
							
							if(this.vsii >= this.wmii){
								if(abs != 0){
									this.vsi_wmijcl = String.valueOf(B6.vsi_b_wmi40[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vsi_wmijcl = String.valueOf(B6.vsi_l_wmi40[abs-1]+"%");
								}
								
							}
						}
						
						if(this.fsiqi >= 80 && this.fsiqi <=89 ){
							
							if(this.vsii >= this.wmii){
								if(abs != 0){
									this.vsi_wmijcl = String.valueOf(B6.vsi_b_wmi80[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vsi_wmijcl = String.valueOf(B6.vsi_l_wmi80[abs-1]+"%");
								}
								
							}
						}
						
						if(this.fsiqi >= 90 && this.fsiqi <=109 ){
							
							if(this.vsii >= this.wmii){
								if(abs != 0){
									this.vsi_wmijcl = String.valueOf(B6.vsi_b_wmi90[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vsi_wmijcl = String.valueOf(B6.vsi_l_wmi90[abs-1]+"%");
								}
								
							}
						}

						if(this.fsiqi >= 110 && this.fsiqi <=119 ){
							
							if(this.vsii >= this.wmii){
								if(abs != 0){
									this.vsi_wmijcl = String.valueOf(B6.vsi_b_wmi110[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vsi_wmijcl = String.valueOf(B6.vsi_l_wmi110[abs-1]+"%");
								}
								
							}
						}
						
						if(this.fsiqi >= 120){
							
							if(this.vsii >= this.wmii){
								if(abs != 0){
									this.vsi_wmijcl = String.valueOf(B6.vsi_b_wmi120[abs-1]+"%");
								}
							}else{
								if(abs != 0){
									this.vsi_wmijcl = String.valueOf(B6.vsi_l_wmi120[abs-1]+"%");
								}
								
							}
						}
						
					}
					
				}
			}
			
			if(this.rv == -1 || this.inf == -1){
			}else{
				this.rv_in = this.rvl - this.infl;
				if(this.ssp == 0 ){
					this.rv_inljz = B7.rv_in01;
				}
				
				if(this.ssp == 1 ){
					this.rv_inljz = B7.rv_in05;
				}
				
				if(this.ssp == 2 ){
					this.rv_inljz = B7.rv_in10;
				}
				
				if(this.ssp == 3 ){
					this.rv_inljz = B7.rv_in15;
				}
				
				if(Math.abs((this.rv_in)) >= this.rv_inljz){
					int abs = Math.abs((this.rv_in));
					if(abs >=18){
						abs = 18;
					}
					if(this.rv_in > 0){
						this.rv_inqrx = 1;
					}else{
						this.rv_inqrx = 1;
					}
					if(this.rvl >= this.infl){
						if(abs != 0){
							this.rv_injcl = String.valueOf(B8.rv_b_in[abs-1]+"%");
						}
					}else{
						if(abs != 0 ){
							this.rv_injcl = String.valueOf(B8.rv_l_in[abs-1]+"%");
						}
					}
				}
			}
			if(this.bd == -1 || this.oa == -1){
			}else{
				this.bd_oa = this.bdl - this.oal;
				if(this.ssp == 0 ){
					this.bd_oaljz = B7.bd_oa01;
				}
				
				if(this.ssp == 1 ){
					this.bd_oaljz = B7.bd_oa05;
				}
				
				if(this.ssp == 2 ){
					this.bd_oaljz = B7.bd_oa10;
				}
				
				if(this.ssp == 3 ){
					this.bd_oaljz = B7.bd_oa15;
				}
				
				if(Math.abs((this.bd_oa)) >= this.bd_oaljz){
					int abs = Math.abs((this.bd_oa));
					if(abs >=18){
						abs = 18;
					}
					if(this.bd_oa > 0){
						this.bd_oaqrx = 1;
					}else{
						this.bd_oaqrx = 1;
					}
					if(this.bdl >= this.oal){
						if(abs != 0){
							this.bd_oajcl = String.valueOf(B8.bd_b_oa[abs-1]+"%");
						}
					}else{
						if(abs != 0){
							this.bd_oajcl = String.valueOf(B8.bd_l_oa[abs-1]+"%");
						}
					}
				}
			}
			if(this.pm == -1 || this.zl == -1){
			}else{
				this.pm_zl = this.pml - this.zll;
				if(this.ssp == 0 ){
					this.pm_zlljz = B7.pm_zl01;
				}
				
				if(this.ssp == 1 ){
					this.pm_zlljz = B7.pm_zl05;
				}
				
				if(this.ssp == 2 ){
					this.pm_zlljz = B7.pm_zl10;
				}
				
				if(this.ssp == 3 ){
					this.pm_zlljz = B7.pm_zl15;
				}
				
				if(Math.abs((this.pm_zl)) >= this.pm_zlljz){
					int abs = Math.abs((this.pm_zl));
					if(abs >=18){
						abs = 18;
					}
					if(this.pm_zl > 0){
						this.pm_zlqrx = 1;
					}else{
						this.pm_zlqrx = 1;
					}
					if(this.pml >= this.zll){
						if(abs != 0){
							this.pm_zljcl = String.valueOf(B8.pm_b_zl[abs-1]+"%");
						}
					}else{
						if(abs != 0){
							this.pm_zljcl = String.valueOf(B8.pm_l_zl[abs-1]+"%");
						}
					}
				}
			}
		}
	}
	
	private void fuzu(){
		//辅助分析页
		//mark4
		//无缺
		if(this.rv == -1 || this.pn == -1){
			this.vai = -1;
		}else if(this.rv == 0 && this.pn == 0){
			this.vai = -1;
		}else{
			this.vai = this.rvl + this.pnl;
		}
		
//		int z_0 = com_zero(this.bd, this.pm, this.oa, this.zl);
//		int[] ct = com_allzero(this.bd, this.pm, this.oa, this.zl, this.rv);
		
		int ct_nvi[] = ct_nvi();
		int ct_gai[] = ct_gai();
		
		if(this.bd == -1 || this.pm == -1 || this.oa == -1 || this.zl == -1){
			this.nvi = -1;
		}else if(ct_nvi[0] >=3){
			this.nvi = -1;
		}else{
			this.nvi = this.bdl + this.pml + this.oal + this.zll;
		}
		
		this.gai = -1;
		
		if(ct_gai[0] >= 3 || ct_gai[1]>=2){
			this.gai = -1;
		}else if(ct_gai[0]< 3 && ct_gai[1]< 1){  //没有缺失
			this.gai = this.rvl + this.bdl + this.infl +  this.oal;
		}else if(ct_gai[0]<3 && ct_gai[1]<2 && this.jsff == 0){
			this.gai = 0;
			if(this.rv == -1){
				this.gai = this.pnl + this.bdl  + this.oal + this.infl;
			}else{
				if(this.rv!=-1){
					this.gai += this.rvl;
				}
				if(this.bd!=-1){
					this.gai += this.bdl;
				}
				if(this.inf!=-1){
					this.gai += this.infl;
				}
				if(this.oa!=-1){
					this.gai += this.oal;
				}
			}
			if(this.bd == -1 || this.inf == -1 || this.oa == -1){
				this.gai = -1;
			}
		}
		
		if(this.vai != -1){
			this.vaii = C1.vaii[this.vai -2];
			this.vaib = C1.vaib[this.vai -2];
			if(this.sp == 0){
				this.vaizxqj = C1.z90[this.vai -2];
			}else{
				this.vaizxqj = C1.z95[this.vai -2];
			}
		}
		
		if(this.nvi != -1){
			this.nvii = C2.nvii[this.nvi -4];
			this.nvib = C2.nvib[this.nvi -4];
			if(this.sp == 0){
				this.nvizxqj = C2.z90[this.nvi -4];
			}else{
				this.nvizxqj = C2.z95[this.nvi -4];
			}
		}
		
		if(this.gai != -1){
			this.gaii = C4.gaii[this.gai -4];
			this.gaib = C4.gaib[this.gai -4];
			if(this.sp == 0){
				this.gaizxqj = C4.z90[this.gai -4];
			}else{
				this.gaizxqj = C4.z95[this.gai -4];
			}
		}
		
		if(this.gai != -1 && this.fsiq !=-1){
			this.gai_fsiq = this.gaii - this.fsiqi;
			if(this.ssp == 0){
				this.gai_fsiqljz = B10.gai_fsiq01;
			}
			if(this.ssp == 1){
				this.gai_fsiqljz = B10.gai_fsiq05;
			}
			if(this.ssp == 2){
				this.gai_fsiqljz = B10.gai_fsiq10;
			}
			if(this.ssp == 3){
				this.gai_fsiqljz = B10.gai_fsiq15;
			}
			if(Math.abs((float)this.gai_fsiq) >= this.gai_fsiqljz){
				this.gai_fsiqcy = 1;
				int abs = Math.abs(this.gai_fsiq);
				if(this.gai_fsiq > 0){
					this.gai_fsiqjcl = String.valueOf(B11.fsiq_l_gai[abs -1])+"%";
				}else{
					if(this.gai_fsiq != 0){
						this.gai_fsiqjcl = String.valueOf(B11.fsiq_b_gai[abs -1])+"%";
					}
				}
			}
		}
		
		if(this.rv != -1 && this.pn !=-1){
			this.rv_pn = this.rvl - this.pnl;
			if(this.ssp == 0){
				this.rv_pnljz = B7.rv_pn01;
			}
			if(this.ssp == 1){
				this.rv_pnljz = B7.rv_pn05;
			}
			if(this.ssp == 2){
				this.rv_pnljz = B7.rv_pn10;
			}
			if(this.ssp == 3){
				this.rv_pnljz = B7.rv_pn15;
			}
			if(Math.abs((float)this.rv_pn) >= this.rv_pnljz){
				this.rv_pncy = 1;
				int abs = Math.abs(this.rv_pn);
				if(this.rv_pn > 0){
					this.rv_pnjcl = String.valueOf(B8.rv_b_pn[abs -1])+"%";
				}else{
					if(this.rv_pn !=0){
						this.rv_pnjcl = String.valueOf(B8.rv_l_pn[abs -1])+"%";
					}
				}
			}
		}
	}
	
	private int[] ct_fsiq(){
		int[] ct = new int[]{0,0};
		if(this.rv == 0){
			ct[0] ++;
		}
		if(this.bd == 0){
			ct[0] ++;
		}
		if(this.inf == 0){
			ct[0] ++;
		}
		if(this.oa == 0){
			ct[0] ++;
		}
		if(this.pm == 0){
			ct[0] ++;
		}
		if(this.rv == -1){
			ct[1] ++;
		}
		if(this.bd == -1){
			ct[1] ++;
		}
		if(this.inf == -1){
			ct[1] ++;
		}
		if(this.oa == -1){
			ct[1] ++;
		}
		if(this.pm == -1){
			ct[1] ++;
		}
		return ct;
	}
	public int[] ct_nvi(){
		int[] ct = new int[]{0,0};	
		if(this.bd == 0){
			ct[0]++;
		}
		if(this.bd == -1){
			ct[1]++;
		}
		if(this.pm == 0){
			ct[0]++;
		}
		if(this.pm == -1){
			ct[1]++;
		}
		if(this.oa == 0){
			ct[0]++;
		}
		if(this.oa == -1){
			ct[1]++;
		}
		if(this.zl == 0){
			ct[0]++;
		}
		if(this.zl == -1){
			ct[1]++;
		}
		return ct;
	}
	
	public int[] ct_gai(){
		int[] ct = new int[]{0,0};	
		if(this.rv == 0){
			ct[0]++;
		}
		if(this.rv == -1){
			ct[1]++;
		}
		if(this.bd == 0){
			ct[0]++;
		}
		if(this.bd == -1){
			ct[1]++;
		}
		if(this.inf == 0){
			ct[0]++;
		}
		if(this.inf == -1){
			ct[1]++;
		}
		if(this.oa == 0){
			ct[0]++;
		}
		if(this.oa == -1){
			ct[1]++;
		}
		return ct;
	}
}

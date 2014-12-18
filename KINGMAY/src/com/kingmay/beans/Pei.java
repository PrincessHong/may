package com.kingmay.beans;

public class Pei {
	private String pname;
	private String pstm;
	private String pnotify;
	private String pshunxu;
	private String pparent;
	private int ptype;
	private int	pstate;
	private int pchild = 0;
	private int pid;
	public Pei(){}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPstm() {
		return pstm;
	}
	public void setPstm(String pstm) {
		this.pstm = pstm;
	}
	public String getPnotify() {
		return pnotify;
	}
	public void setPnotify(String pnotify) {
		this.pnotify = pnotify;
	}
	public String getPshunxu() {
		return pshunxu;
	}
	public void setPshunxu(String pshunxu) {
		this.pshunxu = pshunxu;
	}
	public String getPparent() {
		return pparent;
	}
	public void setPparent(String pparent) {
		this.pparent = pparent;
	}
	public int getPtype() {
		return ptype;
	}
	public void setPtype(int ptype) {
		this.ptype = ptype;
	}
	public int getPstate() {
		return pstate;
	}
	public void setPstate(int pstate) {
		this.pstate = pstate;
	}
	public int getPchild() {
		return pchild;
	}
	public void setPchild(int pchild) {
		this.pchild = pchild;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
}

package com.group.newproject.entity;

import java.util.List;

public class CategotyRoot {
	private String t;
	private int im;
	private List<CateEntities> d;
	private int dt;
	private int st;
	private int sft;
	private int td;
	private String ft;
	
	public int getDt() {
		return dt;
	}
	public void setDt(int dt) {
		this.dt = dt;
	}
	public int getSt() {
		return st;
	}
	public void setSt(int st) {
		this.st = st;
	}
	public int getSft() {
		return sft;
	}
	public void setSft(int sft) {
		this.sft = sft;
	}
	public int getTd() {
		return td;
	}
	public void setTd(int td) {
		this.td = td;
	}
	public String getFt() {
		return ft;
	}
	public void setFt(String ft) {
		this.ft = ft;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public int getIm() {
		return im;
	}
	public void setIm(int im) {
		this.im = im;
	}
	public List<CateEntities> getD() {
		return d;
	}
	public void setD(List<CateEntities> d) {
		this.d = d;
	}
	
}

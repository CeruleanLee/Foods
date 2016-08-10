package com.group.newproject.entity;

import java.util.List;

public class CateEntities {
	private String t;
	private int dt;
	private String i;
	private String d;
	private int st;
	private List<CateCateEntities> ds;
	public List<CateCateEntities2> ds2;

	
	@Override
	public String toString() {
		return "CateEntities [t=" + t + ", dt=" + dt + ", i=" + i + ", d=" + d + ", st=" + st + ", ds=" + ds + "]";
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public int getDt() {
		return dt;
	}

	public void setDt(int dt) {
		this.dt = dt;
	}

	public String getI() {
		return i;
	}

	public void setI(String i) {
		this.i = i;
	}



	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

	public List<CateCateEntities> getDs() {
		return ds;
	}

	public void setDs(List<CateCateEntities> ds) {
		this.ds = ds;
	}

	private class CateCateEntities2 {
		public String t1;
		public String h;
	}
}

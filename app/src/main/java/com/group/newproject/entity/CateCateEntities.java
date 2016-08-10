package com.group.newproject.entity;

import java.io.Serializable;
import java.util.List;

public class CateCateEntities implements Serializable{
	private String t;
	private List<String> d;
	private String h;

	
	@Override
	public String toString() {
		return "CateCateEntities [t=" + t + ", d=" + d + ", h=" + h + "]";
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public List<String> getD() {
		return d;
	}

	public void setD(List<String> d) {
		this.d = d;
	}

	public String getH() {
		return h;
	}

	public void setH(String h) {
		this.h = h;
	}

}

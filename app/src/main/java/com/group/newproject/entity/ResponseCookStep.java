package com.group.newproject.entity;

import java.util.List;

public class ResponseCookStep {
	
	private List<CookStep> cookSteps;
	
	public static class Stips{
		private String title;
		private String image;
		private String content;
		private String width;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getWidth() {
			return width;
		}
		public void setWidth(String width) {
			this.width = width;
		}
		public String getHeight() {
			return height;
		}
		public void setHeight(String height) {
			this.height = height;
		}
		private String height;
	}
	
	public static class CookStep{
		private String t;
		private String d;
		private String dt;
		private String st;
		public String getT() {
			return t;
		}
		public void setT(String t) {
			this.t = t;
		}
		public String getD() {
			return d;
		}
		public void setD(String d) {
			this.d = d;
		}
		public String getDt() {
			return dt;
		}
		public void setDt(String dt) {
			this.dt = dt;
		}
		public String getSt() {
			return st;
		}
		public void setSt(String st) {
			this.st = st;
		}
		public String getStep() {
			return step;
		}
		public void setStep(String step) {
			this.step = step;
		}
		public String getShowNum() {
			return showNum;
		}
		public void setShowNum(String showNum) {
			this.showNum = showNum;
		}
		public String getH() {
			return h;
		}
		public void setH(String h) {
			this.h = h;
		}
		public String getW() {
			return w;
		}
		public void setW(String w) {
			this.w = w;
		}
		public String getI() {
			return i;
		}
		public void setI(String i) {
			this.i = i;
		}
		public String getIs_fmap() {
			return is_fmap;
		}
		public void setIs_fmap(String is_fmap) {
			this.is_fmap = is_fmap;
		}
		public Stips getStips() {
			return stips;
		}
		public void setStips(Stips stips) {
			this.stips = stips;
		}
		private String step;
		private String showNum;
		private String h;
		private String w;
		private String i;
		private String is_fmap;
		private Stips stips;
	}

	public List<CookStep> getCookSteps() {
		return cookSteps;
	}

	public void setCookSteps(List<CookStep> cookSteps) {
		this.cookSteps = cookSteps;
	}
}

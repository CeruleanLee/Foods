package com.group.newproject.entity;

import java.util.List;

public class ResponseCookStuff {

	private List<ZhuLiao> list;
	private List<FuLiao> list_f;

	public static class FuLiao{
		private String title;
		private String id;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUnit() {
			return unit;
		}
		public void setUnit(String unit) {
			this.unit = unit;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getIs_c() {
			return is_c;
		}
		public void setIs_c(String is_c) {
			this.is_c = is_c;
		}
		private String unit;
		private String category;
		private String is_c;
	}

	public static class ZhuLiao{
		private String title;
		private String id;
		private String icon;
		private String num;
		private String category;
		private String is_c;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String getNum() {
			return num;
		}
		public void setNum(String num) {
			this.num = num;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getIs_c() {
			return is_c;
		}
		public void setIs_c(String is_c) {
			this.is_c = is_c;
		}
	}

	public List<ZhuLiao> getList() {
		return list;
	}

	public void setList(List<ZhuLiao> list) {
		this.list = list;
	}

	public List<FuLiao> getList_f() {
		return list_f;
	}

	public void setList_f(List<FuLiao> list_f) {
		this.list_f = list_f;
	}
}

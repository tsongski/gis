package com.example.entity;

public class Entity {

	public Entity() {
		super();
	}

	public Entity(String city, String m1, String m2, String m3, String m4, String m5, String m6,
			String m7, String m8, String m9, String m10, String m11, String m12, String year) {
		super();
		this.city = city;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.m4 = m4;
		this.m5 = m5;
		this.m6 = m6;
		this.m7 = m7;
		this.m8 = m8;
		this.m9 = m9;
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.year = year;
	}

	@Override
	public String toString() {
		return "AEntity [city=" + city + ", m1=" + m1 + ", m2=" + m2 + ", m3="
				+ m3 + ", m4=" + m4 + ", m5=" + m5 + ", m6=" + m6 + ", m7="
				+ m7 + ", m8=" + m8 + ", m9=" + m9 + ", m10=" + m10 + ", m11="
				+ m11 + ", m12=" + m12 + ", year=" + year + "]";
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getM1() {
		return m1;
	}

	public void setM1(String m1) {
		this.m1 = m1;
	}

	public String getM2() {
		return m2;
	}

	public void setM2(String m2) {
		this.m2 = m2;
	}

	public String getM3() {
		return m3;
	}

	public void setM3(String m3) {
		this.m3 = m3;
	}

	public String getM4() {
		return m4;
	}

	public void setM4(String m4) {
		this.m4 = m4;
	}

	public String getM5() {
		return m5;
	}

	public void setM5(String m5) {
		this.m5 = m5;
	}

	public String getM6() {
		return m6;
	}

	public void setM6(String m6) {
		this.m6 = m6;
	}

	public String getM7() {
		return m7;
	}

	public void setM7(String m7) {
		this.m7 = m7;
	}

	public String getM8() {
		return m8;
	}

	public void setM8(String m8) {
		this.m8 = m8;
	}

	public String getM9() {
		return m9;
	}

	public void setM9(String m9) {
		this.m9 = m9;
	}

	public String getM10() {
		return m10;
	}

	public void setM10(String m10) {
		this.m10 = m10;
	}

	public String getM11() {
		return m11;
	}

	public void setM11(String m11) {
		this.m11 = m11;
	}

	public String getM12() {
		return m12;
	}

	public void setM12(String m12) {
		this.m12 = m12;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	private String city;
	private String m1;
	private String m2;
	private String m3;
	private String m4;
	private String m5;
	private String m6;
	private String m7;
	private String m8;
	private String m9;
	private String m10;
	private String m11;
	private String m12;
	private String year;
}

package com.simplilearn.seleniumDemos;

public class Customer {
	Integer cid;
	String name;
	String phone;
	String email;
	String birthdate;
	Integer age;
	String indatetime;
	String outdatetime;
	Float temparature;
	public Customer(Integer cid, String name, String phone, String email, String birthdate, Integer age,
			String indatetime, String outdatetime, Float temparature) {
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birthdate = birthdate;
		this.age = age;
		this.indatetime = indatetime;
		this.outdatetime = outdatetime;
		this.temparature = temparature;
	}
	public Customer() {
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getIndatetime() {
		return indatetime;
	}
	public void setIndatetime(String indatetime) {
		this.indatetime = indatetime;
	}
	public String getOutdatetime() {
		return outdatetime;
	}
	public void setOutdatetime(String outdatetime) {
		this.outdatetime = outdatetime;
	}
	public Float getTemparature() {
		return temparature;
	}
	public void setTemparature(Float temparature) {
		this.temparature = temparature;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", phone=" + phone + ", email=" + email + ", birthdate="
				+ birthdate + ", age=" + age + ", indatetime=" + indatetime + ", outdatetime=" + outdatetime
				+ ", temparature=" + temparature + "]";
	}
}

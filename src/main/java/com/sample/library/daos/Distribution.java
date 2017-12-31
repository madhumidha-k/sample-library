package com.sample.library.daos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="distribution",catalog="library")
public class Distribution {
@Id
@GeneratedValue
@Column(name="sno")
private int sno;
@Column(name="bookid")
private int bookID;
@Column(name="memberid")
private int memberID;
@Column(name="date")
private String date;
@Column(name="lastdate")
private String lastDate;
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public int getBookID() {
	return bookID;
}
public void setBookID(int bookID) {
	this.bookID = bookID;
}
public int getMemberID() {
	return memberID;
}
public void setMemberID(int memberID) {
	this.memberID = memberID;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getLastDate() {
	return lastDate;
}
public void setlastDate(String lastDate) {
	this.lastDate = lastDate;
}

}

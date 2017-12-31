package com.sample.library.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member",catalog="library")

public class Member {
@Id
@GeneratedValue
@Column(name="memberid")
private int memberID;
@Column(name="membername")
private String memberName;
@Column(name="bookondue")
private int dueBook;
@Column(name="fine")
private int fine;
public int getMemberID() {
	return memberID;
}
public void setMemberID(int memberID) {
	this.memberID = memberID;
}
public String getMemberName() {
	return memberName;
}
public void setMemberName(String memberName) {
	this.memberName = memberName;
}
public int getDueBook() {
	return dueBook;
}
public void setDueBook(int dueBook) {
	this.dueBook = dueBook;
}
public int getFine() {
	return fine;
}
public void setFine(int fine) {
	this.fine = fine;
}

}

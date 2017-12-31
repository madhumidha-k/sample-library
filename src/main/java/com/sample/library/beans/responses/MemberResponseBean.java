package com.sample.library.beans.responses;

public class MemberResponseBean {
	private int memberID;
	private String memberName;
	private String dueBook;
	private int fine;
	private String message;
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
	public String getDueBook() {
		return dueBook;
	}
	public void setDueBook(String dueBook) {
		this.dueBook = dueBook;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

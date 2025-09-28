package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "guest")
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int guestId;
	
	private String name;
	private long contactNo;
	private long aadharNo;
	
	public Guest() {
	}

	public Guest(int guestId, String name, long contactNo, long aadharNo) {
		super();
		this.guestId = guestId;
		this.name = name;
		this.contactNo = contactNo;
		this.aadharNo = aadharNo;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", name=" + name + ", contactNo=" + contactNo + ", aadharNo=" + aadharNo
				+ "]";
	};
	
	
	

}

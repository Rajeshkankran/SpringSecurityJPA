package com.tupa.app.data;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="master_bank_details")
public class Bank {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long _id;
	private String bank_name;
	private String bank_mmid_part;
	private String status;
	private Date created_on;
	private Date last_updated_on;
	
	
	
	public long get_id() {
		return _id;
	}
	
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_mmid_part() {
		return bank_mmid_part;
	}
	public void setBank_mmid_part(String bank_mmid_part) {
		this.bank_mmid_part = bank_mmid_part;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public Date getLast_updated_on() {
		return last_updated_on;
	}
	public void setLast_updated_on(Date last_updated_on) {
		this.last_updated_on = last_updated_on;
	}
	
	
	
	
}

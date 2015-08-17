package com.tupa.app.data.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="master_bank_detail")
public class Bank {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long master_bank_detail_id;
	private String bank_name;
	private String bank_mmid_part;
	private byte status;
	private Date created_on;
	private Date last_updated_on;
	

	public long getMaster_bank_detail_id() {
		return master_bank_detail_id;
	}
	public void setMaster_bank_detail_id(long master_bank_detail_id) {
		this.master_bank_detail_id = master_bank_detail_id;
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
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
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

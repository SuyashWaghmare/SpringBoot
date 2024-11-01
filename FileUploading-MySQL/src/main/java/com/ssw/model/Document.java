package com.ssw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class Document {
	
	@Id
	private String docId;
	
	@Lob
	private byte[] adharCard;
	
	@Lob
	private byte[] panCard;
	
	@Lob
	private byte[] license ;
	
	@Lob
	private byte[] photo;

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public byte[] getAdharCard() {
		return adharCard;
	}

	public void setAdharCard(byte[] adharCard) {
		this.adharCard = adharCard;
	}

	public byte[] getPanCard() {
		return panCard;
	}

	public void setPanCard(byte[] panCard) {
		this.panCard = panCard;
	}

	public byte[] getLicense() {
		return license;
	}

	public void setLicense(byte[] license) {
		this.license = license;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	

}

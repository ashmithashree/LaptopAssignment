package com.account.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="laptop")
@NamedQueries(@NamedQuery(name="getAllBooks",query="SELECT laptop FROM Laptop laptop"))
public class Laptop {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int lapId;
	@Column(name="type")
	private String lapType;
	@Column(name="spec")
	private String lapSpecification;
	public int getLapId() {
		return lapId;
	}
	public void setLapId(int lapId) {
		this.lapId = lapId;
	}
	public String  getLapType() {
		return lapType;
	}
	public void setLapType(String lapType) {
		this.lapType = lapType;
	}
	public String getLapSpecification() {
		return lapSpecification;
	}
	public void setLapSpecification (String string) {
		this.lapSpecification = string;
	}
	public String toString()
	{
		return "Laptop ID: "+getLapId()+" Laptop Type: "+getLapType()+" Laptop Specification: "+getLapSpecification();
	}
}

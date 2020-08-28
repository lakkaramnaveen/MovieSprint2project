package com.cg.movie.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="theater")
public class Theater {

	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="theater_seq",allocationSize=1)
	@Column(name="theaterid")
	private int theaterId;
	
	@Column(name="theatername",length=15)
	private String theaterName;
	
	@Column(name="theatercity",length=15)
	private String theaterCity;
	
	@Column(name="managername",length=15)
	private String managerName;
	
	@Column(name="managercontact")
	private int managerContact;
	
	@OneToMany(mappedBy="theater")
	@JsonIgnore
	List<Screen>  screens = new ArrayList<>();


	@Transient
	private int countScreen=screens.size();
	
	public int getCountScreen() {
		return screens.size();
	}


	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}

	public String getTheaterCity() {
		return theaterCity;
	}

	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}

	public int getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(int managerContact) {
		this.managerContact = managerContact;
	}


	public Theater(int theaterId, String theaterName, String theaterCity, String managerName, int managerContact) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
		
	}


	public Theater() {
		super();
	}
	
	
	
	
	
}

package com.cg.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



//it will specify it as entity class for bean configuration
@Entity
@Table(name="screen")//it map table by name to database
public class Screen {

	@Id//primary key
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	//provides the requirements for id generation with name and type
	@SequenceGenerator(name="mygen",sequenceName="screen_seq",allocationSize=1)
	//it will specify the sequence
	@Column(name="screenid")//maps the particular column from table
	private int screenId;
	
	@Column(name="screenname",length=15)//length is mentioned only when we use string
	private String screenName;
	
	@Column(name="no_ofrows")
	private int rows;
	
	@Column(name="no_ofcolumns")
	private int columns;
	
	@ManyToOne//mention many to one relation between screens and theater
	//many screens in one theater 
	@JoinColumn(name="theaterid")
	//joins column by name
	private Theater  theater;

	//getters and setters
	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	//constructor with parameters and without
	//this refers to current object
	public Screen(int screenId, String screenName, int rows, int columns) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.rows = rows;
		this.columns = columns;
	}

	public Screen() {
		super();
	}



}

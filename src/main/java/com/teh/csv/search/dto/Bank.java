package com.teh.csv.search.dto;

import com.opencsv.bean.CsvBindByName;

public class Bank {

	 @CsvBindByName
	  private Long id;
	  
	  @CsvBindByName(column = "Bank Name")
	  private String bankName;
	  
	  @CsvBindByName
	  private String type;
	  
	  @CsvBindByName
	  private String city;
	  
	  @CsvBindByName
	  private String state;
	  
	  @CsvBindByName(column = "Zip code")
	  private String zipCode;
	  

	  public Long getId() {
	    return id;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

	  public String getBankName() {
	    return bankName;
	  }

	  public void setBankName(String bankName) {
	    this.bankName = bankName;
	  }

	  public String getType() {
	    return type;
	  }

	  public void setType(String type) {
	    this.type = type;
	  }

	  public String getCity() {
	    return city;
	  }

	  public void setCity(String city) {
	    this.city = city;
	  }

	  public String getState() {
	    return state;
	  }

	  public void setState(String state) {
	    this.state = state;
	  }

	  public String getZipCode() {
	    return zipCode;
	  }

	  public void setZipCode(String zipCode) {
	    this.zipCode = zipCode;
	  }

	@Override
	public String toString() {
		return "Bank [id=" + id + ", bankName=" + bankName + ", type=" + type + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + "]";
	}
	  
}

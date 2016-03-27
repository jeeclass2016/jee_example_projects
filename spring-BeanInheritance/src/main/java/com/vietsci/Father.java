package com.vietsci;


public class Father {
	private String familyName;
	private String givenName;
	private String rank;
	
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public String getRank() {
		return rank;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public void introduceProfile() {
		System.out.println("Father: "+ familyName + " " + givenName + ", rank: " + rank);
	}
}

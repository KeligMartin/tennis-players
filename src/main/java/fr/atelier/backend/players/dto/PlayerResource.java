package fr.atelier.backend.players.dto;

import fr.atelier.backend.countries.dto.CountryResource;

public class PlayerResource {
	private Integer id;

	private String firstname;

	private String lastname;

	private String shortname;

	private String sex;

	private String picture;

	private DataResource data;

	private CountryResource country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public DataResource getData() {
		return data;
	}

	public void setData(DataResource data) {
		this.data = data;
	}

	public CountryResource getCountry() {
		return country;
	}

	public void setCountry(CountryResource country) {
		this.country = country;
	}
}

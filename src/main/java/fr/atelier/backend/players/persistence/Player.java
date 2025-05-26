package fr.atelier.backend.players.persistence;

import fr.atelier.backend.countries.persistence.Country;
import fr.atelier.backend.players.dto.PlayerResource;
import fr.atelier.backend.players.persistence.playerdata.PlayerData;
import jakarta.persistence.*;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstname;

	private String lastname;

	private String shortname;

	private String sex;

	private String picture;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "data_id")
	private PlayerData data;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "country_id")
	private Country country;

	public Integer getId() {
		return this.id;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setData(PlayerData data) {
		this.data = data;
	}

	public PlayerData getData() {
		return this.data;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public PlayerResource toResource() {
		PlayerResource playerResource = new PlayerResource();
		if(data != null) {
			playerResource.setData(this.data.toResource());
		}
		if(country != null) {
			playerResource.setCountry(this.country.toResource());
		}
		playerResource.setFirstname(this.firstname);
		playerResource.setLastname(this.lastname);
		playerResource.setShortname(this.shortname);
		playerResource.setPicture(this.picture);
		playerResource.setShortname(this.shortname);
		playerResource.setId(this.id);
		playerResource.setSex(this.sex);
		return playerResource;
	}
}

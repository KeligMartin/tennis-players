package fr.atelier.backend.players.persistence;

import fr.atelier.backend.players.persistence.playerdata.PlayerData;
import jakarta.persistence.*;

@Entity
public class Player {

	@Id
	private Integer id;

	private String firstname;

	private String lastname;

	private String shortname;

	private String sex;

	private String picture;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "data_id")
	private PlayerData data;

	public Integer getId() {
		return id;
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

	public void setData(PlayerData data) {
		this.data = data;
	}

	public PlayerData getData() {
		return data;
	}
}

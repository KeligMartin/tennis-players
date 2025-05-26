package fr.atelier.backend.countries.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.atelier.backend.countries.dto.CountryResource;
import fr.atelier.backend.players.persistence.Player;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	private String picture;
	private String code;

	@OneToMany(mappedBy = "country")
	@JsonIgnore
	private List<Player> players;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public CountryResource toResource() {
		CountryResource resource = new CountryResource();
		resource.setPicture(this.picture);
		resource.setCode(this.code);
		return resource;
	}
}

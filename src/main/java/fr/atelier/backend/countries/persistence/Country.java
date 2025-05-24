package fr.atelier.backend.countries.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Player> getPlayers() {
		return players;
	}
}

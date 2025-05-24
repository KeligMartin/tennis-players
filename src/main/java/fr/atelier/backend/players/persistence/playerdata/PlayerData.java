package fr.atelier.backend.players.persistence.playerdata;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PlayerData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer rank;
	private Integer points;
	private Integer weight;
	private Integer height;
	private Integer age;

	@ElementCollection
	private List<Integer> last;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Integer> getLast() {
		return last;
	}

	public void setLast(List<Integer> last) {
		this.last = last;
	}
}

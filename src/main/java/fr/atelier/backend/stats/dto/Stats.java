package fr.atelier.backend.stats.dto;

import fr.atelier.backend.countries.persistence.Country;

import java.util.List;

public class Stats {

	private Float averageBMI;
	private Float medianHeight;
	List<Country> bestCountries;

	public Float getAverageBMI() {
		return averageBMI;
	}

	public void setAverageBMI(Float averageBMI) {
		this.averageBMI = averageBMI;
	}

	public Float getMedianHeight() {
		return medianHeight;
	}

	public void setMedianHeight(Float medianHeight) {
		this.medianHeight = medianHeight;
	}

	public List<Country> getBestCountries() {
		return bestCountries;
	}

	public void setBestCountries(List<Country> bestCountries) {
		this.bestCountries = bestCountries;
	}
}

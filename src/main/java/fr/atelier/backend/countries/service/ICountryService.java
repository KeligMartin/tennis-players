package fr.atelier.backend.countries.service;

import fr.atelier.backend.countries.persistence.Country;

import java.util.List;

public interface ICountryService {

	List<Country> getBestCountry();
}

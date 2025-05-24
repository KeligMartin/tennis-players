package fr.atelier.backend.countries.service.impl;

import fr.atelier.backend.countries.persistence.Country;
import fr.atelier.backend.countries.persistence.CountryRepository;
import fr.atelier.backend.countries.service.ICountryService;
import fr.atelier.backend.players.persistence.Player;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountryService implements ICountryService {

	private final CountryRepository countryRepository;

	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@Override
	public List<Country> getBestCountry() {
		List<Country> countries = countryRepository.findAll();
		Stream<Player> players = countries.stream().flatMap(country -> country.getPlayers().stream());

		Map<Country, Integer> countryWinMap = players.collect(
				Collectors.groupingBy(
						Player::getCountry,
						Collectors.summingInt(p -> Math.toIntExact(p.getData()
								.getLast()
								.stream()
								.filter(value -> value.equals(1)).count()
						))
				));

		Integer maximumWins = countryWinMap.values().stream().max(Integer::compareTo).orElse(0);

		return countryWinMap.entrySet().stream()
				.filter(countryWin -> countryWin.getValue().equals(maximumWins))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}
}

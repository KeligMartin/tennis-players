package fr.atelier.backend.stats.service.impl;

import fr.atelier.backend.countries.service.ICountryService;
import fr.atelier.backend.players.service.IPlayerService;
import fr.atelier.backend.stats.dto.Stats;
import fr.atelier.backend.stats.service.IStatsService;

public class StatsService implements IStatsService {

	private final ICountryService countryService;
	private final IPlayerService playerService;

	public StatsService(ICountryService countryService, IPlayerService playerService) {
		this.countryService = countryService;
		this.playerService = playerService;
	}

	@Override
	public Stats getStats() {
		Stats stats = new Stats();
		stats.setAverageBMI(playerService.findAverageBMI());
		stats.setMedianHeight(playerService.findMedianHeight());
		stats.setBestCountries(countryService.getBestCountry());
		return stats;
	}
}

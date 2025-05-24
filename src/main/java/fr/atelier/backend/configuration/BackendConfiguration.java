package fr.atelier.backend.configuration;

import fr.atelier.backend.countries.persistence.CountryRepository;
import fr.atelier.backend.countries.service.ICountryService;
import fr.atelier.backend.countries.service.impl.CountryService;
import fr.atelier.backend.players.service.IPlayerService;
import fr.atelier.backend.players.persistence.PlayerRepository;
import fr.atelier.backend.players.service.impl.PlayerService;
import fr.atelier.backend.stats.service.IStatsService;
import fr.atelier.backend.stats.service.impl.StatsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackendConfiguration {

	@Bean
	public IPlayerService playerService(final PlayerRepository playerRepository) {
		return new PlayerService(playerRepository);
	}

	@Bean
	public ICountryService countryService(final CountryRepository countryRepository) {
		return new CountryService(countryRepository);
	}

	@Bean
	public IStatsService statsService(final ICountryService countryService, final IPlayerService playerService) {
		return new StatsService(countryService, playerService);
	}
}

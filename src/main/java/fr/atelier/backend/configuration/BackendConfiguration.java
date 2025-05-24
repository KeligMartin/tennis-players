package fr.atelier.backend.configuration;

import fr.atelier.backend.players.service.IPlayerService;
import fr.atelier.backend.players.persistence.PlayerRepository;
import fr.atelier.backend.players.service.impl.PlayerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackendConfiguration {

	@Bean
	public IPlayerService playerService(final PlayerRepository playerRepository) {
		return new PlayerService(playerRepository);
	}
}

package fr.atelier.backend.players.service.impl;

import fr.atelier.backend.players.dto.PlayerResource;
import fr.atelier.backend.players.persistence.Player;
import fr.atelier.backend.players.persistence.PlayerRepository;
import fr.atelier.backend.players.persistence.specifications.PlayerSpecification;
import fr.atelier.backend.players.service.IPlayerService;
import fr.atelier.backend.utils.exception.NotFoundException;

import java.util.List;

public class PlayerService implements IPlayerService {

	private final PlayerRepository playerRepository;

	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	/**
	 *
	 * @return all players ordered by rank
	 */

	public List<Player> findAll() {
		return playerRepository.findAll(PlayerSpecification.orderByRank());
	}

	/**
	 * Finds a player from an id in request
	 *
	 * @param id - id from the searched player
	 * @return the player with the associated id
	 * @throws 404 error if the player is not found
	 */

	public PlayerResource findById(Integer id) {
		var player = playerRepository.findById(id).orElseThrow(() -> new NotFoundException("Player", id));
		return player.toResource();
	}

	/**
	 * Calculate the median height from players with a SQL request
	 * SQL is more efficient to calculate big amount of data, but we could have done it in pure java
	 *
	 * @return median height from all players
	 */
	public Float findMedianHeight() {
		return playerRepository.findMedianHeight();
	}

	public Float findAverageBMI() {
		return playerRepository.findAverageBMI();
	}
}

package fr.atelier.backend.players.service;

import fr.atelier.backend.players.persistence.Player;

import java.util.List;

public interface IPlayerService {

	/**
	 * Find all players
	 *
	 * @return a list of players
	 */
	List<Player> findAll();

	/**
	 *
	 * @param id - id from the player
	 *
	 * @return a unique player
	 */
	Player findById(Integer id);

	/**
	 *
	 * @return median height from all players
	 */
	Float findMedianHeight();

	/**
	 *
	 * @return average BMI from all players
	 */
	Float findAverageBMI();
}

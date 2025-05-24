package fr.atelier.backend.players.service.impl;

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

	public List<Player> findAll() {
		return playerRepository.findAll(PlayerSpecification.orderByRank());
	}

	public Player findById(Integer id) {
		return playerRepository.findById(id).orElseThrow(() -> new NotFoundException("Player", id));
	}
}

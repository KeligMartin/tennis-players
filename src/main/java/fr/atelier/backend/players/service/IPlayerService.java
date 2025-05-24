package fr.atelier.backend.players.service;

import fr.atelier.backend.players.persistence.Player;

import java.util.List;

public interface IPlayerService {

	List<Player> findAll();
}

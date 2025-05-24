package fr.atelier.backend.players.controller;

import fr.atelier.backend.players.service.IPlayerService;
import fr.atelier.backend.players.persistence.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/players")
public class PlayerController {

	private final IPlayerService playerService;

	public PlayerController(IPlayerService playerService) {
		this.playerService = playerService;
	}


	@GetMapping
	public List<Player> findAll() {
		return this.playerService.findAll();
	}
}

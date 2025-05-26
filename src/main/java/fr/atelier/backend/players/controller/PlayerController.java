package fr.atelier.backend.players.controller;

import fr.atelier.backend.players.dto.PlayerResource;
import fr.atelier.backend.players.service.IPlayerService;
import fr.atelier.backend.players.persistence.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<List<PlayerResource>> findAll() {
		return new ResponseEntity<>(this.playerService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PlayerResource> findById(@PathVariable Integer id) {
		return new ResponseEntity<>(this.playerService.findById(id), HttpStatus.OK);
	}
}

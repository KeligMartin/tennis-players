package fr.atelier.backend.player;

import fr.atelier.backend.players.dto.PlayerResource;
import fr.atelier.backend.players.persistence.Player;
import fr.atelier.backend.players.persistence.PlayerRepository;
import fr.atelier.backend.players.persistence.specifications.PlayerSpecification;
import fr.atelier.backend.players.service.impl.PlayerService;
import fr.atelier.backend.utils.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static fr.atelier.backend.helpers.PlayerHelper.createPlayer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerTest {

	@Mock
	private PlayerRepository playerRepository;

	@InjectMocks
	private PlayerService playerService;

	@Test
	void should_exists_player() {
		// Given
		Player player = new Player();
		player.setId(1);
		when(playerRepository.findById(1)).thenReturn(Optional.of(player));

		// When
		PlayerResource result = playerService.findById(1);

		// Then
		assertNotNull(result);
		assertEquals(1, result.getId());
	}

	@Test
	void should_throw_not_found_exception() {
		when(playerRepository.findById(42)).thenReturn(Optional.empty());

		NotFoundException exception = assertThrows(NotFoundException.class, () -> {
			playerService.findById(42);
		});

		assertEquals("Entity Player not found with id 42", exception.getMessage());
	}

	@Test
	void should_give_ordered_players() {

		Player player1 = createPlayer(1, 100);
		Player player2 = createPlayer(2, 5);
		Player player3 = createPlayer(3, 50);

		List<Player> players = Arrays.asList(player1, player2, player3);
		when(playerRepository.findAll(PlayerSpecification.orderByRank())).thenReturn(players);

		List<Player> sortedPlayers = playerService.findAll();

		assertEquals(3, sortedPlayers.size());
		assertEquals(1, sortedPlayers.get(0).getId()); // rank 2
		assertEquals(2, sortedPlayers.get(1).getId()); // rank 3
		assertEquals(3, sortedPlayers.get(2).getId()); // rank 5
	}

}


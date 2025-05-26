package fr.atelier.backend.helpers;

import fr.atelier.backend.players.persistence.Player;
import fr.atelier.backend.players.persistence.playerdata.PlayerData;

public class PlayerHelper {

	public static Player createPlayer(int id, int rank) {
		PlayerData data = new PlayerData();
		data.setRank(rank);

		Player player = new Player();
		player.setId(id);
		player.setData(data);

		return player;
	}
}

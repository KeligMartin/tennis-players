package fr.atelier.backend.players.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>, JpaSpecificationExecutor<Player> {

	@Query(nativeQuery = true, value = "SELECT percentile_cont(0.5) WITHIN GROUP (ORDER BY height) AS median_points " +
			"FROM player " +
			"left join public.player_data pd on pd.id = player.data_id;")
	Float findMedianHeight();

	@Query(nativeQuery = true,
	value = "SELECT " +
			"    avg(ROUND(weight / 1000.0 / POWER(height / 100.0, 2), 2)) " +
			"FROM " +
			"    player_data;")
	Float findAverageBMI();
}

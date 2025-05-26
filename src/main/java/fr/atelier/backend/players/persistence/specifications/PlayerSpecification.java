package fr.atelier.backend.players.persistence.specifications;

import fr.atelier.backend.players.persistence.Player;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class PlayerSpecification {

	public static Specification<Player> orderByRank() {
		return ((root, query, criteriaBuilder) -> {
			query.orderBy(criteriaBuilder.asc(root.join("data").get("rank")));
			return criteriaBuilder.conjunction();
		});
	}
}

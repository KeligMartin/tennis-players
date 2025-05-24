package fr.atelier.backend.stats.controller;

import fr.atelier.backend.stats.dto.Stats;
import fr.atelier.backend.stats.service.IStatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/stats")
public class StatsController {

	private final IStatsService statsService;

	public StatsController(IStatsService statsService) {
		this.statsService = statsService;
	}

	@GetMapping
	public Stats getStats() {
		return statsService.getStats();
	}
}

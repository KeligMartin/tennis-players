package fr.atelier.backend.utils.exception;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String entity, Integer id) {
		super(String.format("Entity %s not found with id %s", entity, id));
	}
}

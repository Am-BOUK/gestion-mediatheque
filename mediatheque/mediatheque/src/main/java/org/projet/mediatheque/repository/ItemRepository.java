package org.projet.mediatheque.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.projet.mediatheque.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ItemRepository extends JpaRepository<Item, Long> {
	
	// Get all available items
	@Query("from Item i where i.nombreExemplaire>0")
	Optional<List<Item>> findDisponibles();
	
	// Get all available and new items
	@Query("from Item i where i.nombreExemplaire>0 and i.dateParution >= :date")
	public List<Item> findItemsByDateParution(Date date);
}


package org.projet.mediatheque.repository;

import java.util.List;

import org.projet.mediatheque.entity.Emprunt;
import org.projet.mediatheque.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

	/**
	 *  Get all emprunts by user
	 * @param user
	 * @return Emprunt List
	 */
	public List<Emprunt> findByUser(User user);

	/**
	 * Get all emprunt by userId
	 * @param id
	 * @return Emprunt List
	 */
	@Query("select e from Emprunt e where e.user.id = :id")
	public List<Emprunt> findByUserId(Long id);
}

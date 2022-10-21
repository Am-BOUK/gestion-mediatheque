package org.projet.mediatheque.repository;

import java.util.List;

import org.projet.mediatheque.entity.Emprunt;
import org.projet.mediatheque.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

	// Get all emprunts by user
	@Query("select e from Emprunt e where e.user = :user")
	public List<Emprunt> findByUser(User user);

//	public List<Emprunt> findByUser_Id(Long id);
}

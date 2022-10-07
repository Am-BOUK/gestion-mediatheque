package org.projet.mediatheque.repository;

import org.projet.mediatheque.entity.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

}

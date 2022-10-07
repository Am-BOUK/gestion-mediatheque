package org.projet.mediatheque.repository;

import org.projet.mediatheque.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}

package org.projet.mediatheque.repository;

import java.util.Optional;

import org.projet.mediatheque.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findUserByLogin(String login);

}

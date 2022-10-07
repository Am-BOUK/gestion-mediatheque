package org.projet.mediatheque.repository;

import java.util.List;

import org.projet.mediatheque.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>{

}

package nl.novi.beeindopdracht.repositories;

import nl.novi.beeindopdracht.entities.Blogpost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogpostRepository extends JpaRepository<Blogpost, Long> {
}

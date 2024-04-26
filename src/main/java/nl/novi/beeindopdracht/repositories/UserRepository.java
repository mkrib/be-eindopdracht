package nl.novi.beeindopdracht.repositories;

import nl.novi.beeindopdracht.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

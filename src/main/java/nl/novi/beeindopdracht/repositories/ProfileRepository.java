package nl.novi.beeindopdracht.repositories;

import nl.novi.beeindopdracht.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}

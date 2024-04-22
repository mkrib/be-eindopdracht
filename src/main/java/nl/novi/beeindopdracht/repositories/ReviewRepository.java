package nl.novi.beeindopdracht.repositories;

import nl.novi.beeindopdracht.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}

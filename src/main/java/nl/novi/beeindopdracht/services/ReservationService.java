package nl.novi.beeindopdracht.services;

import nl.novi.beeindopdracht.entities.Reservation;
import nl.novi.beeindopdracht.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

//    TODO user repository linken wanneer aangemaakt

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }
}

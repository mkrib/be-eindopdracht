package nl.novi.beeindopdracht.services;

import nl.novi.beeindopdracht.entities.Reservation;
import nl.novi.beeindopdracht.exceptions.RecordNotFoundException;
import nl.novi.beeindopdracht.mappers.ReservationMapper;
import nl.novi.beeindopdracht.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

//    TODO user repository linken wanneer aangemaakt

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

//    GET
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Reservation not found"));
    }

//    POST
    public Reservation addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation;
    }

//    DELETE
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }
}

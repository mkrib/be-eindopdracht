package nl.novi.beeindopdracht.controllers;

import nl.novi.beeindopdracht.dtos.ReservationDto;
import nl.novi.beeindopdracht.entities.Reservation;
import nl.novi.beeindopdracht.mappers.ReservationMapper;
import nl.novi.beeindopdracht.services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDto>> getReservations() {
        List<Reservation> reservations = reservationService.getReservations();
        List<ReservationDto> reservationDtos = reservationMapper.translateToDtos(reservations);

        return ResponseEntity.ok().body(reservationDtos);
    }
}

package nl.novi.beeindopdracht.controllers;

import jakarta.validation.Valid;
import nl.novi.beeindopdracht.dtos.ReservationDto;
import nl.novi.beeindopdracht.dtos.ReservationRequestDto;
import nl.novi.beeindopdracht.entities.Reservation;
import nl.novi.beeindopdracht.mappers.ReservationMapper;
import nl.novi.beeindopdracht.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/reservations/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservation(id));
    }

    @PostMapping("/reservations")
    public ResponseEntity<Object> addReservation(@Valid @RequestBody ReservationRequestDto reservationRequestDto) {
        Reservation postedReservation = reservationService.addReservation(reservationMapper.translateToReservation(reservationRequestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationMapper.translateToDto(postedReservation));
    }
}

package nl.novi.beeindopdracht.mappers;

import nl.novi.beeindopdracht.dtos.ReservationDto;
import nl.novi.beeindopdracht.dtos.ReservationRequestDto;
import nl.novi.beeindopdracht.entities.Reservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationMapper {

//    Mapper om de reservering om te zetten naar een dto, die we willen teruggeven aan de gebruiker
    public ReservationDto translateToDto(Reservation reservation) {
        ReservationDto dto = new ReservationDto();
        dto.setId(reservation.getId());
        dto.setStartTime(reservation.getStartTime());
        dto.setEndTime(reservation.getEndTime());
        dto.setDate(reservation.getDate());
        dto.setAmountOfGuests(reservation.getAmountOfGuests());
        dto.setType(reservation.getType());
        dto.setRequestMessage(reservation.getRequestMessage());

        return dto;
    }

    public List<ReservationDto> translateToDtos(List<Reservation> reservationsList) {
        List<ReservationDto> result = new ArrayList<>();
        for (Reservation reservation : reservationsList) {
            result.add(translateToDto(reservation));
        }
        return result;
    }

//    Mapper om de request reservering om te zetten naar een reservering voor in de db
    public Reservation translateToReservation(ReservationRequestDto dto) {
        Reservation reservation = new Reservation();

        reservation.setStartTime(dto.getStartTime());
        reservation.setEndTime(dto.getEndTime());
        reservation.setDate(dto.getDate());
        reservation.setAmountOfGuests(dto.getAmountOfGuests());
        reservation.setType(dto.getType());
        reservation.setRequestMessage(dto.getRequestMessage());
        reservation.setUser(dto.getUser());

        return reservation;
    }
}

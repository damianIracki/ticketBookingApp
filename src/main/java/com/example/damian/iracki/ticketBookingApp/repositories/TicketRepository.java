package com.example.damian.iracki.ticketBookingApp.repositories;

import com.example.damian.iracki.ticketBookingApp.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findTicketByScreeningIdAndNumberOfRowAndNumberOfSeatInRow(Long screenId, int numberOfRow,
                                                                               int numberOfSeatsInRow);
}

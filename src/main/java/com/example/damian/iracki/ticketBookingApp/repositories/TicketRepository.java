package com.example.damian.iracki.ticketBookingApp.repositories;

import com.example.damian.iracki.ticketBookingApp.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

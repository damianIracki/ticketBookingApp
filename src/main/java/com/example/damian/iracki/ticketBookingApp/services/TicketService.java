package com.example.damian.iracki.ticketBookingApp.services;


import com.example.damian.iracki.ticketBookingApp.entities.Ticket;
import com.example.damian.iracki.ticketBookingApp.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void addNewTicket(Ticket ticket){
        Optional<Ticket> ticketOptional = ticketRepository.findTicketByScreeningIdAndNumberOfRowAndNumberOfSeatInRow
                (ticket.getScreeningId(), ticket.getNumberOfRow(), ticket.getNumberOfSeatInRow());
        if(ticketOptional.isPresent()){
            throw new IllegalStateException("Taken seat isn't available");
        }
        ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
}
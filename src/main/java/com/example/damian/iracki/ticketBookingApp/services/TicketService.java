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

    public void addNewTickets(List<Ticket> tickets){
        if(tickets.size() < 1){
            throw  new IllegalStateException("You must book one ticket at least");
        }
        for (Ticket ticket : tickets) {
            Optional<Ticket> ticketOptional = ticketRepository.findTicketByScreeningIdAndNumberOfRowAndNumberOfSeatInRow
                    (ticket.getScreeningId(), ticket.getNumberOfRow(), ticket.getNumberOfSeatInRow());
            if(ticketOptional.isPresent()){
                throw new IllegalStateException("Taken seat isn't available");
            }
            ticketRepository.save(ticket);
        }
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
}

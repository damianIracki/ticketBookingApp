package com.example.damian.iracki.ticketBookingApp.dto;

import com.example.damian.iracki.ticketBookingApp.entities.Ticket;
import com.example.damian.iracki.ticketBookingApp.enums.TypeOfTicket;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto {

    private Long screeningId;

    private int numberOfRow;
    private int numberOfSeatInRow;

    private TypeOfTicket typeOfTicket;

    private String name;
    private String surname;

    public Ticket mapTicketDtoToTicket(TicketDto ticketDto){
        Ticket ticket = new Ticket();
        ticket.setName(ticketDto.getName());
        ticket.setSurname(ticketDto.getSurname());
        ticket.setNumberOfRow(ticketDto.getNumberOfRow());
        ticket.setNumberOfSeatInRow(ticketDto.getNumberOfSeatInRow());
        ticket.setTypeOfTicket(ticketDto.getTypeOfTicket());
        ticket.setScreeningId(ticketDto.getScreeningId());

        return ticket;
    }



}

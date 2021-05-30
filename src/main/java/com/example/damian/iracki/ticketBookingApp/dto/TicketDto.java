package com.example.damian.iracki.ticketBookingApp.dto;

import com.example.damian.iracki.ticketBookingApp.entities.Ticket;
import com.example.damian.iracki.ticketBookingApp.enums.PaymentStatus;
import com.example.damian.iracki.ticketBookingApp.enums.TypeOfTicket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@AllArgsConstructor
@Builder
public class TicketDto {

    private final Long screeningId;

    private final int numberOfRow;
    private final int numberOfSeatInRow;

    private final TypeOfTicket typeOfTicket;

    private final String name;
    private final String surname;

    public Ticket mapTicketDtoToTicket(TicketDto ticketDto){
        Ticket ticket = new Ticket();
        ticket.setName(ticketDto.getName());
        ticket.setSurname(ticketDto.getSurname());
        ticket.setNumberOfRow(ticketDto.getNumberOfRow());
        ticket.setNumberOfSeatInRow(ticketDto.getNumberOfSeatInRow());
        ticket.setTypeOfTicket(ticketDto.getTypeOfTicket());
        ticket.setScreeningId(ticketDto.getScreeningId());
        ticket.setPaymentStatus(PaymentStatus.UNPAID);

        return ticket;
    }
}

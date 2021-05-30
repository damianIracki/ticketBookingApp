package com.example.damian.iracki.ticketBookingApp;

import com.example.damian.iracki.ticketBookingApp.entities.Movie;
import com.example.damian.iracki.ticketBookingApp.entities.Screening;
import com.example.damian.iracki.ticketBookingApp.entities.ScreeningRoom;
import com.example.damian.iracki.ticketBookingApp.entities.Ticket;
import com.example.damian.iracki.ticketBookingApp.enums.PaymentStatus;
import com.example.damian.iracki.ticketBookingApp.enums.TypeOfTicket;
import com.example.damian.iracki.ticketBookingApp.validators.TicketValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScreeningResourceTest {

    private final TicketValidator ticketValidator = new TicketValidator();

    @Test
    public void shouldThrowErrorWhenFirstLetterOfNameIsNotCapital() {

        //Given
        LocalDateTime localDateTime = LocalDateTime.now();
        Ticket ticket = new Ticket(1L, 1L, PaymentStatus.UNPAID, TypeOfTicket.NORMAL, 3,
                3, "adam", "Nowak");

        Screening screening = new Screening(1L, new Movie(), new ScreeningRoom(), localDateTime, Collections.singletonList(ticket));

        //Expect
        assertThrows(IllegalStateException.class, () -> ticketValidator.checkTicket(ticket, screening, localDateTime));
    }


}

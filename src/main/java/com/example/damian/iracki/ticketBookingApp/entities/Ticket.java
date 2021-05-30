package com.example.damian.iracki.ticketBookingApp.entities;


import com.example.damian.iracki.ticketBookingApp.enums.PaymentStatus;
import com.example.damian.iracki.ticketBookingApp.enums.TypeOfTicket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @SequenceGenerator(
            name = "ticket_sequence",
            sequenceName = "ticket_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_sequence")
    private Long id;

    private Long screeningId;

    private PaymentStatus paymentStatus;
    private TypeOfTicket typeOfTicket;

    private int numberOfRow;
    private int numberOfSeatInRow;

    private String name;
    private String surname;

}

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
    @GeneratedValue(
            strategy = GenerationType.AUTO)
    private Long id;

    private Long screeningId;

    private PaymentStatus paymentStatus;
    private TypeOfTicket typeOfTicket;

    private int numberOfRow;
    private int numberOfSeatInRow;

    private String name;
    private String surname;

    public Ticket(Long screeningId, PaymentStatus paymentStatus, TypeOfTicket typeOfTicket, int numberOfRow, int numberOfSeatInRow, String name, String surname) {
        this.screeningId = screeningId;
        this.paymentStatus = paymentStatus;
        this.typeOfTicket = typeOfTicket;
        this.numberOfRow = numberOfRow;
        this.numberOfSeatInRow = numberOfSeatInRow;
        this.name = name;
        this.surname = surname;
    }
}

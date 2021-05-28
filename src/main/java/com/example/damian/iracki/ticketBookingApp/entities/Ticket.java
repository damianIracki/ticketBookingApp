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
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screening;

    private PaymentStatus paymentStatus;
    private TypeOfTicket typeOfTicket;

}

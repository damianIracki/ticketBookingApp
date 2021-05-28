package com.example.damian.iracki.ticketBookingApp.enums;

import java.math.BigDecimal;

public enum TypeOfTicket {
    NORMAL(new BigDecimal(25)),
    STUDENT(new BigDecimal(15)),
    CHILD(new BigDecimal(12.5));

    BigDecimal price;

    private TypeOfTicket(BigDecimal price){
        this.price = price;
    }
}

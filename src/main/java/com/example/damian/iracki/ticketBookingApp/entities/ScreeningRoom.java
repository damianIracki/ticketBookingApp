package com.example.damian.iracki.ticketBookingApp.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
@Getter
@NoArgsConstructor
public class ScreeningRoom {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int rowCount;
    private int seatsInRowCount;

    public ScreeningRoom(String name, int rowCount, int seatsInRowCount) {
        this.name = name;
        this.rowCount = rowCount;
        this.seatsInRowCount = seatsInRowCount;
    }
}

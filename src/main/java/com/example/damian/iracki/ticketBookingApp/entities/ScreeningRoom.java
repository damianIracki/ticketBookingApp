package com.example.damian.iracki.ticketBookingApp.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class ScreeningRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

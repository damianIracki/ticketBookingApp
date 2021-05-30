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
    @SequenceGenerator(
            name = "screening_room_sequence",
            sequenceName = "screening_room_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "screening_room_sequence")
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

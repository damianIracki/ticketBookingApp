package com.example.damian.iracki.ticketBookingApp.entities;


import com.example.damian.iracki.ticketBookingApp.enums.SeatStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class ScreeningRoom {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int rowCount;
    private int seatsInRowCount;

    private List<SeatStatus> seats;

}

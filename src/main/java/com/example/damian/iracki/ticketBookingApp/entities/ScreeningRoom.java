package com.example.damian.iracki.ticketBookingApp.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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


}

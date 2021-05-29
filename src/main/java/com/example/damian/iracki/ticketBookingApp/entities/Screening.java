package com.example.damian.iracki.ticketBookingApp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Screening {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="screening_room_id")
    private ScreeningRoom screeningRoom;

    private LocalDateTime startingDateTime;
}

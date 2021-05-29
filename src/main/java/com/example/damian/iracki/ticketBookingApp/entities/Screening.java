package com.example.damian.iracki.ticketBookingApp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @OrderBy(value = "title ASC")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screening_room_id")
    private ScreeningRoom screeningRoom;

    private LocalDateTime startingDateTime;

    @OneToMany()
    @JoinColumn(name = "screeningId")
    private List<Ticket> tickets;

    public Screening(Movie movie, ScreeningRoom screeningRoom, LocalDateTime startingDateTime) {
        this.movie = movie;
        this.screeningRoom = screeningRoom;
        this.startingDateTime = startingDateTime;
    }
}

package com.example.damian.iracki.ticketBookingApp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Screening {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
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

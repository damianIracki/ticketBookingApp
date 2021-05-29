package com.example.damian.iracki.ticketBookingApp.repositories;

import com.example.damian.iracki.ticketBookingApp.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}

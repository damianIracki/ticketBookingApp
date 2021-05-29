package com.example.damian.iracki.ticketBookingApp.repositories;

import com.example.damian.iracki.ticketBookingApp.entities.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}

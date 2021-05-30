package com.example.damian.iracki.ticketBookingApp.repositories;

import com.example.damian.iracki.ticketBookingApp.entities.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface ScreeningRepository extends JpaRepository<Screening, Long> {

    List<Screening> findAllByOrderByStartingDateTime();

    List<Screening> findAllByStartingDateTimeBetweenOrderByStartingDateTime(LocalDateTime startDate, LocalDateTime endDate);

    List<Screening> findAllByStartingDateTimeBetweenOrderByStartingDateTimeAscMovie_title(LocalDateTime startDate, LocalDateTime endDate);

    List<Screening> findAllByStartingDateTimeBetweenOrderByMovie_title(LocalDateTime startDate, LocalDateTime endDate);

    Optional<Screening> findScreeningById(Long id);
}

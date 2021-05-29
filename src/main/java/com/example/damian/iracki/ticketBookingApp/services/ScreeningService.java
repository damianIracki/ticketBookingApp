package com.example.damian.iracki.ticketBookingApp.services;

import com.example.damian.iracki.ticketBookingApp.entities.Screening;
import com.example.damian.iracki.ticketBookingApp.repositories.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScreeningService {

    private final ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public List<Screening> findAllScreeningOrderByStartingDate(){
        return screeningRepository.findAllByOrderByStartingDateTime();
    }

    public List<Screening> findAllScreeningsBetweenDateSortedByDate(LocalDateTime startDate, LocalDateTime endDate){
        return screeningRepository.findAllByStartingDateTimeBetweenOrderByStartingDateTime(startDate, endDate);
    }

    public List<Screening> findAllScreeningsBetweenDateSortedByMovieTitle(LocalDateTime startDate, LocalDateTime endDate) {
        return screeningRepository.findAllByStartingDateTimeBetweenOrderByMovie_title(startDate, endDate);
    }
}
